<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>My JSP 'postsList.jsp' starting page</title>
  </head>
  <body>
  		<form action="PostServlet?operation=0" method="post">
			<table class="simple">
				<tr>
					<td></td>
				</tr>
				<tr>
					<th width="20%">
						ѡ��&nbsp;
					</th>
					<th width="20%">
						���&nbsp;&nbsp;
					</th>
					<th width="20%">
						����&nbsp;&nbsp;
					</th>
					<th width="40%">
						����
					</th>
				</tr>
				<c:forEach items="${receiptlist}" var="receipt">
					<tr>
						<td align="center">
							<input type="checkbox" name="ids" value="${ receipt.id }">
						</td>
						<td>
							${ receipt.id }&nbsp;
						</td>
						<td>
							${ receipt.name }&nbsp;
						</td>
						<td>
							<a href="HospitalSystem?operation=2&id=${ receipt.id }">ɾ��</a>
							<a href="AuthorsServlet?operation=4&id=${ receipt.id }">�޸�</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			<input type="button" value="���" class="buttonClass" onclick="javaScript:window.location.href='posts.jsp'">
			<input type="button" value="����ɾ��" onclick="submitFrm();">
		 </form>
  </body>
</html>
