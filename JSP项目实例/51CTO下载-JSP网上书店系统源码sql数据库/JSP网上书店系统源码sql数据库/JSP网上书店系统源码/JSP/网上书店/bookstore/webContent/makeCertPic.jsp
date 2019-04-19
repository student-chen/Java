<%@page contentType="image/jpeg" %>
<jsp:useBean id="image" scope="page" class="bean.db.common.makeCertPic" />
<%
	String str = image.getCertPic(0,0,response.getOutputStream());
	session.setAttribute("certCode", str); 
%>