package com.tsinghuait.st0717.hospitalsystem.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class PatientListServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		return this.select(request, response);
	}
	//���Ʊ�Ų�ѯ���˵���Ϣ
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return this.select(request, response);	
	}
	//���Ƿ����ѯ���˵���Ϣ
	protected RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		return this.select(request, response);
	}
	//ģ���鿴������Ϣ
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");
		String sql="";
		System.out.println("num:"+num);
		if(num==null||num==""||num.equals("null")){
			sql="select * from patient";	
		}else if(num=="1"||num.equals("1")){
			num="1";
			sql="select * from patient";	
		}else if(num=="2"||num.equals("2")){
			num="2";
			sql = "select * from patient where mcId=1";
		}else if(num=="3"||num.equals("3")){
				num="3";
				sql = "select * from patient where mcId=0";
		}else if(num=="4"||num.equals("4")){
			num="4";
			sql="select * from patient where isfinished=1";			
		}else if(num=="5"||num.equals("5")){
				num="5";
				sql="select * from patient where isfinished=0";
		}else{
			sql="select * from patient";
		}
		System.out.println("patientList_sql:"+sql);
		int page=1;
		int pageSize=5;
		String pag=request.getParameter("page");
		if(pag!=null){
			page=Integer.parseInt(pag);
		}
		PatientService dao=new PatientService();
		request.setAttribute("patientList",dao.selectPatientDTO(sql,page,pageSize));   
		PagePagination pf=new PagePagination();
		
		pf.setCurrentType(num);//��ס��ǰ�Ĵ���ؼ���
		System.out.println("numpf:"+pf.getCurrentType());
		pf.setPageNum(dao.getRowsPages());
		pf.setPageCount(dao.getPageCount());		
		if(page<dao.getPageCount()){	//��һҳ ��ֵ
			pf.setNextPage(page+1);
		}else{
			pf.setNextPage(dao.getPageCount());
		}
		if(page>1){			//��һҳ��ֵ
			pf.setPriorPage(page-1);
		}else{
			pf.setPriorPage(1);
		}
		pf.setLastPage(dao.getPageCount());			
		if(page>=pf.getLastPage()){	//�ж����Ƿ�������һҳ
			page=pf.getLastPage();
		}	
		pf.setPageSize(page);
		request.setAttribute("page", pf);
		System.out.println("curretyn:"+pf.getCurrentType());
		RequestDispatcher rd=request.getRequestDispatcher("view_zhouxiaoli/patientList.jsp");
		return rd;
	}
	//�޸Ĳ�����Ϣ
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse response) throws ServletException, IOException 
	{
		String oid=arg0.getParameter("oid");
		if(oid==null){
			oid="0";
		}
		int id=Integer.parseInt(oid);
		String sql="select *from patient where oid = "+id+"";
		System.out.println("Patient_sql:"+sql);
		PatientService patientService=new PatientService();
		arg0.setAttribute("patientSelect",patientService.selePatient(sql));
		RequestDispatcher rd=arg0.getRequestDispatcher("view_zhouxiaoli/patientsSelect.jsp");
		return rd;
	}	 
}