package com.sevenEleven.javaBean.admin_test;

public class CgetCurrentTimeFromTimeClassBegin {

	String timeClassNow = null; //

	public CgetCurrentTimeFromTimeClassBegin(String timeClassBegin,
			String timeClassUnit) {
		getCurrentTimeFromTimeClassBegin(timeClassBegin, timeClassUnit);
	}

	/**
	 * @auther Tim
	 * @exception û�����õ�������........ֻ�Ǽ򵥵ĵõ�����ʱ��,�ɶ��Բ�ǿ,�д��Ľ�
	 * @function: �ɿ�ѧʱ��Ϳγ̵�ʱ��Ƭ�ϵõ��γ̵� ��ȷʱ��.
	 * @return: timeClassNow (String) eg: A011420070101
	 * @from : timeClassUnit (String)eg:A0114 timeClassBegin (String)20060101
	 */
	public void getCurrentTimeFromTimeClassBegin(String timeClassBegin,
			String timeClassUnit) {

		timeClassNow = new String(); // Ҫ���صĵ�ǰʱ��Ƭ�ϵľ���ʱ��
		boolean isLeapYear = checkYearIsLeapYear(Integer.valueOf(
				timeClassBegin.substring(0, 4)).intValue()); // �Ƿ�����
		int sumDay = getSumDay(timeClassBegin, timeClassUnit, isLeapYear);// ����ʱ���������ӵ�����
		int year = Integer.valueOf(timeClassBegin.substring(0, 4)).intValue(); // ��ǰ�ľ��Ե���
		year = year += isLeapYear ? sumDay / 366 : sumDay / 365;// ��ǰ�ľ��Ե���
		int month = this.getMonthFromSumDay(sumDay, isLeapYear); // ��ǰ���Ե���
		int day = this.getDayFromSumDay(sumDay, isLeapYear); // ��ǰ���Ե���
		String month1 = month>9 ? String.valueOf(month) : "0"+String.valueOf(month);//תString��
		String day1 = day>9 ? String.valueOf(day) : "0"+String.valueOf(day);
		timeClassNow = timeClassUnit + year + month1 + day1;                          //��ֵ
	}

	/**
	 * @auther Tim function: �Ƿ�������,�Ƿ���true,�񷵻�false name: check return:
	 *         boolean(trun/false)
	 */
	public boolean checkYearIsLeapYear(int year) {
		return ((0 == year % 4) && (0 != (year % 100))) || (0 == year % 400) ? true
				: false;
	}

	/**
	 * @auther Tim function: �����ж�����,�������� name: dayOfTheMonth return: int how
	 *         many days of this month from month
	 */
	public int dayOfTheMonth(int month, boolean isLeapYear) {
		if (month == 2) {
			return isLeapYear ? 29 : 28;
		} else if (month == 4 || month == 6 || month == 10 || month == 12) {
			return 30;
		} else {
			return 31;
		}
	}

	/**
	 * @auther Tim
	 * @function: ��ѧʱ������ + ���������ھ���������
	 * @name: dayOfTheMonth
	 * @return: int how many days of this month from month
	 */
	public int getSumDay(String timeClassBegin, String timeClassUnit,
			boolean isLeapYear) {
		int dayOfUnit = ((Integer.valueOf(timeClassUnit.substring(1, 3))
				.intValue() - 1) * 7 + Integer.valueOf(
				timeClassUnit.substring(3,4)).intValue()); // ����timeClassUnitΪA0214
		// ����ֵΪ(2-1)*7+1
		int sumDay = 0;
		for (int i = 1; i < Integer.valueOf(timeClassBegin.substring(4, 6))
				.intValue(); i++) {// ����ÿ���µõ������� 20060301
			sumDay += dayOfTheMonth(i, isLeapYear); // 1�µ�31 + 2�µ�28
		}
		sumDay = sumDay + Integer.valueOf(timeClassBegin.substring(6, 8)) + dayOfUnit;
		return sumDay;
	}

	/**
	 * @auther Tim
	 * @function: �õ����Ե��·�
	 * @name: getMonthFromSumDay
	 * @return: �õ����Ե��·�
	 */
	public int getMonthFromSumDay(int sumDay, boolean isLeapYear) {
		int day = isLeapYear ? sumDay % 366 : sumDay % 365;
		int month;
		for (month = 1; day > dayOfTheMonth(month, isLeapYear); month++) {

		}
		return month;
	}

	/**
	 * @auther Tim
	 * @function: �õ����Ե���
	 * @name: getMonthFromSumDay
	 * @return: �õ����Ե���
	 */
	public int getDayFromSumDay(int sumDay, boolean isLeapYear) {
		int day = isLeapYear ? sumDay % 366 : sumDay % 365;
		int month;
		for (month = 1; day > dayOfTheMonth(month, isLeapYear); month++) {
			day -= dayOfTheMonth(month, isLeapYear);
		}
		return day;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getTimeClassNow() {
		return timeClassNow;
	}

	public void setTimeClassNow(String timeClassNow) {
		this.timeClassNow = timeClassNow;
	}

}
