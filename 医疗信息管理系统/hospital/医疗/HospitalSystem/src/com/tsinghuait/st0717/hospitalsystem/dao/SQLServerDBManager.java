package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class SQLServerDBManager {

	/**
	 * �÷�����������SQL Server���ݿ�
	 * 
	 * @param url:
	 *            �������ݿ��url
	 * @param username:
	 *            ���ݿ�����û���
	 * @param password:
	 *            ���ݿ��������
	 */
	public static Connection getConnection(String url, String username,
			String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �÷����û���ѯ���ݿⲢ����ResultSet���͵Ľ����
	 * 
	 * @param sql:���ݿ��ѯ���
	 * @param id:
	 *            Ҫ�������ݵ�ID
	 */
	public static ResultSet execQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Collection execQuery(int id) {
		Collection coll = null;
		return coll;
	}

	/**
	 * �÷��������޸Ķ�Ӧ��������Ϣ
	 * 
	 * @param sql:�����޸����ݵ�sql���
	 * @return int :Ӱ�������
	 */
	public int updateData(String sql) {
		int refrenceRows = 0;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			refrenceRows = stmt.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return refrenceRows;
	}

	/**
	 * �÷�������ɾ����Ӧ��������Ϣ
	 * 
	 * @param sql:����ɾ�����ݵ�sql���
	 */
	public int deleteData(String sql) {
		int refrenceRows = 0;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			refrenceRows = stmt.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return refrenceRows;
	}

	/**
	 * �÷������ڴ洢������Ϣ
	 * 
	 * @param sql:���ڴ洢���ݵ�sql���
	 */
	public static void saveData(String sql) {
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
