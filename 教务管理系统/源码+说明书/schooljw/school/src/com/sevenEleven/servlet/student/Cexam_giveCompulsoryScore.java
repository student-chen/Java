package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.exam.CoperationOfExam;

/**
 * Servlet implementation class for Servlet: Cexam_giveCompulsoryScore
 * 
 */
public class Cexam_giveCompulsoryScore extends javax.servlet.http.HttpServlet
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
	public Cexam_giveCompulsoryScore() {
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
		request.setCharacterEncoding("gb2312");
		CoperationOfExam operateExam = new CoperationOfExam();
		int choose1Mark = 0; // ��ѡ�����
		int choose2Mark = 0; // ��ѡ�����
		int textMark = 0; // ��������
		// ���㵥ѡ����
		for (int i = 1; i <= 10; i++) {
			if (request.getParameter("Key1" + i) == null || request.getParameter("Key1" + i) == "") {
				continue;
			}
			String curChoose1Answer = request.getParameter("Key1" + i);
			String curChoose1Id = request.getParameter("choose1id" + i);
			try {
				if (operateExam.Choose1IsRight(curChoose1Id, curChoose1Answer)) {
					choose1Mark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// �����ѡ����
		for (int j = 1; j <= 10; j++) {
			if (request.getParameter("Key2" + j) == null || request.getParameter("Key2" + j) == "") {
				continue;
			}
			String[] curChoose2Answer = request.getParameterValues("Key2" + j);
			String curChoose2Id = request.getParameter("choose2id" + j);
			String Choose2Answer = null;
			for (int i = 0; i < curChoose2Answer.length; i++) {
				Choose2Answer += curChoose2Answer[i];
			}

			try {
				if (operateExam.Choose1IsRight(curChoose2Id, Choose2Answer)) {
					choose2Mark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ������շ���
		for (int k = 1; k <= 10; k++) {
			if (request.getParameter("text" + k) == null || request.getParameter("text" + k) == "") {
				continue;
			}
			String curTextAnswer = request.getParameter("text" + k);
			String curTextId = request.getParameter("textid" + k);
			try {
				if (operateExam.text1IsRight(curTextId, curTextAnswer)) {
					textMark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//String s = request.getParameter("courseId");
		CstudentBean student = (CstudentBean) request.getSession()
				.getAttribute("student");
		int sumMark = choose1Mark + choose2Mark + textMark;// �õ��ܷ�
		// �ܷ�ת���ַ�����
		
		String s_mark = String.valueOf(sumMark);	
		// ���ܷ�
		try {
			operateExam.insetCompulsoryE_Mark(String.valueOf(student.getS_id()),
					request.getParameter("courseId"), s_mark);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       //��תҳ��
		request.setAttribute("choose1Mark",choose1Mark);//��ѡ
		request.setAttribute("choose2Mark",choose2Mark);//��ѡ
		request.setAttribute("textMark",textMark);//���
		request.setAttribute("s_mark",s_mark);
		request.getRequestDispatcher("exam_displayCompulsoryMark.jsp").forward(request, response);
	}
}