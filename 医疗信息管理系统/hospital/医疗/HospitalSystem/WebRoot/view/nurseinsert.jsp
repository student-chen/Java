<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.NurseService,
	com.tsinghuait.st0717.hospitalsystem.service.PostService" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>��ʿ��Ϣ��</title>
   <script>
  function on(obj)
  		{
  		     var to=obj.value;
  		     window.location.href="nurseServlet?opertion=1";
  		}
  		
   function check(form)
  {
   if(form.staffNo.value=="")
   {
     alert("ְ���Ų���Ϊ��");
   }
   else if(form.name.value=="")
   {
     alert("��������Ϊ��");
   }
  else if(form.loginName.value=="")
   {
     alert("��¼������Ϊ��");
   }
   else
   {
     document.f1.submit();
   }
 }
</script>
<%
		String sql="select * from post";
		PostService ps=new PostService();
		request.setAttribute("postlistSelected",ps.selectRowsPost(sql));
 %>
  <%
		String sql2="select * from nurse";
		NurseService ns=new NurseService();
		request.setAttribute("loginPasswordSelected", ns.selectNurse(sql2));
 %>
</head>

  <body>
  <form action="<%=request.getContextPath()%>/nurseServlet?opertion=1" method="post" name="f1">
    <div>
      <center>
      <table  class="simple textCss">
      <tr>
      <th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">��ʿ��Ϣע��</th>
      </tr>
        <tr>
        	<th width="20%" align="center">ְ����:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^0-9\A-Z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^0-9\A-Z]/g,''))" class="txt" name="staffNo"></td><%--ֻ���������ֺʹ�д��ĸ--%>
        	<td width="40%" align="left">��ע��ְ����Ϊ��ʿ�����ı�־ ��:HD[1076]</td>
        	<td></td>
       </tr>
        <tr>
        	<th width="20%" align="center">����:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="name"></td><%--�����»���,������ĸ�ͺ���
        --%></tr>
        <tr>
        	<th width="20%" align="center">�Ա�:</th>
        	<td width="40%"><input type="radio" name="sex" value="��" checked="checked">
               <img src="<%=request.getContextPath()%>/imgs/sex/boy.GIF">&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="sex" value="Ů">
               <img src="<%=request.getContextPath()%>/imgs/sex/girl.GIF"></td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="center">ְ��:</th>
        	<td width="40%">
        	<select name="post">
                     <c:forEach items="${postlistSelected}" var="ps">
                         <option value="${ps.id},${ps.name}">${ps.name}</option>
                      </c:forEach>         
                 </select>
             </td>
             <td>��ע����ѡ��û�ʿ����Ӧְ��</td>
        </tr>
        <tr>
        	<th width="20%" align="center">��¼��:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="loginName"></td><%--�����»���,������ĸ�ͺ���
        --%></tr>
        <tr>
        	<th width="20%" align="center">��¼����:</th>
        	<td width="40%">
        		<input type="text" name="loginPassword" value="123"disabled="disabled" class="txt">	
        	</td><td>ע:��¼�����޸�����..</td>
       </tr>
        <tr>
        	<th width="20%" align="center">�Ƿ񼤻�:</th>
        	<td width="40%"><input type="radio" name="isActive" value="1" checked>��
        		<input type="radio" name="isActive" value="0">��</td>
       </tr>
        <tr>
        	<td colspan="12" background="imgs/color/color_qianse.jpg"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">
        	<input type="button" value="�ύ" class="buttonClass" onclick="check(this.form)">
        	<input type="reset" value="ȡ��" class="buttonClass">
        	</td>
       </tr>
      </table>
      </center>
      </div>
    </form>
   </body>
</html>
