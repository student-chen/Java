<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>updateOrDelete</title>
<script language="javascript">
<!--
//4�����ӿ��Կ����ĸ���ı仯
function onClickTestType1(){

       MM_showHideLayers('mustStudyChoose','','show');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType2(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','show');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType3(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','show');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType4(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','show');

}
-->
</script>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>addTest</title>
<style type="text/css">
<!-- ������ -->
.TH {
text-align:left; 
vertical-align:middle;
padding:2px;
font-size:9pt;
font-family:Arial;
cursor:hand;

background-color: #3366cc;
border-bottom: #264e75 solid 1px;
border-left: #71c2ff solid 1px;
border-right: #264e75 solid 1px;
border-top: #71c2ff solid 1px;
color: #ffffff;
text-decoration: none;
}

TD {
vertical-align:top;
background-color:#EEE;
padding:4px;
font-size:9pt;
font-family:Arial;
}
#mustStudyChoose {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#mustStudyText {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#easyStudyChoose {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#easyStudyText {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}


</style>
<script type="text/JavaScript">
<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>
</head>
<body>



<table border="1" width="480" bgcolor="#E8E8E8" cellpadding="2"
	class="TH">
	<tr bgcolor="#FFFFFF">
		<td width="120" id="onClick1" onClick="onClickTestType1();"><a
			href="#">��ʾ���޿�ѡ����</a></td>
		<td width="120" id="onClick2" onClick="onClickTestType2();"><a
			href="#">��ʾѡ�޿�ѡ����</a></td>
		<td width="120" id="onClick3" onClick="onClickTestType3();"><a
			href="#">��ʾ���޿������</a></td>
		<td width="120" id="onClick4" onClick="onClickTestType4();"><a
			href="#">��ʾѡ�޿������</a></td>
	</tr>
</table>
<!--------------------------------- 1.���޿�ѡ����� ------------------------->

<div id="mustStudyChoose" style="visibility: visible;">
<table width="700"  >

	<tr>
		<td colspan="5">���޿�ѡ����:</td>
	</tr>
	<tr>
		<td width="54">��Ŀ���</td>
		<td width="58">�γ̱��</td>
		<td width="46">����</td>
		<td width="420">����</td>
		<td width="37">�޸�</td>
		<td width="41">ɾ��</td>
	</tr>
	<!-------- forEachѭ���������޿ε�ѡ�����ÿһ����Ϣ ------->
	<!-------- �����Ӵ����޿�ѡ���������Ϣ��servlet ------->
	<c:forEach items="${choose1List}" var="choose1" begin="0">
		<tr>
			<td>${choose1.ch_id}</td>
			<td>${choose1.l_id}</td>
			<td><c:choose>
				<c:when test="${choose1.type==1}">
��ѡ
</c:when>
				<c:when test="${choose1.type==2}">
��ѡ
</c:when>
				<c:otherwise>
�޷�ʶ��
</c:otherwise>
			</c:choose></td>
			<td>${choose1.ch_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryChooseServlet?cType=mustChoose&view=${choose1.ch_id}"
				target="_blank">�޸�</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryChooseServlet?dType=mustChoose&delete=${choose1.ch_id}">
			ɾ��</a></td>
		</tr>

	</c:forEach>

	<tr>
		<td><input type="hidden" name="choose1Page" value="${choose1Page}" /></td>
	</tr>

<!-- ��ҳ�ؼ� -->
<tr><td colspan="6">
${choose1PageStr}
</td>
</tr>
<tr><td colspan="6">
${choose1ToString}
</td>
</tr>
</table>

</div>

<!--------------------------------- 2.ѡ�޿�ѡ����� ------------------------->
<div id="mustStudyText" style="visibility: hidden;">

<table width="700" >


	<tr>
		<td colspan="5">ѡ�޿�ѡ����:</td>
	</tr>
	<tr>
		<td width="54">��Ŀ���</td>
		<td width="58">�γ̱��</td>
		<td width="46">����</td>
		<td width="420">����</td>
		<td width="37">�޸�</td>
		<td width="41">ɾ��</td>
	</tr>
	<!-------- forEachѭ������ѡ�޿ε�ѡ�����ÿһ����Ϣ ------->
	<!-------- �����Ӵ�ѡ�޿�ѡ���������Ϣ��servlet ------->
	<c:forEach items="${choose2List}" var="choose2" begin="0">
		<tr>
			<td>${choose2.ch_id}</td>
			<td>${choose2.l_id}</td>
			<td><c:choose>
				<c:when test="${choose2.type==1}">
��ѡ
</c:when>
				<c:when test="${choose2.type==2}">
��ѡ
</c:when>
				<c:otherwise>
�޷�ʶ��
</c:otherwise>
			</c:choose></td>
			<c:set value="${choose2}" var="choose2" scope="session"></c:set>
			<td>${choose2.ch_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveChooseServlet?cType=easyChoose&view=${choose2.ch_id}"
				target="_blank">�޸�</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveChooseServlet?dType=easyChoose&delete=${choose2.ch_id}">
			ɾ��</a></td>
		</tr>
	</c:forEach>

	<!-- ��ҳ�ؼ� -->
<tr><td colspan="6">
${choose2PageStr}
</td>
</tr>
<tr><td colspan="6">
${choose2ToString}
</td>
</tr>
</table>

</div>
<!--------------------------------- 3.���޿������� ------------------------->

<div id="easyStudyChoose" style="visibility: hidden;">
<table width="700" >


	<tr>
		<td colspan="5">���޿������:</td>
	</tr>
	<tr>
		<td width="54">��Ŀ���</td>
		<td width="58">�γ̱��</td>
		<td width="466">����</td>
		<td width="37">�޸�</td>
		<td width="41">ɾ��</td>
	</tr>
	<!-------- forEachѭ���������޿ε�������ÿһ����Ϣ ------->
	<!-------- �����Ӵ����޿�����������Ϣ��servlet ------->
	<c:forEach items="${text1List}" var="text1" begin="0">
		<tr>
			<c:set value="${text1}" var="text1" scope="session"></c:set>
			<td>${text1.text_id}</td>
			<td>${text1.l_id }</td>
			<td>${text1.text_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryTextServlet?cType=mustText&view=${text1.text_id}"
				target="_blank">�޸�</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryTextServlet?dType=mustText&delete=${text1.text_id}">
			ɾ��</a></td>
		</tr>
	</c:forEach>

	<!-- ��ҳ�ؼ� -->
<tr><td colspan="6">
${text1PageStr}
</td>
</tr>
<tr><td colspan="6">
${text1ToString}
</td>
</tr>
</table>
</div>
<!--------------------------------- 4.ѡ�޿������� ------------------------->
<div id="easyStudyText" style="visibility: hidden;">
<table width="700" >

	<tr>
		<td colspan="5">ѡ�޿������:</td>
	</tr>
	<tr>
		<td width="54">��Ŀ���</td>
		<td width="58">�γ̱��</td>
		<td width="466">����</td>
		<td width="37">�޸�</td>
		<td width="41">ɾ��</td>
	</tr>
	<!-------- forEachѭ���������޿ε�������ÿһ����Ϣ ------->
	<!-------- �����Ӵ����޿�����������Ϣ��servlet ------->
	<c:forEach items="${text2List}" var="text2" begin="0">
		<tr>
			<c:set value="${text2}" var="text2" scope="session"></c:set>
			<td>${text2.text_id}</td>
			<td><c:out value="${text2.l_id}" default="null"></c:out></td>
			<td>${text2.text_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveTextServlet?cType=easyText&view=${text2.text_id}"
				target="_blank">�޸�</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveTextServlet?dType=easyText&delete=${text2.text_id}">
			ɾ��</a></td>

		</tr>
	</c:forEach>

	<!-- ��ҳ�ؼ� -->
<tr><td colspan="6">
${text2PageStr}
</td>
</tr>
<tr><td colspan="6">
${text2ToString}
</td>
</tr>
</table>

</div>


</body>
</html>
