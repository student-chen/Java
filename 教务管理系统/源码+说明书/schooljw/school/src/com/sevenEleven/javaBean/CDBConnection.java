package com.sevenEleven.javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CDBConnection {


	 protected static Connection con = null;

    Statement stmt = null;

	 protected String sql = "";

	protected ResultSet rs = null;

	/** ************************************************************ */

	//private static final String DRIVE = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    /*���ڱ��˵��԰�װsqlserver��û�п���1433�˿ڣ���ʹ��odbc��ʽ�������ݿ�*/
	private static final String DRIVE = "sun.jdbc.odbc.JdbcOdbcDriver";

	private final String USERNAME = "sa";

	private final String PASSWORD = "sa";

	//private static final String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school";
    private static final String url = "jdbc:odbc:school";

	public static void DBConn() { // ��������

		try {

			Class.forName(DRIVE).newInstance();

		}

		catch (ClassNotFoundException e) {

			System.err.println("DBConn():" + e.toString());

		}

		catch (Exception e) {

			System.err.println("DBConn():" + e.toString());

		}

	}

	public Connection getConnection() { // �õ�����

		try {
			
			//con = DriverManager.getConnection(strUrl, this.USERNAME,this.PASSWORD);
			
			con = DriverManager.getConnection(this.url);

		}

		catch (Exception e) {

			con = null;
		}
		return con;

	}

	public void dropConnection() { // �ر�����

		try {
			closeRs();

			closeStmt();

             closeConn();
		}

		catch (Exception ignored) {

		}

		finally {

			con = null;

		}

	}

	public ResultSet executeQuery(String sql) { // ִ��sql��ѯ

		ResultSet rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(sql);

		}

		catch (SQLException ex) {

			System.err.println("DBConn.executeQuery():" + ex.getMessage());

		}

		return rs;

	}

	public int executeUpdate(String sql) { // ִ��sql�������

		int b = 0;

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			b = stmt.executeUpdate(sql);

			stmt.close();

	

		}

		catch (SQLException ex) {

			System.err.println("DBConn:executeUpdate(0:" + ex.getMessage());

		}

		return b;

	}

	public void execute(String sql) { // ִ��sql���

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			stmt.execute(sql);

			stmt.close();


		}

		catch (SQLException ex) {

			System.err.println("DBConn:excute():" + ex.getMessage());

		}

	}

	public void closeStmt() { // �ر�sql����

		try {

			stmt.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void closeConn() { // �ر�sql����

		try {

			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}
	public void closeRs() { // �ر�sql����

		try {

			rs.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}
	

}
