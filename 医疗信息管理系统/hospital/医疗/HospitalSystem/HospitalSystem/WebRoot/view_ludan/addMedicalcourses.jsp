<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/> 
	<script type="text/javascript">
	     function check(form){
		   if(form.name.value==""){
		     alert("�Ʊ����Ʋ���Ϊ��");
		   }else{
		     document.mediForsm.submit();
		   }
		 }
	</script>   
	<title>�Ʊ����</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=1" method="post" name="mediForsm">
		<table class="simple textCss">
			<tr>
				<th colspan="2" class="title">�Ʊ����</th>
			</tr>
			<tr>
				<td align="right" width="30%" class="title">�Ʊ�����</td>
				<td><input type="text" name="name" class="txt"></td>
			</tr>
			<tr>
				<td align="right" width="30%" class="title">�Ʊ�����</td>
				<td>
					<input type="radio" name="type" value="0" checked="checked">���
					<input type="radio" name="type" value="1">�ڿ�
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="���" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="����" class="buttonClass">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="����" class="buttonClass"
						 onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>