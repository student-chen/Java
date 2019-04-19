<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ page isELIgnored="false"%>
      <table border="0" cellpadding="0" cellspacing="0" width="170" vliagn="top">    	
     <c:if test="${sessionScope.user_name==null}">
     	<tr>
          <td align="right"><font size="2" color="#FF0000">最近新书--></font></td>
        </tr>
        <tr>
          <td>
            <p align="center"><font size="2" color="#000080">用户登录</font></td>
        </tr>
        <tr align="center"><td ><font color="red" size="2"><html:errors/></font></td></tr>
        <html:form action="/userlogin.do" method="post">
        <tr>
          <td><font size="2" color="#000080">用户名：
          <html:text property="user_name" size="14"/></font></td>
        </tr>
        <tr>
          <td><font size="2" color="#000080">密&nbsp;&nbsp;码：
          <html:password property="user_password" size="14"/></font></td>
        </tr>
        <tr>
          <td><font size="2" color="#000080">验证码：
          <html:text property="certCode" size="4"/>
          <img src="<%=request.getContextPath()%>/makeCertPic.jsp"></font></td>
        </tr>
        <tr>
          <td align="center"><font size="2" color="#000080">
          &nbsp;<a href="<%=request.getContextPath()%>/user/adduser.jsp">新注册用户</a>&nbsp;
            　<input type="submit" value="登录"></font></td>
        </tr>    
        </html:form>
      </c:if>
      <c:if test="${sessionScope.user_name!=null}">
      	<tr>
          <td align="center"><font size="2" color="#000080">
          欢迎您!${sessionScope.user_name}</font></td>
        </tr>
        <tr>
          <td align="center"><font size="2" color="#000080">
          <a href="<%=request.getContextPath()%>/buy/viewBuyCar.jsp">查看购物车</a>&nbsp;&nbsp;
          <a href="<%=request.getContextPath()%>/buy/viewOrderForm.jsp">查看订单</a></font></td>
        </tr>
        <tr>
          <td align="center"><font size="2" color="#000080">
          <a href="user/adduser.jsp">新注册用户</a>&nbsp;
          <a href="<%=request.getContextPath()%>/exitlogin.do">退出登录</a></font></td>
        </tr>
      </c:if>
      </table>