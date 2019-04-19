package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;
public class OperationRoomWuJiRuiServlet extends BaseServltes{
	/**
	 *    �⼪��    
	 * ����ʵ�ֶ������ұ������ɾ���ġ��� 
	 */	
	//ɾ����Ϣ
	protected RequestDispatcher delete(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		     String id=arg0.getParameter("id");
		     String deletesql="delete from operationRoom where id="+id+"";
		     String deletenurse_opsql="delete from nurse_opertionRoom where operationRoom_id="+id+"";
		     OperationRoomWuJiRuiService operationRoom=new OperationRoomWuJiRuiService();
	       if(operationRoom.executeUpdate(deletesql)>0&&operationRoom.executeUpdate(deletenurse_opsql)>0){
	    	   JOptionPane.showMessageDialog(null,"��ɾ����");	  
	       }else{
	    	   JOptionPane.showMessageDialog(null,"δɾ����");
	       }
	       this.select(arg0, arg1);
	      RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
		return rd;
	}  
	protected RequestDispatcher executeQuery(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {	
		return this.select(arg0, arg1);
	}
	//���������Ϣ
	protected RequestDispatcher insert(HttpServletRequest arg0,	HttpServletResponse arg1) throws ServletException, IOException {
		     arg0.setCharacterEncoding("gbk");
		     arg1.setCharacterEncoding("gbk");
		     OperationRoomWuJiRuiService opRoom=new OperationRoomWuJiRuiService();
		      String orNo=arg0.getParameter("orNo");
		      String address=arg0.getParameter("address");
		      String info=arg0.getParameter("info");
		      String [] nurseList=arg0.getParameterValues(("nurseName"));  
		      for (int i = 0; i < nurseList.length; i++) {		    	  
		    	  System.out.println("nurseList:"+nurseList[i]);
			  }   
		     int isUseable=Integer.parseInt(arg0.getParameter("kongxian"));
		       //int id=new OperationRoomWuJiRuiService().returnid();//��ȡoperationRoom�е����һ�����ݵ�ID
		      // int idss=id+1;
		      String addsql="insert into operationRoom(orNo,address,info,isUseable) values('"+orNo+"','"+address+"','"+info+"',"+isUseable+")";  
		      if(opRoom.executeUpdate(addsql)>0){
				  JOptionPane.showMessageDialog(null,"��ӳɹ�");
		      }else{
				  JOptionPane.showMessageDialog(null,"���ʧ��");
		      }//�������ݿ������һ�������ң�operationRoom����Ϣ
		     
		      int id=new OperationRoomWuJiRuiService().returnid();//��ȡoperationRoom�е����һ�����ݵ�ID
		      //������nurse_opertionRoom��ѭ����������  
		      for(int j=0;j<nurseList.length;j++){      
		      String addnursesql="insert into nurse_opertionRoom(nurse_id,operationRoom_id) values("+nurseList[j]+","+id+")";   
			      if(opRoom.executeUpdate(addnursesql)>0){
			    	  arg1.getWriter().println("��ӳɹ���");
			       }else{
				       arg1.getWriter().println("���ʧ�ܣ�");
					} 
		      }         
		      System.out.println("operationRoom_add_sql:"+addsql);  

		      arg1.setContentType("text/html;charset=gbk");
					    
				//arg0.getSession().setAttribute("locationURL", "view_wujirui/showOprtionRoom.jsp");
			   // RequestDispatcher rd=arg0.getRequestDispatcher("/submits.jsp");
		     this.select(arg0, arg1);
		     RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
			 return rd;
	}	        
	//��ѯ������ 
	protected RequestDispatcher select(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		String name=arg0.getParameter("orNo");
		String isUseable=arg0.getParameter("isUseable");		
		if(isUseable==null||isUseable==""||isUseable.equals("null")){
			isUseable ="1";
		}	   
		System.out.println("isUseable:"+isUseable+"\n name:"+name);
		String sql="";
		if(name==null){	
			sql="select * from operationRoom where orNo like '%"+name+"%'";
		}
		if(name!=null){
			if(isUseable=="0"||isUseable.equals("0")){
			    sql="select * from operationRoom where isUseable=0 and orNo like '%"+name+"%'";  	
			}else if(isUseable=="1"||isUseable.equals("1")){
				sql="select * from operationRoom where isUseable=1 and orNo like '%"+name+"%'";
			}else{
				sql = "select * from operationRoom where orNo like '%"+name+"%'";
			}
		}		
		System.out.println("sql:"+sql);
	     OperationRoomWuJiRuiService operationRoomService=new OperationRoomWuJiRuiService();
		arg0.setAttribute("operationRoomList",operationRoomService.selectOperationRoom(sql));	
		arg0.setAttribute("isUseableType",isUseable.toString());
		RequestDispatcher rd=arg0.getRequestDispatcher("/view_wujirui/showOprtionRoom.jsp");
		return rd;
	}
	//�޸�
	protected RequestDispatcher update(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		   OperationRoomWuJiRuiService operationSer=new OperationRoomWuJiRuiService();
           String id=arg0.getParameter("id");  
	       String orNo=arg0.getParameter("orNo");
           String address=arg0.getParameter("address");
           String info=arg0.getParameter("info");   
           int isUseable=Integer.parseInt(arg0.getParameter("isUseable"));
		      String [] updatenurseList=arg0.getParameterValues(("updateNurseName"));  
		      for (int i = 0; i < updatenurseList.length; i++) {		    	  
		    	  System.out.println("nurseList:"+updatenurseList[i]);
			} 

           String updatesql="update operationRoom set orNo='"+orNo+"',address='"+address+"',info='"+info+"',isUseable="+isUseable+" where id="+id+"";
           System.out.println("update_sql:"+updatesql);  
           // ���Ƚ�ԭ����nurse_operationRoom�еĸ���õĻ�ʿȫ��ɾ��
           String dele="delete from nurse_opertionRoom where operationRoom_id="+id+"";
             if(new OperationRoomWuJiRuiService().executeUpdate(dele)>0){
            	 System.out.println("dddddddddddddd��ɾ�����ȴ�������ӣ�1");
             }else{
            	 System.out.println("not ddddddddddddddddδɾ����1");
             }
                  //������ӻ�ʿ��Ϣ
             for (int k=0;k<updatenurseList.length;k++){
                 String insertsql="insert into nurse_opertionRoom(nurse_id,operationRoom_id) values("+updatenurseList[k]+","+id+")";
                         if(operationSer.executeUpdate(insertsql)>0){
                      	   System.out.println("�ѽ�ԭ��ʿ�޸��ˣ�2");
                         }else{
                      	   System.out.println("δ�޸� ��2");
                         }
                    }
           if(new OperationRoomWuJiRuiService().executeUpdate(updatesql)>0){
            
            	 JOptionPane.showMessageDialog(null,"���޸ģ�");
             }else{
            
            	 JOptionPane.showMessageDialog(null,"δ�޸ģ�");
             }
		   this.select(arg0, arg1);
         RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
		  return rd;
	} 
}
