<%@ page contentType="text/html; charset=gb2312"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">
		
		<style type="text/css">
			A:link{color: #000000; TEXT-DECORATION: none;}
			A:visited {COLOR: #000000; TEXT-DECORATION: none;}
			A:active {COLOR: #3333ff; TEXT-DECORATION: none;}
			A:hover {COLOR: #ff0000;text-decoration: underline;}
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-image: url(${pageContext.request.contextPath}/imgs/bg.jpg);
			}
			</style>
			 <script language="javascript">
			    window.setTimeout('window.location.reload()',300000)
			    function logout(){
			    if(self!=top){top.location='${pageContext.request.contextPath}/logout.jsp'}
			    }
			    function init(){
			    if(self!=top){top.location='${pageContext.request.contextPath}/login.jsp'}
			    }
	</script>
	</head>
	<body topmargin="3" leftmargin="2" rightMargin="0" class="panel"
		marginwidth="0" marginheight="0" onselectstart="return false">
		<div id="navi">
			<table class="small" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td nowrap><img src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif" width="16" height="18" class="outline" id="MEMU_11" style="cursor:hand" title="չ��/����"></td>
					<td nowrap><img src="${pageContext.request.contextPath}/imgs/menu/marketing.gif" border="0" WIDTH="16" HEIGHT="16" align="absmiddle"></td>
					<td colspan="2">
						<a class="title" href="#" onclick="MEMU_11.click();return false;">&nbsp;��������</a>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table class="small" border="0" cellspacing="0" cellpadding="0" id="MEMU_11d" style="display:none ">
							<tr>
								<td>
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
											</td>
											<td>
												<img src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif" border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/world_time.gif" border="0">
											</td>
											<td colspan="2">
												<a class="title"
													href="${pageContext.request.contextPath}/view/updatenursepasssword.jsp"
													target="main">&nbsp;�޸�����</a>
											</td>
										</tr>
									</table>									
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="small" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif"
							width="16" height="18" class="outline" id="MEMU_55"
							style="cursor:hand">
					</td>
					<td>
						<img src="${pageContext.request.contextPath}/imgs/menu/addresslist.gif"
							border="0" WIDTH="16" HEIGHT="16" align="absmiddle" alt="����ͨѶ¼����">
					</td>
					<td colspan="2">
						<a class="title" href="as" onclick="MEMU_55.click();return false;">&nbsp;�ҵĹ���</a>
					</td>
				</tr>
			</table>
			<table class="small" border="0" cellspacing="0" cellpadding="0"
				id="MEMU_55d" style="display:none">
				<tr>
					<td>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/@bease.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title" href="topQueryServlet?opertion=0&type=0"
										target="main">&nbsp;���˹Һ�</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif" border="0">
								</td>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/@my2.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/patientListServlet?opertion=4&num=1"
										target="main">&nbsp;����ά��</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif"></td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif" border="0">
								</td>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/my.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/view_zhouxiaoli/nurse_sickbed.jsp"
										target="main">&nbsp;�ҵĲ���</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif" border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/ip_search.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/view_zhouxiaoli/nurse_operationRoom.jsp"
										target="main">&nbsp;�ҵ�������</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif"
										border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/ip_search.gif"
										border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/operatingRoomServlet?opertion=4"
										target="main">&nbsp;�����Ҳ鿴</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif" border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/pay.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/view_wujirui/addOprationRoom.jsp"
										target="main">&nbsp;���������</a>
								</td>
							</tr>
						</table>
						<table class="small" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif" border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/payment.gif" border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/ReceiptServlet?operation=0"
										target="main">&nbsp;�տ</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>
	<script language="JavaScript">
var menu_flag=0;
var openedid;
var openedid_ft;
var flag=0,sflag=0;

var previousid="";
var previousobj=0;
//-------- �˵�����¼� -------
function clickHandler(){
	    var targetid,srcelement,targetelement;
        var strbuf;
        srcelement=window.event.srcElement;
        //-------- ��������չ����������ť---------
        if(srcelement.className=="outline")     {
                targetid=srcelement.id+"d";
                targetelement=document.all(targetid);
                if (targetelement.style.display=="none")    // �ж��Ƿ�����   
                { // --------- ��ʾ
                       // --- ����ǰһ�ε����ʾ�ĸ�
					   if(previousobj!=0)                                        // ��ʼ�ж�,��ֹ����
					   {
                         if(!(srcelement.id.indexOf(previousobj.id)>-1))         // �жϵ�ǰ������Ƿ�����һ������
					     {
                            targetid2 = previousobj.id+"d";
						    targetelement2 = document.all(targetid2);
						    targetelement2.style.display="none";                 // ����
						    strbuf=previousobj.src;                              // ͼ��·��
                            if(strbuf.indexOf("imgs/minus.gif")>-1)                   // �ж�ͼƬ״̬��״̬��ת
                                  previousobj.src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif";
                            else
                                  previousobj.src="${pageContext.request.contextPath}/imgs/menu/tree_plusl.gif";
					      }
                        }
                        // --- ��ʾ��ǰ�����
                        targetelement.style.display='';
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("imgs/plus.gif")>-1)
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minus.gif";
                        else
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minusl.gif";

                        // --- ��¼��ǰ����ĸ�����
                        if(srcelement.id.length==7) previousobj = window.event.srcElement; // ���ID���ȵ���7(Ϊ��)�����������.ֻ��¼������
                }
                else { // ------------ ����
                        targetelement.style.display="none";
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("imgs/minus.gif")>-1)                     // �ж�ͼƬ״̬��״̬��ת
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif";
                        else
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plusl.gif";
                }
        }
}
document.onclick = clickHandler;
//-------- ����ַ -------
function openURL(URL,LINK){
    parent.openURL(URL,LINK);    
}
//-------- �˵�ȫ��չ��/���� -------
//menu_flag=0;
function menu_expand(){
  if(menu_flag==0)
     expand_text.innerHTML="����ȫ��";
  else
     expand_text.innerHTML="չ��ȫ��";
     
  menu_flag=1-menu_flag;
  for (i=0; i<document.all.length; i++)  {
        srcelement=document.all(i);
        if(srcelement.className=="outline"){
                targetid=srcelement.id+"d";
                targetelement=document.all(targetid);                
                 if (menu_flag==1) {
                        targetelement.style.display='';
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("imgs/plus.gif")>-1)
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minus.gif";
                        else
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minusl.gif";
                }
                else {
                        targetelement.style.display="none";
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("imgs/minus.gif")>-1)
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif";
                        else
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plusl.gif";
                }
        }
  }
}
//-------- �����򿪵����˵��� -------
function menu_shrink(){
  for (i=0; i<document.all.length; i++)  {
        srcelement=document.all(i);
        if(srcelement.title!="") {
              strbuf=srcelement.src;
              if(strbuf.indexOf("minus")>-1) {
                 targetid=srcelement.id+"d";
                 targetelement=document.all(targetid);
                 targetelement.style.display='none';

                 if(strbuf.indexOf("imgs/minus.gif")>-1)
                    srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif";
                 else
                    srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_plusl.gif";
               }
         }
  }
}
//-------- ��windows���� -------
function winexe(NAME,PROG){
   URL="/function/callrun?PROG="+PROG+"&NAME="+NAME;
   window.open(URL,"winexe","height=100,width=350,status=0,toolbar=no,menubar=no,location=no,scrollbars=yes,top=0,left=0,resizable=no");
}
</script>
</html>