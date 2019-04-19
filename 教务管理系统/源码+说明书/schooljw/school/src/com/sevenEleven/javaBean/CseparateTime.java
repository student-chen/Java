package com.sevenEleven.javaBean;

/**
 *@auther Tim
 * ʵ�ְ�һ������ı�ʾʱ����ַ����ֽ���ض���ʱ�䡣
 *    ��:A011420070101  A�׶�1������1��4�ÿ�,2007��1��1��  
 */
public class CseparateTime {
	private String year;         //ÿ��   ��2007��
	
	private String month;        //ÿ��
	
	private String timeUnit;        //��Сʱ�䵥λ. �� 420070101   ��2007���1��1�ŵĵ�4�ÿ�
	
	//private String timeClassUnit;       //����ÿ������˵����Сʱ�䵥λ ��A0114  ����A�׶εĵ�1������1�ĵ�4�ÿ�
	
	//private String timeClassNow;       //�ɿ���ʱ��õ���ʱ��  ��20070101 + 1�ܺ� = 20070108
	
	private String time;            //��׼ʱ��,��������ݿ��ϵ�ʱ��   ��:A011420070101  A�׶�1������1��4�ÿ�,2007��1��1��  
	
	private char phase; // ÿ�׶Σ���2030��A��B��C�׶�(A,B,C)ֻ���Ǵ�д��

	private int week; // ÿ���ڣ���2030��һ���׶ε�10������(1,2,3,4,5,6,7,8,9,10)

	private int day; // ÿ�죬day=1��ʾ����һ day(1,2,3,4,5,6,7)

	private int course; // ÿ�ڿΣ� course(1,2,3,4) 1����1��2�ڿΣ� 2����3��4�ڿΣ� 3����5��6�ڿΣ�

	// 4����7��8�ڿ�

	public CseparateTime(String time) {
		this.setTime(time);
		this.setPhase(time);
		this.setWeek(time);
		this.setDay(time);
		this.setCourse(time);
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public void setCourse(String time) {
		if (time.length() != 13) {
			System.out.print("ʱ�䲻����");
			return;
		}
		int course = time.codePointAt(4) - 48;// �õ�����codePoint���ֵ
		if (course > 4) { // ÿ��Ŀγ̲��ܴ���4
			System.out.print("ʱ�䲻����");
			return;
		}
		this.course = course;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setDay(String time) {
		if (time.length() != 13) {
			System.out.print("ʱ�䲻����");
			return;
		}
		int day = time.codePointAt(3) - 48;//
		if (day > 7) {// �������ܴ���7
			System.out.print("ʱ�䲻����");
			return;
		}
		this.day = day;
	}

	public char getPhase() {
		return phase;
	}

	public void setPhase(char phase) {
		this.phase = phase;
	}

	public void setPhase(String time) {
		if (time.length() != 13) {
			System.out.print("ʱ�䲻����");
			return;
		}
		char phase = time.charAt(0);// �õ�����codePoint���ֵ
		if (phase > 'C' || phase < 'A') { // �׶�ֻ����A��B��C
			System.out.print("ʱ�䲻����");
			return;
		}
		this.phase = phase;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public void setWeek(String time) {
		if (time.length() != 13) {
			System.out.print("ʱ�䲻����");
			return;
		}
		int week = (time.codePointAt(1) - 48) * 10 + (time.codePointAt(2) - 48);
		if (week > 10) { // ÿ�׶β�����10��
			System.out.print("ʱ�䲻����");
			return;
		}
		this.week = week;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

	public static void main(String[] args) {
		CseparateTime timeToString = new CseparateTime("B1034");
		int course = timeToString.getCourse();
		char Phase = timeToString.getPhase();
		int week = timeToString.getWeek();
		int day = timeToString.getDay();
		System.out.println(Phase);
		System.out.println(week);
		System.out.println(day);
		System.out.println(course);
		StringBuffer sss = new StringBuffer();
		
	}



	
}
