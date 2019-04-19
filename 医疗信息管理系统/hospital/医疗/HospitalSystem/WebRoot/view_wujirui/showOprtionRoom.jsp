<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'showOprtionRoom.jsp' starting page</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
		<script type="text/javascript">
        function ch(obj){
           var page=obj.value;
           window.location.href="${pageContext.request.contextPath}/operationRoomServlet?&opertion=4&page="+page;
        }          
		function loadRadioIsUseable(){
		<%
			Object type=request.getAttribute("isUseableType").toString();
			System.out.println("========="+request.getAttribute("isUseableType"));
			if(type!=null){
				if("0".equals(type+"")){
		%>
				document.formoper.feikongxian.checked=true;
		<%}else	if("1".equals(type+"")){
		%>
				document.formoper.kongxian.checked=true;
		<%}else{
		%>
				document.formoper.souyouxinxi.checked=true;
		<%}
		}
		%>
		}
   		</script>
	<style type="text/css">
	<!--
	a:link {text-decoration: none;}
	a:visited {	text-decoration: none;}
	a:hover {text-decoration: none;}
	a:active {text-decoration: none;}
	-->
	</style>
	</head>
	<body onload="loadRadioIsUseable();"> 
		<form action="${pageContext.request.contextPath }/operationRoomWuJiRuiServlet?opertion=4" method="post" name="formoper" id="formoper">
			<table class="simple textCss">
				<tr>
					<th width="20%">������Ҫ��ѯ�����ƣ�</th>
					<th width="35%">
						<input type="text" name="orNo" class="txt">
					</th>
					<th width="35%">
					    <input type="radio" name="isUseable" id="kongxian" value="1" checked>����
						<input type="radio" name="isUseable" id="feikongxian" value="0">�ǿ���
						<input type="radio" name="isUseable" id="souyouxinxi" value="2">������Ϣ
					</th>
					<th width="15%">
						<input type="submit" value="��ѯ" class="buttonClass">
					</th>
				</tr>
			</table>
			<c:if test="${not empty requestScope.operationRoomList}">
				<table class="simple textCss">
					<tr>
						<th colspan="7" align="center">�����ұ���Ϣ</th>
					</tr>
					<tr><%--
						<th width="7%" align="right">ѡ��</th>
						--%>
						<th width="13%" align="right">�����ұ��</th>
						<th width="20%" align="right">��ַ</th>
						<th width="20%" align="right">��ע</th>
						<th width="10%" align="right">�Ƿ����</th>
						<th width="20%" align="right">����</th>						
					</tr>
					<c:forEach items="${operationRoomList}" var="operationRoom">
						<tr>
							<%--<td align="center">
								<input type="checkbox" name="che">
							</td>
							--%><td align="center">
								<a href="<%=request.getContextPath()%>/showNurseServlet?id=${operationRoom.id}">${operationRoom.orNo}</a>
							</td>
							<td align="center">
								${operationRoom.address}
							</td>
							<td align="center">
								${operationRoom.info}
							</td>
							<td align="center">
								<c:choose>
									<c:when test="${operationRoom.isUseable==1}">
										<c:out value="��"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="��"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="center">
								<input type="button" value="ɾ��" class="buttonClass"
									onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?&opertion=2&id=${operationRoom.id}'">&nbsp;&nbsp;&nbsp;
								<input type="button" value="�޸�" class="buttonClass"
									onclick="window.location.href='<%=request.getContextPath()%>/updateOperationRoomServlet?id=${operationRoom.id}'">
							</td>
						</tr>
					</c:forEach>
				</table>
		</c:if>
		<table class="simple textCss">
				<tr>
					<td width="100%" align="center">
					<input type="button" value="���" class="buttonClass"
					   onclick="window.location.href='<%=request.getContextPath()%>/view_wujirui/addOprationRoom.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
