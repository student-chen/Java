<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	User user = (User)session.getAttribute(Constants.LOGIN_USER_INFO_KEY);
%>
<HTML><HEAD><TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><LINK 
href="images/style.css" type="text/css" rel=stylesheet>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<div align="center">
  <center>
<TABLE cellSpacing=0 cellPadding=0 width=763 bgColor=#336699 
border=0 height="27" style="border-collapse: collapse" bordercolor="#111111">
  <TBODY>
  <TR>
    <TD height="27">
      ��</TD></TR>
  </TBODY></TABLE>
  </center>
</div>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD width="85%">
      <FORM name=BasketForm action="addrConfirm.do" 
      method=post>
      <INPUT type=hidden value=2 name=txtOrigQty> <INPUT 
                        type=hidden value=��ɫ�ڰ�ɫ֮�� name=prdname> 
      <TABLE cellSpacing=0 cellPadding=8 width="100%" align=center 
        border=0><INPUT type=hidden name=OP> 
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD>
                <IMG src="images/book_046.gif" width="122" height="84"></TD>
                <TD align=middle width=400 
                background=images/book_004.gif>
                <IMG 
                  src="H:\Struts����\bookstore\images\spacer(1).gif" width="1" height="1"> </TD>
                <TD>
                <IMG src="images/book_003.gif" width="142" height="97"> 
            </TD></TR></TBODY></TABLE></TD></TR>
        <tr>
          <TD align=right width="90%">
            <TABLE cellSpacing=0 cellPadding=0 width="612" align=right 
border=0 height="92">
              <TBODY>
              <TR>
                <TD align=left colSpan=2 height=20 width="612"><FONT class=large 
                  color=#0d7999>����ע����Ϣ:</FONT></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>������&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getName()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>��ϵ��ַ��&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getAddress()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>�绰��&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getTel()%></TD>
                </TR></TBODY></TABLE></TD>
        </tr>
        <TR>
          <TD>
			  <table cellSpacing="0" cellPadding="0" width="612" align="right" border="0" height="92">
              <tr>
                <td align="left" height="20" width="206">
                <font class="large" color="#0d7999">�����ͻ���ʽ:</font></td>
                <td align="left" height="20" width="1018">��</td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="�ͻ�����" name="deliv" checked>�ͻ�����</font><b>��&nbsp;</b></td>
                <td class="p9" width="912" height="18"> 
					<font class="small">�Ļ�·����(�������졢�����ۡ���ͨԷ����ׯ���ߵء���ׯ��ʯ��ɽ���ֵ���)���Ļ�·���ڼӼ�����(�Ӽ���绰ȷ��62269575)��ÿ�ݶ�����<font color="red">10Ԫ</font>�ͻ��ѡ�</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small"><input type="radio" value="��ݰ���" name="deliv" >��ݰ���</font></td>
                <td class="p9" width="912" height="18"> 
					<font class="small">��ݷ�Ϊͼ��ԭ�۵�<font color=red>20%</font>������<font color=red>20Ԫ</font>��<font color=red>20Ԫ</font>���㡣</font>
                </td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small"><input type="radio" value="��½�Һ��ʼ�" name="deliv" >��½�Һ��ʼ�</font>
                </td>
                <td class="p9" width="912" height="18"> 
					<font class="small">�ʷ�Ϊͼ��ԭ�۵�<font color=red>8%</font>������<font color=red>5Ԫ</font>��<font color=red>5Ԫ</font>���㡣(<font color="red">���ﳬ��200Ԫ,�ʷ�8��</font>)</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="EMS�ؿ�ר��" name="deliv" >EMS�ؿ�ר��</font>
                </td>
                <td class="p9" width="912" height="18"> 
					<font class="small">��ÿ����ѡ��ͼ��ԭ�۵�<FONT color=red>75%</FONT>��ȡEMS�ؿ�ר�ݵķ��ã�����25.00Ԫ��
<FONT color=red>25.00</FONT>Ԫ�ơ�</font></td>
              </tr>
            </table>
            <p>��</TD></TR>
        <TR>
          <TD>
            <table cellSpacing="0" cellPadding="0" width="612" align="right" border="0" height="92">
              <tr>
                <td align="left" height="20" width="206">
                <font class="large" color="#0d7999">���ĸ��ʽ:</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="�ֽ�֧��" name="payment" checked ></font>�ֽ�֧��<b>��&nbsp;</b></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="�ʼ�" name="payment" ></font>�ʼ�</td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="���п�" name="payment" ></font>���п� 
                </td>
              </tr>
            </table>
            <p>��</TD></TR>
        <TR>
          <TD>
            <p align="center">
            <input type="image" src="images/book_038.gif" width="76" height="30"></TD></TR></TBODY></TABLE></FORM></TD></TR></TBODY></TABLE></TD></TR></TABLE></TD></TR></TABLE><BR>
<TABLE width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <HR width="90%" SIZE=1>
    </TD></TR>
  <TR>
    <TD height=20>
      </TD></TR>
  </TBODY></TABLE></BODY></HTML>