<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>�鿴������</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
	</head>
	<body>
		<form
			action="${pageContext.request.contextPath}/operatingRoomServlet?opertion=4"
			method="post">
			<input type="button" class="buttonClass" value="��������"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=true'">
			<input type="button" value="����������" class="buttonClass"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=false'">
			<table class="simple textCss">
				<tr>
					<th colspan=7 align="center">
						�����ұ�
					</th>
				</tr>
				<tr>
					<th width="15%" align="center">
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
					</th><%--
					<th width="10%" align="center">
						��ʿ�б�
					</th>
					--%><th width="10%" align="center">
						�Ƿ����
					</th>
				</tr>
				<c:forEach items="${operatingRoomList}" var="operating">
					<tr>
						<td align="center">
							${operating.orNo}
						</td>
						<td align="center">
							${operating.type}
						</td>
						<td align="center">
							${operating.address}
						</td>
						<td align="center">
							${operating.info}
						</td>
						<%--<td align="center">
							${operating.nurseList}
						</td>
						--%><td align="center">
							<c:if test="${operating.isUseable==1}">��</c:if>
							<c:if test="${operating.isUseable==0}">��</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7" align="center">
						<input type="button" value="�������" class="buttonClass"
							onClick="javaScript:window.location.href='view_zhouxiaoli/operatingRoom.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
