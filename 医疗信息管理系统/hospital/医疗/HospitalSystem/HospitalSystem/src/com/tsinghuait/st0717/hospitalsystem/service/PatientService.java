package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Patient;
public class PatientService {
	/**
	 * �Բ��˵Ĳ���
	 * �����ݿ����
	 * */
	//�鿴 
	public ResultSet selectPatient(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;
	}
	public int execteUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	//����
	public ArrayList selePatient(String sql){
		ArrayList<Patient> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null){
			arr=new ArrayList<Patient>();
			try {
				while(rs.next()&&rs!=null){
					Patient dto=new Patient();
					dto.setOid(rs.getInt("oid"));
					dto.setPatientNo(rs.getString("patientNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setAddress(rs.getString("address"));
					dto.setAge(rs.getInt("age"));
					dto.setIsfinished(rs.getByte("isfinished"));
					dto.setMcId(rs.getInt("mcId"));
					dto.setMcName(rs.getString("mcName"));
					arr.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
//	�鿴������Ϣ	
	public ArrayList selectPatientDTO(String sql){
		ArrayList<Patient> arr=null;	
      try {
		   ResultSet rs=new SQLConnection().executeQuery(sql);
		 if(rs!=null){
			arr=new ArrayList<Patient>();
		      while(rs.next()){
		    	    Patient dto=new Patient();
					dto.setOid(rs.getInt("oid"));
					dto.setPatientNo(rs.getString("patientNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setAddress(rs.getString("address"));
					dto.setAge(rs.getInt("age"));
					dto.setIsfinished(rs.getInt("isfinished"));
					dto.setMcId(rs.getInt("mcId"));
					dto.setMcName(rs.getString("mcName"));
					arr.add(dto);
					//i++;
				}
			 }	
		}catch(Exception e){
			e.printStackTrace();
	  }
		return arr;
	}
	/**
	 * ��������������ҳ
	 * */
	int rowsPages=0;//������
	int pageCount=1;//��ʾҳ��
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}
	public ArrayList selectPatientDTO(String sql,int page,int pageSize){
		ArrayList<Patient> arr=null;	
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				 arr=new ArrayList<Patient>();
					//ȡ���ܼ�¼��
					rs.last();
					rowsPages=rs.getRow();
					pageCount=(rowsPages/pageSize)+(rowsPages%pageSize==0?0:1);		
					if(page>=pageCount){
						page=pageCount;
					}
					int indexCount=(page-1)*pageSize+1;
					rs.absolute(indexCount);
					int i=0;
					do{
		    	    Patient dto=new Patient();
					dto.setOid(rs.getInt("oid"));
					dto.setPatientNo(rs.getString("patientNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setAddress(rs.getString("address"));
					dto.setAge(rs.getInt("age"));
					dto.setIsfinished(rs.getInt("isfinished"));
					dto.setMcId(rs.getInt("mcId"));
					dto.setMcName(rs.getString("mcName"));
					arr.add(dto);
					i++;
				}while(rs.next()&&i<pageSize);
			 }	
		}catch(Exception e){
			e.printStackTrace();
	  }
		return arr;
	}
	//ɾ��
	public int deletePatientByID(String oid)
	{
		SQLConnection sq=new SQLConnection();
		return sq.executeUpdate("delete from patient where oid="+oid);	
	}
}
