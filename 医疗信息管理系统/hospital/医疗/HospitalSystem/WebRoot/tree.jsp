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
						<a class="title" href="#" onclick="MEMU_11.click();return false;">&nbsp;Ա����ְ</a>
					</td>
				</tr>
			</table>


			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>

						<table class="small" border="0" cellspacing="0" cellpadding="0"
							id="MEMU_11d" style="display:none ">
							<tr>
								<td>
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/world_time.gif"
													border="0">
											</td>
											<td colspan="2">
												<a class="title"
													href="${pageContext.request.contextPath}/view/doctorinsert.jsp"
													target="main">&nbsp;ҽ����ְ</a>
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
													src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/@personsetting.gif">
											</td>
											<td colspan="2">
												<a class="title"
													href="${pageContext.request.contextPath}/view/nurseinsert.jsp"
													target="main">&nbsp;��ʿ��ְ</a>
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
						<img
							src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif"
							width="16" height="18" class="outline" id="MEMU_55"
							style="cursor:hand">
					</td>
					<td>
						<img
							src="${pageContext.request.contextPath}/imgs/menu/addresslist.gif"
							border="0" WIDTH="16" HEIGHT="16" align="absmiddle" alt="����ͨѶ¼����">
					</td>
					<td colspan="2">
						<a class="title" href="as" onclick="MEMU_55.click();return false;">&nbsp;�����ֵ�ά��</a>
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
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"
										border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/@bease.gif"
										border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/view_ludan/medicalcoursesList.jsp"
										target="main">&nbsp;�Ʊ�ά��</a>
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
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"
										border="0">
								</td>
								<td>
									<img
										src="${pageContext.request.contextPath}/imgs/menu/@my2.gif"
										border="0">
								</td>
								<td colspan="2">
									<a class="title"
										href="${pageContext.request.contextPath}/view_ludan/postList.jsp"
										target="main">&nbsp;ְ��ά��</a>
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
										src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif"
										border="0">
								</td>
								<td>
									<img src="${pageContext.request.contextPath}/imgs/menu/my.gif"
										border="0">
								</td>
								<td colspan="2">
									<a class="title"
										 href="${pageContext.request.contextPath}/sickBedServlet?opertion=4"
										target="main">&nbsp;����ά��</a>
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
										href="${pageContext.request.contextPath}/operationRoomWuJiRuiServlet?opertion=4"
										target="main">&nbsp;������ά��</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" class="small">
				<tr>
					<td nowrap>
						<img
							src="${pageContext.request.contextPath}/imgs/menu/tree_plus.gif"
							id="MEMU_07" class="outline" style="cursor:hand"
							title="չ��/����">
					</td>
					<td nowrap>
						<img
							src="${pageContext.request.contextPath}/imgs/menu/resource.gif"
							border="0" WIDTH="16" HEIGHT="16" align="absmiddle"
							alt="������Ϣ">
					</td>
					<td colspan="3" nowrap>
						<a href="#GO" onClick="MEMU_07.click();" class="title">&nbsp;Ա��ά��</a>
					</td>


				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table class="small" border="0" cellspacing="0" cellpadding="0"
							id="MEMU_07d" style="display:none ">
							<tr>
								<td>
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/vote.gif"
													border="0" WIDTH="16" HEIGHT="16" align="absmiddle"
													alt="����">
											</td>
											<td colspan="2">
												<a class="title"
													href="doctorServlet?opertion=4"
													target="main">&nbsp;ҽ��ά��</a><%-- findAllFlow --%>
											</td>
										</tr>
									</table>
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_blank.gif">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/winexe.gif"
													border="0" WIDTH="16" HEIGHT="16" align="absmiddle"
													alt="����">
											</td>
											<td colspan="2">
												<a class="title"
													href="nurseServlet?opertion=4"
													target="main">&nbsp;��ʿά��</a>
											</td>
										</tr>
									</table>
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/stockout.gif"
													border="0" WIDTH="16" HEIGHT="16" align="absmiddle" alt="">
											</td>
											<td colspan="2">
												<a href="${pageContext.request.contextPath}/receiptLiuHaiQingServlet?operation=0"
													class="title" target="main">&nbsp;�վ�ά��</a>
											</td>
										</tr>
									</table><%--
									<table class="small" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_line.gif"
													border="0">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/tree_blankl.gif">
											</td>
											<td>
												<img
													src="${pageContext.request.contextPath}/imgs/menu/@resource.gif"
													border="0" WIDTH="16" HEIGHT="16" align="absmiddle" alt="">
											</td>
											<td colspan="2">
												<a
													href="${pageContext.request.contextPath}/ReceiptServlet?operation=0"
													class="title" target="main">&nbsp;����ά��</a>
											</td>
										</tr>
									</table>
								--%></td>
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
function clickHandler()
{
	    var targetid,srcelement,targetelement;
        var strbuf;
        srcelement=window.event.srcElement;

        //-------- ��������չ����������ť---------
        if(srcelement.className=="outline")
        {
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
                else
                { // ------------ ����
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
function openURL(URL,LINK)
{
    parent.openURL(URL,LINK);
    
}


//-------- �˵�ȫ��չ��/���� -------
//menu_flag=0;
function menu_expand()
{
  if(menu_flag==0)
     expand_text.innerHTML="����ȫ��";
  else
     expand_text.innerHTML="չ��ȫ��";

  menu_flag=1-menu_flag;

  for (i=0; i<document.all.length; i++)
  {
        srcelement=document.all(i);
        if(srcelement.className=="outline")
        {
                targetid=srcelement.id+"d";
                targetelement=document.all(targetid);
                if (menu_flag==1)
                {
                        targetelement.style.display='';
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("imgs/plus.gif")>-1)
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minus.gif";
                        else
                                srcelement.src="${pageContext.request.contextPath}/imgs/menu/tree_minusl.gif";
                }
                else
                {
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
function menu_shrink()
{
  for (i=0; i<document.all.length; i++)
  {
        srcelement=document.all(i);
        if(srcelement.title!="")
        {
              strbuf=srcelement.src;

              if(strbuf.indexOf("minus")>-1)
              {
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
function winexe(NAME,PROG)
{
   URL="/function/callrun?PROG="+PROG+"&NAME="+NAME;
   window.open(URL,"winexe","height=100,width=350,status=0,toolbar=no,menubar=no,location=no,scrollbars=yes,top=0,left=0,resizable=no");
}

</script>
</html>

