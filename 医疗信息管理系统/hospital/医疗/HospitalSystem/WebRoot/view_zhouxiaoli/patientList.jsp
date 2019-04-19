<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>�鿴������ϸ��Ϣ</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
  		function onch(){
  			var page = document.patientListFormsabc.textPages.value;
  			if(page==null||page==0||page==""){
  				alert("������Ҫ��ѯ����Чҳ����");
  				return;
  			}
  			window.location.href ="<%=request.getContextPath()%>/patientListServlet?opertion=4&num=1&page="+page;
  		}   
	</script>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/patientListServlet?opertion=4" method="post" name="patientListFormsabc">
  <table class="simple textCss">
 <tr>
  	<td class="title">
  		<input type="submit" value="��ѯȫ��" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=1'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="���ڿƲ�ѯ" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=2'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="����Ʋ�ѯ" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=3'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="�Ѵ���Ĳ���" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=4'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="δ����Ĳ���" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=5'">
  	</td>
 </tr>	
 </table>
  <table  class="simple textCss">
  <tr>
  	<th width="10%" align="center">���˱��</th>
  	<th width="10%" align="center">����</th>
  	<th width="5%" align="center">�Ա�</th>
  	<th width="15%" align="center">��ַ</th>
  	<th width="5%" align="center">����</th>
  	<th width="10%" align="center">�Ƿ���</th>
  	<th width="10%" align="center">�Ʊ�</th>
	<th width="15%" align="center">����</th>
  </tr>
  <c:forEach items="${patientList}" var="patient">
  <tr>
  		<td width=10% align="center">${patient.patientNo}</td>
    	<td width=10% align="center">${patient.name}</td>
    	<td width=5% align="center">${patient.sex}</td>
    	<td width=15% align="center">${patient.address}</td>
    	<td width=5% align="center">${patient.age}</td>
    	<td width=10% align="center">
    		<c:if test="${patient.isfinished==1}">�Ѵ���</c:if>
    		<c:if test="${patient.isfinished==0}">δ����</c:if>
    	</td>
    	<td width=10% align="center">${patient.mcName}</td>
    	<td width=15% align="center">
			<input type="button" value="ɾ��"
							onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=2&oid=${patient.oid}'"
							class="buttonClass">
		</td>
 </tr>  
  </c:forEach>
    </table>
   <table class="simple textCss">
		<tr>
   			<td align="right" width=100% colspan="5">��<font color="red">${page.pageNum}</font>���������&nbsp;&nbsp;&nbsp;����<font color="red">${page.lastPage}</font>ҳ
   			&nbsp;&nbsp;&nbsp;��ǰ�ǵ�<font color="red">${page.pageSize}</font>ҳ&nbsp;&nbsp;&nbsp;
   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=1&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.priorPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.nextPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="���ҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.lastPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			������&nbsp;<input type=text name="textPages" value="1" size="7" onkeyup="this.value=this.value.replace(/\D/g,'')">
   			ҳ&nbsp;&nbsp;&nbsp;<input type="button" value="GO" onclick="onch();" class="patientButton">&nbsp;&nbsp;&nbsp;</td>
   		</tr>
   	</table>
 </form>
  </body>
</html>
