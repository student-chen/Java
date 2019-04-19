package com.tsinghuait.st0717.hospitalsystem.common;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetToBean {

	/**
	 * ��������е����ݿ�����DTO������ȥ
	 * 
	 * @param rs
	 *            ���ݿ���������
	 * @param dto
	 *            dto����
	 */
	public static Collection convertResultSet2DTOCollection(ResultSet rs,
			Class cls,int rsBeginIndex,int size) {
		Logger log = Logger.getLogger(ResultSetToBean.class.getName());
		Collection col = null; // ���DTO����ļ���
		Method[] methods = cls.getMethods(); // DTO���������еķ���
		String currentMethodName = null;
		Method currentMethod = null;
		String currentColumnName = null;
		try {
			// ���ڴ����ݿ���ȡ���ݵ�������ӦҪ���õ�set����
			Map<String, Method> dataMap = new HashMap<String, Method>();
			// ��ȡ���ݵ�������ӦҪ���õ�set������map����
			for (int i = 0; i < methods.length; i++) {
				currentMethodName = methods[i].getName();
				if ("set".equals(currentMethodName.subSequence(0, 3))) {
					dataMap.put(currentMethodName.substring(3), methods[i]);
				}
			}
			Set<String> columns = dataMap.keySet();
			if (rs != null && rs.absolute(rsBeginIndex)) {
				col = new ArrayList(); // ʵ�������϶������ڴ��DTO
				int count = 0;
				do {
					Object obj = cls.newInstance(); // ʵ����dto����
					Iterator<String> colIterator = columns.iterator();
					while (colIterator.hasNext()) {
						currentColumnName = colIterator.next();
						currentMethod = dataMap.get(currentColumnName);
						if (currentMethod.getParameterTypes()[0] == String.class) {
							currentMethod.invoke(obj, rs
									.getString(currentColumnName));
						} else if (currentMethod.getParameterTypes()[0] == Integer.class) {
							currentMethod.invoke(obj, rs
									.getInt(currentColumnName));
						} else if (currentMethod.getParameterTypes()[0] == Date.class) {
							currentMethod.invoke(obj, rs
									.getDate(currentColumnName));
						} else {
							log.log(Level.WARNING, "�в�������ת��ʧ��");
							//throw new Exception("����ת��ʧ�ܣ�");
						}
					}
					count++;
					col.add(obj);
				} while (rs.next() && count<size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}

}
