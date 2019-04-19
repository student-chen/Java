<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>�鿴������</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/operatingRoomServlet?opertion=0"
			method="post">
			<input type="button" class="buttonClass" value="��������"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=true'">
			<input type="button" value="����������" class="buttonClass"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=false'">
			<table class="simple textCss">
				<tr>
					<th colspan="8" align="center">
						�����ұ�
					</th>
				</tr>
				<tr>
					<th width="7%" align="center">
						�����ұ��
					</th>
					<th width="10%" align="center">
						����
					</th>
					<th width="20%" align="center">
						��ַ
					</th>
					<th width="20%" align="center">
						��ע
					</th>
					<%--<th width="10%" align="center">
						��ʿ�б�
					</th>
					--%><th width="10%" align="center">
						�Ƿ����
					</th>
					<th width="15%" align="center">
						����
					</th>
				</tr>
				<c:forEach items="${operatingRoomList}" var="operating">
					<tr>
						<td>
							${operating.orNo}
						</td>
						<td>
							${operating.type}
						</td>
						<td>
							${operating.address}
						</td>
						<td>
							${operating.info}
						</td><%--
						<td>
							${operating.nurseList}
						</td>
						--%><td>
							<c:if test="${operating.isUseable==1}">��</c:if>
							<c:if test="${operating.isUseable==0}">��</c:if>
						</td>
						<td>
							<input type="button" class="buttonClass" value="ɾ��" 
							onclick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=2&id=${operating.id}'">
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
