<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<LINK href="../res/css/main.css" rel=stylesheet>
<title>ѡ�޿���</title>

</head>
<!-- һ��ҳ��Ϳ�ʼ��ʱ -->
<body onload="beginTimer()">
<h1 align="center">ѡ�޿���</h1>
<form name="testForm" id="TestForm" method="post"
	action="Cexam_giveElectiveScore" target="mainFrame">
<table  width="534" align="center">
	<caption>�γ̺�:${courseId}</caption>
	<tr>
		<td><input type="hidden" name="courseId" value="${courseId}" /></td>
	</tr>
	<tr>
		<td width="109">${sessionScope.student.s_name
		}���ѧ����:${sessionScope.student.s_id }</td>
		<td width="403">��ѡ:${countOfChoose1}��,��ѡ:${countOfChoose2}��,���:${countOfText}��,ʣ��ʱ��:<input
			name="Btime" type="text" id="Btime" readonly="readonly"
			align="bottom" size="5" /></td>
		<td><input type="submit" name="submit" value="����" /></td>
	</tr>
</table>
<table width="534"  align="center">
	<tr>
		<td width="516" height="23">һ����ѡ�� :(ÿ�� 2��)</td>
	</tr>
</table>

 <%int i = 0;
			int j = 0;
			int k = 0;

			%> <c:forEach end="${countOfChoose1-1}" begin="0"
	items="${compulsoryPaper}" var="Choose1">
	<table  width="534"  align="center">
		<%i++;

				%>


		<tr>
			<td height="90">��Ŀ<%=i%>: ${Choose1.ch_question}</td>
		</tr>
		<tr>
			<td height="25">Aѡ��: ${Choose1.keya}</td>
		</tr>
		<tr>
			<td height="25">Bѡ��: ${Choose1.keyb}</td>
		</tr>
		<tr>
			<td height="25">Cѡ��: ${Choose1.keyc}</td>
		</tr>
		<tr>
			<td height="25">Dѡ��: ${Choose1.keyd}</td>
		</tr>

		<tr>
			<td height="25"><label><font class="BODY">A</font><input type="radio"
				name="Key1<%=i%>" value="a" /></label>&nbsp;&nbsp; <label><font
				class="BODY">B</font><input type="radio" name="Key1<%=i%>" value="b" /></label>
			&nbsp;&nbsp;<label><font class="BODY">C</font><input type="radio"
				name="Key1<%=i%>" value="c" /></label>&nbsp;&nbsp; <label><font
				class="BODY">D</font><input type="radio" name="Key1<%=i%>" value="d" /></label></td>
		</tr>
		<tr><td>
		<input type="hidden" name="choose1id<%=i%>" value="${Choose1.ch_id}" /></td></tr>
	</table>
</c:forEach>
<table  width="534" align="center">
	<tr>
		<td height="23">������ѡ��:(ÿ�� 4��)</td>
	</tr>
</table>
<c:forEach end="${countOfChoose1+countOfChoose2-1}"
	begin="${countOfChoose1}" items="${compulsoryPaper}" var="Choose2">
	<table class="TH" width="534" height="435" border="3" align="center">
		<%j++;

				%>
<tr><td>
		<input type="hidden" name="choose2id<%=j%>" value="${Choose2.ch_id}" /></td></tr>

		<tr>
			<td height="90">��Ŀ<%=j%>: ${Choose2.ch_question}</td>
		</tr>
		<tr>
			<td height="25">Aѡ��: ${Choose2.keya}</td>
		</tr>
		<tr>
			<td height="25">Bѡ��: ${Choose2.keyb}</td>
		</tr>
		<tr>
			<td height="25">Cѡ��: ${Choose2.keyc}</td>
		</tr>
		<tr>
			<td height="25">Dѡ��: ${Choose2.keyd}</td>
		</tr>

		<tr>
			<td height="25"><label><font class="BODY">A</font><input
				type="checkbox" name="Key2<%=j%>" value="a" /></label>&nbsp;&nbsp;
			<label><font class="BODY">B</font><input type="checkbox"
				name="Key2<%=j%>" value="b" /></label> &nbsp;&nbsp;<label><font
				class="BODY">C</font><input type="checkbox" name="Key2<%=j%>"
				value="c" /></label>&nbsp;&nbsp; <label><font class="BODY">D</font><input
				type="checkbox" name="Key2<%=j%>" value="d" /></label></td>
		</tr>
		<tr><td>
		<input type="hidden" name="choose2id<%=j%>" value="${Choose2.ch_id}" /></td></tr>
	</table>
</c:forEach>
<table  width="534" align="center">
	<tr>
		<td>���������:(ÿ�� 4��)</td>
	</tr>
</table>
<c:forEach begin="${countOfChoose1+countOfChoose2}"
	items="${compulsoryPaper}" var="Text">
	<table width="534"  align="center">
		<%k++;

				%>

		<input type="hidden" name="textid<%=k%>" value="${Text.text_id}" />

		<tr>
			<td height="92">��Ŀ<%=k%>: ${Text.text_question}</td>
		</tr>

		<tr>
			<td height="25"><input type="text" name="text<%=k%>" size="80" /></td>
		</tr>
	</table>
</c:forEach></form>
</body>
</html>
<script>
<!--
var limit = "60:00";
if(document.images){
var parseLimit = limit.split(":");
parseLimit = parseLimit[0] * 60 + parseLimit[1] * 1;
}
function beginTimer(){
if(!document.images) return;
if(parseLimit == 1){
//����������ʱ�䵽�˺�������ӵ�ҳ��,�����ֶ��޸�
window.location="Cexam_giveElectiveScore";
}else{
parseLimit -= 1;
curmin = Math.floor(parseLimit/60);
cursec = parseLimit%60;
curtime = curmin + ":" + cursec;
setTimeout("beginTimer()",1);
//���ı�������ʾʣ���ʱ��
document.testForm.Btime.value=curtime;
}
}

//-->
</script>
