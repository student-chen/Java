<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script language="JavaScript" src="../images/main.js"> 
</script> 


<script type="text/javascript">
<!--
//���ǵ�ѡ,��ѡ,��������������Ч���ĺ���
function changeTestType(){
 if(document.all("TestType").selectedIndex==0){
        MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','show');
		MM_showHideLayers('choose2','','hide');
		MM_showHideLayers('text','','hide');
 }else if(document.all("TestType").selectedIndex==1){
 		  MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','hide');
		MM_showHideLayers('choose2','','show');
		MM_showHideLayers('text','','hide');
 }else{
   MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','hide');
		MM_showHideLayers('choose2','','hide');
		MM_showHideLayers('text','','show');
 }
}
-->
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>���ӱ��޿ε�����--������ѡ,��ѡ,���</title>

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
<!-- ��Ĺ̶� -->
<style type="text/css">
<!--
#choose1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#choose2 {
		position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#text {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
-->
</style>
</head>
<body>

<!------------------------------- ���� ----------------------------------->
<form name=exam_addTest action=Cexam_uploadTestServlet method=post>
<div id="head"  style="visibility: visible;"
	onload="MM_showHideLayers('head','','show','choose1','','show','choose2','','hide','text','','hide');MM_showHideLayers('head','','show','choose1','','hide','choose2','','show','text','','hide');MM_showHideLayers('head','','show','choose1','','hide','choose2','','hide','text','','show')">
<table width="700" >
	<tr>
		<td class="BODY">���̵ı��޿���:</td>
		<td width=><select id="sub" class="INPUT_text" name="course"
			length="1">
        
			<c:forEach items="${requestScope.courseList}" var="course">
				<option value="${course}">${course}   <!-- ��Cexam_addtestServlet���ı��� -->
			</c:forEach>

		</select></td>
		<td class="BODY">��Ŀ����</td>
		<td><select id="TestType" class="INPUT_text" name="testType"
			length="1" onchange="changeTestType();">  <!-- onchange���ò���������� -->
			<option value="1" selected>��ѡ</option>
			<option value="2">��ѡ</option>
			<option value="3">�����</option>
		</select></td>
		<td><input type="submit" neme="" value="�ύ" /></td>
	</tr>
</TABLE>
</div>
<br>
<!----------------------------- ��ѡ�е���Ŀͷ ------------------------>
<div id="choose1" style="visibility: visible;">
<table width="700" >
	<tr>
		<td><textarea name="choose1_head" clos="" rows="10" cols="75">
        �뽫��Ŀ��������ʽ���������
  </textarea></td>
	</tr>
</table>
<!----------------------------- ��ѡ�е�ѡ��ʹ� ------------------------>
<table width="700" >

	<tr>
		<td width="50" class="BODY">ѡ��A:</td>
		<td width="450" class="BODY"><input type="text" name="choose1_Keya"
			size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��B:</td>
		<td><input type="text" name="choose1_Keyb" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��C:</td>
		<td><input type="text" name="choose1_Keyc" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��D:</td>
		<td><input type="text" name="choose1_Keyd" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">��:</td>
		<td><label><font class="BODY">A</font><input type="radio" name="Key1"
			value="a" /></label>&nbsp;&nbsp; <label><font class="BODY">B</font><input
			type="radio" name="Key1" value="b" /></label> &nbsp;&nbsp;<label><font
			class="BODY">C</font><input type="radio" name="Key1" value="c" /></label>&nbsp;&nbsp;
		<label><font class="BODY">D</font><input type="radio" name="Key1"
			value="d" /></label></td>
	</tr>
</TABLE>
</div>
<!----------------------------- ��ѡ�е���Ŀͷ ------------------------>
<div id="choose2" style="visibility: hidden;">
<table width="700" >
	<tr>
		<td><textarea name="choose2_head" clos="" rows="10" cols="75">
        �뽫��Ŀ��������ʽ���������
  </textarea></td>
	</tr>
</table>
<!----------------------------- ��ѡ�е�ѡ��ʹ� ------------------------>
<table width="700" >

	<tr>
		<td width="50" class="BODY">ѡ��A:</td>

		<td width="450" class="BODY"><input type="text" name="choose2_Keya"
			size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��B:</td>
		<td><input type="text" name="choose2_Keyb" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��C:</td>
		<td><input type="text" name="choose2_Keyc" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��D:</td>
		<td><input type="text" name="choose2_Keyd" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">��:</td>
		<td><label><font class="BODY">A</font><input type="checkbox"
			name="Key2" value="a" /></label>&nbsp;&nbsp; <label><font
			class="BODY">B</font><input type="checkbox" name="Key2" value="b" /></label>
		&nbsp;&nbsp;<label><font class="BODY">C</font><input type="checkbox"
			name="Key2" value="c" /></label>&nbsp;&nbsp; <label><font
			class="BODY">D</font><input type="checkbox" name="Key2" value="d" /></label></td>
	</tr>
</TABLE>
</div>
<!----------------------------- ����е���Ŀͷ ------------------------>
<div id="text" style="visibility: hidden;">
<table width="700" >
	<tr>
		<td><textarea name="text_head" clos="" rows="10" cols="60">
        �뽫��Ŀ��������ʽ���������
  </textarea></td>
	</tr>
</table>
<!----------------------------- ����еĴ� ------------------------>
<table width="700" >

	<tr>
		<td class="BODY">��:</td>
		<td><input type="text" name="Key" size="80" /></td>

	</tr>
</TABLE>
</div>
</form>
</body>
</html>






