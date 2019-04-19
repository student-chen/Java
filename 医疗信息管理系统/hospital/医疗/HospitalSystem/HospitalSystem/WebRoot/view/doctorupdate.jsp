<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService,
com.tsinghuait.st0717.hospitalsystem.service.PostService,com.tsinghuait.st0717.hospitalsystem.service.DoctorService
,java.util.*,com.tsinghuait.st0717.hospitalsystem.dto.Doctor" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>ҽ����Ϣ��</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
   <script>
   function toDate()
   {//����
	with(document.all)
	{
		var vYear=parseInt(year.options[year.selectedIndex].text);
		var vMonth=parseInt(month.options[month.selectedIndex].text);
		day.length=0;
		for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++)
		{
			day.options[day.length++].value=day.length;
			day.options[day.length-1].text=day.length;
		}
	}
	toDay();
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
		pageContext.setAttribute("doc",request.getParameter("docList"));
 %>
 <%
 	String id=request.getParameter("id");
 	System.out.println("updateJSP_id:"+id);
 	int ids=0;
 	if(id!=null){
 		ids=Integer.parseInt(id);
 	}
 	String sql2="select *from doctor where id="+ids+"";
 	DoctorService doctorService=new DoctorService();
 	ArrayList arr=(ArrayList)doctorService.selectDoctor(sql2);
 	Iterator it=arr.iterator();
  %>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/doctorServlet?opertion=3" method="post">
      <table class="table">
      <tr><th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">ҽ����Ϣ�޸�</th></tr>
      <%
 		while(it.hasNext()){
 			Doctor dto=(Doctor)it.next();
       %>
        <tr>
        	<th>ְ����:</th>
        	<td>
	        	<input type="hidden" name="id" value="<%=dto.getId() %>" class="text">
	        	<input type="text" name="staffNo"  value="<%=dto.getStaffNo()%>" >
	        </td>
        	<td></td>
        </tr>
        <tr>
	        <th>����:</th>
	        <td><input type="text" name="name"  value="<%=dto.getName()%>"></td>
	        <td></td>
        </tr>
        <tr>
	        <th>ְ��:</th>
	        <td><input type="text" name="post"  value="<%=dto.getPost() %>" ></td>
	        <td></td>
        </tr>
        <tr>
	        <th>�Ա�:</th>
	        <td><input type="text" name="sex"  value="<%=dto.getSex()%>"></td>
	        <td></td>
        </tr>
        <tr>
	        <th>��������:</th>
	        <td><input type="text" name="birthday" value="<%=dto.getBirthday() %>"></td>
		</tr>
        <tr>
        	<th>��ע:</th>
        	<td>
        		<textarea rows="4" cols="1" name="info"><%=dto.getInfo()%></textarea>
        	</td>
        	<td></td>
        </tr>
        <tr><th>�Ʊ�����:</th><td><input type="text" name="mcName"  value="<%=dto.getMcName() %>" ></td><td></td></tr>
         <tr><th>�Ƿ񼤻�:</th><td><input type="text" name="isActive" value="<%=dto.getIsActive() %>">
        		</td>	
        <td>��ע:1Ϊ����,0Ϊδ����</td></tr>
        <tr><td colspan="12" background="imgs/color/color_qianse.jpg"></td></tr>
        <tr><td colspan="3" align="center">
        	<input type="submit" value="ȷ��" class="buttonClass">
        	<input type="button" value="ȡ��" class="buttonClass"onclick="window.location.href='<%=request.getContextPath()%>/doctorServlet?opertion=4'">
        </td></tr>        
        <%} %>
      </table>
    </form>
   </body>
</html>
