package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.OperationService;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class OperationServlet extends BaseServltes {

	@Override
	protected RequestDispatcher delete(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		String name=(String)arg0.getSession().getAttribute("doctorLoginTree");
		System.out.println("Login_patientMcName:"+name);
		PatientService patientService=new PatientService();
		String sql="select * from patient where isfinished=0 and mcName='"+name+"'";
	    arg0.setAttribute("operationPatient",patientService.selePatient(sql));			
		RequestDispatcher rd=arg0.getRequestDispatcher("view_linli/operationPatient.jsp");
		return rd;
	}

	protected RequestDispatcher executeQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return this.select(request, response);
	}
	protected RequestDispatcher insert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=GBK");
		 RequestDispatcher rd=null;
		OperationService os=new OperationService();//ʵ����һ��OperationService����
		//��ò��˵�����
	/*	String patientName=request.getParameter("patientName").toString();
		System.out.println("patientName1"+patientName);*/
		String patientName=getParamByMyFilter(request,"patientName");
		//�����ҳ�����صĲ��˵�Id
		String p=request.getParameter("pId");
		int patientId=Integer.parseInt(p);
		/*System.out.println(p);
		int patientId=0;
		if(p==null){
			String oid="select oid from patient where name='"+patientName+"'";
			patientId=os.returnOid(oid);
		}
		else
		{
			patientId=Integer.parseInt(p);
		}*/
		//��ò��˵ĿƱ�
		String patientType=request.getParameter("patientType");
		System.out.print(patientType);
		String date=request.getParameter("date");	//�õ���������
		String sh=request.getParameter("shour");	//�õ�������ʼʱ���Сʱ
		String sm=request.getParameter("sminute");  //�õ�������ʼʱ��ķ���
		String eh=request.getParameter("ehour");    //�õ���������ʱ���Сʱ
		String em=request.getParameter("eminute");  //�õ���������ʱ��ķ���
		String Starttime=date+" "+sh+":"+sm+":00";  //������ʼʱ��
		String Endtime=date+" "+eh+":"+em+":00";    //��������ʱ��
		System.out.println("Starttime"+Starttime+"Endtime"+Endtime);
		String sqla="select operatingRoomId from operation where startTime='"+Starttime+"' and endTime='"+Endtime+"'";
		int roomId=os.returnRoomId(sqla);  //��ѯ�ö�ʱ������ò���
	/*	if(roomId<=0)
		{
			//request.getHeader("refresh,0;url=operationServlet?opertion=4");
		}*/
		//��ô˴��������軨�ѵĽ��  (��β��ܱ����û����������ĸ)
		String money=request.getParameter("pay");
		float pay=Float.parseFloat(money);
		//ͨ�����ұ�Ų�ѯ�ò��ҵ�Id
		String No=request.getParameter("No");
		String sql2="select id from operationRoom where orNo='"+No+"'";
		int orNo=os.returnId(sql2);//���ݲ��ҵı�Ż����ID
		if(roomId==orNo)//���orNo����roomId����������ǲ����õ�
		{
			//System.out.println("�������Ҳ�����");
	        rd=request.getRequestDispatcher("/operationServlet?opertion=4&name="+patientName+"&id="+patientId);
	        JOptionPane.showMessageDialog(null,"�������Ҳ�����");
		}
		else
		{
			System.out.println("�����ұ��"+orNo);
			//��ø���ҽʦ��Id
			String extDoctorName=request.getParameter("extDoctorName");
			String sql3="select id from doctor where name='"+extDoctorName+"'";
			int extDoctorId=os.returnId(sql3);//����������ø���ҽʦID
	        //�������ҽʦ��Id
			String pkDoctorName=request.getParameter("pkDoctorName");
			String sql4="select id from doctor where name='"+pkDoctorName+"'";
			int pkDoctorId=os.returnId(sql4);//���������������ҽʦID
			System.out.println("extDoctorId"+extDoctorId+"pkDoctorId"+pkDoctorId);
	        //��������(operation)�в�����Ϣ
			String sql11="insert into operation values("+pay+","+orNo+","+patientId+","+pkDoctorId+","+extDoctorId+",1,'"+Starttime+"','"+Endtime+"')";
			boolean flag1=os.insertOperation(sql11);
			//���վݱ�(receipt)�в�����Ϣ
			String sql22="insert into receipt values('"+patientType+"',"+pay+",'"+patientName+"',"+patientId+",getdate(),0)";
			boolean flag2=os.insertOperation(sql22);
			//��ѯ�ö�ʱ���operationId
			String sql="select id from operation where  patenitID="+patientId+" and startTime='"+Starttime+"' and endTime='"+Endtime+"'";
		    int operationId=os.returnId(sql);
			//�������Ұ��ű�(operationSchedule)�в�����Ϣ
			String sql33="insert into operationSchedule values("+orNo+","+operationId+",'"+Starttime+"','"+Endtime+"')";
			boolean flag3=os.insertOperation(sql33);
			//�޸Ĳ��˵Ĵ����ֶ�(isfinished)
			String sql44="update patient set isfinished=1 where oid="+patientId;	
			boolean flag4=os.updateOperation(sql44);
			System.out.println("flag1:"+flag1);
			System.out.println("flag2:"+flag2);
			System.out.println("flag3:"+flag3);
			System.out.println("flag4:"+flag4);
			if(flag1==false||flag2==false||flag3==false||flag4==false)
			{
			     System.out.println("���ʧ��...");
			     rd=request.getRequestDispatcher("/operationServlet?opertion=4&name="+patientName+"&id="+patientId);
			     JOptionPane.showMessageDialog(null,"�������ʧ�ܣ���ȷ��������Ϣ�Ƿ�׼ȷ");
			}
	      rd=request.getRequestDispatcher("/patientServlet?isfinished=1");
	      JOptionPane.showMessageDialog(null,"������ӳɹ�");
	    }
		return rd;
	}
	
	String sqlOrNo = null;
	protected RequestDispatcher select(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ò�������
	/*	String p=request.getParameter("name");
		String patientName=null;
		if(p!=null){
			patientName=new String(p.trim().getBytes("iso-8859-1"),"gbk");
		}
		System.out.println("patientName2:"+patientName+" \np:"+p);*/
		String patientName=getParamByMyFilter(request, "name");
		//��ò��˱��
		String i=request.getParameter("id");
		int oid=0;
		if(i!=null){
			oid=Integer.parseInt(i);
		}
		System.out.println("oid:"+oid);
		request.setAttribute("pName",patientName);
		request.setAttribute("oid", oid);
		OperationService os=new OperationService();
		String sqlDoctorName="select name from doctor";
		request.setAttribute("DoctorName", os.selectDoctor(sqlDoctorName));
	    String slqOrNo="select orNO from operationRoom where isUseable=1";
		request.setAttribute("roomOrNo",os.selectorNo(slqOrNo));
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/addOperation.jsp");
		return rd;
	}

	@Override
	protected RequestDispatcher update(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
