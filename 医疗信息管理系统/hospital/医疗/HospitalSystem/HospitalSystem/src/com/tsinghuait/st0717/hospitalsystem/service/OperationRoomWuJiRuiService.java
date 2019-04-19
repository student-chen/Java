package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;
import com.tsinghuait.st0717.hospitalsystem.dto.OperatingRoom;
public class OperationRoomWuJiRuiService {
	/*�⼪��
	 * 	
	 * ����������ұ���в���       
	 * **/
	//��ѯ�����
	public ArrayList selectOperationRoom(String sql){
	   	ArrayList<OperatingRoom> arrayList=null;
	   	try{
	   		ResultSet rs=new SQLConnection().executeQuery(sql);
		     if(rs!=null){
		    	  arrayList=new ArrayList<OperatingRoom>();
		     while(rs.next()&&rs!=null){
		    	 		OperatingRoom dto=new OperatingRoom();
		    			 dto.setId(rs.getInt("id"));
		    		     dto.setOrNo(rs.getString("orNo"));
		    		     dto.setAddress(rs.getString("address"));
		    		     dto.setInfo(rs.getString("info"));
		    		     dto.setIsUseable(rs.getInt("isUseable"));
		    			  arrayList.add(dto);
		    		 }	  		 
		    	   }
		 }catch(Exception e){
		      e.printStackTrace();
    }  	  
		return arrayList;	
	}

	public Collection getNurseList(String temp[]){		
		return this.nurseList(temp);
	}
	public ArrayList  nurseList(String temp[]){	
		ArrayList<Nurse> col=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement();
			for(int i=0;i<temp.length;i++){
				ResultSet rs=st.executeQuery("select * from nurse where id="+temp[i]);
				if(rs!=null){
					col=new ArrayList<Nurse>();
					while(rs.next()){
						Nurse n=new Nurse();
						n.setId(rs.getInt("id"));
						n.setName(rs.getString("name"));		
						col.add(n);
					}
				}
			}			
		} catch (SQLException e) {
			System.out.println("�����ݿ��еı���в���ʱ���ֲ�������!!");
			e.printStackTrace();
		}
		
		return col;
	}
	
	//���������ʱ��ʾ�����ҵ���ϸ��Ϣ��
	public ArrayList getNurseListNameCollection(String sql){
		ArrayList<String> arrList=null;
		try {
				ResultSet rs=new SQLConnection().executeQuery(sql);
				if(rs!=null)
				{
					arrList=new ArrayList<String>();
					while(rs.next()&&rs!=null){	
						arrList.add(rs.getString("orNo"));
				 		/*arrList.add(rs.getString("type"));*/
						arrList.add(rs.getString("address"));
						arrList.add(rs.getString("info"));
						arrList.add(rs.getString("isUseable"));
					}
					System.out.println("Arraylist:"+arrList);
			}			
		} catch (SQLException e) {
			System.out.println("�����ݿ��еı���в���ʱ���ֲ�������!!");
			e.printStackTrace();
		}		
		return arrList;
	}	
	//�÷������������ʱ��ʾ��ʿ������
	public ArrayList addoperationgetNurseListName(String sql){
		ArrayList<Nurse> al=null;
		try {	ResultSet rs=new SQLConnection().executeQuery(sql);
		     if(rs!=null){
			   al=new ArrayList<Nurse>();
				while(rs.next()&&rs!=null){
					 Nurse dto=new Nurse();
					 dto.setId(rs.getInt("id"));
					 dto.setName(rs.getString("name"));
				     al.add(dto);
				  }
			} 
			}catch (SQLException e) {				
				e.printStackTrace();
		   }
		return al;
	}	
	//���������ҵ����һ�е�	ID
	public int returnid(){
	   String selectId="select top 1 id from operationRoom  order by id  desc";
	    ResultSet rs=new SQLConnection().executeQuery(selectId);
		int id=0;
		    if(rs!=null){
		    	try {
		    		while(rs.next()){
		    			id=rs.getInt("id");
		    		}
				} catch (SQLException e) {	
					e.printStackTrace();
				}
		    }
		    
		return id;
	}
		
	
	//�÷���������ʾ��������ϸ��Ϣʱ��ʾ��ʿ��������
	public ArrayList nurseNameList(int id){
		ArrayList<Nurse> arr=null;
		String sql="select nurse.name from nurse_opertionRoom,operationRoom,nurse where nurse_opertionRoom.nurse_id=nurse.id and nurse_opertionRoom.operationRoom_id=operationRoom.id and operationRoom.id="+id+"";
		ResultSet rs=new SQLConnection().executeQuery(sql);
		try {
			if(rs!=null){
				arr=new ArrayList<Nurse>();
				while(rs!=null&&rs.next()){
					Nurse dto=new Nurse();
					dto.setName(rs.getString("name"));
					arr.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	public int executeUpdate(String sql){
		int count=0;
		try{ 
			count=new SQLConnection().executeUpdate(sql);
		  if(count>0){
			  System.out.println(" �����ɹ���");
		  }
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;	
	}	
}
