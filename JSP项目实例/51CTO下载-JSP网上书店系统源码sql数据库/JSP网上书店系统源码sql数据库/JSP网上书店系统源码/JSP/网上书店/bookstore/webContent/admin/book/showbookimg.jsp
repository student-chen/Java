<%@ page contentType="image/jpg;charset=GB2312" %>
<%@ page import="java.io.OutputStream,bean.db.bookOPBean,bean.db.bookBean"%>
<%
	bookOPBean bookop=new bookOPBean();
	bookBean book=bookop.selectBookById(Integer.parseInt(request.getParameter("bookid")));
	OutputStream toClient = response.getOutputStream();
	toClient.write(book.getImageByteArray());
	toClient.flush();
    toClient.close();
%>