<%@ page language="java" pageEncoding="GBK"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<title>ְ���޸�</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>    
</head>
<body>
	<form action="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=3" method="post">
	<%
	String id=request.getParameter("id");
	String name1=request.getParameter("name");
	String name=new String(name1.trim().getBytes("iso-8859-1"),"gbk");
	String type=request.getParameter("type");
	if(type==null||type==""||type=="1"){
		type="�ڿ�";
	}else{
		type="���";
	}
	 %>
	 <table class="simple textCss">
	 	<tr>
	 		<td colspan="3" class="title" align="center"><h3><font face="����">�޸ĿƱ���Ϣ</font></h3></td>
	 	</tr>
		 <tr>
			 <td width="30%%" align="right" class="title">�Ʊ�ID:</td>
			 <td><input type="text" name="id" value=<%=id%> readonly class="txt"></td>
		 </tr>
		 <tr>
			 <td width="30%%" align="right" class="title">�Ʊ�����:</td>
			 <td><input type="text" name="name" value=<%=name%> class="txt"></td>
	     </tr>
	     <tr>
			 <td width="30%%" align="right" class="title">�Ʊ�����:</td>
			 <td><input type="text" name="type" value=<%=type%> class="txt"></td>
		 </tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" value="�޸�" class="buttonClass">&nbsp;&nbsp;&nbsp;
				<input type="button" value="����" class="buttonClass"
				onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>