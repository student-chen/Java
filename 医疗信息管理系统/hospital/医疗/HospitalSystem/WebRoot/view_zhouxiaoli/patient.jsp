<%@ page language="java"pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>My JSP 'patient.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<%
	pageContext.setAttribute("patient",request.getAttribute("patientList"));
	 %>
  </head>
 <body> 
  	<form action="<%=request.getContextPath()%>/patientServlet?operation=3" method="post">
  	<table  class="simple textCss">
	<tr>
  		<th align="center" colspan="2">������Ϣ</th>
  	</tr>
  	<tr>
  		<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
  		<td><input type="text" name="oid" value="${patient.oid }" ReadOnly=true class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">סԺ&nbsp;&nbsp;��:</th>
  		<td><input type="text" name="patientNo" value="${patient.patientNo }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
  		<td><input type="text" name="name" value="${patient.name }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
  		<td><input type="radio" name="r1">��<input type="radio" name="r1">Ů</td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;ַ:</th>
  		<td><input type="text" name="address" value="${patient.address }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
  		<td><input type="text" name="age" value="${patient.age }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">�Ƿ���:</th>
  		<td>
  			<input type="radio" name="r">��
  			<input type="radio" name="r">��</td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">�Ʊ�&nbsp;&nbsp;ID:</th>
  		<td><input type="text" name="mcID" value="${patient.mcID }" ReadOnly=true class="txt"></td>
  	</tr>
  	<tr>
  	 <th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
	  	<td>
	  	<select name="aa">
		  	<option name="a" value="Ƥ����" selected>Ƥ����</option>
		  	<option name="b" value="�ǿ�" selected>�ǿ�</option> 
		   <option name="c" value="ICU" selected>ICU</option>
		   <option name="d" value="��ǻ��" selected>��ǻ��</option>
 	   </select>
		 </td>
		 </tr>
		 <tr>
		 	<td align="center" colspan="2">
			 	<input type="submit"  value="�ύ" class="buttonClass">&nbsp;&nbsp;
			 	<input type="reset"  value="����" class="buttonClass"></td>
		 </tr>
	 </table>
 </form>
  </body>
</html>
