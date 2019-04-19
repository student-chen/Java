<%@ page language="java"  pageEncoding="GBK"%>
<jsp:directive.page import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>  
    <title>My JSP 'addSickBed.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
     function check(form){
	   if(form.bedNo.value==""){
	     alert("������Ų���Ϊ��");
	   }else{
	     document.formSickBed.submit();
	   }
	 }
    </script>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/sickBedServlet?opertion=1" method="post" name="formSickBed" onsubmit="return check(formSickBed);">
         <table class="simple textCss">
          	<tr>
	            <th align="center" colspan="2">��Ӳ�����Ϣ</th>
            </tr>
          	<tr>
	            <th width="30%" align="right">������:</th>
	            <td><input type="text" name="bedNo" class="txt"></td>
            </tr>
            <tr>
	            <th width="30%" align="right">��&nbsp;&nbsp;&nbsp;��:</th>
	            <td>	            	
		            <input type="radio" name="type" value="һ�ȼ�">һ�ȼ�
		            <input type="radio" name="type" value="���ȼ�">���ȼ�
		            <input type="radio" name="type" value="���ȼ�">���ȼ�
		            <input type="radio" name="type" value="�ĵȼ�" checked="checked">�ĵȼ�
	            	<%--<input type="text" name="type" class="txt">--%>
	           </td>
            </tr>         
             <%  
            	String sql="select *from nurse";       
            	OperationRoomWuJiRuiService operatingRoomService=new OperationRoomWuJiRuiService();            	
		      	request.setAttribute("nurselistName",operatingRoomService.addoperationgetNurseListName(sql));
		     %>
            <tr>
            <th width="30%" align="right">��ʿ�б�:</th>
            <td>
                <select name="nurseNameList"  onclick="nurseName();" multiple="multiple" size="3">          
	               <c:forEach items="${nurselistName}" var="nurselist">
	                   <option value="${nurselist.id}">${nurselist.name}</option>
	               </c:forEach>
	            </select>
            </td>
            </tr> 
            <tr>
	            <th width="30%" align="right">�Ƿ����:</th>
	             <td>
	             	<input type="radio" name="isUseable" value="1">��
	             	<input type="radio" name="isUseable" value="0" checked="checked">��
	             </td>
            </tr>
            <tr>
	            <td colspan="2" align="center">
		            <input type="button" value="���"  class="buttonClass" onclick="check(this.form);">&nbsp;&nbsp;
		            <input type="reset" value="����" class="buttonClass">&nbsp;&nbsp;
		            <input type="button" value="����" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/sickBedServlet?opertion=4'">
	            </td>
            </tr>
       </table>
       </form>
  </body>
</html>