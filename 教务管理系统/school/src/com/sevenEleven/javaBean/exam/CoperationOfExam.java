package com.sevenEleven.javaBean.exam;

import java.sql.SQLException;

import com.sevenEleven.javaBean.CDBConnection;

public class CoperationOfExam extends CDBConnection {

	/**
	 * @author Tim ������ʦ���Bean
	 */
	/*
	 * @author Tim �б���޿�ѡ����ĶԴ�
	 */
	public boolean Choose1IsRight(String id, String answer) throws SQLException {
		try {
			sql = "select count(*) from choose1 where ch_id =" + id
					+ "and ch_answer =" + " '" + answer + "' ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/*
	 * @author Tim �б�ѡ�޿�ѡ����ĶԴ�
	 */
	public boolean Choose2IsRight(String id, String answer) throws SQLException {
		try {
			sql = "select count(*) from choose2 where ch_id =" + id
					+ "and ch_answer =" + " '" + answer + "' ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/*
	 * @author Tim �б���޿������ĶԴ�
	 */
	public boolean text1IsRight(String id, String answer) throws SQLException {
		try {
			sql = "select count(*) from text1 where text_id =" + id
					+ "and text_answer =" + " '" + answer + "' ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/*
	 * @author Tim �б�ѡ�޿������ĶԴ�
	 */
	public boolean text2IsRight(String id, String answer) throws SQLException {
		try {
			sql = "select count(*) from text2 where text_id =" + id
					+ "and text_answer =" + " '" + answer + "' ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/*
	 * @author Tim ������޿���Ŀ�ķ���
	 */
	public boolean insetCompulsoryE_Mark(String s_id, String L1_id,
			String e_mark) throws SQLException {
		try {

			sql = "insert into result1 (S_ID,L1_ID,E_MARK) values (" + s_id + ", " + L1_id + ", "
					+ e_mark + " )";
			if (con == null) {
				DBConn(); // ����
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/*
	 * @author Tim ����ѡ�޿���Ŀ�ķ���
	 */
	public boolean insetElectiveE_Mark(String s_id, String L2_id,
			String e_mark) throws SQLException {
		try {

			sql = "insert into result2 (S_ID,L2_ID,E_MARK) values (" + s_id + ", " + L2_id + ", "
					+ e_mark + " )";
			if (con == null) {
				DBConn(); // ����
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
////		<1>
//		int I = 2;
//		int x = (++I) + (++I) + (++I)+ (++I);

//		<2>
		int I = 2;
		int y = (I++) + (I++) + (I++);
//System.out.println(x);
System.out.println(y);
	}

}
