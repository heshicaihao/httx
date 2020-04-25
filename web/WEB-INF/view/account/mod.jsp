<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
a{border:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652142"></script>
</head>
<body>
<div class="easyui-panel" title="修改用户密码" style="width:600px">
	<div style="padding:10px 60px 20px 60px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    		<tr>
    			<td width="90">&nbsp;当前用户名称:</td>
    			<td width="156">${account.loginName }</td>
    			<td>&nbsp;<input type="hidden" id="hiddenInstkey" value="${account.id }"></input></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;当前密码:</td>
    			<td><input type="password" id="p" name="loginPWD" maxlength="20"></input></td>
    			<td>支持英文和数字，长度为6-20</td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;新密码:</td>
    			<td><input type="password" id="p1" name="loginPWD" maxlength="20"></input></td>
    			<td>支持英文和数字，长度为6-20</td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;确认新密码:</td>
    			<td><input type="password" id="p2" name="loginPWD" maxlength="20"></input></td>
    			<td>支持英文和数字，长度为6-20</td>
    		</tr>
    	</table>
    </form>
    <div style="text-align:center;padding:5px">
    	<input type="button" value="提交" style="width:60px" onclick="submitForm();"/>
    	<input type="button" value="清空" style="width:60px" onclick="clearForm();" />
    </div>
    </div>
</div>
<script>
	function submitForm(){
		if(!checkRequired('p','当前密码') || !checkLength('p','当前密码',6,20)){
			return;
		}
		if(!checkRequired('p1','新密码') || !checkLength('p1','新密码',6,20)){
			return;
		}
		var newpwd = $('#p1').val();
		var reppwd = $('#p2').val();
		if(newpwd != reppwd){
			$.messager.alert("信息提示","新密码与确认密码不一致，请重新输入!","info",function(){
				$('#p2').select();
			});
			return;
		}
		var param = {};
		param.oldPWD = $('#p').val();
		param.loginPWD = $('#p1').val();
		$.ajax({
			url: '${appName}/account/modSave',
			type: 'POST',
			dataType: 'json',
			data:JSON.stringify(param),
			contentType: "application/json; charset=utf-8", 
			timeout: 30000,
			success: function(data){
				if(data){
					if(data.code == 0){
						$.messager.alert("提示信息","修改密码成功!","info",function(){
							clearForm();
						});
					}else{
						$.messager.alert("提示信息","修改密码失败! " + data.errorMsg,"info");
					}
				}else{
					$.messager.alert("Error","系统通信失败!",'error');
				}
			}
		});
	}
	function clearForm(){
		$('#ff').form('clear');
	}
</script>
</body>
</html>