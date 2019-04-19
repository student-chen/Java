package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.LoginService;
import javax.swing.JOptionPane;

public class LoginServlet extends HttpServlet{
	/*
	 *  �Ե�¼�����ж�
	 * */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		String username=arg0.getParameter("username");
		String password=arg0.getParameter("password");
		String postOffice=arg0.getParameter("postOffice");
		System.out.println("username:"+username+"\n password:"+password+"\n postOffice:"+postOffice);
		String sql="";
		if(postOffice.equals("ҽ��")||postOffice==null||postOffice==""||postOffice=="ҽ��"){
			sql="select * from doctor where loginName='"+username+"' and loginPassword='"+password+"'";
			LoginService loginService=new LoginService();
			ResultSet rs=loginService.loginSelect(sql);
			if(rs!=null){
				String maName=loginService.selectDoctorMcName(sql);
				arg0.getSession().setAttribute("doctorLoginTree",maName);//ҽ����¼���ж����Ĳ��˺����Ŀ���
				System.out.println("session_loginDoctor:"+arg0.getSession().getAttribute("doctorLoginTree"));
				arg0.getSession().setAttribute("doctorName",username);
				arg0.getSession().setAttribute("doctorPassword",password);
				arg0.getRequestDispatcher("/mainDoctor.jsp").forward(arg0, arg1);
				return;
			}else{
				JOptionPane.showMessageDialog(null,"ҽ����¼ʧ��,��������д����Ϣ�Ƿ���ȷ!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}
		else if(postOffice=="��ʿ"||postOffice.equals("��ʿ")){
			sql="select *from nurse where loginName='"+username+"' and loginPassword='"+password+"'";
			LoginService loginService=new LoginService();
			ResultSet rs=loginService.loginSelect(sql);
			if(rs!=null){
				String maName=loginService.seleceNursePost(sql);
				arg0.getSession().setAttribute("nurseLoginTree",maName);//��ʿ��¼���ж����Ĳ��˺����Ŀ���
				System.out.println("session_loginNurse:"+arg0.getSession().getAttribute("nurseLoginTree"));	
				arg0.getSession().setAttribute("nurseName",username);
				arg0.getSession().setAttribute("nursePassword",password);
				arg0.getRequestDispatcher("/mainNurse.jsp").forward(arg0, arg1);
				return ;
			}else{
				JOptionPane.showMessageDialog(null,"��ʿ��¼ʧ��,��������д����Ϣ�Ƿ���ȷ!!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}
		else if(postOffice=="����Ա"||postOffice.equals("����Ա")){
			if((username.equals("����Ա")||username=="����Ա")&&(password=="123"||password.equals("123"))){
				arg0.getRequestDispatcher("/main.jsp").forward(arg0, arg1);
				return ;
			}else{
				JOptionPane.showMessageDialog(null,"����Ա��¼ʧ��,��������д����Ϣ�Ƿ���ȷ!!!");
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return ;
			}
		}else{
			JOptionPane.showMessageDialog(null,"��¼ʧ��!!!");
			arg0.getRequestDispatcher("/h").forward(arg0, arg1);
			return ;
		}
	}
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}	
}