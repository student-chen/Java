package com.sevenEleven.javaBean;

/**
 * �����������ͻ��ʽ��ת����
 * 
 * @author Tim
 */
public class CdataFormat {
	/**
	 * ���ַ���ת�����ʺ�����ҳ��ʾ���ı���δȫ�����
	 * 
	 * @param s
	 *            Ҫ������ַ���
	 * @return �������ַ���
	 */
	public static String toHtml(String s) {
		if (s == null)
			return s;
		s = strReplace(s, "&", "&amp;");
		s = strReplace(s, "<", "&amp;");
		s = strReplace(s, ">", "&amp;");
		s = strReplace(s, "", "&amp;");
		// s = parseReturn(s,"<br>\n&nbsp:&nbsp:&nbsp:&nbsp:");
		return s;
	}

	/**
	 * ���ַ���sBody�е�sFrom��sTo�滻
	 * 
	 * @param sBody
	 *            Ҫ������ַ���
	 * @param sFrom
	 *            Ҫ���滻���ַ���
	 * @param sTo
	 *            �滻�ɵ��ַ���
	 * @return �������ַ���
	 */

	public static String strReplace(String sBody, String sFrom, String sTo) {
		int i, j, l;
		if (sBody == null || sBody.equals(""))
			return "";
		i = 0;
		j = sFrom.length(); // С�ַ����ĳ���
		// k = sTo.length();
		StringBuffer sss = new StringBuffer(sBody.length());
		// boolean bFirst = true;
		l = i;
		while (sBody.indexOf(sFrom, i) != -1) { // �ҵ�һ�γ�������ַ������ַ��ĵ�һλ������
			i = sBody.indexOf(sFrom, i);
			sss.append(sBody.substring(l, i)); // ���Ϸ��滻��
			sss.append(sTo); // ����Ҫ�滻��
			i += j;
			l = i;
		}
		sss.append(sBody.substring(l));
		return sss.toString();
	}

	/**
	 * To change the template for this generated file go to window&gt;
	 * 
	 * @author Tim
	 * 
	 * @param sBody
	 *            string which's EnCodingType wanted be change
	 * 
	 * @return ת�ͺ���ַ���
	 */
	public static String unicode2GB(String strIn) {
		byte b[];
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals("")) {
			try {
				b = strIn.getBytes("ISO-8859-1");
				strOut = new String(b, "GBK");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strOut;
	}

	/**
	 * To change the template for this generated file go to window&gt;
	 * 
	 * @author Tim
	 * 
	 * @param sBody
	 *            string which's EnCodingType wanted be change
	 * 
	 * @return ת�ͺ���ַ���
	 */
	public static String GB2unicode(String strIn) {
		byte b[];
		String strOut = null;
		if (strIn == null || (strIn.trim()).equals("")) {
			try {
				b = strIn.getBytes("GBK");
				strOut = new String(b, "ISO-8859-1");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strOut;
	}

	public static void main(String[] args) {
		String s = "StringString";
		String newString = CdataFormat.strReplace(s, "tr", "!ok!");
		System.out.println(newString);

	}
}
