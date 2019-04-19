<%@ page contentType="text/html;charset=GB2312" %>
<table border="1" cellpadding="0" cellspacing="0" width="160">
  <tr><td>
	 <table border="0" cellpadding="0" cellspacing="0" width="160">
      	<tr>
          <td align="center">
            <font size="3" color="#000080">管理菜单&nbsp;&nbsp;&nbsp;&nbsp;</font>
          	<hr>
          </td>
        </tr>
        <tr>
          <td><u><font color="#000080" size="2">书藉分类管理</font></u>
          <li><font size="2" color="#000080">
            	<a href="<%=request.getContextPath()%>/admin/booktype/booktypeview.do">书藉分类维护</a>
          </font></li></td>
        </tr>
        <tr>
          <td  align="left">
            <u><font color="#000080" size="2">店中书藉管理</font></u>
            <li><font size="2" color="#000080">
            	<a href="<%=request.getContextPath()%>/admin/book/addbook.jsp">录入书籍资料</a>
            </font></li>
            <li><font size="2" color="#000080">
            	<a href="<%=request.getContextPath()%>/admin/book/dispBookInfo.do">修改书籍资料</a>
            </font></li>
            <li><font size="2" color="#000080">
            	<a href="<%=request.getContextPath()%>/admin/book/uploadPicDispBookInfo.do">上传书藉图片</a>
            </font></li>
          </td>
        </tr>
        <tr>
          <td><u><font size="2" color="#000080">订单管理</font></u>
          <li><font size="2" color="#000080">
            	<a href="<%=request.getContextPath()%>/admin/orderform/orderformview.do">订单处理</a>
          </font></li>
          </td>
        </tr>
        <tr>
          <td align="center">
            <p align="left"><font size="2" color="#000080">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            　</font></p>
          </td>
        </tr>
      </table>
    </td></tr>
</table>    