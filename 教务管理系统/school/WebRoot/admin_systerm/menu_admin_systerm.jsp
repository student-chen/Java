 <%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�˵�</title>
<STYLE type=text/css>
BODY {
	 BACKGROUND: #cccccc; MARGIN: 0px; FONT: 9pt ����
}
  TABLE {
	 BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; 

BORDER-BOTTOM: 0px
}
  TD {
	 FONT: 12px ����
}
 IMG {
	 BORDER-RIGHT: 0px; BORDER-TOP: 0px; VERTICAL-ALIGN: bottom; 

BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
A {
	FONT: 12px ����; COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #428eff; TEXT-DECORATION: underline
}
.sec_menu {
	BORDER-RIGHT: white 1px solid; OVERFLOW: hidden; BORDER-LEFT: 

white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title {
	
}
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #215dc6; POSITION: relative; 

TOP: 2px
}
.menu_title2 {
	
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; 

TOP: 2px
}
.STYLE1 {color: #FFFFFF}
</STYLE>

<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>

<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<TR>
	<TD valign="top">
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD bgColor=blue height=25>&nbsp;<A href="http://www.i2030.org"
					target="mainFrame" class="STYLE1"><B>ϵͳ����Ա</B></A> | <A href="../ClogoutServlet" target="_parent" class="STYLE1"><B>�˳�</B></A></TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR>
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(1)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>��ѧ����Ա</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu1>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>��<A
								href="ShowServlet?action=show_admin_teach" target="mainFrame">
							��ʾ��ѧ����Ա </A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>�� <A
								href="add_admin.jsp"
								target=mainFrame>��ӽ�ѧ����Ա </A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>�� <A
								href="ModshowServlet?action=modshow_admin_teach"
								target=mainFrame>�޸Ľ�ѧ����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>�� <A
								href="DelshowServlet?action=delshow_admin_teach" target=mainFrame>ע����ѧ����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>�� <A href=""
								target=mainFrame class="STYLE1">����Ȩ��</A></TD>
						</TR>


					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(6)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><SPAN>ͼ�����Ա</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu6>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>�� <A
								href="ShowServlet?action=show_admin_book" target=mainFrame>��ʾͼ�����Ա

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>�� <A 
							href="add_admin.jsp"
								target=mainFrame>���ͼ�����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>�� <A href="ModshowServlet?action=modshow_admin_book"
								target=mainFrame>�޸�ͼ�����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>�� <A href="DelshowServlet?action=delshow_admin_book"
								target=mainFrame>ע��ͼ�����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>�� <A href="" target=mainFrame
								class="STYLE1">����Ȩ��</A></TD>
						</TR>

					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;

	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(3)
					onmouseout="this.className='menu_title';" bgColor=#fafbfe height=25><SPAN>BBS����Ա</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu3>
				<DIV class=sec_menu style="WIDTH: 158px">
				<Form method=post action="">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>�� <A
								href="ShowServlet?action=show_admin_bbs" target=mainFrame>��ʾBBS����Ա

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>�� <A href="add_admin.jsp"
								target=mainFrame>���BBS����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>�� <A href="ModshowServlet?action=modshow_admin_bbs"
								target=mainFrame>�޸�BBS����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>�� <A href="DelshowServlet?action=delshow_admin_bbs"
								target=mainFrame>ע��BBS����Ա</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>�� <A href="http://www.i2030.org"
								target=mainFrame class="STYLE1">����Ȩ��</A></TD>
						</TR>
					</TBODY>
				</TABLE>
				</form>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;&nbsp;

	 