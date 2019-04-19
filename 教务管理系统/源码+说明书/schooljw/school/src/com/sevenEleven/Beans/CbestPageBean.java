package com.sevenEleven.Beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

/*
 * һ����ҳ���࣬��ҳ�Ĵ洢���̣���ҳ��jspʾ��һ����ҳ�Ĵ洢����һ�����ô洢���̵İ�װ����÷�ҳ�����jspʾ��
 *����˼·���ȵ��ô洢���̴����ݿ���ȡ��һ�������ݣ����뼯���н��л��棬Ȼ�����ȡ��һ������ʾ��һҳ�У�
 *��Ҫȡ��һҳ����ʱ���ȴӻ�����ȡ���ݣ���������е����ݲ��㣬Ȼ���ڵ��ô洢���̴����ݿ���ȡ����
 */
public class CbestPageBean {

	private int curDbPage = 1;// �����ݿ��ж�ȡ���ǵڼ���ҳ������ݣ�����һ�ζ�rowsPerGetDB����¼��

	private int maxDbPage;// ���ݿ��й��ж��ٸ�ҳ��ɹ���ȡ������һ�ζ�rowsPerGetDB����¼��

	private int sumRows;// ���ݿ��е��ܼ�¼��

	private int curPage = -1;

	/*
	 * ��ǰ��ʾ��ҳ�棬-1��ʾ�����ݿ���ȡ����һ��ҳ������� -2 ��ʾ�����ݿ���ȡ����ǰҳ���ǰһ��ҳ������� -3
	 * ��ʾ�����ݿ���ȡ����ǰҳ��ĺ�һ��ҳ������� -4 ��ʾ�����ݿ���ȡ�����һ��ҳ�������
	 * ����˵���Ǵӻ���������ȡ����Ӧ��ҳ�棬���Ǵ����ݿ���ȡ���ݣ�������ִ�С��1��multiple֮��
	 */
	private int maxPage;// �������ÿҳ��ʾ�������������򹲿�����ʾ��ҳ����

	private int displayPageNumber;// ��ǰһ��������ʾ��ҳ��

	private int multiple = 10; // һ�δ����ݿ���ȡ����������ÿҳ��ʾ�����ݵı���

	private int rowsPerPage = 20;// ÿҳ��ʾ����������

	private int rowsPerGetDB = 200;// һ�δ����ݿ��ж�ȡ�ļ�¼��Ӧ����rowsPerPage��multiple֮��

	private int pageSumFromDBVector;// ��ǰʵ�ʴ����ݿ��ж�ȡ�����ݿɹ���ʾ��ҳ����

	private Vector pageData;// ���һ��Ҫ��ʾ������

	private Vector dataFromDB;// һ�δ����ݿ��ж�ȡ������

	// ���������Ҫ�Ĳ���
	private Connection conn;// ���ݿ����Ӷ���

	private int i_desc = 1;// �������ǽ����������ݣ�0 ����1����

	private String s_WhereCondition = "";// ����

	private String s_OrderFieldName = "pubDate";// �����ֶΣ�����Ϊ�գ�

	private String s_TableName = "rss";// ���Ǹ�����ȡ����

	private String s_FieldsName = "title,link,author,category,pubDate,description"; // Ҫ��ѯ�������У�*

	// Ϊȫ�����ݣ�

	private int i_FieldsCount = 6; // Ҫȡ�������еĸ���

	public CbestPageBean() {
		pageData = new Vector();
		dataFromDB = new Vector();
	}

	public void setConnection(Connection con) {
		conn = con;
	}

	public void setTableName(String s) {
		this.s_TableName = s;
		// ȡ���ֶθ���
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select  count( *)   From   Syscolumns C, Sysobjects N where N.id=C.id and N.name='"
							+ this.s_TableName + "'");
			rs.next();
			i_FieldsCount = rs.getInt(1);
			rs.close();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("��ñ���ֶθ�������" + e.toString());
		}

	}

	public void setFieldsName(String s) {
		this.s_FieldsName = s;
		java.util.StringTokenizer st = new StringTokenizer(s, ",");
		this.i_FieldsCount = st.countTokens();
	}

	public void setWhereCondition(String s) {
		this.s_WhereCondition = s;
		this.getSumPage();// ���������˲�ѯ���ݵ�����������Ҫ���¼�������������ҳ����

	}

	public void setOrderFieldName(String s) {
		this.s_OrderFieldName = s;
	}

	public void setDesc(int i) {
		this.i_desc = i;
	}

	public void setCurDbPage(int curDbPage) {
		// �����������ҳ����ȡ��ǰ��һ������ҳ�����-2����ȡ��ǰҳ���ǰһҳ����
		// ����Ҫ�ȼ���һҳ��ȡ�������ݲŸպ���Ҫȡ�����ݡ�
		this.curPage = -2;
		this.curDbPage = curDbPage + 1;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerGetDB = rowsPerPage * multiple;
		this.rowsPerPage = rowsPerPage;
		this.getSumPage();// ����������ÿҳ��ʾ������������Ҫ���¼�����ҳ����
	}

	public void setMultiple(int multiple) {
		this.rowsPerGetDB = rowsPerPage * multiple;
		this.multiple = multiple;
	}

	public int getCurDbPage() {
		return curDbPage;
	}

	public int getMaxDbPage() {
		return maxDbPage;
	}

	public int getSumRows() {
		return sumRows;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getDisplayPageNumber() {
		return displayPageNumber;
	}

	public int getMultiple() {
		return multiple;
	}

	public int getPageSumFromDBVector() {
		return pageSumFromDBVector;
	}

	// �õ�ÿҳ������
	public Vector getPageData() {
		pageData.clear();
		// ��Ҫ�����ݿ���ȡ����(��ǰ������)
		if (this.curPage == -1) {
			this.curDbPage = 1;
			getDataFromDB();
			this.curPage = 1;
		}
		// ��Ҫ�����ݿ���ȡ����(��ǰȡ����)
		if (this.curPage == -2) {
			if (this.curDbPage > 1)
				this.curDbPage = this.curDbPage - 1;
			else
				this.curDbPage = 1;
			getDataFromDB();
			this.curPage = 1;
		}
		// ��Ҫ�����ݿ���ȡ����(���ȡ����)
		if (this.curPage == -3) {
			if (this.curDbPage < this.maxDbPage)
				this.curDbPage = this.curDbPage + 1;
			else
				this.curDbPage = this.maxDbPage;
			getDataFromDB();
			this.curPage = 1;
		}
		// ��Ҫ�����ݿ���ȡ����(��������)
		if (this.curPage == -4) {
			this.curDbPage = this.maxDbPage;
			getDataFromDB();
			this.curPage = 1;
		}

		// �������ݵ���ʼҳ��
		this.displayPageNumber = (this.curDbPage - 1) * this.multiple;
		// ����Ҫ�ж�������ݲ����Ĵ���
		int i_vectorsize = dataFromDB.size();
		int rows = (this.curPage - 1) * this.rowsPerPage;
		int i_shouldsize = rows + this.rowsPerPage;
		if (i_vectorsize < i_shouldsize)
			i_shouldsize = i_vectorsize;

		for (int i = rows; i < i_shouldsize; i++) {
			pageData.add(this.dataFromDB.get(i));
		}
		return pageData;
	}

	// �����ݿ�õ�����
	private Vector getDataFromDB() {
		dataFromDB.clear();
		CallableStatement proc = null;
		try {
			proc = conn
					.prepareCall("{call GetRecordFromPage(?,?,?,?,?,?,?,?)}");
			proc.setString(1, this.s_TableName);
			proc.setString(2, this.s_FieldsName);
			proc.setString(3, this.s_OrderFieldName);
			proc.setInt(4, this.rowsPerGetDB);
			proc.setInt(5, this.curDbPage);
			proc.setInt(6, 0);
			proc.setInt(7, this.i_desc);
			proc.setString(8, this.s_WhereCondition);
			ResultSet rs = proc.executeQuery();
			while (rs.next()) {
				Object[] obj = new Object[this.i_FieldsCount];
				for (int i_count = 1; i_count <= this.i_FieldsCount; i_count++) {
					obj[i_count - 1] = rs.getObject(i_count);
				}
				dataFromDB.add(obj);
			}
			rs.close();
			proc.close();
		} catch (SQLException ex) {
			System.out.println("���ô洢���̻�����ݴ���:" + ex.toString());
		}
		// �ж�һ�´����ݿ���ȡ�����������������������ǰ�����ݿ���ȡ���������ܹ���ʾҳ����
		int i_V_size = dataFromDB.size();
		if ((i_V_size % this.rowsPerPage) == 0)
			this.pageSumFromDBVector = i_V_size / this.rowsPerPage;
		else
			this.pageSumFromDBVector = i_V_size / this.rowsPerPage + 1;
		this.getSumPage();// ÿ�δ����ݿ���ȡ���ݣ���õ���һ������������Ա�õ����ݿ������µ�����
		return dataFromDB;
	}

	// ������������ļ�¼����
	private void getDataSumCount() {
		CallableStatement proc = null;
		this.sumRows = 0;
		try {
			proc = conn
					.prepareCall("{call GetRecordFromPage(?,?,?,?,?,?,?,?)}");
			proc.setString(1, this.s_TableName);
			proc.setString(2, "");
			proc.setString(3, "");
			proc.setInt(4, 0);
			proc.setInt(5, 0);
			proc.setInt(6, 1);
			proc.setInt(7, 0);
			proc.setString(8, this.s_WhereCondition);
			ResultSet rs = proc.executeQuery();
			while (rs.next()) {
				this.sumRows = rs.getInt(1);
			}
			rs.close();
			proc.close();

		} catch (SQLException ex) {
			System.out.println("���ô洢���̻������������" + ex.toString());
		}
	}

	// ������ҳ��
	private void countMaxPage() {
		// ��������ݿ��п���ȡ���ݵ���ҳ��
		if (this.sumRows % this.rowsPerGetDB == 0) {
			this.maxDbPage = this.sumRows / this.rowsPerGetDB;
		} else {
			this.maxDbPage = this.sumRows / this.rowsPerGetDB + 1;
		}

		// ��������ݿ��е����ݿ�����ʾ����ҳ��
		if (this.sumRows % this.rowsPerPage == 0) {
			this.maxPage = this.sumRows / this.rowsPerPage;
		} else {
			this.maxPage = this.sumRows / this.rowsPerPage + 1;
		}

	}

	// ������ҳ��
	private void getSumPage() {
		getDataSumCount();
		countMaxPage();
	}

	// �ر����ݿ�����
	public void ColseConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public CbestPageBean(int curDbPage, int maxDbPage, int sumRows,
			int curPage, int maxPage, int displayPageNumber, int multiple,
			int rowsPerPage, int rowsPerGetDB, int pageSumFromDBVector,
			Vector pageData, Vector dataFromDB, Connection conn, int i_desc,
			String whereCondition, String orderFieldName, String tableName,
			String fieldsName, int fieldsCount) {
		super();
		// TODO Auto-generated constructor stub
		this.curDbPage = curDbPage;
		this.maxDbPage = maxDbPage;
		this.sumRows = sumRows;
		this.curPage = curPage;
		this.maxPage = maxPage;
		this.displayPageNumber = displayPageNumber;
		this.multiple = multiple;
		this.rowsPerPage = rowsPerPage;
		this.rowsPerGetDB = rowsPerGetDB;
		this.pageSumFromDBVector = pageSumFromDBVector;
		this.pageData = pageData;
		this.dataFromDB = dataFromDB;
		this.conn = conn;
		this.i_desc = i_desc;
		s_WhereCondition = whereCondition;
		s_OrderFieldName = orderFieldName;
		s_TableName = tableName;
		s_FieldsName = fieldsName;
		i_FieldsCount = fieldsCount;
	}

}
