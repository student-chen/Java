<%@ page language="java" pageEncoding="GBk"%>
<html>
	<head>
		<title>ְ���޸�</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>    
	</head>
	<body>
	<%
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String name1=new String(name.trim().getBytes("iso-8859-1"),"gbk");
	 %>
	<form action="<%=request.getContextPath()%>/postServlets?opertion=3" method="post">
	<table class="simple textCss">
		<tr>
			<td colspan="2" align="center" class="title">�޸�ְ����Ϣ</td>
		</tr>
		<tr>
			<td align="right" class="title" width="30%">���:</td>
			<td><input type="text" name="id" value=<%=id%> class="txt"></td>
		</tr>
		<tr>
			<td align="right" class="title" width="30%">ְ������:</td>
			<td><input type="text" name="name" value="<%=name1%>" class="txt"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="�޸�" class="buttonClass">
				<input type="button" value="����" class="buttonClass"					
					onclick="window.location.href='<%=request.getContextPath()%>/postServlets?opertion=4'">				
			</td>
		</tr>	
	</table>					
	</form>
	</body>
</html>
