package com.sevenEleven.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_uploadOrDeleteTestServlet
 * 
 */
public class Cexam_uploadOrDeleteTestServlet extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7446936267762213860L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_uploadOrDeleteTestServlet() {
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
		Cexam exam = new Cexam();
	
		// ���if����Ƕ�ҳ��exam_updateOrDeleteTest.jsp�Ĳ鿴��ť����Ӧ
		if (request.getParameter("cType") != null
				&& request.getParameter("cType").equals("mustChoose")) {
			CchooseTestBean choose = exam.getChoose1Table(request
					.getParameter("view"));
			if (choose.getType() == 1) {
				request.setAttribute("type", "���޿ε�ѡ��");
				request.setAttribute("choose1", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose1.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("type", "���޿ζ�ѡ��");
				request.setAttribute("choose2", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose2.jsp")
				.forward(request, response);
			}
		} else if (request.getParameter("cType") != null
				&& request.getParameter("cType").equals("easyChoose")) {
			CchooseTestBean choose = exam.getChoose2Table(request
					.getParameter("view"));
			if (choose.getType() == 1) {
				request.setAttribute("type", "ѡ�޿ε�ѡ��");
				request.setAttribute("choose1", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose1.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("type", "ѡ�޿ζ�ѡ��");
				request.setAttribute("choose2", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose2.jsp")
						.forward(request, response);
			}
		} else if (request.getParameter("cType") != null
				&& request.getParameter("cType").equals("mustText")) {
			CtextTestBean text = exam.getText1Table(request
					.getParameter("view"));
			request.setAttribute("type", "���޿������");
			request.setAttribute("text", text);
			request.getRequestDispatcher("exam_newPageUpdateText.jsp").forward(
					request, response);
		} else if (request.getParameter("cType") != null
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
				&& request.getParameter("dType").equals("mustChoose")) {
			String x = request.getParameter("delete");
			exam.deleteItemOfChoose1Table(x);
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		} else if (request.getParameter("dType") != null
				&& request.getParameter("dType").equals("easyChoose")) {
			exam.deleteItemOfChoose2Table(request.getParameter("delete"));
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		} else if (request.getParameter("dType") != null
				&& request.getParameter("dType").equals("mustText")) {
			exam.deleteItemOfText1Table(request.getParameter("delete"));
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		} else if (request.getParameter("dType") != null
				&& request.getParameter("dType").equals("easyText")) {
			exam.deleteItemOfText2Table(request.getParameter("delete"));
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		}
		
	}
}