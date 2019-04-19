<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<!------系统交互javascript----->
<script language="JavaScript">
<!--
function delete_confirm() {
//按删除链接时，弹出确认对话框
   if(confirm("确认要删除吗？")){
  		return true;
	}else return false;	
}
-->
</script>
<jsp:include page="../adminmoduleup.jsp"/>
<c:set var="pagePath" value="/admin/booktype/booktypeview.do"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="4">
		<font size="2" color="#000080">增加书藉类型</font>		
	</td></tr>
	<tr><td colspan="4">
		<font size="2" color="red"><html:errors/></font>
	</td></tr>
	<html:form action="${pagePath}" method="post" focus="booktypename">
	<tr><td colspan="6"><font size="2" color="#000080">
		类型名称：<html:text property="booktypename" size="40"/>
		<html:submit value="提交"/>
	</font></td></tr>
	</html:form>
	<tr><td colspan="4" align="right"><font size="2" color="#000080">
		<%@ include file="../common/page.txt"%>
	</td></tr>
	<tr><td align="center"><font size="2" color="#000080">ID号</font></td>
		<td align="center"><font size="2" color="#000080">类型名称</font></td>
		<td align="center"><font size="2" color="#000080">修改?</font></td>
		<td align="center"><font size="2" color="#000080">删除?</font></td>
	</tr>
	<c:forEach items="${CurrentPageArray}" var="bookType">
		<tr><td align="center"><font size="2" color="#000080">
			<c:out value="${bookType.bookTypeId}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:out value="${bookType.bookTypeName}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<html:link page="/admin/booktype/updatebooktype.jsp"
				paramId="booktypeid" paramName="bookType" paramProperty="bookTypeId">
			修改</html:link>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<html:link page="/admin/booktype/deleteBookTypeAction.do"
				paramId="booktypeid" paramName="bookType" paramProperty="bookTypeId" onclick="return delete_confirm()">
			删除</html:link>&nbsp;</font></td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="../adminmoduledown.jsp"/>