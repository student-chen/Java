
package com.sevenEleven.Beans;

/**
 * @author Tim
 * admin Bean
 */
public class CadminBean {
	private long a_id;               //sequense������
	private String a_name;          //����Ա����
	private String a_password;      //����Ա����
	private long a_type;         //����Ա����1.�ܹ���Ա 2.У�����Ա 3.ͼ�����Ա 4.BBS����Ա
	//set                                               	
	public long getA_id() {
		return a_id;
	}
	public void setA_id(long a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public long getA_type() {
		return a_type;
	}
	public void setA_type(long a_type) {
		this.a_type = a_type;
	}

}
