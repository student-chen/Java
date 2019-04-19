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
 * Servlet implementation class for Servlet: OneLesson2ListSchemeMaker
 * 
 */
public class OneLesson2ListSchemeMaker extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public OneLesson2ListSchemeMaker() {
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

		String TIMEID1 = request.getParameter("time1");
		String L2ID1 = request.getParameter("lesson2");
		String TID1 = request.getParameter("teacher1");
		String CRID1 = request.getParameter("classroom1");
		// System.out.print(TIMEID1);
		// System.out.print(L2ID1);
		// System.out.print(TID1);
		// System.out.print(CRID1);
		String sql1 = "insert into lesson2_list values (" + CRID1 + "," + TID1
				+ "," + L2ID1 + ",'" + TIMEID1 + "')";
		// System.out.print(sql1);
		String sqlcheckteacher = "SELECT TIME.TIME_ID,L2_NAME,T_NAME,CR_NAME FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='"
				+ TIMEID1 + "' AND LESSON2_LIST.T_ID=" + TID1;

		String sqlcheckclassroom = "SELECT TIME.TIME_ID,L2_NAME,T_NAME,CR_NAME FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='"
				+ TIMEID1 + "' AND LESSON2_LIST.CR_ID=" + CRID1;
		String sqlcheckLessonOfTeacher  = "SELECT count(*) FROM TEACHER t WHERE t.T_SKILL = (SELECT L2_NAME FROM LESSON2 L2 WHERE L2.L2_ID =" + L2ID1 + ")";
		// System.out.print(sqlcheckteacher);
	    System.out.print(sqlcheckclassroom);
		CDBOracle db = new CDBOracle();
		CConnectMSSQL check = new CConnectMSSQL();
		List checkteacherlist = check
				.getNestedListFromResultSet(sqlcheckteacher);// �����ʦ��ͻ
		CConnectMSSQL check3 = new CConnectMSSQL();
		List checkclassroomlist = check3
				.getNestedListFromResultSet(sqlcheckclassroom);// �����ҳ�ͻ
		// System.out.print(checkteacherlist);
		CConnectMSSQL check4 = new CConnectMSSQL();
        List checkLessonOfTeacher = check4.getNestedListFromResultSet(sqlcheckLessonOfTeacher);//�����ʦ�ļ�����γ��Ƿ�һ��
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		System.out.print(checkclassroomlist);
		boolean b = String.valueOf(checkteacherlist).equals("[]");// �����ݿ��м����ʦ��״̬����ֵ
		boolean c = String.valueOf(checkclassroomlist).equals("[]");
		boolean d = String.valueOf(checkLessonOfTeacher).equals("[]");
		System.out.print(b);
		if (!b) {
			out.print("<script language=javascript>alert('�ο���ʦϵͳ�ţ�"
							+ TID1
							+ "�Ѿ�û��');this.location.href='info_admin.jsp'</script>");

		}

		else if (!c) {
			out.print("<script language=javascript>alert('����ϵͳ�ţ�"
							+ CRID1
							+ "�Ѿ���Ԥ������˶Ժ������ύ');this.location.href='info_admin.jsp'</script>");
		}else if(!d){
			out.print("<script language=javascript>alert('�ο���ʦ�ţ�"
					+ TID1
					+"û�пγ�IDΪ: "
					+ L2ID1
					+ " �ļ���,��˶Ժ������ύ');this.location.href='info_admin.jsp'</script>");
		}
		else {
			db.executeUpdate(sql1);
			response.sendRedirect("info_admin.jsp");
		}
	}
}