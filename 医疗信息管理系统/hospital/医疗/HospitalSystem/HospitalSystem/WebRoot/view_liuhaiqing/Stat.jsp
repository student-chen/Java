<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>ͳ���շ�</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
     <script>
	    function toDate(){
			with(document.all){
				vYear=parseInt(year.options[year.selectedIndex].text)
				vMonth=parseInt(month.options[month.selectedIndex].text)
				day.length=0;
				/*��������µ�ֵ����һ�����ڶ������getDate()�����õ�����*/	
				for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
					day.options[day.length++].value=day.length;/*����ÿһ��������ֵ���ı�*/
					day.options[day.length-1].text=day.length;
			}
		}
		 toDay();/*����toDay()�������������Ч�Խ�����֤*/
		}
		/*�������toDay()����������֤�������Ч�Ե�*/
		function toDay(){
		if(document.form1.yearName.value=="1900"){
			/*��������1900������գ����ǿ�ѡ�ģ���Ϊ�������������Ǵ�1970��ʼ�ģ�
			���Ǽ�����һ���������ô��ѧϰ����������������ֵ*/
			document.all("studentAge").value="";
		}
		else{
			/*�����ݲ���1900�����ȵõ���ǰ����������е���ݣ�Ȼ���ȥ�û��������ݣ�
			���С�ھ�˵����������Ч�ģ����������Ч�ģ������������ֵ��Ϊѧ�������䡣*/
			vDay=parseInt(document.all.day.options[document.all.day.selectedIndex].value)
			nD=new Date().getYear();/*�õ���ǰ����������*/
			with(document.all){
				vYear=parseInt(year.options[year.selectedIndex].text) /*�õ��û���������*/
				ss = nD-vYear;/*�������*/
				if(ss <= 0)/*���С��0����˵��������Ч*/
				{
					///document.all("studentAge").value="��Ч����";
				}
				else
				{
					///document.all("studentAge").value=ss;
				} 
			}
		}
	}
	window.onload=toDate;
	</script>
	<script>
    function toDate1()
    {
		with(document.all)
		{
			vYear=parseInt(year1.options[year1.selectedIndex].text)
			vMonth=parseInt(month1.options[month1.selectedIndex].text)
			day1.length=0;
			/*��������µ�ֵ����һ�����ڶ������getDate()�����õ�����*/	
			for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
				day1.options[day1.length++].value=day1.length;/*����ÿһ��������ֵ���ı�*/
				day1.options[day1.length-1].text=day1.length;
		}
	}
	 toDay1();/*����toDay()�������������Ч�Խ�����֤*/
	}
	/*�������toDay()����������֤�������Ч�Ե�*/
	function toDay1(){
	if(document.form1.yearName1.value=="1900"){
		/*��������1900������գ����ǿ�ѡ�ģ���Ϊ�������������Ǵ�1970��ʼ�ģ�
		���Ǽ�����һ���������ô��ѧϰ����������������ֵ*/
		document.all("studentAge").value="";
	}
	else{
		/*�����ݲ���1900�����ȵõ���ǰ����������е���ݣ�Ȼ���ȥ�û��������ݣ�
		���С�ھ�˵����������Ч�ģ����������Ч�ģ������������ֵ��Ϊѧ�������䡣*/
		vDay=parseInt(document.all.day1.options[document.all.day1.selectedIndex].value)
		nD=new Date().getYear();/*�õ���ǰ����������*/
		with(document.all){
			vYear=parseInt(year.options[year1.selectedIndex].text) /*�õ��û���������*/
			ss = nD-vYear;/*�������*/
			if(ss <= 0)/*���С��0����˵��������Ч*/
			{
				///document.all("studentAge").value="��Ч����";
			}
			else{
				///document.all("studentAge").value=ss;
			} 
		}
		}
	}
	window.onload=toDate1;
	</script>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/StatServlet" name="form1" method=post>
   <table class="simple textCss"> 
      <tr>
        <th align="right" width="30%"> ��ʼ���ڣ�</th>
        <td>
        <select id=year name="yearName" onchange=toDate()>
			<script>
				for(i=1990;i<=2010;i++)document.write("<option>"+i+"</option>")
			</script> 
		</select>��
		<select id=month name="monthName" onchange=toDate()>
			<script>
				for(i=1;i<=12;i++)document.write("<option>"+i+"</option>")
			</script>
		</select>��
		<select id=day name="dayName" onchange=toDay()>
			<option value="1" selected>1</option>
		</select>��
		</td>
      </tr>
      <tr>
       <th align="right" width="30%"> ��ֹ���ڣ�</th>
       <td>
         <select id=year1 name="yearName1" onchange=toDate1()>
			<script>
				for(i=1990;i<=2010;i++)
					document.write("<option>"+i+"</option>")
			</script> 
		</select>��
		<select id=month1 name="monthName1" onchange=toDate1()>
			<script>
				for(i=1;i<=12;i++)
					document.write("<option>"+i+"</option>")
			</script>
		</select>��
		<select id=day1 name="dayName1" onchange=toDay1()>
		</select>��
        </td>
      </tr>
      <tr>
        <td align="center" colspan="2">
          	<input type="submit" value="ͳ��" class="buttonClass">&nbsp;&nbsp;&nbsp;
          	<input type="button" value="�˳�" class="buttonClass" onclick="window.location.href='${pageContext.request.contextPath}/receiptLiuHaiQingServlet?operation=0'">
        </td>
      </tr>
   </table>
   </form>
  </body>
</html>