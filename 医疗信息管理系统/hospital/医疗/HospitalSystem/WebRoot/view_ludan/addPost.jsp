<%@ page language="java" contentType="text/html; charset=gbk"pageEncoding="GBK"%>
<html>
<head>
<title>ְ�����</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>  
	<script type="text/javascript">
	     function check(form){
		   if(form.name.value==""){
		     alert("ְ�����Ʋ���Ϊ��");
		   }else{
		     document.postFormsName.submit();
		   }
		 }
	</script>     
</head>
<body>
	<form action="<%=request.getContextPath()%>/postServlets?opertion=1" method="post" name="postFormsName">
		<table class="simple textCss">
			<tr>
				<th colspan="2" class="title">ְ�����</th>
			</tr>
			<tr>
				<td class="title" width="30%" align="right">ְ������</td>
				<td><input type="text" name="name" class="txt"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="���" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="����" class="buttonClass">&nbsp;&nbsp;&nbsp;
					<input type="button" value="����" class="buttonClass"					
					onclick="window.location.href='<%=request.getContextPath()%>/postServlets?opertion=4'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>