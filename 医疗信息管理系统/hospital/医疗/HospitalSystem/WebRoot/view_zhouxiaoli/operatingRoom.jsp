<%@ page language="java" pageEncoding="GBK"%>
<html>
  <head>    
    <title>�����ҵ����</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
     function check(form){
	   if(form.orNo.value==""){
	     alert("�����ұ�Ų���Ϊ��");
	   }else if(form.address.value=="") {
	     alert("������ַ����Ϊ��");
	   }else{
	     document.operationRoomformsad.submit();
	   }
	 }
	</script>
  </head>  
  <body>
    <form action="<%=request.getContextPath()%>/operatingRoomServlet?opertion=3" method="post" name="operationRoomformsad">
    <table class="simple textCss">
    	<tr><th align="center" colspan="2">��������Ϣ</th></tr>
    	<tr>
    		<th width="30%" align="right">�����ұ��:</th>
    		<td><input type="text" name="orNo" class="txt"></td>
    	</tr>
    	<tr>
  		   <th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
  		   <td>
	  		<select name="leixing">
		  		<option name="a" value="��������" selected>��������</option>
		  		<option name="b" value="��������" selected>��������</option> 
		  	 	<option name="c" value="С������" selected>С������</option>
 			</select>
	 	   </td>
		 </tr>
		 <tr>
		 	<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ַ:</th>
		 	<td><input type="text" name="address" class="txt"></td>
		 </tr>
		 <tr>
		 	<th width="30%" align="right">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ע:</th>
		 	<td><input type="text" name="info" class="txt"></td>
		 </tr>
		 <%--<tr>
		 	<th width="30%" align="right">��ʿ�б�&nbsp;:</th>
		 	<td><input type="text" name="nurseList" class="txt"></td>
		 </tr>
		 --%><tr>
		 	<th width="30%" align="right">�Ƿ����&nbsp;:</th>
			 <td>
			 	<input type="radio" name="r" value="1">��
			 	<input type="radio" name="r" value="0" checked="checked">��
			</td>
		 </tr>
		 <tr>
		 	<td colspan="2" align="center">
			 	<input type="button" value="�ύ" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;
			 	<input type="reset" value="����" class="buttonClass">
		 	</td>
		 </tr>
    </table>
  </form>
  </body>
</html>