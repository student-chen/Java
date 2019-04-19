package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.Page;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_updateOrDeleteTestServlet
 * 
 */
public class Cexam_updateOrDeleteTestServlet extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5540700906168746917L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_updateOrDeleteTestServlet() {
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
	
		Cexam exam = new Cexam();
		// ��ҳ����:
		// 1.����ж���һ�η���.��session����.��request�в��ܰѶ�������.�÷�����鷳
		// 2.javaScipt�ύ�˵�������,�ύ����.
		// 3.curPage �����ǰҳ�������ȡ������,����javaScipe�ύ��û������.
		// ���ʵ��:��JavaScipt,�����ж��Ƿ�Ϊ��ʹ�л��д����,����������
		// request.getSession().getAttribute("teacher");
		// ��ʹ��,��ʾ��һҳ
//���޿�ѡ�������ʾ
		Page choose1Page = new Page();
		List choose1List = null;
		int maxChoose1RowCount = exam.getLengthOfChoose1Table();// choose1���ж�����
		choose1Page.setCurPage(1); // Ϊcourse1Page���Bean���õ�ǰҳΪ1
		choose1Page.setRowsPerPage(15); // Ϊcourse1Page���Bean����ÿҳΪ15������.
		choose1Page.setFormName("choose1Form"); // Ϊcourse1Page���Bean����FormName
		choose1Page.setMaxRowCount(maxChoose1RowCount); // Ϊcourse1Page���Bean���ü�¼�й��ж�����.
		
		if (maxChoose1RowCount % 15 == 0) {// Ϊcourse1Page���Bean�������ҳ��.
			choose1Page.setMaxPage(maxChoose1RowCount / 15 );//����ҳ��������ÿҳ��������ʱ
		} else {
			choose1Page.setMaxPage(maxChoose1RowCount / 15 + 1);//����
		}
		choose1Page.setTarget("CflushExam_updateOrDeleteTestServlet");// Ϊchoose1Page���BeanҪ��ת��servlet,���Ǳ�ҳ.
		choose1List = exam.getChoose1Table(1, 15); // ȡ����ʹ���ĵ�ǰҳ��Ҫ��ʾ�ļ�¼.
		request.getSession().setAttribute("choose1Page", choose1Page);
		request.setAttribute("choose1List", choose1List);
		request.setAttribute("choose1ToString",choose1Page.toString());
		request.setAttribute("choose1PageStr", choose1Page.getPageStr());
		//ѡ��ѡ����
		int maxChoose2RowCount = exam.getLengthOfChoose2Table();
		List choose2List = exam.getChoose2Table(1,maxChoose2RowCount);
		request.setAttribute("choose2List", choose2List);
		//���������
		int maxText1RowCount = exam.getLengthOfText1Table();
		List text1List = exam.getText1Table(1,maxText1RowCount);
		request.setAttribute("text1List", text1List);
		//ѡ�������
		int maxText2RowCount = exam.getLengthOfText2Table();
		List text2List = exam.getText2Table(1,maxText2RowCount);
		request.setAttribute("text2List", text2List);
//		//ѡ�޿�ѡ�������ʾ
//		Page choose2Page = new Page();
//		List choose2List = null;
//		int maxChoose2RowCount = exam.getLengthOfChoose2Table();// choose2���ж�����
//		choose2Page.setCurPage(1); // Ϊcourse2Page���Bean���õ�ǰҳΪ1
//		choose2Page.setRowsPerPage(15); // Ϊcourse2Page���Bean����ÿҳΪ15������.
//		choose2Page.setFormName("choose2Form"); // Ϊcourse2Page���Bean����FormName
//		choose2Page.setMaxRowCount(maxChoose2RowCount); // Ϊcourse2Page���Bean���ü�¼�й��ж�����.
//		
//		if (maxChoose2RowCount % 15 == 0) {// Ϊcourse2Page���Bean�������ҳ��.
//			choose2Page.setMaxPage(maxChoose2RowCount / 15 );//����ҳ��������ÿҳ��������ʱ
//		} else {
//			choose2Page.setMaxPage(maxChoose2RowCount / 15 + 1);//����
//		}
//		choose2Page.setTarget("CflushExam_updateOrDeleteTestServlet");// Ϊchoose2Page���BeanҪ��ת��servlet,���Ǳ�ҳ.
//		choose2List = exam.getChoose2Table(1, 15); // ȡ����ʹ���ĵ�ǰҳ��Ҫ��ʾ�ļ�¼.
//		request.getSession().setAttribute("choose2Page", choose2Page);
//		request.setAttribute("choose2List", choose2List);
//		request.setAttribute("choose2ToString",choose2Page.toString());
//		request.setAttribute("choose2PageStr", choose2Page.getPageStr());
////		���޿���������ʾ
//		Page text1Page = new Page();
//		List text1List = null;
//		int maxText1RowCount = exam.getLengthOfText1Table();
//		text1Page.setCurPage(1); 
//		text1Page.setRowsPerPage(15); 
//		text1Page.setFormName("text1Form"); 
//		text1Page.setMaxRowCount(maxText1RowCount); 
//		
//		if (maxText1RowCount % 15 == 0) {
//			text1Page.setMaxPage(maxText1RowCount / 15 );
//		} else {
//			text1Page.setMaxPage(maxText1RowCount / 15 + 1);
//		}
//		text1Page.setTarget("CflushExam_updateOrDeleteTestServlet");
//		text1List = exam.getText1Table(1, 15); 
//		request.getSession().setAttribute("text1Page", text1Page);
//		request.setAttribute("text1List", text1List);
//		request.setAttribute("text1ToString",text1Page.toString());
//		request.setAttribute("text1PageStr", text1Page.getPageStr());
////		ѡ�޿���������ʾ
//		Page text2Page = new Page();
//		List text2List = null;
//		int maxText2RowCount = exam.getLengthOfText2Table();
//		text2Page.setCurPage(1); 
//		text2Page.setRowsPerPage(15); 
//		text2Page.setFormName("text2Form"); 
//		text2Page.setMaxRowCount(maxText2RowCount); 
//		
//		if (maxText2RowCount % 15 == 0) {
//			text2Page.setMaxPage(maxText2RowCount / 15 );
//		} else {
//			text2Page.setMaxPage(maxText2RowCount / 15 + 1);//����
//		}
//		text2Page.setTarget("CflushExam_updateOrDeleteTestServlet");
//		text2List = exam.getText2Table(1, 15); 
//		request.getSession().setAttribute("text2Page", text2Page);
//		request.setAttribute("text2List", text2List);
//		request.setAttribute("text2ToString",text2Page.toString());
//		request.setAttribute("text2PageStr", text2Page.getPageStr());
		// ��ʹ����ת
		request.getRequestDispatcher("exam_updateOrDeleteTest.jsp").forward(
				request, response);
	}
}