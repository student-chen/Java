<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>17ҽԺ���˹Һ�--�ذ�������Ϊ������</title>
    <meta http-equiv="content-type" content="text/html;charset=gb2312">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
		function load(){
		<%
			Object type=request.getAttribute("type");
			if(type!=null){
				if("1".equals(type+"")){
		%>
				document.f1.neike.checked=true;
		<%}else{
		%>
				document.f1.waike.checked=true;
		<%}}
		%>
		}
		function isthis1(){		//�����״��
			if(document.f1.neike.checked){
				document.patientRegisterForms.mcid.disabled=false;
				window.location.href="topQueryServlet?opertion=0&type=1";
			}else if(document.f1.waike.checked){
				document.patientRegisterForms.mcid.disabled=true;
				window.location.href="topQueryServlet?opertion=0&type=0";
			}
		}
		function toAge(){   //��֤�������Ч��
			var age=document.patientRegisterForms.age.value;
			if(isNaN(age)){ //������䲻�����֣�����ʾ�����Ϣ
				alert("��������������͵ģ�����");
				document.all("age").value="";
				return false;
			}
			else if(age>115||age<7){
				alert("����̫���̫С������");
				document.all("age").value="";
				return false;
			}
			return true;	
		}	
		function tochange(){
			var name=document.patientRegisterForms.name.value;
			if(name==null||name==""){
				alert("����û���Ϊ�գ�");
				return false;
			}else if(name.length>13||name.length<2){
				alert("�������Ϸ�����");
               document.patientRegisterForms.name.value="";
				return false;
			}
			return true;
		}		
     function check(form){
	   if(form.patientNo.value==""){
	     alert("�ҺŲ���Ϊ��");
	   }else if(form.name.value=="") {
	     alert("��������Ϊ��");
	   }else if(form.address.value=="") {
	     alert("��ַ����Ϊ��");
	   }else{
	     document.patientRegisterForms.submit();
	   }
	 }
	</script>
	
	</head>  
  <body onload="load();">
    <form action="topQueryServlet?opertion=1" method="post" name="patientRegisterForms" id="f1">
    	<table  class="simple textCss"> 
    		<tr>
    			<th colspan="3">���˹Һ�ע����Ϣ</th>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">��������:</td>
    			<td width="40%" align="left">
    				<input type="radio" name="mcid" value="0" id="waike" onclick="isthis1()">���
    				<input type="radio" name="mcid" value="1" id="neike" onclick="isthis1()">�ڿ�
    			</td>
    			<td width="40%" align="left">ע���Ǹò���Ӧ��Ҫȥ�����Ŀ�������</td>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">��������:</td>
    			<td width="40%" align="left">
    				<select name="mcName">
    					<c:forEach items="${medicalcoursesNameSelected}" var="na">
    						<option value="${na.name}">${na.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td width="40%" align="left">ע���Ǹò���Ӧ��Ҫȥ�����Ŀ�������</td>
    		</tr>
    		<tr>	
    			<td width="20%" align="right">�Һź���:</td>
    			<td width="40%" align="left"><input type="text" name="patientNo" class="txt"></td>
    			<td width="40%" align="left">ע���Һź���Ϊ���˹Һŵı�־&nbsp;&nbsp;��:[S1002]</td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">����:</td>
    			<td width="40%" align="left">
    				<input type="text" name="name" class="txt" onblur="return tochange();" 
    					onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')"></td>
    			<td width="40%" align="left">ע����������</td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">�Ա�:</td>
    			<td width="40%" align="left">    				
    				<input type="radio" name="sex" id="m" value="��" checked>��
    				<input type="radio" name="sex" id="w" value="Ů">Ů</td>
    			<td width="40%" align="left"></td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">����:</td>
    			<td width="40%" align="left">
    				<input type="text" name="age" value="24" onBlur="return toAge();" class="txt"></td>
    			<td width="40%" align="left"></td>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">��ͥ��ַ:</td>
    			<td width="40%" align="left"><input type="text" name="address" class="txt"></td>
    			<td width="40%" align="left">ע���Ǹò��˼�ͥ����ϸ��Ϣ</td>
    		</tr>   
    		<tr height="40">	
    			<td width="20%" align="right">�Ƿ񼤻�:</td>
    			<td width="40%" align="left">
    				<input type="radio" name="isfinished" value="��" checked>��
    				<input type="radio" name="isfinished" value="��">��	
    			</td>
    			<td width="40%" align="left">ע������������Ͽ��Խ�������!</td>
    		</tr>   
    		<tr>
    			<td colspan="2" align="center" width="60%">
    				<input type="button" value="�ύ" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="reset" value="����" class="buttonClass">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td align="right" width="40%">
    				<font color=red>����������ǳ�ŵ���������������Ϣ���ܣ���</font>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>