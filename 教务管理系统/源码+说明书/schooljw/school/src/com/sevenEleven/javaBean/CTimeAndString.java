package com.sevenEleven.javaBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CTimeAndString {

	/**
	 * @param args
	 */
	/*** ȡ��ϵͳʱ��  ***/
	public String getCurrentlyTime(){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = f.format(new Date());
		return time;
		
	}
	/*** ȡ���������ڵ�����  ***/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
