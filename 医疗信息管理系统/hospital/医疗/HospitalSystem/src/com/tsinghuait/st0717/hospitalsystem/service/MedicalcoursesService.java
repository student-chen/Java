package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Medicalcourses;
public class MedicalcoursesService {
	/**
	 * ���ݿ�  �Ʊ�� medicalcourses ��ѯ
	 * */
	//��ѯ
	public ResultSet selectMedicalcourses(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;		
	}
	 //�ԿƱ��еı����  ���,�޸�,ɾ�� 
	public int executeUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	
	//�����Ʊ��
	public ArrayList selectRowsMedicalcourses(String sql){
		ArrayList<Medicalcourses> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null){
			arr=new ArrayList<Medicalcourses>();
			try {
				while(rs.next()&&rs!=null){
					Medicalcourses dto=new Medicalcourses();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setType(rs.getByte("type"));
					arr.add(dto);
				}
			} catch (SQLException e) {
				System.out.println("���ݿ�  �Ʊ�� medicalcourses ��������ʧ��");
				e.printStackTrace();
			}
		}
		return arr;
	}	
	/**
	 * ��ҳ����
	 * 
	 */
	int rowsPages=0;//������
	int pageCount=1;//��ʾҳ��
	public ArrayList selectRowsMedicalcourses(String sql,int page,int pageSize){
		ArrayList<Medicalcourses> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				 arr=new ArrayList<Medicalcourses>();
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
						Medicalcourses dto=new Medicalcourses();
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setType(rs.getByte("type"));
						arr.add(dto);
						i++;
				}while(rs.next()&&i<pageSize);
			  }
			} catch (SQLException e) {
				System.out.println("���ݿ�  �Ʊ�� medicalcourses ��������ʧ��");
				e.printStackTrace();
		}
		return arr;
	}	
//	��ѯ�Ʊ����� 
	public int selectNameMed(String name){
		String sql="select * from medicalcourses where name='"+name+"'";
		ResultSet rs=new SQLConnection().executeQuery(sql);
		int num=0;
		try {
			while(rs!=null&&rs.next()){
				Medicalcourses dto=new Medicalcourses();
				dto.setId(rs.getInt("id"));				
				num=dto.getId();
			}
		} catch (SQLException e) {
			System.out.println("�����ݿ��пƱ���ȡ�Ʊ��ID���ִ���..."+rs);
			e.printStackTrace();
		}
		return num;
	}
//	��ӿƱ����Ϣ
    public int insertMedicalcourses(String name,String type){
    	int num=0;
    	num=new SQLConnection().executeUpdate("insert into medicalcourses values('"+name+"','"+type+"')");
    	return num;
    }
    
    //ɾ���Ʊ����Ϣ
    public int deleteById(String id){
    	int num=0;
    	num=new SQLConnection().executeUpdate("delete from medicalcourses where id="+id);
    	return num;
    }
   //�޸ĿƱ����Ϣ
    public int updateById(String sql){ 
    	int num=0;
    	num=new SQLConnection().executeUpdate(sql);
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
		for (int i=0;i<ids.length;i++)
		{
			refrenceRows=this.deleteById(ids[i]);
		}
		return refrenceRows;
	}
}