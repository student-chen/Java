<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>ҽ����Ϣ��</title>
     <script type="text/javascript">
  		function onch(obj)
  		{
  			var page = obj.value;
  			window.location.href ="view/nurseServlet?page="+page;
  		}
  		function goon(obj)
  		{
  		     var to=obj.value;
  		     window.location.href="view/nurseinsert.jsp";
  		}
  	</script>  	
	<script type="text/javascript">
  		function onch(){
  			var page = document.nurseListForms.textPages.value;
  			if(page==null||page==0||page==""){
  				alert("������Ҫ��ѯ����Чҳ����");
  				return;
  			}
  			window.location.href ="<%=request.getContextPath()%>/nurseServlet?opertion=4&page="+page;
  		}
	</script>
	<script type="text/javascript">
	function go(form){
  		  if(form.selectedAll.checked) {
	  		   for(var i=0;i<form.elements.length;i++){
	  		        var e=form.elements[i];
	  		        if(e.type=="checkbox") {
	  		          e.checked=true;
	  		        }
	  		     }
	  		   } 
  		  else if(!form.selectedAll.checked){
	  		    for(var i=0;i<form.elements.length;i++){
	  		        var e=form.elements[i];
	  		        if(e.type=="checkbox"){
	  		          e.checked=false;
	  		        }
	  		     }
  		  }
  	  }
  		function goto(obj) 
  		{
      	document.forms[1].submit();
      }      
      function Delete(){
  		    var e="";
  		    if(document.all.c.length){
  		    var emp=document.all.c.length;
  		    for(var i=0;i<emp;i++){
  		       if(document.all.c[i].checked){
  		        e+=document.all.c[i].value+";";
  		       }
  		    }
  		  } else{
  		     e+=document.all.c.value+";"
  		    }
  		    e=e.substring(0,e.length-1)
  		    window.location.href="<%=request.getContextPath()%>/nurseServlet?opertion=2&nurseid="+e;
  	 }
	</script>
   ${alertMsg} 
   </head>
  <body> 
 <form action="<%=request.getContextPath()%>/nurseServlet?opertion=4" method="post" name="nurseListForms">    
	 <table class="simple textCss">
	 	<tr>
	 		<td width="25%" align="center" class="title">�����Ͳ�ѯ:</td>
	 		<td width="20%" align="center" class="title">
	 			<select name="Scount">
	 				<option value="staffNo">ְ����</option>		
	 				<option value="name" selected="selected">����</option>		
	 				<option value="post">ְ��</option>				
	 			</select>
	 		</td>
	 		<td width="40%" class="title">
		    	<input type="text" name="name" class="txt">
	 		</td>
	 		<td width="20%" class="title">
		    	<input type="submit" value="��ѯ" class="buttonClass">
	 		</td>
	 	</tr>
	 </table>
      <table class="simple textCss">
      <tr><th colspan="8" align="center">��ʿ��Ϣ��</th></tr>
      <tr><%--
        <td width="15%" align="center" class="title">ѡ��
         <input type="checkbox" name="selectedAll" onclick="go(this.form);">(ȫѡ)</td>
        --%><td width="10%" align="center" class="title">ְ����</td>
        <td width="10%" align="center" class="title">����</td>
        <td width="8%" align="center" class="title">�Ա�</td> 
        <td width="17%" align="center" class="title">ְ��</td>
        <td width="15%" align="center" class="title">��¼��</td>
        <td width="25%" align="center" class="title">����</td>
      </tr><tr>
	         <td colspan="11" background="IMAGES/color/color_qianse.jpg"></td>
	  </tr>
     <c:forEach items="${nurseservice}" var="nurse">
     <tr><%--
    		        <td align="center"><input type="checkbox" value="${nurse.id}" name="c"></td>
	    			--%><td align="center">${nurse.staffNo}</td>
	    			<td align="center">${nurse.name}</td>
	    			<td align="center">${nurse.sex}</td>
	    		    <td align="center">${nurse.post}</td>
	    			<td align="center">${nurse.loginName}</td>
	    		    <td align="center">
	    		    	<input type="button" value="ɾ��" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=2&id=${nurse.id}'">&nbsp;&nbsp;
					    &nbsp;&nbsp;<input type="button" value="�޸�" class="patientButton" onclick="window.location.href='view/nurseupdate.jsp?&id=${nurse.id}'">
	              </td>
	  </tr>
	    </c:forEach>
	 </table>
	   <table class="simple textCss">
			<tr>
	   			<td align="right" width=100% colspan="5">��<font color="red">${page.pageNum}</font>���������&nbsp;&nbsp;&nbsp;����<font color="red">${page.lastPage}</font>ҳ
	   			&nbsp;&nbsp;&nbsp;��ǰ�ǵ�<font color="red">${page.pageSize}</font>ҳ&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=4&page=1'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=4&page=${page.priorPage}'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=4&page=${page.nextPage}'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="���ҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=4&page=${page.lastPage}'">&nbsp;&nbsp;&nbsp;
	   			������&nbsp;<input type=text name="textPages" value="1" size="7" onkeyup="this.value=this.value.replace(/\D/g,'')">
	   			ҳ&nbsp;&nbsp;&nbsp;<input type="button" value="GO" onclick="onch();" class="patientButton">&nbsp;&nbsp;&nbsp;</td>
	   		</tr>  
	   	</table>
	   	<table>
	   		<tr>
	   			<td align="center">
	        		<input type="button" value="���" onclick="goon(this)" class="buttonClass">
	        		<input type="hidden" name="hd" value="${nurse.postid}">
	        		<input type="hidden" name="hd" value="${nurse.postid}">&nbsp;&nbsp;&nbsp;&nbsp;
	        		<%--<input type="button" value="����ɾ��" onclick="Delete()" class="buttonClass">
	   			--%></td>
	   		</tr>
	   	</table>
     </form>
   </body>
</html>     