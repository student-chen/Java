<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�ſεڶ���-Ϊ����༶ѡ����ʦ�Ϳγ�</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<LINK href="../res/css/main.css" rel=stylesheet>
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>
<script type="text/javascript">
 function getResult(stateVal) {
         var url = "CautoMakeScheme_selectTeacherServlet?state="+stateVal; 
         if (window.XMLHttpRequest) { 
                 req = new XMLHttpRequest(); 
         }else if (window.ActiveXObject) { 
                 req = new ActiveXObject("Microsoft.XMLHTTP"); 
         } 
         if(req){ 
                 req.open("GET",url, true); 
                 req.onreadystatechange = complete; 
                 req.send(null); 
         } 
 } 
 function complete(){
         if (req.readyState == 4) { 
                 if (req.status == 200) { 
                         var teacher = req.responseXML.getElementsByTagName("teacher"); 
                         //alert(teacher.length);
                         var str=new Array();
                         for(var i=0;i<teacher.length;i++){
                                 str[i]=teacher[i].firstChild.data;
                         }
                         //alert(document.getElementById("teacher"));
                         buildSelect(str,document.getElementById("teacher"));
                 }
         }
 }
 function buildSelect(str,sel) {
         sel.options.length=0;
         for(var i=0;i<str.length;i++) {
                 sel.options[sel.options.length]=new Option(str[i],str[i])
         }
 }
 </script>
<body>
�ſεڶ���-Ϊ����༶ѡ����ʦ�Ϳγ�
<br>
��һ��������ʦ�Ϳγ���һ��һ�Ĺ�ϵ
<form method="post" action="CautoMakeScheme_getLesson1AndTeacherInfo">

<table width="596" height="210" class="tableborder">
	<tr>
		<!--------------------- ѡ��γ̺Ͱ༶ --------------------->
		<td width="156">
		<table width="147" class="tableborder">
			<caption>�༶:${className} �׶�:${phase}</caption>
			<tr>
				<td>ѡ����޿γ�:</td>
			</tr>
			<tr>
				<td><SELECT name="state" onChange="getResult(this.value)">
					<c:forEach items="${lesson1List}" var="lesson1">
						<option value="${lesson1.lessonName}" />${lesson1.lessonName}
					</c:forEach>
				</SELECT></td>
			</tr>

			<tr>
				<td>��Ӧ����ʦ:</td>
			</tr>
			<tr>
				<td><SELECT id="teacher" name="teacher">
					<option value="-1" selected />==========
				</SELECT></td>
			</tr>
		</table>

		<!--------------------- ȷ����ť ---------------------></td>
		<td width="28" bordercolor="#00FF00" align="justify"><input
			type="submit" name="Submit" value="=>" align="middle"></td>
		<!--------------------- ��ʾ��ʦ,�γ�,�༶ --------------------->
		<td width="396" valign="top">
		<table width="397" height="55" class="tableborder">
			<tr>
				<td height="32">���</td>
				<td>��ʦ</td>
				<td>�γ�</td>
				<td>�༶</td>
				<td>ɾ��</td>
			</tr>
			<c:forEach items="${c_l_t_list}" var="c_l_t">
				<tr>
				<c:forEach items="${c_l_t}" var="info">
					<td>${info}</td>
				</c:forEach>
				<c:forEach items="${c_l_t}" var="clt" begin="0" end="0">
				<td><a href="CautoMakeScheme_deleteClassAndTeacherForClasses?action=${clt}">ɾ��</a></td>	
				</c:forEach>
				</tr>
			</c:forEach>
		</table>
		</td>
	<tr>
</table>
<c:if
	test='${(warnMessage != null)|| (warnMessage != "") || (warnMessage != "null") || (warnMessage != "NULL") }'><font color="red">${warnMessage}</font></c:if>
</form>
<p><input type="button" onclick="window.history.go(-1)" value="��ʼ�Զ��ſ�"></p>
</body>
</html>
