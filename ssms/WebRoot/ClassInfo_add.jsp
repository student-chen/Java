<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.Colleage" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //��ȡ���е�collleage��Ϣ
    List<Colleage> colleageList = (List<Colleage>)request.getAttribute("colleageList");
    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>��Ӱ༶��Ϣ</TITLE> 
<STYLE type=text/css>
BODY {
    	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
.label {font-style.:italic; }
.errorLabel {font-style.:italic;  color:red; }
.errorMessage {font-weight:bold; color:red; }
</STYLE>
 <script src="<%=basePath %>calendar.js"></script>
<script language="javascript">
/*��֤��*/
function checkForm() {
    var classNumber = document.getElementById("classInfo.classNumber").value;
    if(classNumber=="") {
        alert('������༶���!');
        return false;
    }
    var className = document.getElementById("classInfo.className").value;
    if(className=="") {
        alert('������༶����!');
        return false;
    }
    var banzhuren = document.getElementById("classInfo.banzhuren").value;
    if(banzhuren=="") {
        alert('�����������!');
        return false;
    }
    return true; 
}
 </script>
</HEAD>

<BODY>
<s:fielderror cssStyle="color:red" />
<TABLE align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top >
    <s:form action="ClassInfo/ClassInfo_AddClassInfo.action" method="post" id="classInfoAddForm" onsubmit="return checkForm();" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">

  <tr>
    <td width=30%>�༶���:</td>
    <td width=70%><input id="classInfo.classNumber" name="classInfo.classNumber" type="text" /></td>
  </tr>

  <tr>
    <td width=30%>�༶����:</td>
    <td width=70%><input id="classInfo.className" name="classInfo.className" type="text" size="20" /></td>
  </tr>

  <tr>
    <td width=30%>��ѧ���:</td>
    <td width=70%><input id="classInfo.startYear" name="classInfo.startYear" type="text" size="8" /></td>
  </tr>

  <tr>
    <td width=30%>������:</td>
    <td width=70%><input id="classInfo.banzhuren" name="classInfo.banzhuren" type="text" size="20" /></td>
  </tr>

  <tr>
    <td width=30%>����ѧԺ:</td>
    <td width=70%>
      <select name="classInfo.collleage.colleageId">
      <%
        for(Colleage colleage:colleageList) {
      %>
          <option value='<%=colleage.getColleageId() %>'><%=colleage.getColleageName() %></option>
      <%
        }
      %>
    </td>
  </tr>

  <tr bgcolor='#FFFFFF'>
      <td colspan="4" align="center">
        <input type='submit' name='button' value='����' >
        &nbsp;&nbsp;
        <input type="reset" value='��д' />
      </td>
    </tr>

</table>
</s:form>
   </TD></TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>
