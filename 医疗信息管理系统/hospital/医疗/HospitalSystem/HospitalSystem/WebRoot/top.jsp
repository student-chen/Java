<%@ page contentType="text/html; charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>ͷ��</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mycss.css">
		<script language="javascript">
  function get_time()
  {
    var date=new Date();
    var year="",month="",day="",week="",hour="",minute="",second="";
    year=date.getYear();
    month=add_zero(date.getMonth()+1);
    day=add_zero(date.getDate());
    week=date.getDay();
    switch (date.getDay()) {
    case 0:val="������";break
    case 1:val="����һ";break
    case 2:val="���ڶ�";break
    case 3:val="������";break
    case 4:val="������";break
    case 5:val="������";break
    case 6:val="������";break
      }
    hour=add_zero(date.getHours());
    minute=add_zero(date.getMinutes());
    second=add_zero(date.getSeconds());
    timetable.innerText=" "+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+" "+val;
  }
  function add_zero(temp){
    if(temp<10) return "0"+temp;
    else return temp;
  }
setInterval("get_time()",1000);
  </script>
	</head>
	<%String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td height="70" width="200" background="${pageContext.request.contextPath }/imgs/index_02.gif">
					&nbsp;</td>
				<td align="right" valign="bottom" background="${pageContext.request.contextPath }/imgs/index_01.gif">
					<table width="330" border="0" cellspacing="0">
						<tr align="right">
							<td height="50" colspan="2">
								<a href="${pageContext.request.contextPath}/first.jsp"
									target="main" class="title"> <img
										src="${pageContext.request.contextPath }/imgs/indexpage.gif" alt="��ҳ" border="0"
										align="absmiddle"> </a> &nbsp;
								<a href="${pageContext.request.contextPath}/logout.jsp"target="_parent"
									onClick="if(!confirm('ȷ��Ҫ�ص�����')){return false;}"class="title">
								<img src="${pageContext.request.contextPath }/imgs/indexpage_1.jpg" border="0" align="absmiddle"> 
								</a> &nbsp;
								<%--<a href="h" target="_partant" class="title">
									 <img src="${pageContext.request.contextPath }/imgs/indexpage_1.jpg" alt="�ص�¼" border="0"
										align="absmiddle"> </a> &nbsp;
								--%><a href="#" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('<%=url%>')"
									onFocus="if(this.blur)this.blur()" class="title">
									 <img src="${pageContext.request.contextPath }/imgs/set.gif" border="0" align="absmiddle">
								</a>&nbsp;
								<a href="${pageContext.request.contextPath}/logout.jsp"target="_parent"
									onClick="if(!confirm('ȷ��Ҫ�˳���½��')){return false;}"class="title">
								<img src="${pageContext.request.contextPath }/imgs/logout.gif" border="0" align="absmiddle"> 
								</a> &nbsp;
							</td>
						</tr>
						<tr>
							<td height="8" align="left" colspan="2">
								����ʱ��:<font color="#0066FF" id="timetable"></font>&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>