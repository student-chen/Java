<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  response.setIntHeader("Refresh",10);
 %>
<html>
	<head>
		<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	</head>
	<body>
		<center>
			<%
					if (request.getAttribute("Statsptlist") != null)
					session.setAttribute("money", request
					.getAttribute("Statsptlist"));
				else {
			%>
			<script type="text/javascript">
			      alert("null");
			    </script>
			<%
			}
			%>
			<form action="view_liuhaiqing/cart.jsp" method="post" name="f">
				<table class="simple textCss">
					<tr>
						<th width="30%">
							��Ŀ
						</th>
						<th width="10%">
							���
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
					<c:set var="all" value="0"></c:set>
					<c:forEach items="${Statsptlist}" var="Stat">
						<c:set var="all" value="${all+ Stat.pay }"></c:set>
						<tr>
							<td align="center">
								${ Stat.items }&nbsp;
							</td>
							<td align="center">
								${ Stat.pay }&nbsp;
							</td>
							<td align="center">
								${ Stat.payee }&nbsp;
							</td>
							<td align="center">
								${ Stat.name }&nbsp;
							</td>
							<td align="center">
								${ Stat.pdate }&nbsp;
							</td>
							<td align="center">
								<c:choose>
									<c:when test="${ Stat.isFinished ==0}">
										<c:out value="��"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="��"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td align="center" colspan="6">
						 <c:if test="${requestScope.finish ==1 }">
						   <input type="submit" value="���س�Excel" class="buttonClass">
						 </c:if>
						 <c:if test="${requestScope.finish ==0 }">
						  <input type="button" value="�˳�"
							onclick="window.location.href='${pageContext.request.contextPath}/receiptLiuHaiQingServlet?operation=0'" class="buttonClass" >
						 </c:if>
						</td>
					</tr>
				</table>
				<hr>
				ͳ�ƣ����${all }Ԫ.
			</form>
		</center>
	</body>
</html>
