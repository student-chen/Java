package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.SickBedService;
public class SickBedServlet extends BaseServltes {
	/**
	 *    �⼪��
	 *    
	 * ����ʵ�ֶԲ����������ɾ���ġ��� 
	 */
	//ɾ����Ϣ
	protected RequestDispatcher delete(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		     String id=arg0.getParameter("id");
		     String deletesql="delete from sickbed where id="+id+"";
		     String deletenurse_sickbed="delete from nurse_sickbed where sickbed_id="+id+"";
		     System.out.println("sickbed_delete_sql:"+deletesql+"\n nurse_sickbed_delete_sql:"+deletenurse_sickbed);
		     SickBedService sickBedService=new SickBedService();
	       if(sickBedService.executeUpdate(deletesql)>0&&sickBedService.executeUpdate(deletenurse_sickbed)>0){
	             System.out.println("��ɾ����");
	    	  
	       }else{
	    	    System.out.println("δɾ����");
	       }
	       this.select(arg0, arg1);
	      RequestDispatcher rd=arg0.getRequestDispatcher("/view_wujirui/showSickBed.jsp");
		return rd;
	}
  

	@Override
	protected RequestDispatcher executeQuery(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
	
		return null;
	}

	//��Ӳ�����Ϣ
	@Override
	protected RequestDispatcher insert(HttpServletRequest arg0,HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		SickBedService sickBed=new SickBedService();
		   String bedNo=arg0.getParameter("bedNo");
		   String type=arg0.getParameter("type");
		   int isUseable=Integer.parseInt(arg0.getParameter("isUseable"));
		      String [] nurseNameList=arg0.getParameterValues(("nurseNameList"));  
		      for (int i = 0; i < nurseNameList.length; i++) {		    	  
		    	  System.out.println("nurseList:"+nurseNameList[i]);
			} 
		      int id=new SickBedService().returnSickId();
		      int idss=id+1;
		    String addSickBed="insert into sickBed values('"+bedNo+"','"+type+"',"+isUseable+")";
		      for(int j=0;j<nurseNameList.length;j++){      
			      String addnursesql="insert into nurse_sickbed(nurse_id,sickbed_id) values("+nurseNameList[j]+","+idss+")";
					      if(sickBed.executeUpdate(addnursesql)>0){
					    	  System.out.println("��ӳɹ�~��");
					      }
					      else{
					    	  System.out.println("���ʧ�ܣ�");
					      } 
			      }  		      
		      
		      SickBedService sick=new SickBedService();
		      if(sick.executeUpdate(addSickBed)>0){
		    	  JOptionPane.showMessageDialog(null,"��ӳɹ�..");
		      }
		      else{
		    	  JOptionPane.showMessageDialog(null,"���ʧ��..");
		      }
		       this.select(arg0, arg1);
			//	arg0.getSession().setAttribute("locationURL", "view_wujirui/showSickBed.jsp");
		     //RequestDispatcher rd=arg0.getRequestDispatcher("/submits.jsp");
	        RequestDispatcher rd=arg0.getRequestDispatcher("/view_wujirui/showSickBed.jsp");
			return rd;
	}	        

	//��ѯ������ 
	protected RequestDispatcher select(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		String sql = "select * from sickbed";	 
		SickBedService sickbedService=new SickBedService();
		arg0.setAttribute("sickbedList",sickbedService.selectSickBed(sql));	
		RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showSickBed.jsp");
		return rd;
	}
	
	
	//�޸Ĳ�����
	protected RequestDispatcher update(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");   
		   SickBedService sicksss=new SickBedService();
		String id=arg0.getParameter("id");
		String bedNo=arg0.getParameter("bedNo");
		String type =arg0.getParameter("type");
		 int isUseable=Integer.parseInt(arg0.getParameter("isUseable"));//no 	
	    String [] upsickdatenurseList=arg0.getParameterValues(("sickNurseNameList"));  
	      for (int i = 0; i < upsickdatenurseList.length; i++) {		    	  
	    	  System.out.println("nurseList:"+upsickdatenurseList[i]);
		} 
	      // ���Ƚ�ԭ����nurse_sickbed�еĸ���õĻ�ʿȫ��ɾ��
		   String delenursesql="delete from nurse_sickbed where sickbed_id="+id+"";
	         if(new SickBedService().executeUpdate(delenursesql)>0){
          	 System.out.println("��ɾ�����ȴ�������ӣ�1");
           }else{
          	 System.out.println("not ddδɾ����1");
           }
	         //������ӻ�ʿ��Ϣ
	         for (int s=0;s<upsickdatenurseList.length;s++){
	         String insertnursql="insert into nurse_sickbed(nurse_id,sickbed_id) values("+upsickdatenurseList[s]+","+id+")";
             if(sicksss.executeUpdate(insertnursql)>0){
            	   System.out.println("�ѽ�ԭ��ʿ�޸��ˣ�2");
               }else{
            	   System.out.println("δ�޸� ��2");
               }
	     }
		String upsql="update sickbed set bedNo='"+bedNo+"',type='"+type+"',isUseable="+isUseable+" where id="+id+"";
		  System.out.println("sql:"+upsql);
			SickBedService sickbed=new SickBedService();
		  if(sickbed.executeUpdate(upsql)>0){
			  System.out.println("���޸ģ�3");
		  }else{
			  System.out.println("δ�޸ģ�3");
		  }
		  this.select(arg0, arg1);
		RequestDispatcher rd=arg0.getRequestDispatcher("/view_wujirui/showSickBed.jsp");
		return rd;
	} 
}