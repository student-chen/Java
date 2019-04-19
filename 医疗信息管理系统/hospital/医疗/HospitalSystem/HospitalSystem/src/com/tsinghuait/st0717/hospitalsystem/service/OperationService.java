package com.tsinghuait.st0717.hospitalsystem.service;

import com.tsinghuait.st0717.hospitalsystem.dto.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;

public class OperationService {	
	SQLConnection ssdb=new SQLConnection();
    public Collection selectDoctor(String sql)
    {
    	ResultSet rs=null;
    	ArrayList <Doctor> conn=null;
    	try {
    	    rs=ssdb.executeQuery(sql);
    	    if (rs != null)
			{
				conn = new ArrayList<Doctor>();
				while(rs.next()&&rs!=null){
				  Doctor dd=new Doctor();
                  dd.setName(rs.getString("name"));
			      conn.add(dd);
			  }
	       }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return conn;
    }
    public Collection selectorNo(String sql)
    {
    	ResultSet rs=null;
    	ArrayList <OperatingRoom> conn=null;
    	try {
    	    rs=ssdb.executeQuery(sql);
    	    if (rs != null)
			{
				conn = new ArrayList<OperatingRoom>();
				while(rs.next()&&rs!=null)
			   {
				  OperatingRoom ord=new OperatingRoom();
                  ord.setOrNo(rs.getString("orNo"));
			      conn.add(ord);
			   }
	       }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return conn;
    }
    public int returnId(String sql)
    {
    	ResultSet rs=null;
    	int id=0;
    	try
    	{
    		rs=ssdb.executeQuery(sql);
    		if(rs!=null)
    		{
    		   while(rs.next())
    		   {
    		   id=rs.getInt("id");	
    		   }
    		}
    		else
    		{
    			System.out.println("Ϊ��");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("����ID���쳣");
    		e.printStackTrace();
    	}
    	return id;
    }
    public int returnRoomId(String sql)
    {
    	ResultSet rs=null;
    	int id=0;
    	try
    	{
    		rs=ssdb.executeQuery(sql);
    		if(rs!=null)
    		{
    			while(rs.next())
    			{
    		     id=rs.getInt("operatingRoomId");	
    			}
    		}
    		else
    		{
    			System.out.println("Ϊ��");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("����operatingRoomId���쳣");
    		e.printStackTrace();
    	}
    	return id;
    }
    public int returnOid(String sql)
    {
    	ResultSet rs=null;
    	int id=0;
    	try
    	{
    		rs=ssdb.executeQuery(sql);
    		if(rs!=null)
    		{	
    		   while(rs.next())
    		   {
    		   id=(int)rs.getInt("oid");
    		   }
    		}
    		else
    		{
    			System.out.println("Ϊ��");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("����Oid���쳣");
    		e.printStackTrace();
    	}
    	return id;
    }
    public String returnPatientNo(String sql)
    {
    	ResultSet rs=null;
    	String patientNo=null;
    	try
    	{
    		rs=ssdb.executeQuery(sql);
    		if(rs!=null)
    		{	
    		   while(rs.next())
    		   {
    			   patientNo=rs.getString("patientNo");
    		   }
    		}
    		else
    		{
    			System.out.println("Ϊ��");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("����Oid���쳣");
    		e.printStackTrace();
    	}
    	return patientNo;
    }
    public boolean insertOperation(String sql)
    {
 	   boolean flag=false;
 	   int i=ssdb.executeUpdate(sql);
 	   try{
 		   if(i!=0)
 		   {
 			   flag=true;
 		   }
 		   else{
 			   System.out.println("�������������ɹ� \n"+i);
 		   }
 	   } 
 	   catch (Exception e)
 	   {
 		System.out.print("������������ɹ�1");
 		e.printStackTrace();
 	   }
 	   return flag;
    }
    public boolean updateOperation(String sql)
    {
 	   boolean flag=false;
 	   int i=ssdb.executeUpdate(sql);
 	   try{
 		   if(i>0)
 		   {
 			   flag=true;
 		   }
 		   System.out.println("�޸Ĳ��ɹ�"+i);
 	   } 
 	   catch (Exception e)
 	   {
 		System.out.print("�޸����������ɹ�2");
 		e.printStackTrace();
 	   }
 	   return flag;
    }
}