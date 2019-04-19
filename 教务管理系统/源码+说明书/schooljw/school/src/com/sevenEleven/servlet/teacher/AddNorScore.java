package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.teacher.DBO;
import com.sevenEleven.javaBean.teacher.Doing;

 public class AddNorScore extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	public AddNorScore() {
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
		String UpdateScore=request.getParameter("stuScore");
		int iUpdateScore = Integer.parseInt(UpdateScore);
		String score = request.getParameter("Scored");
		int iScore = Integer.parseInt(score);
		String scorePersent = request.getParameter("scorePersent");
		if(scorePersent == null || scorePersent == ""){
			request.setAttribute("errorMSG","û�и�����ʱ�ֵİٷֱ�!!");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		int iScorePersent = Integer.parseInt(scorePersent);
		
		 //��ƽʱ�ֺ�����ֵõ��ܷ�
		iScore = iScore * (100 - iScorePersent)/100 + iUpdateScore * iScorePersent/100;
		score = String.valueOf(iScore);
		//score = Integer.parseInt(score)*(100-Integer.parseInt(scorePersent))/100 + Integer.parseInt(UpdateScore) * Integer.parseInt(scorePersent)/100;  
		String s_id=request.getParameter("s_id");
		int x = 100-Integer.valueOf("12");
		if (UpdateScore==null||s_id==null){
			request.setAttribute("errorMSG","���ݷǷ�");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		Doing DB=DBO.DBODoing();
		if (!DB.IsTeacherStu(teacherID,s_id)){
			request.setAttribute("errorMSG","��ѧ���������ѧ��,��Ȩ�޸�");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		if (DB.AddStudentScore(teacherID,s_id,score,UpdateScore)){
			request.setAttribute("successMSG","����ѧ���ɼ��ɹ�");
			request.setAttribute("location","StuResult?s_id="+s_id);
			request.getRequestDispatcher("success.jsp").forward(request,response);
			return;
		}else{
			request.setAttribute("errorMSG","����ʧ��,��ϵϵͳ����Ա");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		DB.Close();
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}