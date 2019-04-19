<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	Vector catList = (Vector)session.getAttribute(Constants.BOOK_CAT_LIST_KEY);
	Vector bookList = (Vector)session.getAttribute(Constants.BOOK_LIST_KEY);
	Book book = null;
	BookCat bookCat = null;
	
	SearchStatus schSta = (SearchStatus)session.getAttribute(Constants.BOOK_SEARCH_STATUS_KEY);
%>

<HTML>
<HEAD><TITLE>�鼮��ѯ</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="images/new.css" type="text/css" rel=stylesheet>
</HEAD>
<BODY bgcolor="#7387B8"> 
<div align="center">
  <img border="0" src="images/ruanjian.jpg" width="770" height="154" ></div>	
<TABLE cellSpacing=0 cellPadding=0 width="788" border=0>
  <TR vAlign=top bgColor=#cbd7f3>
    <TD align=middle width=170 bgColor=#7387B8>
      <br><br>
      <TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
       <TR> <TD bgcolor="#FFFFFF">
       
    <%if(catList != null ){

       for(int i = 0;i < catList.size();i++)
       {  
       		bookCat = (BookCat)catList.get(i);
       %>
       
       <a href="bookSearch.do?bookCatId=<%=bookCat.getId()%>&mode=1"><font color="#000000"><%=bookCat.getName()%></font></a><br>       
          <%
         }
      }
      %>
       
         
</TD> </TR>
	  </TABLE>
	</TD>
    <TD bgColor=#7387B8>
	<br>
	 <TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0 bgColor=#ffffff>
      <TR><TD>
		  <FORM action="bookSearch.do" method=post>
		  <DIV align=center><font size=2>������ؼ��֣�<font>
		  <INPUT type=hidden name=mode value="2"> 
		  <INPUT class=button2 size=12 name=key> 
		  	<SELECT class=button1 name=field> 
		  		<OPTION value=1 selected>����</OPTION> 
		  		<OPTION 	value=2>����</OPTION> </SELECT> 
		  <INPUT type=submit value=���� name=Submit> 
		<BR><BR></DIV></FORM>
	  </TD></TR>
	  <TR><TD width="50%" height=20>&nbsp;&nbsp;�γ���Ϣ��Ŀ¼��</TD></TR>
	  <TR><TD align=right width="48%" height=10>���鵽 <%=schSta.getBookCount()%>����¼����ʾ��<%=schSta.getPageId()+1%>ҳ/��<%=schSta.getPageCount()%>ҳ</TD></TR>
	  <TR><TD>
	  <table class="txt" cellSpacing="1" cellPadding="1" width="515" align="center" bgColor="#005b4b" border="0">
        <tr bgColor="#bad4a5">
          <td vAlign="top" width="197" bgcolor="#0099CC" align="center"><b>
          <font color="#FFFFFF">����</font></b></td>
          <td vAlign="top" width="39" bgcolor="#0099CC" align="center"><b>
          <font color="#FFFFFF">����</font></b></td>
          <td vAlign="top" width="41" bgcolor="#0099CC" align="center"><b>
          <font color="#FFFFFF">��Ա��</font></b></td>
          <td vAlign="top" width="112" bgcolor="#0099CC" align="center"><b>
          <font color="#FFFFFF">����</font></b></td>
          <td vAlign="top" width="42" bgcolor="#0099CC" align="center"><b>
          <font color="#FFFFFF">��ϸ</font></b></td>
        </tr>
        


	   <%if(bookList != null ){

       for(int i = 0;i < bookList.size();i++)
       {  
       		book = (Book)bookList.get(i);
      %>

		<tr bgColor="#ffffff">
          <td width="197" bgColor="#ffffff"><%=book.getName()%></td>
          <td width="39" bgColor="#ffffff">��<%=book.getPrice()%></td>
          <td width="41" bgColor="#ffffff">��<%=book.getSalePrice()%></td>
          <td width="112"><%=book.getAuthor()%></td>
          <td vAlign="center" width="42">
          <a href="bookDetail.do?bookId=<%=book.getId()%>">
          <img src="images/view.gif" border="0" width="25" height="25"></a></td>
      <%
         }	%>
      
         
          
        </tr> 
		<%}
      %>
      </table>
      <p>��<TR height=24>
			<TD align=right>| <font color="#999999">
            <a href="bookPage.do?pageId=<%=0%>">��ҳ</a></font> | <font color="#999999">
            <a href="bookPage.do?pageId=<%=schSta.getPageId()-1%>">��ҳ</a></font> | <a href="bookPage.do?pageId=<%=schSta.getPageId()+1%>">��ҳ</a> </TD>
		</TR>
		<br></TD></TR>
	 </TABLE>                              
	 <br>
    </TD>
  </TR>
</TABLE>
</body>
</html>