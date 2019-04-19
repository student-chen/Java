<%@ page language="java" contentType="text/html; charset=GBK"pageEncoding="GBK"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>    
<title>Insert title here</title>
    <script type="text/javascript">
		function loadTypeCordoba(){
		<%
			Object active=request.getAttribute("typeCordoba");
			if(active!=null){
				if("1".equals(active+"")){
		%>
				document.medListForms.neike.checked=true;
		<%}else{
		%>
				document.medListForms.waike.checked=true;
		<%}
		}
		%>
		}
	</script>
	<script type="text/javascript">
  		function onch(){
  			var page = document.medListForms.textPages.value;
  			if(page==null||page==0||page==""){
  				alert("������Ҫ��ѯ����Чҳ����");
  				return;
  			}
  			window.location.href ="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&page="+page;
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
  		function goto(obj) {
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
  		    window.location.href="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=2&doctorid="+e;
  	 }
	</script>
</head>
 <body onload="loadTypeCordoba();">   
	<form action="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4" method="post" name="medListForms">
	<table class="simple textCss">
	 <tr>
	 	<td width="15%" class="title" align="right">�Ʊ�����:</td>	
	 	<td width="40%" class="title"><input type="text" name="name" class="txt"></td>
    	<td width="20%" class="title"><input type="submit" value="��ѯ" class="buttonClass"></td>	
    	<td width="20%" class="title">
    	<input type="button" value="��ӿƱ�" onclick="javaScript:window.location.href='<%=request.getContextPath()%>/view_ludan/addMedicalcourses.jsp'" class="buttonClass"></td>
    </tr>
    <tr>
    	<td align="right" colspan="4">�Ʊ�����(1�ڿƣ�0���)��
	 		<input type="radio" value="�ڿ�" name="typeCordoba" id="neike" 
	 		 onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&type=1'">�ڿ�&nbsp;&nbsp;
	 		<input type="radio" value="���" name="typeCordoba" id="waike"
	 		 onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&type=0'">���&nbsp;&nbsp;
		</td>
    </tr>
    </table>
 <c:if test="${not empty medicalcoursesList}"> 
  <table  class="simple textCss" width="80%">
	<tr>
		<th width="15%" class="title" align="center">��ѡ��
         <input type="checkbox" name="selectedAll" onclick="go(this.form);"></th>
		<th width="25%" class="title" align="center">�Ʊ�����</th>
		<th width="35%" class="title" align="center">�Ʊ�����</th>
		<th width="35%" class="title" align="center">����</th> 
	</tr>
		<c:forEach items="${medicalcoursesList}" var="medicalcourses">
			<tr>
				<td align="center"><input type="checkbox" value="${medicalcourses.id}" name="c"></td>
				<td align="center">${medicalcourses.name}</td>
				<td align="center">				
					<c:if test="${medicalcourses.type==0}">���</c:if>
					<c:if test="${medicalcourses.type==1}">�ڿ�</c:if>
				</td>
				<td align="center">
				<input type="button" value="ɾ��" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=2&id=${medicalcourses.id}'">&nbsp;&nbsp;
				<input type="button" value="�޸�" class="patientButton" onclick="window.location.href='view_ludan/updateMedicalcourses.jsp?id=${medicalcourses.id}&name=${medicalcourses.name}&type=${medicalcourses.type}'">
			</td>
			</tr>
	   </c:forEach>
     <tr>
		<td colspan="4" align="center">
		    <input type="button" value="�������" onclick="javaScript:window.location.href='view_ludan/addMedicalcourses.jsp'" class="buttonClass">
		   				&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
		   <input type="button" value="����ɾ��" onclick="Delete();" class="buttonClass">
	    </td>
	</tr>
    </table>
    </c:if>    
	   <table class="simple textCss">
			<tr>
	   			<td align="right" width=100% colspan="5">��<font color="red">${page.pageNum}</font>���������&nbsp;&nbsp;&nbsp;����<font color="red">${page.lastPage}</font>ҳ
	   			&nbsp;&nbsp;&nbsp;��ǰ�ǵ�<font color="red">${page.pageSize}</font>ҳ&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&page=1&type=${page.currentType}'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&page=${page.priorPage}&type=${page.currentType}'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="��һҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&page=${page.nextPage}&type=${page.currentType}'">&nbsp;&nbsp;&nbsp;
	   			<input type="button" value="���ҳ" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4&page=${page.lastPage}&type=${page.currentType}'">&nbsp;&nbsp;&nbsp;
	   			������&nbsp;<input type=text name="textPages" value="1" size="7" onkeyup="this.value=this.value.replace(/\D/g,'')">
	   			ҳ&nbsp;&nbsp;&nbsp;<input type="button" value="GO" onclick="onch();" class="patientButton">&nbsp;&nbsp;&nbsp;</td>
	   		</tr>  
	   	</table>
    </form>
 </body>
</html>