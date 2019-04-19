package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet:
 * CautoMakeScheme_getLesson1AndTeacherInfo
 * 
 */
public class CautoMakeScheme_getLesson1AndTeacherInfo extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_getLesson1AndTeacherInfo() {
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
		CmakeTeacherAndCourseTogether mtact = new CmakeTeacherAndCourseTogether();
		String className = (String) request.getSession()
				.getAttribute("className");
		String phase = (String) request.getSession().getAttribute("phase");
		//�õ�State��teacher�ٷŵ�Parameter��ȥ
		String lesson1Name = (String) request.getParameter("state");
		String teacherName = (String) request.getParameter("teacher");
		
		//
		String lesson1Id = null;
		String classId = null;
		String warnMessage = new String();      //�������
//		 ��className�õ�classId
		if ((className == null) || (className == "")) {
            request.getSession().setAttribute("warnMessage","�γ�������Ϊ��!!");
            request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
            return;
	} else {

		try {
			classId = mtact
					.getClassIdFromClassName(className);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		// ��lesson1Name�õ�lesson1Id
		if ((lesson1Name == null) || (lesson1Name == "")) {
                   request.getSession().setAttribute("warnMessage","�γ�������Ϊ��!!");
                   request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
                   return;
		} else {

			try {
				 lesson1Id = mtact
						.getLesson1IdFromLesson1Name(lesson1Name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
       // ��teacherName �õ�teacher id
		String teacherId = null;
		if ((teacherName == null) || (teacherName == "")) {
			 request.getSession().setAttribute("warnMessage","��ʦ������Ϊ��!!");
             request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
             return;
		} else {

			try {
				 teacherId = mtact
						.getTeacherIdFromTeacherName(teacherName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// �ж������Ƿ��Ѵ���.���ھͷ��ش�����Ϣ,���������������  
		if(mtact.checkTableTeacherAndLesson1ForClass(classId,lesson1Id,teacherId)){
			request.getSession().setAttribute("warnMessage","�γ��ѱ�����!!");
			request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
			return;
		}else{
			warnMessage = mtact.insertIntoTableTeacherAndLesson1ForClass(teacherId, lesson1Id, classId,phase)?("����ɹ�"):("����ʧ��");
			request.getSession().setAttribute("warnMessage",warnMessage);
			request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
			return;
		}

	}
}