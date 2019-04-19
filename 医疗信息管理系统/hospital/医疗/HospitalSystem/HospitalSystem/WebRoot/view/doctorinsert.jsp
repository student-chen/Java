<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService,
com.tsinghuait.st0717.hospitalsystem.service.PostService" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>ҽ����Ϣ��</title>
   <script>
   function toDate(){						//����
		with(document.all){
			var vYear=parseInt(year.options[year.selectedIndex].text);
			var vMonth=parseInt(month.options[month.selectedIndex].text);
			day.length=0;
			for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
				day.options[day.length++].value=day.length;
				day.options[day.length-1].text=day.length;
			}
		}
   }
     function check(form){
	   if(form.staffNo.value==""){
	     alert("ְ���Ų���Ϊ��");
	   }
	   else if(form.name.value=="") {
	     alert("��������Ϊ��");
	   }
	   else if(form.info.value=="") {
	     alert("��ע����Ϊ��");
	   }
	    else if(form.loginName.value==""){
	     alert("��¼������Ϊ��");
	   }
	   else{
	     document.f.submit();
	   }
	 }
</script>
<%
		String sql1="select * from medicalcourses";
		MedicalcoursesService medicalcoursesService=new MedicalcoursesService();
		request.setAttribute("medicalcoursesSelected", medicalcoursesService.selectRowsMedicalcourses(sql1));
 %>
 <%
		String sql="select * from post";
		PostService ps=new PostService();
		request.setAttribute("postlistSelected", ps.selectRowsPost(sql));
 %>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/doctorServlet?opertion=1" method="post" name="f">
    <table class="simple textCss">
      <tr>
      <th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">ҽ����Ϣע��</th>
      </tr>
        <tr>
        	<th width="20%" align="right">ְ����:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^0-9\A-Z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^0-9\A-Z]/g,''))" class="txt" name="staffNo"></td><%--ֻ���������ֺʹ�д��ĸ--%>
        	<td width="40%" align="left">��ע��ְ����Ϊҽ�������ı�־ ��:HD[1076]</td>
        	<td></td>
       </tr>
        <tr>
        	<th width="20%" align="right">����:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="name"></td>
        	<%--������ĸ�ͺ���--%>
        	</tr>
        <tr>
        	<th width="20%" align="right">ְ��:</th>
        	<td width="40%">
        		<select name="post">
                     <c:forEach items="${postlistSelected}" var="ps">
                         <option value="${ps.id},${ps.name}">${ps.name}</option>
                      </c:forEach>         
                 </select>
             </td>
             <td>��ע����ѡ���ҽ������Ӧְ��</td>
        </tr>
        <tr>
        	<th width="20%" align="right">�Ա�:</th>
        	<td width="40%"><input type="radio" name="sex" value="��" checked="checked">
               	<img src="<%=request.getContextPath()%>/imgs/sex/boy.GIF">&nbsp;&nbsp;&nbsp;
               <input type="radio" name="sex" value="Ů">
               <img src="<%=request.getContextPath()%>/imgs/sex/girl.GIF">
            </td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="right">��������:</th>
			  <td width="40%">
			        <select name="checkbox1" id="year" onchange="toDate()">
						 <script type="text/javascript">
							var today=new Date();
							for(var i=1975;i<=today.getYear();i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>��
					<select name="checkbox2" id="month" onchange="toDate()">
						 <script type="text/javascript">
							for(var i=1;i<=12;i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>��
					<select name="checkbox3" id="day" >
						 <script type="text/javascript">
							for(var i=1;i<=31;i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>��
			</td>
		</tr>
        <tr>
        	<th width="20%" align="right">��ע:</th>
        	<td width="40%"><input type="text" name="info"class="txt"></td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="right">�Ʊ�����:</th>
        	<td width="40%">
        		<select name="mcName">
                   <c:forEach items="${medicalcoursesSelected}" var="mc">
                       <option value="${mc.name}">${mc.name}</option>
                   </c:forEach>
               	</select>
            </td><td>��ע����ѡ���ҽ���Ĺ�������</td>
        </tr>
        <tr>
        	<th width="20%" align="right">��¼��:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="loginName"></td>
        	<%--������ĸ�ͺ���--%>
        <tr>
        	<th width="20%" align="right">��¼����:</th>
        	<td width="40%"><input type="text" name="loginPassword" value="123" disabled="disabled" class="txt"></td>
        	<td width="40%" align="left">��ע����¼�����޸���������</td>
        </tr>
        <tr>
        	<th width="20%" align="right">�Ƿ񼤻�:</th>
        	<td width="40%"><input type="radio" name="isActive" value="1" checked="checked">��
        		<input type="radio" name="isActive" value="0">��
        	</td>	
        </tr>
        <tr>
        	<td colspan="12" background="imgs/color/color_qianse.jpg"></td>
       	</tr>
        <tr>
        	<td colspan="12" align="center">
        	<input type="button" value="�ύ" class="buttonClass" onclick="check(this.form);">
        	<input type="reset" value="ȡ��" class="buttonClass">
        	</td>
       </tr>
      </table>
    </form>
   </body>
</html>