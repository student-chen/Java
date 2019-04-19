package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet:
 * CautoMakeScheme_printCheckedClassAndPhase
 * 
 */
public class CautoMakeScheme_printCheckedClassAndPhase extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_printCheckedClassAndPhase() {
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
		String classname = (String) request.getSession().getAttribute("className");
		String phase = (String) request.getSession().getAttribute("phase");
		String warnMessage = "���Ϊ"
				+ classname
				+ "�İ༶�Ŀ�����,��պ�ſ�������";
		if (mtact.isExistInTable(classname, (String) request.getSession().getAttribute(
				"phase"))) {
			request.getSession().setAttribute("warnMessage", warnMessage);
			request.getRequestDispatcher("CautoMakeScheme_getAllClasses")
					.forward(request, response);
		} else {

			// �õ����еĿγ�
			try {
				List lesson1NameList = mtact.getAllLesson1Name();
				request.setAttribute("lesson1List", lesson1NameList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�õ��༶-��ʦ-�γ����߹�ϵ�ı������༶�������Ϣ
			try {
				List c_l_t = mtact.getTeacherAndLesson1ForClass(classname,phase);
				request.setAttribute("c_l_t_list", c_l_t);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ��ҳ����༶����ʦ�Ϳγ̵���Ϣ
			request.getRequestDispatcher(
					"automakescheme2_addTeacherAndLesson1.jsp").forward(
					request, response);
		}
	}
}