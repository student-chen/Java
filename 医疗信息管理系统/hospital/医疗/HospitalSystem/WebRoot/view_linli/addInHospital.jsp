<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="Css/LightBlue_Css.css">
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/time.js">
	</script>
		<script type="text/javascript">
	 function mycheck() {
	     <%--    var today=new Date();--%>
	    if(document.form.startdate.value=="")  {
	      alert('��ѡ��סԺ����');
	      return false;
	    }
	    else if(document.form.enddate.value=="") {
	      alert('��ѡ���Ժ����');
	      return false;
	    }
	    else if(document.form.startdate.value==""&&document.form.enddate.value=="")
	    {
	      alert("�뽫�ò���סԺ����Ϣ������");
	      return false;
	    }  
	  <%--      else if(document.form.startdate.value!=today)
	    {
	      alert('�Բ�����ֻ�ܰ��ŵ���סԺ��Ϣ');
	      return false;
	    }--%>
	 } 
	</script>
	</head>
	<%
    String patientName=(String)request.getAttribute("pName").toString();
    String oid=request.getAttribute("oid").toString();
    %>
	<body>
		<form action="<%=request.getContextPath()%>/inHospitalServlet?opertion=1" method="post" name="form">
			<table class="simple textCss">
				<tr>
					<th colspan="2" align="center">��Ӳ���סԺ</th>
				</tr>
				<tr>
					<th width="30%" align="right">
						���˿Ʊ�:
					</th>
					<td>
						<input type="text" name="patientType"
							value="<%=session.getAttribute("doctorLoginTree")%>"
							readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						��������:
					</th>
					<td>
						<input type="hidden" name="pId" value="<%=oid%>">
						<input type="text" name="patientName" value="<%=patientName%>" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						�������:
					</th>
					<td>
						<select name="bed">
							<c:forEach items="${bedNo}" var="bn">
								<option>
									${bn.bedNo}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						סԺ����:
					</th>
					<td>
						<input type="text" name="startdate" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						��Ժ����:
					</th>
					<td>
						<input type="text" name="enddate" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						ҽʦǩ��:
					</th>
					<td>
						<input type="text" name="pId"
							value="<%=session.getAttribute("doctorName")%>" readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="�ύ" onClick="return mycheck()" class="buttonClass">
						<input type="reset" value="����" class="buttonClass">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
