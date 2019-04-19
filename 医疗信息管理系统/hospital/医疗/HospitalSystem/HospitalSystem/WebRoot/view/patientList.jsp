<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>17ҽԺҽ����ʿ����--�ذ�������Ϊ������</title>
    <meta http-equiv="content-type" content="text/html;charset=gb2312">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
		function loadIsfinished(){
		<%
			Object isfinished=request.getAttribute("isfinished");
			if(isfinished!=null){
				if("1".equals(isfinished+"")){
		%>
				document.patientListFrom.chuli.checked=true;
		<%}else{
		%>
				document.patientListFrom.weichuli.checked=true;
		<%}}
		%>
		}
	</script>
  </head>  
  <body onload="loadIsfinished();">
    <form name="patientListFrom">
    	<table class="simple textCss">
    	<tr>
	    	<td colspan="6">���˴���״̬:
	    		<input type="radio" name="isfinished" value="δ����"id="weichuli" 
	    			onclick="window.location.href='<%=request.getContextPath()%>/patientServlet?isfinished=0'">δ������&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="radio" name="isfinished" value="����"id="chuli" 
	    			onclick="window.location.href='<%=request.getContextPath()%>/patientServlet?isfinished=1'">������Ĳ���
	    	</td>
    	</tr>
    		<tr class="simple">
    			<th align="center" width="12%">�Һź���</th>
    			<th align="center" width="12%">����</th>
    			<th align="center" width="10%">�Ա�</th>
    			<th align="center" width="10%">����</th>
    			<th align="center" width="20%">�Ʊ�</th>
    			<c:if test="${patientSer!=null}">
    				<th align="center" width="36%">����</th>
    			</c:if>
    		</tr>
    		<c:forEach items="${patientSer}" var="patient">
    			<tr>
	    			<td align="center" width="12%">${patient.patientNo}</td>
	    			<td align="center" width="12%">
	    				<a href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patient.oid}">${patient.name}</a>
	    			</td>
	    			<td align="center" width="10%">${patient.sex}</td>
	    			<td align="center" width="10%">${patient.age}</td>
	    			<td align="center" width="20%">${patient.mcName}</td>
	    			<td align="center" width="36%">
						<input type="button" value="�������" onclick="window.location.href='<%=request.getContextPath()%>/diagnosisServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">&nbsp;&nbsp;&nbsp;
						<input type="button" value="����" onclick="window.location.href='<%=request.getContextPath()%>/operationServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">&nbsp;&nbsp;&nbsp;
						<input type="button" value="סԺ" onclick="window.location.href='<%=request.getContextPath()%>/inHospitalServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">
					</td>
    			</tr>
    		</c:forEach>
    		<c:forEach items="${patientSerIsfinished}" var="patie">
    			<tr>
	    			<td align="center" width="12%">${patie.patientNo}</td>
	    			<td align="center" width="12%">
	    				<a href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patie.oid}">${patie.name}</a>
	    			</td>
	    			<td align="center" width="10%">${patie.sex}</td>
	    			<td align="center" width="10%">${patie.age}</td>
	    			<td align="center" width="20%">${patie.mcName}</td>
	    			<td align="center" width="36%"></td>
    			</tr>
    		</c:forEach>
    	</table>
    </form>
  </body>
</html>
