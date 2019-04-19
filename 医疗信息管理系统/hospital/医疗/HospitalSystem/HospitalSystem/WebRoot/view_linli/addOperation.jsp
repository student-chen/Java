<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/time.js"></script>
		<script type="text/javascript">
		function my(){
	        var today=new Date();
		    var reg=new RegExp(/^[-\+]?\d+(\.\d+)?$/);
            if(document.frm.pay.value=="") {
               alert("�����벡���������"); 
                return false;
            }
            else if(!reg.test(document.frm.pay.value)){
                alert("���ڷ���������������");
                return false;
            }
           else if(document.frm.date.value==""){
	            alert('��ѡ����������');
	            return false;
	       }
	  <%--     else if(document.frm.date.value<=today)
	       {
	             alert('�Բ�����ֻ�ܰ��ŵ�����Ժ������');
	             return false;
	       }--%>
	     }
	</script>
	</head>
	<%
		String name = (String) request.getAttribute("pName").toString();
		String oids = request.getAttribute("oid").toString();
	%>
	<body onload="loadType();">
		<form
			action="<%=request.getContextPath()%>/operationServlet?opertion=1"
			method="post" name="frm" id="forforms">
			<table class="simple textCss">
				<tr>
					<th colspan="2" align="center">��Ӳ��˵�������</th>
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
						<input type="hidden" name="pId" value="<%=oids%>">
						<input type="text" name="patientName" value="<%=name%>" class="txt">
					</td>
				</tr>
				<%--<td width="10%" align="center">��������:</td>
            <td><select name="checkbox1" id="year" onchange="toDate()">
		             <script>
						var today=new Date();
						  for(var i=today.getYear();i<=today.getYear()+100;i++)
						   {
						      document.write("<option>"+i+"</option> selected");
						   }
					 </script>
		        </select>��
	    	    <select name="checkbox2" id="month" onchange="toDate()">
		             <script>
			             for(var i=1;i<=12;i++)
			             {
				           document.write("<option>"+i+"</option> selected");
			             }
		              </script>
		        </select>��
		        <select name="checkbox3" id="day">
		              <script>
							for(var i=1;i<=31;i++)
							{
								document.write("<option>"+i+"</option> selected");
							}
	                  </script>
		        </select>��
	        </td>
      --%>
				<tr>
					<th width="30%" align="right">
						�����ұ��:
					</th>
					<td>
						<select name="No">
							<c:forEach items="${roomOrNo}" var="no">
								<option>
									${no.orNo }
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						��������:
					</th>
					<td>
						<input type="text" name="date" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						������ʼʱ��:
					</th>
					<td>
						<select name="shour">
							<%
							for (int sh = 8; sh <= 24; sh++) {
							%>
							<option>
								<%=sh%>
							</option>
							<%
							}
							%>
						</select>
						ʱ
						<select name="sminute">
							<option>
								00
							</option>
							<option>
								20
							</option>
							<option>
								40
							</option>
						</select>
						��
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						��������ʱ��:
					</th>
					<td>
						<select name="ehour">
							<%
							for (int eh = 8; eh <= 24; eh++) {
							%>
							<option>
								<%=eh%>
							</option>
							<%
							}
							%>
						</select>
						ʱ
						<select name="eminute">
							<option>
								00
							</option>
							<option>
								20
							</option>
							<option>
								40
							</option>
						</select>
						��
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						��������֧�����:
					</th>
					<td>
						<input type="text" name="pay" class="txt">��
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						����ҽʦ����:
					</th>
					<td>
						<select name="extDoctorName">
							<c:forEach items="${DoctorName}" var="dn">
								<option>
									${dn.name}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						����ҽʦǩ��:
					</th>
					<td>
						<input name="pkDoctorName"
							value="<%=session.getAttribute("doctorName")%>" readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="�ύ" class="buttonClass" onClick="return my()">
						<input type="reset" value="����" class="buttonClass">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
