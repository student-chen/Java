package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Doctor;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;

public class LoginService {
	/*
	 * ��¼�ж�
	 * */
	public ResultSet loginSelect(String sql){
		ResultSet rs=null;
		rs=this.executeQuery(sql);
		return rs;
	}	
	/**
	 * ��ѯ���ݿ��еı�
	 * */
	public ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement();
			rs=st.executeQuery(sql);
			if(rs!=null&&rs.next()){
				System.out.println("��ѯ���ݳɹ�����"+rs);
			}else{
				System.out.println("��ѯ����ʧ�ܣ���"+rs);
				rs=null;
			}
		} catch (SQLException e) {
			System.out.println("��ѯ���ݿ���ֲ�������!!!"+e);
			rs=null;
		}
		return rs;
	}
	
	//��ѯҽ���ĿƱ�
	public String selectDoctorMcName(String sql){
		ResultSet rs=new SQLConnection().executeQuery(sql);
		String mcName="";
		if(rs!=null){
			try {
				while(rs!=null&&rs.next()){
					Doctor dto=new Doctor();
					dto.setMcName(rs.getString("mcName"));
					mcName=dto.getMcName();
				}
			} catch (SQLException e) {
				System.out.println("loginServlet����ҽ���Ʊ����...");
				e.printStackTrace();
			}
		}
		return mcName;
	}
	
	//��ѯ��ʿ�ĿƱ�
	public String seleceNursePost(String sql){
		ResultSet rs=new SQLConnection().executeQuery(sql);
		String mcName="";
		if(rs!=null){
			try {
				while(rs!=null&&rs.next()){
					Nurse dto=new Nurse();
					dto.setPost(rs.getString("post"));
					mcName=dto.getPost();
				}
			} catch (SQLException e) {
				System.out.println("loginServlet���ػ�ʿ�Ʊ����...");
				e.printStackTrace();
			}
		}
		return mcName;
	}
}
