package com.sevenEleven.javaBean.admin_test;

public class CTimeClassUnit {

	/**
	 * ʱ��Ƭ����,��Ϊ�ſε���С��λ,Ϊһ�����ſ�,
	 * ����Ϊ������ÿһ�ڿ��ҵ����Һ�(��ʦ-�γ�)
	 * ����������ϵ��ֶ���Ҫ׼���洢�����е�����
	 */
	private String time;   //ʱ��Ƭ��
	
	private String standardTime; //��׼ʱ��
	
	private String c_id;      //���ҵ�id
	
	private String t_id;       //��ʦ��id
	
	private String l1_id;       //���޿γ̵�id
	
   public void CTimeClassUnit(){
	   time = null;
	   standardTime = null;
	   c_id = null;
	   t_id = null;
	   l1_id = null;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String getC_id() {
		return c_id;
	}


	public void setC_id(String c_id) {
		this.c_id = c_id;
	}


	public String getL1_id() {
		return l1_id;
	}


	public void setL1_id(String l1_id) {
		this.l1_id = l1_id;
	}




	public String getT_id() {
		return t_id;
	}


	public void setT_id(String t_id) {
		this.t_id = t_id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getStandardTime() {
		return standardTime;
	}


	public void setStandardTime(String standardTime) {
		this.standardTime = standardTime;
	}

}
