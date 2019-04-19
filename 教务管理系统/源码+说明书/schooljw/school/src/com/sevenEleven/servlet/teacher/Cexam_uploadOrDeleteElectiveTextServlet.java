package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_uploadOrDeleteElectiveTextServlet
 *
 */
 public class Cexam_uploadOrDeleteElectiveTextServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_uploadOrDeleteElectiveTextServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cexam exam = new Cexam();
	
//		 ���if����Ƕ�ҳ��exam_updateOrDeleteTest.jsp�Ĳ鿴��ť����Ӧ
		if (request.getParameter("cType") != null
				&& request.getParameter("cType").equals("easyText")) {
			CtextTestBean text = exam.getText2Table(request
					.getParameter("view"));
			request.setAttribute("type", "ѡ�޿������");
			request.setAttribute("text", text);
			request.getRequestDispatcher("exam_newPageUpdateText.jsp").forward(
					request, response);

		}
		// ���if����Ƕ�ҳ��exam_updateOrDeleteTest.jsp��ɾ����ť����Ӧ
		if (request.getParameter("dType") != null
				&& request.getParameter("dType").equals("easyText")) {
			exam.deleteItemOfText2Table(request.getParameter("delete"));
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		}
	}   	  	    
}