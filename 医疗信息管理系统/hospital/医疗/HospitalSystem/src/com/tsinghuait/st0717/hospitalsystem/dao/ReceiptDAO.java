package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.ResultSet;

public class ReceiptDAO extends SQLServerDBManager {
	/**
	 * ����������Ϣ
	 * 
	 * */
	public void savePost(String sql)
	{
		saveData(sql);
	}
	/**
	 * �������е�������Ϣ
	 * 
	 * */
	public ResultSet loadAllPosts()
	{
		return execQuery("select * from post");
	}
	
	/**
	 * �����ߵ�id����ɾ��
	 * 
	 * @return Ӱ�������
	 * */
	public int deletePostById(String sql)
	{
		return deleteData(sql);
	}
}
