package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;
public class Nurse_operationRoomService{	
//	�鿴������Ϣ
	public ArrayList selectNurse(String sql){
		ArrayList<Nurse> arr=null;	
      try 
		 {
		   ResultSet rs=new SQLConnection().executeQuery(sql);
		 if(rs!=null){
			arr=new ArrayList<Nurse>();
		      while(rs!=null&&rs.next()){
		    	  Nurse dto=new Nurse();
					dto.setId(rs.getInt("id"));
					dto.setStaffNo(rs.getString("staffNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setPostid(rs.getInt("postid"));
					dto.setPost(rs.getString("post"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
					arr.add(dto);
				}
			 }	
		}	catch(Exception e)
		       {
			e.printStackTrace();
		       }
		return arr;
	}
	//���ػ�ʿ�ı��
	public int execteUpdate(String sql)
	{	
		ResultSet rs=null;
		int num=0;
		rs=new SQLConnection().executeQuery(sql);	
			try {
				if(rs!=null||rs.next())
				{
					while(rs.next())
					{
						num=rs.getInt("id");
						System.out.println("ID���"+num);
					}
				System.out.println(num);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return num;
		
	}
	//���ر��
	public int execte(String sql){	
		ResultSet rs=null;
		int num=0;
		rs=new SQLConnection().executeQuery(sql);	
			try 
			{
				if(rs!=null||rs.next())
				{
					while(rs.next())
					{
						num=rs.getInt("operationRoom_id");
						System.out.println("ID���"+num);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		return num;		
	}
	//��������������
	public String execteOrNO(String sql){	
		ResultSet rs=null;
		String num=null;
		rs=new SQLConnection().executeQuery(sql);	
			try 
			{
				if(rs!=null||rs.next())
				{
					while(rs.next())
					{
						num=rs.getString("orNo");
						System.out.println("ID���"+num);
					}
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		return num;		
	}
}
