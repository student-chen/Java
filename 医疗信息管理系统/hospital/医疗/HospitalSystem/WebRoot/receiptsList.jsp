<%@ page language="java" pageEncoding="GBK"%>
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
					<th width="10%">
						ѡ��&nbsp;
					</th>
					<th width="20%">
						��Ŀ&nbsp;&nbsp;
					</th>
					<th width="10%">
						���&nbsp;&nbsp;
					</th>
					<th width="10%">
						�տ���
					</th>
					<th width="10%">
						������
					</th>
					<th width="30%">
						����
					</th>
					<th width="10%">
						�Ƿ�����
					</th>
				</tr>
				<c:forEach items="${receiptlist}" var="post">
					<tr>
						<td align="center">
							<input type="checkbox" name="ids" value="${ post.id }">
						</td>
						<td>
							${ post.items }&nbsp;
						</td>
						<td>
							${ post.pay }&nbsp;
						</td>
						<td>
							${ post.payee }&nbsp;
						</td>
						<td>
							${ post.payeeId }&nbsp;
						</td>
						<td>
							${ post.pdate }&nbsp;
						</td>
						<td>
							${ post.isFinished }&nbsp;
						</td>
						<td>
							<a href="HospitalSystem?operation=2&id=${ post.id }">ɾ��</a>
							<a href="HospitalSystem?operation=4&id=${ post.id }">�޸�</a>
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
