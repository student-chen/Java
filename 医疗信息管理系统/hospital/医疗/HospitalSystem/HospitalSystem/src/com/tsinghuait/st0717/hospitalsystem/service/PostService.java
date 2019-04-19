package com.tsinghuait.st0717.hospitalsystem.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLServerDBManager;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;
import com.tsinghuait.st0717.hospitalsystem.dto.Post;

public class PostService {
	/**
	 * ��������������
	 * 
	 * @return װdto�����collection����
	 * 
	 * @forword �����б�
	 */
	public Collection searchPostsById(String sql) {
		Collection<Post> col = null;
		ResultSet rs = SQLServerDBManager.execQuery(sql);
		if (rs != null) {
			col = new ArrayList<Post>();
			try {
				while (rs.next()) {
					Post dto = new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					col.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return col;
	}
	/**
	 * ��ҳ����
	 * 
	 */
	int rowsPages=0;//������
	int pageCount=1;//��ʾҳ��
	public ArrayList selectRowsPost(String sql,int page,int pageSize){
		ArrayList<Post> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				 arr=new ArrayList<Post>();
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
					Post dto=new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
				    arr.add(dto);
				    i++;
				}while(rs.next()&&i<pageSize);
			  }
			} catch (SQLException e) {
				System.out.println("���ݿ�  ְ�Ʊ� post ��������ʧ��");
				e.printStackTrace();
			}
		return arr;
	}	
	/**
	 * ���ݿ�  ְ�Ʊ� post ��ѯ
	 * */
	//��ѯ
	public ResultSet selectPost(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;		
	}
	//��ѯ���ػ�ʿְ�Ʊ��id
	public int selectPostId(String sql){
		int num=0;
		ResultSet rs=this.selectPost(sql);
		if(rs!=null){
			Nurse dto=new Nurse();
			try {
				dto.setPostid(rs.getInt("postid"));
				System.out.println("dto:"+dto.getPostid());
				num=dto.getPostid();
				System.out.println("num:"+num);
			} catch (SQLException e) {
				System.out.println("���ػ�ʿְ�Ʊ��id����...");
				e.printStackTrace();
			}
		}
		return num;
	}
	
	 //��ְ���еı����  ���,�޸�,ɾ�� 
	public int executeUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	
	//����ְ�Ʊ�
	public ArrayList selectRowsPost(String sql){
		ArrayList<Post> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null){
			arr=new ArrayList<Post>();
			try {
				while(rs.next()&&rs!=null){
					Post dto=new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
				    arr.add(dto);
				}
			} catch (SQLException e) {
				System.out.println("���ݿ�  ְ�Ʊ� post ��������ʧ��");
				e.printStackTrace();
			}
		}
		return arr;
	}	
	//�����ݿ����
	public int execteUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
//	ɾ��ְ�Ʊ���Ϣ
    public int deleteById(String id){
    	int num=0;
    	num=new SQLConnection().executeUpdate("delete from post where id="+id);
    	return num;
    }
    
    //�޸�ְ�Ʊ���Ϣ
    public int updateById(String sql) { 
    	int num=0;
    	num=new SQLConnection().executeUpdate(sql);
    	return num;
    }    
    //���ְ�Ʊ���Ϣ
    public int insertPost(String name){
    	int num=0;
    	num=new SQLConnection().executeUpdate("insert into post values('"+name+"')");
    	return num;
    }
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}

	public int deleteDoctorBatch(String ids[]){
		int refrenceRows=0;
		for (int i=0;i<ids.length;i++){
			refrenceRows=this.deleteById(ids[i]);
		}
		return refrenceRows;
	}
}