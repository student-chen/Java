<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.*,java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="com.tsinghuait.st0717.hospitalsystem.dto.Doctor"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>ҽ����Ϣ��</title>
    <script type="text/javascript">    
     function check(form){
	   if(form.loginPassword2.value==""){
	     alert("����������,�����������Ƿ���ȷ!");
	   }else{
	     document.doctorpassForms.submit();
	   }
	 }
    </script>
 </head>
 <body>
  <form action="<%=request.getContextPath()%>/updatePasswordServlet?opertion=2" method="post" name="doctorpassForms">
    <div>
      <center>
      <table class="simple textCss">
      <tr>
      		<th colspan="2" valign="center" class="title">ҽ�������޸�</th>
      </tr>
       <tr>
       		<th width="30%" align="right">��¼��:</th>
       		<td><input type="text" name="loginName" class="txt" value="<%=session.getAttribute("doctorName")%>" disabled="disabled"></td>
       </tr>
       <tr>
	       <th width="30%" align="right">������:</th>
	       <td>
	       		<input type="password" name="loginPassword" class="txt" onchange="pass(this);">
	       		<script type="text/javascript">
	       			function pass(obj){
	       				var ob=obj.value;
	       				var pa=<%=(String)session.getAttribute("doctorPassword")%>
	       				if(ob!=pa){
	       					alert("�����������͵�¼ʱ�����벻һ��!!");
	       					obj.value="";
	       					return;
	       				}	       				
	       			}
	       		</script>
	       </td>
       </tr>
       <tr>
	       <th width="30%" align="right">������:</th>
	       <td><input type="password" name="loginPassword1" class="txt" onchange="doctorpass1();">
		       <script type="text/javascript">
		       		function doctorpass1(){
		       			var pass1=document.doctorpassForms.loginPassword1.value;
	       				var pa2=<%=(String)session.getAttribute("doctorPassword")%>
		       			if(pass1==pa2){
		       				alert("��������������ԭ������ͬ!!");
		       				document.doctorpassForms.loginPassword1.value="";
		       				return ;
		       			}
		       		}		       
		       </script>
	       </td>
       </tr>
       <tr>
	       <th width="30%" align="right">ȷ������:</th>
	       <td>
	       	   <input type="password" name="loginPassword2" class="txt" onchange="doctorpass();">
		       <script type="text/javascript">
		       		function doctorpass(){
		       			var pass3=document.doctorpassForms.loginPassword1.value;
		       			var pass2=document.doctorpassForms.loginPassword2.value;
		       			if(pass3!=pass2){
		       				alert("��������������벻һ��!!");
		       				document.doctorpassForms.loginPassword2.value="";
		       				return;
		       			}
		       		}		       
		       </script>
	       </td>	       
       </tr>
        <tr>
        	<td colspan="2" background="imgs/color/color_qianse.jpg"></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
	        <input type="button" value="�ύ" class="buttonClass" onclick="return check(this.form);"></td>
        </tr>      
      </table>
      </center>
      </div>
    </form>
   </body>
</html>
    