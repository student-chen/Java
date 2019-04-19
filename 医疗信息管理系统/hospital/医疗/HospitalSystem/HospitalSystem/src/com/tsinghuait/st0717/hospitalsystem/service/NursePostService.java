package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.ViewNursePostDTO;

public class NursePostService {
	/**
	 * �Ի�ʿ�������ϲ�ѯ
	 * */
	//����  �Ի�ʿ���� viewNursePost��ͼ �Ĳ鿴
	int rowsPages=0;//������
	int pageCount=1;//��ʾҳ��
	public ArrayList selectViewNursePost(String sql,int page,int pageSize){
		ArrayList<ViewNursePostDTO> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			if(rs!=null){
				arr=new ArrayList<ViewNursePostDTO>();
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
				while(rs.next()&&i<pageSize){
					ViewNursePostDTO dto=new ViewNursePostDTO();
					dto.setId(rs.getInt("id"));
					dto.setWorkNum(rs.getString("workNum"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setPostName(rs.getString("postName"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
					dto.setPName(rs.getString("pName"));
					arr.add(dto);
					i++;
				}
			  } 
			}catch (SQLException e) {
				System.out.println("�Ի�ʿ��ͼ��Ĳ�������");
				e.printStackTrace();
		}
		return arr;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}
}
