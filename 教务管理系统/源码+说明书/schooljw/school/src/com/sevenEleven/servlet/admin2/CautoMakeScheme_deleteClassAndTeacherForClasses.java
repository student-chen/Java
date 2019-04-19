package com.sevenEleven.servlet.admin2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet: CautoMakeScheme_deleteClassAndTeacherForClasses
 *
 */
 public class CautoMakeScheme_deleteClassAndTeacherForClasses extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_deleteClassAndTeacherForClasses() {
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
		CmakeTeacherAndCourseTogether mtact = new CmakeTeacherAndCourseTogether();
		String id =request.getParameter("action");
		if(id == "" || id == null || id == "null"){
			request.getSession().setAttribute("warnMessage","ɾ��ʧ��");
		}else{
			if(!mtact.deleteTableTeacherAndLesson1ForClass(id))//ɾ��
			{
				request.getSession().setAttribute("warnMessage","ɾ��ʧ��");
			}else{
				request.getSession().setAttribute("warnMessage","ɾ���ɹ�");
			}
		}
		request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
	}   	
 	  	    
}