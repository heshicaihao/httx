<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>EBS-跨境电商运营管理系统</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<link rel="shortcut icon" href="${appName}/static/favicon.ico" type="image/x-icon"></link>

<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js"></script>
<style>
form,img{margin:0;padding:0;}
body{ margin:0; background:#016aa9;padding:0; font-size:12px;}
a{ font-size:12p; color:#000;}
a:hover{ text-decoration:none;}
ul,li{ margin:0; padding:0; list-style:none;}
dl,dt,dd{ margin:0; padding:0;}
.list_dl{ width:100%; padding:6px 0 0 0;}
.list_dl dt{ float:left; width:125px; text-align:right; height:18px; line-height:18px; padding:0 4px 0 0;}
.list_dl dd{ float:left;}
img{ border:none;}
.l{ float:left;}
.r{ float:right;}
.clear{ clear:both;}
.login_area{ width:100%; height:20px; line-height:20px; margin:0; padding:14px 0; background:none; border:none;overflow-x:hidden;overflow-y:hidden; color:#fff; text-decoration:none;}
.login_text{ width:102px; height:15px; background:#fff; border:1px solid #7dbad7; background:#292929; line-height:15px; color:#fff; margin:0; padding:1px;}
.login_img{ height:18px; line-height:15px;margin:0; padding-left:2px;padding-bottom:0px}
.wrapper{ width:370px; height:162px; padding:116px 254px 92px 264px; background:url(${appName}/static/images/login_back.jpg) no-repeat top center; margin:60px auto; position:relative;}
.login_submit{ margin:0; padding:0; width:59px; height:26px; background:#2793c1 url(${appName}/static/images/submit.gif) no-repeat center center; cursor:pointer; border:none;}
.div_submit{ text-align:center; padding:6px 0 0 0;}
.div_login{ text-align:right;}
a.link_login{ color:#fff; text-decoration:none;}
.bm_login{ position:absolute; width:100px; height:15px; left:520px; top:263px;}
.bm_login a{ display:block; width:100px; height:15px; background:url(${appName}/static/images/bm_login.jpg) no-repeat top center; float:right;}
.logo{position:absolute;bottom:23px;padding-left:40%;}
.companyname{position:absolute;bottom:5px;padding-left:44%;}
</style>
<script type="text/javascript">
function changeCode(){
   document.getElementById("verify").src="${appName }/verify";
}
function login(){
	var url = '${appName}/login?';
	url += 'u=' + $('#u').val();
	url+='&p=' + $('#p').val();
	url+='&v=' + $('#v').val();
	$.post(url,null,function(data){
		if(data){
			switch(data.code){
				case 1:
					location.href="${appName}/main";
					break;
				case 2:
					$.messager.alert("提示信息","用户名或密码错误，请重新输入","info",function(){
						$('#p').val("");
						$('#v').val("");
						changeCode();
						$('#p').focus();
					});
					break;
				case 3:
					$.messager.alert("提示信息","验证码不正确，请重新输入","info",function(){
						$('#v').val("");
						changeCode();
						$('#v').focus();
					});
					break;
				case 4:
					$.messager.alert("提示信息","用户状态异常","info");
					break;
				default:break;
			}
		}
	});
}
</script>
</head>

<body>

<div class="wrapper">
<form id="loginForm" name="loginForm" action="${appName}/u/login" method="post" onkeydown="if (event.keyCode==13){login();}">
<div class="login_area"><font color="white" style="font-weight:bold;font-size:20px">EBS-跨境电商运营管理系统</font></div>

<dl class="list_dl">
	<dt>用户</dt>
    <dd><input type="text" class="login_text" id="u" name="u" value="administrator"/></dd>
    <div class="clear"></div>
</dl>
<dl class="list_dl">
	<dt>密码</dt>
    <dd><input type="password" class="login_text" id="p" name="p" value="wangfujie123"/></dd>
    <div class="clear"></div>
</dl>
<dl class="list_dl">
	<dt>验证码</dt>
    <dd><input type="text" id="v" name="v" class="login_text" value=""/></dd>
	<dd><img name="verify" id="verify" src="${appName }/verify" onclick="changeCode()" title="看不清？单击换一张图片" class="login_img" /></dd>
    <div class="clear"></div>
</dl>
<div class="div_submit"><input type="button" value="" onclick="login()" class="login_submit" /></div>
<div class="bm_login"><a href="#"></a></div>
</form>
</div>
<div align="center">
<div class="logo"><img src="${appName}/static/images/logo.png"></img></div>
</div>
</body>
</html>
