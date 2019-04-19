package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.InHospitalService;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class InHospitalServlet extends BaseServltes {
	InHospitalService ihs=new InHospitalService();
	protected RequestDispatcher delete(HttpServletRequest request,
			HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request,
			HttpServletResponse reponse) throws ServletException, IOException {
		String name=(String)request.getSession().getAttribute("doctorLoginTree");
		System.out.println("Login_patientMcName:"+name);
		PatientService patientService=new PatientService();
		String sql="select * from patient where isfinished=0 and mcName='"+name+"'";
	    request.setAttribute("inHospitalPatient",patientService.selePatient(sql));			
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/inHospitalPatient.jsp");
		return rd;
	}
	protected RequestDispatcher insert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		//��ò��˵�����
		//String patientName=request.getParameter("patientName");
		String patientName=getParamByMyFilter(request, "patientName");
		String pId=request.getParameter("pId");
		int patientId=Integer.parseInt(pId);
		//��������Ų�ѯ����Id
		String bedNo=request.getParameter("bed");
		String sql1="select id from sickbed where bedNo='"+bedNo+"'";
		int bedid1=ihs.returnId(sql1);
		String startdate=request.getParameter("startdate");
	    String enddate=request.getParameter("enddate");		
		//���סԺ�ͳ�Ժ��ʱ���
		int day=ihs.getdate(startdate, enddate);
		if(day<0)
		{
			 rd=request.getRequestDispatcher("/inHospitalServlet?opertion=4&name="+patientName+"&id="+patientId);
		     JOptionPane.showMessageDialog(null," ��ѡ���סԺʱ����Ժʱ�䲻��ȷ");
		}
		else
		{
		String sql2="select sinkbedId from sinkbedSchedule where startTime='"+startdate+"' and endTime='"+enddate+"'";
	    int bedid2=ihs.returnSickbedId(sql2);
	    if(bedid1==bedid2)
	    {
	    	    rd=request.getRequestDispatcher("/inHospitalServlet?opertion=4&name="+patientName+"&id="+patientId);
		        JOptionPane.showMessageDialog(null,"�ò������ڸö�ʱ�䱻ʹ��");
	    }
	    else
	    {
	    	String sql11="insert into sinkbedSchedule values ("+bedid1+",'"+startdate+"','"+enddate+"',null)";
	    	String sql22="insert into stayInHp values("+patientId+","+bedid1+","+day+")";
	    	String sql33="update patient set isfinished=1 where oid="+patientId;
	    	boolean flag1=ihs.insertInHospital(sql11);
	    	boolean flag2=ihs.insertInHospital(sql22);
	    	boolean flag3=ihs.updateInHospital(sql33);
	    	System.out.println("flag1:"+flag1+"\n flag2:"+flag2+"\n flag3:"+flag3);
	    	if(flag1==false||flag2==false||flag3==false)
	    	{
	    		System.out.println("���ʧ��");
	    		rd=request.getRequestDispatcher("/inHospitalServlet?opertion=4&name="+patientName+"&id="+patientId);
	    		JOptionPane.showMessageDialog(null,"סԺ���ʧ�ܣ���ȷ��������Ϣ�Ƿ�׼ȷ");
	    	}
			request.getSession().setAttribute("locationURL", "patientServlet?isfinished=1");
	        rd=request.getRequestDispatcher("/submits.jsp");
	       /*rd=request.getRequestDispatcher("/patientServlet?isfinished=1");
	       JOptionPane.showMessageDialog(null,"סԺ��ӳɹ�");*/
	      }
		}
		return rd;
	}
	protected RequestDispatcher select(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        //	��ò�������
		String patientName=getParamByMyFilter(request, "name");
		System.out.println("patientName2:"+patientName+" \np:");
		//��ò��˱��
		String i=request.getParameter("id");
		int oid=0;
		if(i!=null){
			oid=Integer.parseInt(i);
		}
		System.out.println("oid:"+oid);
		request.setAttribute("pName",patientName);
		request.setAttribute("oid", oid);
		String sqlbedNo="select bedNo from sickbed where isUseable=0";
		request.setAttribute("bedNo", ihs.selectbedNo(sqlbedNo));
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/addInHospital.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest request,
			HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
