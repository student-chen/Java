<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	</head>
	<body>
		<table class="simple textCss">
			<tr class="simple">
				<th align="center" width="12%">
					�Һź���
				</th>
				<th align="center" width="12%">
					����
				</th>
				<th align="center" width="10%">
					�Ա�
				</th>
				<th align="center" width="10%">
					����
				</th>
				<th align="center" width="20%">
					�Ʊ�
				</th>
				<c:if test="${operationPatient!=null}">
					<th align="center" width="36%">
						����
					</th>
				</c:if>
			</tr>
			<c:forEach items="${operationPatient}" var="patie">
				<tr>
					<td align="center" width="12%">
						${patie.patientNo}
					</td>
					<td align="center" width="12%">
						<a
							href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patie.oid}">${patie.name}</a>
					</td>
					<td align="center" width="10%">
						${patie.sex}
					</td>
					<td align="center" width="10%">
						${patie.age}
					</td>
					<td align="center" width="20%">
						${patie.mcName}
					</td>
					<td align="center" width="36%">
						<input type="button" value="����"
							onclick="window.location.href='<%=request.getContextPath()%>/operationServlet?opertion=4&name=${patie.name}&id=${patie.oid }'"
							class="buttonClass">
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
