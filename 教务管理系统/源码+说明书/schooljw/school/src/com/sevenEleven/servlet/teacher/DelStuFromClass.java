package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.teacher.Typer;
import com.sevenEleven.javaBean.teacher.DBO;
import com.sevenEleven.javaBean.teacher.Doing;

 public class DelStuFromClass extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public DelStuFromClass() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
		if (teacherID==null||teacherID==""){
			request.setAttribute("errorMSG","û�е�½���½�ѳ�ʱ");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		String s_id_del=request.getParameter("s_id");
		if (s_id_del==null||s_id_del==""||!Typer.IsInter(s_id_del)){
			request.setAttribute("errorMSG","���ݲ��Ϸ�");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		Doing DB=DBO.DBODoing();
		if (!DB.IsTeacherStu(teacherID,s_id_del)){
			request.setAttribute("errorMSG","��ѧ���������ѧ��,����ɾ��");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		if (!DB.DelStudenFromClass(s_id_del)){
			request.setAttribute("errorMSG","ɾ��ʧ��??");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		DB.Close();
		request.setAttribute("successMSG","ɾ��ѧ���ɹ�");
		request.setAttribute("location","ShowTeacherStudent.jsp");
		request.getRequestDispatcher("success.jsp").forward(request,response);
		return;
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}