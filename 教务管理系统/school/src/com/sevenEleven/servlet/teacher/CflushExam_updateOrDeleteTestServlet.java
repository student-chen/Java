package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.Page;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: CflushExam_updateOrDeleteTestServlet
 *
 */
 public class CflushExam_updateOrDeleteTestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CflushExam_updateOrDeleteTestServlet() {
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
		String[] curPageArray = request.getParameterValues("pageSize");
//		 �ı䵱ǰҳ,��ʾ��ǰҳ
		//���޿ε�ѡ����
	
		List choose1List = null;
		 Page choose1Page = (Page) request.getSession().getAttribute("choose1Page");
		 
		int curPage = Integer.parseInt(curPageArray[0]);
		choose1Page.setCurPage(curPage);
		if (curPage < choose1Page.getMaxPage()) {
			choose1List = exam.getChoose1Table((curPage - 1)//ȡ����ǰҳ��Ҫ��ʾ�ļ�¼.
					* choose1Page.getRowsPerPage() + 1, curPage
					* choose1Page.getRowsPerPage());
		} else {
			choose1List = exam.getChoose1Table((curPage - 1)
					* choose1Page.getRowsPerPage() + 1, choose1Page//ȡ�����һҳҳ��Ҫ��ʾ�ļ�¼.
					.getMaxRowCount());
		}
		request.setAttribute("choose1PageStr",choose1Page.getPageStr());
		request.setAttribute("choose1PageToString",choose1Page.toString());
		request.setAttribute("choose1List",choose1List);
		
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
/*		ѡ�޿ε�ѡ����
		request.setCharacterEncoding("gb2312");
		List choose2List = null;
		 Page choose2Page = (Page) request.getSession().getAttribute("choose1Page");
		int curPage2 = Integer.parseInt(request.getParameter("pageSize"));
		choose2Page.setCurPage(curPage2);
		if (curPage2 < choose2Page.getMaxPage()) {
			choose2List = exam.getChoose2Table((curPage2 - 1)//ȡ����ǰҳ��Ҫ��ʾ�ļ�¼.
					* choose2Page.getRowsPerPage() + 1, curPage2
					* choose2Page.getRowsPerPage());
		} else {
			choose2List = exam.getChoose2Table((curPage2 - 1)
					* choose2Page.getRowsPerPage() + 1, choose2Page//ȡ�����һҳҳ��Ҫ��ʾ�ļ�¼.
					.getMaxRowCount());
		}
		request.setAttribute("choose2PageStr",choose2Page.getPageStr());
		request.setAttribute("choose2PageToString",choose2Page.toString());
		request.setAttribute("choose2List",choose2List);
//	���޿ε������
		request.setCharacterEncoding("gb2312");
		List text1List = null;
		 Page text1Page = (Page) request.getSession().getAttribute("choose1Page");
		int curPage3 = Integer.parseInt(request.getParameter("pageSize"));
		text1Page.setCurPage(curPage3);
		if (curPage3 < text1Page.getMaxPage()) {
			text1List = exam.getChoose2Table((curPage3 - 1)//ȡ����ǰҳ��Ҫ��ʾ�ļ�¼.
					* text1Page.getRowsPerPage() + 1, curPage3
					* text1Page.getRowsPerPage());
		} else {
			text1List = exam.getChoose2Table((curPage3 - 1)
					* text1Page.getRowsPerPage() + 1, text1Page//ȡ�����һҳҳ��Ҫ��ʾ�ļ�¼.
					.getMaxRowCount());
		}
		request.setAttribute("text1PageStr",text1Page.getPageStr());
		request.setAttribute("text1PageToString",text1Page.toString());
		request.setAttribute("text1List",text1List);
//*		ѡ�޿ε�ѡ����
		request.setCharacterEncoding("gb2312");
		List text2List = null;
		 Page text2Page = (Page) request.getSession().getAttribute("choose1Page");
		int curPage4 = Integer.parseInt(request.getParameter("pageSize"));
		text2Page.setCurPage(curPage4);
		if (curPage4 < text2Page.getMaxPage()) {
			text2List = exam.getChoose2Table((curPage4 - 1)//ȡ����ǰҳ��Ҫ��ʾ�ļ�¼.
					* text2Page.getRowsPerPage() + 1, curPage4
					* text2Page.getRowsPerPage());
		} else {
			text2List = exam.getChoose2Table((curPage4 - 1)
					* text2Page.getRowsPerPage() + 1, text2Page//ȡ�����һҳҳ��Ҫ��ʾ�ļ�¼.
					.getMaxRowCount());
		}
		request.setAttribute("text2PageStr",text2Page.getPageStr());
		request.setAttribute("text2PageToString",text2Page.toString());
		request.setAttribute("text2List",text2List);
	   //�ǳ�ʹ����ת*/
		request.getRequestDispatcher("exam_updateOrDeleteTest.jsp").forward(
				request, response);
	}   	  	    
}