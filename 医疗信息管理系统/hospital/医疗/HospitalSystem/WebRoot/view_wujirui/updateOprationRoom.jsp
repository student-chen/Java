<%@ page language="java" pageEncoding="gbk"%>
<jsp:directive.page
	import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'updateOprationRoom.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
		<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none; 
}
-->
</style>
	</head>
	<body>
		<form
			action="<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=3"
			method="post">
			<table  class="simple textCss">
				<c:forEach items="${showOperationRoom}" var="showoperationRoom">
					<tr>
    					<th align="center" width="30%">�����ұ��</th>
						<td>
							<input type="text" value="${showoperationRoom.orNo}" name="orNo" class="txt">
							<input type="hidden" value="${showoperationRoom.id}" name="id">
						</td>
						<td></td>
					</tr>
					<tr>
    					<th align="center" width="30%">��&nbsp;&nbsp;&nbsp;ַ</th>
						<td>
							<input type="text" value="${showoperationRoom.address}" name="address" class="txt">
						</td>
						<td></td>
					</tr>
					<tr>
    					<th align="center" width="30%">��&nbsp;&nbsp;&nbsp;ע</th>
						<td>
							<input type="text" value="${showoperationRoom.info}" name="info" class="txt">
						</td>
						<td></td>
					</tr>
					<%
						//���� OperatingRoomService�е�addoperationgetNurseListName
						String sql = "select *from nurse";
						OperationRoomWuJiRuiService operatingRoomService = new OperationRoomWuJiRuiService();
						request.setAttribute("nurselistName", operatingRoomService
								.addoperationgetNurseListName(sql));
					%>
					<tr>
						<th align="center" width="30%">��ʿ�б�</th>
						<td class="txt">
							<c:forEach items="${updatenurseNameList}" var="updatenurseNameList">
								<font color="blue">${updatenurseNameList.name} </font>
							</c:forEach>
							<%--   
	                 			 ��ʾ�Ļ�ʿ�Ǵ�UpdateOperationRoomServlet�е�updatenurseNameList��������
	               			 --%>
						</td>
						<td>
							<select name="updateNurseName" onclick="nurseName();" multiple="multiple" size="3">
								<c:forEach items="${nurselistName}" var="nurselist">
									<option value="${nurselist.id}">
										${nurselist.name}
									</option>
								</c:forEach>
							</select>

							<%--
	              				 �û�ʿ�б��ǴӸ�ҳ��ġ�%  %���е�nurselistName�д�������
	               			--%>
						</td>
					</tr>
					<tr>
						<th align="center" width="30%">�Ƿ����</th>
					    <td>
				   			<c:if test="${showoperationRoom.isUseable==1}">
				   			   <input type="radio" name="isUseable" value="1" checked>��
				   			   <input type="radio" name="isUseable" value="0">��
				   			</c:if>
				   			<c:if test="${showoperationRoom.isUseable==0}">
				   			    <input type="radio" name="isUseable" value="1">��
				   			    <input type="radio" name="isUseable" value="0" checked>��
				   			</c:if>  ע:(��,��)
			   		    </td>					
		            </tr>
				</c:forEach>
				<tr>
					<td colspan="7" align="center">
						<input type="submit" value="�޸�" class="buttonClass">
						 <input type="button" value="����" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=4'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>