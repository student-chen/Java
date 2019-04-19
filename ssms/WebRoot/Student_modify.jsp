<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.Student" %>
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.ClassInfo" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //��ȡ���е�classInfo��Ϣ
    List<ClassInfo> classInfoList = (List<ClassInfo>)request.getAttribute("classInfoList");
    Student student = (Student)request.getAttribute("student");

    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>�޸�ѧ����Ϣ</TITLE>
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
    var studentNumber = document.getElementById("student.studentNumber").value;
    if(studentNumber=="") {
        alert('������ѧ��ѧ��!');
        return false;
    }
    var studentName = document.getElementById("student.studentName").value;
    if(studentName=="") {
        alert('������ѧ������!');
        return false;
    }
    var sex = document.getElementById("student.sex").value;
    if(sex=="") {
        alert('������ѧ���Ա�!');
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
    <TD align="left" vAlign=top ><s:form action="Student/Student_ModifyStudent.action" method="post" onsubmit="return checkForm();" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
  <tr>
    <td width=30%>ѧ��ѧ��:</td>
    <td width=70%><input id="student.studentNumber" name="student.studentNumber" type="text" value="<%=student.getStudentNumber() %>" readOnly /></td>
  </tr>

  <tr>
    <td width=30%>ѧ������:</td>
    <td width=70%><input id="student.studentName" name="student.studentName" type="text" size="20" value='<%=student.getStudentName() %>'/></td>
  </tr>

  <tr>
    <td width=30%>���ڰ༶:</td>
    <td width=70%>
      <select name="student.classInfo.classNumber">
      <%
        for(ClassInfo classInfo:classInfoList) {
          String selected = "";
          if(classInfo.getClassNumber().equals(student.getClassInfo().getClassNumber()))
            selected = "selected";
      %>
          <option value='<%=classInfo.getClassNumber() %>' <%=selected %>><%=classInfo.getClassName() %></option>
      <%
        }
      %>
    </td>
  </tr>

  <tr>
    <td width=30%>ѧ���Ա�:</td>
    <td width=70%><input id="student.sex" name="student.sex" type="text" size="2" value='<%=student.getSex() %>'/></td>
  </tr>

  <tr>
    <td width=30%>ѧ������:</td>
    <td width=70%><input type="text" readonly  id="student.birthday"  name="student.birthday" onclick="setDay(this);" value='<%=student.getBirthday() %>'/></td>
  </tr>

  <tr>
    <td width=30%>��ϵ�绰:</td>
    <td width=70%><input id="student.telphone" name="student.telphone" type="text" size="20" value='<%=student.getTelphone() %>'/></td>
  </tr>

  <tr>
    <td width=30%>��ͥסַ:</td>
    <td width=70%><input id="student.address" name="student.address" type="text" size="20" value='<%=student.getAddress() %>'/></td>
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
