package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;
import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: OneSchemeMaker
 * 
 */
public class OneSchemeMaker extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public OneSchemeMaker() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String CID = request.getParameter("cname");

		String TIMEID1 = request.getParameter("time1");
		String L1ID1 = request.getParameter("lesson11");
		String TID1 = request.getParameter("teacher1");
		String CRID1 = request.getParameter("classroom1");

		String sql1 = "insert into lesson1_list values (" + CID + "," + TID1
				+ "," + CRID1 + "," + L1ID1 + ",'" + TIMEID1 + "')";
		// System.out.print(sql1);
		String sqlcheckteacher = "SELECT C_NAME,TIME.TIME_ID,L1_NAME,T_NAME,CR_NAME FROM CLASS,TIME,LESSON1,TEACHER,CLASSROOM,LESSON1_LIST WHERE CLASS.C_ID=LESSON1_LIST.C_ID AND TIME.TIME_ID=LESSON1_LIST.TIME_ID AND LESSON1.L1_ID=LESSON1_LIST.L1_ID AND TEACHER.T_ID=LESSON1_LIST.T_ID AND CLASSROOM.CR_ID=LESSON1_LIST.CR_ID AND LESSON1_LIST.TIME_ID='"
				+ TIMEID1 + "' AND LESSON1_LIST.T_ID=" + TID1;
		String sqlcheckscheme = "SELECT C_NAME,TIME.TIME_ID,L1_NAME,T_NAME,CR_NAME FROM CLASS,TIME,LESSON1,TEACHER,CLASSROOM,LESSON1_LIST WHERE CLASS.C_ID=LESSON1_LIST.C_ID AND TIME.TIME_ID=LESSON1_LIST.TIME_ID AND LESSON1.L1_ID=LESSON1_LIST.L1_ID AND TEACHER.T_ID=LESSON1_LIST.T_ID AND CLASSROOM.CR_ID=LESSON1_LIST.CR_ID AND LESSON1_LIST.TIME_ID='"
				+ TIMEID1 + "' AND LESSON1_LIST.C_ID=" + CID;
		String sqlcheckclassroom = "SELECT C_NAME,TIME.TIME_ID,L1_NAME,T_NAME,CR_NAME FROM CLASS,TIME,LESSON1,TEACHER,CLASSROOM,LESSON1_LIST WHERE CLASS.C_ID=LESSON1_LIST.C_ID AND TIME.TIME_ID=LESSON1_LIST.TIME_ID AND LESSON1.L1_ID=LESSON1_LIST.L1_ID AND TEACHER.T_ID=LESSON1_LIST.T_ID AND CLASSROOM.CR_ID=LESSON1_LIST.CR_ID AND LESSON1_LIST.TIME_ID='"
				+ TIMEID1 + "' AND LESSON1_LIST.CR_ID=" + CRID1;
		String sqlcheckTeacherSkill = "SELECT count(*) FROM TEACHER t WHERE t.T_SILL = (SELECT L1_NAME FROM LESSON1 L1 WHERE L1.L1_ID =" + L1ID1 + ")";
		// System.out.print(sqlcheckteacher);
		// System.out.print(sqlcheckscheme);
		CDBOracle db = new CDBOracle();
		CConnectMSSQL check = new CConnectMSSQL();
		List checkteacherlist = check
				.getNestedListFromResultSet(sqlcheckteacher);// �����ʦ��ͻ
		CConnectMSSQL check2 = new CConnectMSSQL();
		List checkschemelist = check2
				.getNestedListFromResultSet(sqlcheckscheme);// ����ѧ�ƻ���ͻ
		CConnectMSSQL check3 = new CConnectMSSQL();
		List checkclassroomlist = check3
				.getNestedListFromResultSet(sqlcheckclassroom);// �����ҳ�ͻ
		CConnectMSSQL check4 = new CConnectMSSQL();
		List checkTeacherSkill = check4
				.getNestedListFromResultSet(sqlcheckTeacherSkill);// �����ʦ������γ��Ƿ��Ӧ
		// System.out.print(checkteacherlist);
		// System.out.print(checkschemelist);
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		boolean a = String.valueOf(checkschemelist).equals("[]");
		boolean b = String.valueOf(checkteacherlist).equals("[]");// �����ݿ��м����ʦ��״̬����ֵ
		boolean c = String.valueOf(checkclassroomlist).equals("[]");
		boolean d = String.valueOf(checkTeacherSkill).equals("[]");
		// System.out.print(b);
		if (!b) {
			out
					.print("<script language=javascript>alert('�ο���ʦϵͳ�ţ�"
							+ TID1
							+ "�Ѿ��ڸ�ʱ���ϿΣ���˶Ժ������ύ');this.location.href='info_admin.jsp'</script>");

		} else if (!a) {
			out
					.print("<script language=javascript>alert('�༶ϵͳ�ţ�"
							+ CID
							+ "��ѧ�ƻ��г�ͻ����˶Ժ������ύ');this.location.href='info_admin.jsp'</script>");
		} else if (!c) {
			out
					.print("<script language=javascript>alert('����ϵͳ�ţ�"
							+ CRID1
							+ "�Ѿ���Ԥ������˶Ժ������ύ');this.location.href='info_admin.jsp'</script>");
		} else if (!d) {
			out.print("<script language=javascript>alert('�ο���ʦϵͳ�ţ�" + TID1
					+ "û�м�����γ̺�" + L1ID1
					+ "��Ӧ');this.location.href='info_admin.jsp'</script>");
		} else {
			out
					.print("<script language=javascript>alert('�Ѿ��ύ�ſ���Ϣ');this.location.href='info_admin.jsp'</script>");
			db.executeUpdate(sql1);
			response.sendRedirect("info_admin.jsp");
		}

	}
}