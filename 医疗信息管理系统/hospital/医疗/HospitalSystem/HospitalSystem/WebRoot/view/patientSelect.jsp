<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>17ҽԺ���˲鿴������Ϣ--�ذ�������Ϊ������</title>
    <meta http-equiv="content-type" content="text/html;charset=gb2312">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>  
  <body>
    <form>
    	<table  class="simple textCss"> 
    		<tr>
    			<th colspan="3"��class="title">�鿴������Ϣ</th>
    		</tr> 
    		<c:forEach items="${patientDoctorHref}" var="pa">
    		<tr>	
    			<td width="20%" align="right">��������:</td>
    			<td width="40%" align="left">
    				<input type="text" value="${pa.mcName}" class="txt">
    			</td>
    		</tr>
    		<tr>	
    			<td width="20%" align="right">�Һź���:</td>
    			<td width="40%" align="left">
    				<input type="text" value="${pa.patientNo}" class="txt"></td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">����:</td>
    			<td width="40%" align="left">
    				<input type="text" value="${pa.name}" class="txt"></td>
     		</tr>    	
    		<tr>	
    			<td width="20%" align="right">�Ա�:</td>
    			<td width="40%" align="left">    		    						
    				<input type="text" value="${pa.sex}" class="txt"></td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">����:</td>
    			<td width="40%" align="left">
    				<input type="text" name="age" value="${pa.age}"  class="txt"></td>
    		</tr>   
    		</c:forEach>  
    		<tr>
    			<td colspan="2" align="center" width="60%">
    				<input type="button" value="����" class="buttonClass" 
    					onclick="window.location.href='<%=request.getContextPath()%>/patientServlet?isfinished=0'">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
