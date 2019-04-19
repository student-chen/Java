<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.Score" %>
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.Student" %>
<%@ page import="com.MadeBy_shuangyulin_QQ287307421.domain.Term" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //获取所有的student信息
    List<Student> studentList = (List<Student>)request.getAttribute("studentList");
    //获取所有的term信息
    List<Term> termList = (List<Term>)request.getAttribute("termList");
    Score score = (Score)request.getAttribute("score");

    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>修改成绩信息</TITLE>
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
/*验证表单*/
function checkForm() {
    return true; 
}
 </script>
</HEAD>
<BODY>
<s:fielderror cssStyle="color:red" />
<TABLE align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top ><s:form action="Score/Score_ModifyScore.action" method="post" onsubmit="return checkForm();" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
  <tr>
    <td width=30%>成绩编号:</td>
    <td width=70%><input id="score.scoreId" name="score.scoreId" type="text" value="<%=score.getScoreId() %>" readOnly /></td>
  </tr>

  <tr>
    <td width=30%>学生对象:</td>
    <td width=70%>
      <select name="score.student.studentNumber">
      <%
        for(Student student:studentList) {
          String selected = "";
          if(student.getStudentNumber().equals(score.getStudent().getStudentNumber()))
            selected = "selected";
      %>
          <option value='<%=student.getStudentNumber() %>' <%=selected %>><%=student.getStudentName() %></option>
      <%
        }
      %>
    </td>
  </tr>

  <tr>
    <td width=30%>学期信息:</td>
    <td width=70%>
      <select name="score.term.termId">
      <%
        for(Term term:termList) {
          String selected = "";
          if(term.getTermId() == score.getTerm().getTermId())
            selected = "selected";
      %>
          <option value='<%=term.getTermId() %>' <%=selected %>><%=term.getTermName() %></option>
      <%
        }
      %>
    </td>
  </tr>

  <tr>
    <td width=30%>成绩得分:</td>
    <td width=70%><input id="score.score" name="score.score" type="text" size="8" value='<%=score.getScore() %>'/></td>
  </tr>

  <tr bgcolor='#FFFFFF'>
      <td colspan="4" align="center">
        <input type='submit' name='button' value='保存' >
        &nbsp;&nbsp;
        <input type="reset" value='重写' />
      </td>
    </tr>

</table>
</s:form>
   </TD></TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>
