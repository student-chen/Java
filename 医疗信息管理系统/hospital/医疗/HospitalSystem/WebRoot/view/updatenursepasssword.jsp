<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">    
     function check(form){
	   if(form.password1.value==""){
	     alert("����������,�����������Ƿ���ȷ!");
	   }else{
	     document.nursePasswordForms.submit();
	   }
	 }
    </script>
    <title>��ʿ��Ϣ��</title>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/updatePasswordServlet?opertion=3" method="post" name="nursePasswordForms">
      <table class="simple textCss">
      <tr>
      	   <th colspan="2" align="center" class="title">��ʿ�����޸�</th>
      </tr>
      <tr>
	      <th width="30%" align="right">��¼��:</th>
	      <td><input type="text" name="loginName" value="<%=session.getAttribute("nurseName")%>" class="txt" disabled="disabled"></td>
      </tr>
      <tr>
	      <th width="30%" align="right">������:</th>
	      <td>
	      <input type="password" name="loginPassword" class="txt" onchange="pass(this)">
	         <script type="text/javascript">
	       			function pass(obj){
	       				var ob=obj.value;
	       				var pa=<%=(String)session.getAttribute("nursePassword")%>
	       				if(ob!=pa){
	       					alert("�����������͵�¼ʱ�����벻һ��!!");
	       					obj.value="";
	       					return;
	       				}	       				
	       			}
	       		</script></td>
      </tr>
     <tr>
	     <th width="30%" align="right">������:</th>
	     <td>
	     <input type="password" name="password" class="txt" onchange="nursepass1(this)">
	      <script type="text/javascript">
		       		function nursepass1(obj){
		       			var pass1=obj.value;
	       				var pa2=<%=(String)session.getAttribute("nursePassword")%>
		       			if(pass1==pa2){
		       				alert("��������������ԭ������ͬ!!");
		       				document.nursePasswordForms.password.value="";
		       				return ;
		       			}
		       		}		       
		       </script></td>
     </tr>
     <tr>
	     <th width="30%" align="right">ȷ������:</th>
	     <td>
	     <input type="password" name="password1" class="txt" onchange="nursepass()">
	     <script type="text/javascript">
		       		function nursepass(){
		       			var pass3=document.nursePasswordForms.password.value;
		       			var pass2=document.nursePasswordForms.password1.value;
		       			if(pass3!=pass2){
		       				alert("��������������벻һ��!!");
		       				document.nursePasswordForms.password1.value="";
		       				return;
		       			}
		       		}		       
		       </script></td>
     </tr>
     <tr>
     	<td colspan="2" background="imgs/color/color_qianse.jpg">
     </td>
     </tr>
     <tr>
     	<td colspan="2" align="center">
        <input type="button" value="�ύ" class="buttonClass"onclick="return check(this.form);"></td>
    </tr>
      </table>
    </form>
   </body>
</html>
