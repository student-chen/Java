<%@ page contentType="text/html; charset=gb2312"%>
<html>
<head>
<script language="javascript">
	function rep(){
		this.location.replace('${pageContext.request.contextPath}/foot.jsp');
	}
	window.setTimeout('rep()',30000); 
</script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">
</head>

<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	 <table width="100%" border="0" cellspacing="0">
	   <tr>
	     <td height="20" align="center" background="${pageContext.request.contextPath}/imgs/sb_bg.gif">&copy;��Ȩ����.����Ͼ�</td>
	   </tr>
	 </table>
	<%--<c:if test="${empty user}">
		 <script type="text/javascript" language="javascript">
			 <!--
				 if(self==top){
					alert("�Ự��ʧ�������µ�½������");
					top.location='${pageContext.request.contextPath}';
				 }
			 -->
		 </script>
	</c:if>
--%></body>
</html>