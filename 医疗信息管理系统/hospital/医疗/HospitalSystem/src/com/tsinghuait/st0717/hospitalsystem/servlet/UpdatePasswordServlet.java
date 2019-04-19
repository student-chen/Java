package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.DoctorService;
import com.tsinghuait.st0717.hospitalsystem.service.NurseService;

public class UpdatePasswordServlet extends BaseServltes{
	//ҽ��������޸�
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name=(String)arg0.getSession().getAttribute("doctorName");
		String password=(String)arg0.getSession().getAttribute("doctorPassword");
		String password1=arg0.getParameter("loginPassword2");
		String sql="update doctor set loginPassword='"+password1+"' where loginName='"+name+"' and loginPassword='"+password+"'";
		RequestDispatcher rd=null;
		System.out.println("UpdatePasswordDoctor_sql"+sql);
		DoctorService doctorService=new DoctorService();
		int num=doctorService.DoctorUpdate(sql);
		if(num==0){
			StringBuffer sb=new StringBuffer();
			JOptionPane.showMessageDialog(null, "��ҽ���޸�����ʧ�ܣ�������������Ƿ���ȷ��!");
			sb.append("<script>alert('��ҽ���޸�����ʧ�ܣ�������������Ƿ���ȷ!')</script>");
			arg0.setAttribute("alertMsg", sb.toString());
			rd=arg0.getRequestDispatcher("view/updatedoctorpassword.jsp");
		}else{
			JOptionPane.showMessageDialog(null, "��ҽ���޸�����ɹ������ס�������������!!");
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('��ҽ���޸�����ɹ������ס�������������!')</script>");
			arg0.setAttribute("alertMsg", sb.toString());
			rd=arg0.getRequestDispatcher("/first.jsp");
		}
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return arg0.getRequestDispatcher("/doctorServlet?opertion=4");
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return arg0.getRequestDispatcher("/nurseServlet?opertion=4");
	}
	//��ʿ������޸�
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name=(String)arg0.getSession().getAttribute("nurseName");
		String password=(String)arg0.getSession().getAttribute("nursePassword");
		String password1=arg0.getParameter("password1");
		String sql="update nurse set loginPassword='"+password1+"' where loginName='"+name+"' and loginPassword='"+password+"'";
		RequestDispatcher rd=null;
		System.out.println("UpdatePasswordNurse_sql"+sql);
		NurseService nurseService=new NurseService();
		int num=nurseService.NurseUpdate(sql);
		if(num==0){
			StringBuffer sb=new StringBuffer();
			JOptionPane.showMessageDialog(null, "�˻�ʿ�޸�����ʧ�ܣ�������������Ƿ���ȷ!");
			sb.append("<script>alert('�˻�ʿ�޸�����ʧ�ܣ�������������Ƿ���ȷ!')</script>");
			arg0.setAttribute("alertMsg", sb.toString());
			rd=arg0.getRequestDispatcher("view/updatenursepasssword.jsp");
		}else{
			JOptionPane.showMessageDialog(null, "�˻�ʿ�޸�����ɹ������ס�������������!");
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('�˻�ʿ�޸�����ɹ������ס�������������!')</script>");
			arg0.setAttribute("alertMsg", sb.toString());
			rd=arg0.getRequestDispatcher("/first.jsp");
		}
		return rd;
	}
}