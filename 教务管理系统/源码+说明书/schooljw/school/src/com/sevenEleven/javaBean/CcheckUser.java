package com.sevenEleven.javaBean;

import java.sql.SQLException;

import com.sevenEleven.Beans.CadminBean;
import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.Beans.CteacherBean;

public class CcheckUser extends CDBConnection {

	// admin��½��֤
	public CadminBean checkAdminLogin(String userName, String userPwd) {
		CadminBean admin = null;
		if (!checkParameter(userName + userPwd)) {
			userName = "null";
			userPwd = "null";
		}
		try {
			sql = "SELECT COUNT(*) FROM ADMINISTRATOR WHERE A_NAME=" + " '"
					+ userName + "' " + "AND A_PASSWORD=" + " '" + userPwd // ƴSQL���
					+ "'  ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					rs.close();
					closeStmt(); // �رռ�¼��������
					admin = this.getAdmin(userName);
				} else {
					admin = null;
				}
			}
		} catch (Exception e) {
			admin = null;
			e.printStackTrace();
		}
		return admin;
	}

	// student��½��֤
	public CstudentBean checkStudentLogin(String userName, String userPwd) {
		CstudentBean studnet = null;
		if (!checkParameter(userName + userPwd)) {
			userName = "null";
			userPwd = "null";
		}
		try {
			sql = "SELECT COUNT(*) FROM STUDENT WHERE S_NUMBER=" + " '"
					+ userName + "' " + "AND S_PASSWORD=" + " '" + userPwd // ƴSQL���
					+ "'  ";
			if (con == null) {
				DBConn(); //
				// getConnection();
			}
			rs = executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					rs.close();
					stmt.close(); // �رռ�¼��������
					studnet = this.getStudent(userName);
				} else {
					    return studnet ;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return studnet;
	}

	// teacher��½��֤
	public CteacherBean checkTeacherLogin(String userName, String userPwd) {
		CteacherBean teacher = null;
		if (!checkParameter(userName + userPwd)) {
			 userName = "null";
			 userPwd = "null";
		}
		try {
			sql = "SELECT COUNT(*) FROM TEACHER WHERE T_NUMBER=" + " '"// ƴSQL���
					+ userName + "' " + "AND T_PASSWORD=" + " '" + userPwd
					+ "'  ";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					rs.close();
					stmt.close(); // �رռ�¼��������
					teacher = this.getTeacher(userName);
				} else {
					return null;
				}
				}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return teacher;
	}

	// ��ȡ��¼student��Ϣ
	public CstudentBean getStudent(String userName) {
		CstudentBean student = new CstudentBean();
		sql = "select * from student where s_number =" + " '" + userName + "' ";
		try {
			rs = this.executeQuery(sql);
			if (rs.next()) {
				student.setS_id(rs.getLong("S_ID"));
				student.setC_id(rs.getLong("C_ID"));
				student.setS_name(rs.getString("S_NAME"));
				student.setS_number(rs.getString("S_NUMBER"));
				student.setS_password(rs.getString("S_PASSWORD"));
				this.dropConnection(); // �رռ�¼����ɾ������
				return student;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return student;
	}

	// ��ȡ��¼teacher��Ϣ
	public CteacherBean getTeacher(String userName) {
		CteacherBean teacher = new CteacherBean();
		sql = "select * from teacher where t_number =" + " '" + userName + "' ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				teacher.setT_id(rs.getLong("T_ID"));
				teacher.setT_name(rs.getString("T_NAME"));
				teacher.setT_number(rs.getString("T_NUMBER"));
				teacher.setT_password(rs.getString("T_PASSWORD"));
				teacher.setSkill(rs.getString("T_SKILL"));
				this.dropConnection(); // �رռ�¼����ɾ������
				return teacher;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return teacher;
	}

	// ��ȡ��¼admin��Ϣ
	public CadminBean getAdmin(String userName) {
		CadminBean admin = new CadminBean();
		sql = "select A_ID,A_NAME,A_PASSWORD,A_TYPE from [ADMINISTRATOR] where A_NAME=" + " '" + userName
				+ "' ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				admin.setA_id(rs.getLong("A_ID"));
				admin.setA_name(rs.getString("A_NAME"));
				admin.setA_password(rs.getString("A_PASSWORD"));
				//admin.setA_password("bbs");
				admin.setA_type(rs.getLong("A_TYPE"));
				//admin.setA_type(4);
				this.dropConnection(); // �رռ�¼����ɾ������
				return admin;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return admin;
	}
	  //�������
	public boolean checkNet(){
		try {
			sql = "select * from tab";
			if (con == null) {
				DBConn(); // ����
			}
			rs = executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					rs.close();
					closeStmt(); // �رռ�¼��������
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	// ���˷Ƿ��ַ�
	public boolean checkParameter(String para) {
		int flag = 0;
		flag += para.indexOf("'") + 1;
		flag += para.indexOf(";") + 1;
		flag += para.indexOf("1=1") + 1;
		flag += para.indexOf("|") + 1;
		flag += para.indexOf("<") + 1;
		flag += para.indexOf(">") + 1;
		if (flag != 0) {
			System.out.println("�ύ�˷Ƿ��ַ�!!!");
			return false;
		}
		return true;
	}
}
