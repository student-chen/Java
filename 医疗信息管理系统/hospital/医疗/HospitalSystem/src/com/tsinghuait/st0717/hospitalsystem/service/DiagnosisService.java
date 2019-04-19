package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;


public class DiagnosisService {
	SQLConnection ssd=new SQLConnection();
	ResultSet rs=null;
   public int selectDoctorID(String sql)
   {
	   int doctorID=0;
	   rs=ssd.executeQuery(sql);
	   try
	   {
		   if(rs!=null)
		   {
			   while(rs.next())
			   {
				  doctorID=rs.getInt("id");
			   }
		   }
	   }
	   catch (SQLException e) 
	   {
		System.out.println("��ѯҽ��ID���ɹ�");
		e.printStackTrace();
	   }
	   return doctorID;
    }
   public int selectPatientID(String sql)
   {
	   int patientID=0;
	   rs=ssd.executeQuery(sql);
	   try
	   {
		   if(rs!=null)
		   {
			   while(rs.next())
			   {
			   patientID=rs.getInt("oid");
			   }
		   }
		   else
		   {
			   System.out.println("IDΪ��");
		   }
	   }
	   catch (SQLException e) 
	   {
		System.out.println("��ѯ����ID���ɹ�");
		e.printStackTrace();
	   }
	   return patientID;
    }
   public boolean insertDiagnosis(String sql)
   {
	   boolean flag=false;
	   int i=ssd.executeUpdate(sql);
	   try{
		   if(i>0)
		   {
			   flag=true;
		   }
		   System.out.println("����"+i);
	   } 
	   catch (Exception e)
	   {
		System.out.print("�������鲻�ɹ�");
		e.printStackTrace();
	   }
	   return flag;
   }
   public boolean updateDiagnosis(String sql)
   {
	   boolean flag=false;
	   int i=ssd.executeUpdate(sql);
	   try{
		   if(i>0)
		   {
			   flag=true;
		   }
		   System.out.println("�޸�"+i);
	   } 
	   catch (Exception e)
	   {
		System.out.print("�������鲻�ɹ�");
		e.printStackTrace();
	   }
	   return flag;
   }
}
