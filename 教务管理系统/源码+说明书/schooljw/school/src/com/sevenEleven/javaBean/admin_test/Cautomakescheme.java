package com.sevenEleven.javaBean.admin_test;

import java.util.ArrayList;
import java.util.List;

public class Cautomakescheme {

	/**
	 * �Զ��ſε�����: ��ÿ����ʱ��Ƭ�ϼ��Ͻ��Һ�(��ʦ-�γ�), �Զ��ſη�Ϊ����,����,����ÿһ�ڿ�.���ݽ��Ĺ�ϵ.
	 * 
	 * 1.���ȡ���Ľ��Ҳ�Ϊ��,��������һ������Ľ���. ���Ϊ��,��ڿξͲ�����.
	 * 2.���ȡ����(��ʦ-�γ�)��ǰ6�ÿ����Ϲ��Ͳ鿴��һ��(��ʦ-�γ�)����.
	 * 
	 * @return
	 * 
	 */
	public void Catomakescheme(String className, String phase) {
		@SuppressWarnings("unused") List timeClassUnitList = initTimeClassUnitList(phase);
	}

	/**
	 * @auther Tim
	 * @return List function: �ɽ׶�A�õ�����׶� ʮ�ܵ�ʱ��Ƭ������,��List���
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List initTimeClassUnitList(String phase) {
		List timeClassUnitList = new ArrayList();
		for (int i = 1; i <= 10; i++) { // 10��
			for (int j = 1; j <= 5; j++) { // 1�����ڵ�ǰ5��
				for (int k = 1; k <= 4; k++) {// ÿ���4�ڿ�
					CTimeClassUnit timeClassUnit = new CTimeClassUnit();
					if (i < 10) { // һλ��ʱ�õ���ʱ��
						timeClassUnit.setTime(phase + "0" + String.valueOf(i)
								+ String.valueOf(j) + String.valueOf(k));
					} else { // ��λ��ʱ�õ���ʱ��
						timeClassUnit.setTime(phase + String.valueOf(i)
								+ String.valueOf(j) + String.valueOf(k));
					}
					timeClassUnitList.add(timeClassUnit);
				}
			}
		}
		return timeClassUnitList;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * @auther Tim
		 * @exception û�����õ�������........ֻ�Ǽ򵥵ĵõ�����ʱ��,�ɶ��Բ�ǿ,�д��Ľ�
		 * @function: �ɿ�ѧʱ��Ϳγ̵�ʱ��Ƭ�ϵõ��γ̵� ��ȷʱ��.
		 * @return: timeClassNow (String) eg: A011420070101
		 * @from : timeClassUnit (String)eg:A0114 timeClassBegin (String)20060101
		 */
		CgetCurrentTimeFromTimeClassBegin gctftc = new CgetCurrentTimeFromTimeClassBegin("20060105","A0124");
		String timeClassNow = gctftc.getTimeClassNow();
		System.out.print(timeClassNow);
	}

}
