package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLConnection {
	/**
	 * �������ݿ�(�û���ѯͼ����Ϣ,��SearchBookServlet��ʵ��)
	 * */	
	Connection conn=null;
	public SQLConnection(){
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital","sa", "sa");
			
			//��¥ ����������������Դ
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//conn=DriverManager.getConnection("jdbc:odbc:com","sa","sa");
			System.out.println("���ݿ����ӳɹ�!! ");	
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��--");
			e.printStackTrace();
		}	
	}
	public Connection getConnection(){
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital","sa", "sa");
			
			//��¥ ����������������Դ
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//conn=DriverManager.getConnection("jdbc:odbc:com","sa","sa");
			System.out.println("���ݿ����ӳɹ�!! ");	
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��--");
			e.printStackTrace();
		}	
		return conn;
	}
	/**
	 * ��ѯ���ݿ��еı�
	 * */
	public ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try {
			Statement st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs!=null){
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
	
	/**
	 * �����ݿ��еı����  ���,�޸�,ɾ��  ����
	 * */
	public int executeUpdate(String sql){
		int num=0;
		try {
			Statement st=conn.createStatement();
			num=st.executeUpdate(sql);
			if(num!=0){
				System.out.println("�����ݿ�����ɹ�!!"+num);
			}else{
				System.out.println("�����ݿ����ʧ�ܣ���"+num);
				num=0;
			}
		} catch (SQLException e) {
			System.out.println("�����ݿ��еı���в���ʱ���ֲ�������!!");
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * �ر����ݿ�
	 * */
	public void getColse(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("���ݿ�ر�ʧ�ܣ����Ժ��ڹرգ���");
			e.printStackTrace();
		}
	}
}