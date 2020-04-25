<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个人资料</title>
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
<div class="easyui-panel" title="个人资料" style="width:600px">
<div style="padding:10px 20px 10px 20px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    		<tr>
    			<td width="90"><font color="red">*</font>&nbsp;登陆用户名称:</td>
    			<td width="156">
    				<input type="text" id="u" name="loginName" maxlength="20" value="${account.loginName }" disabled="true" ></input>
    				<input type="hidden" id="hiddenId" value="${account.id }"></input>	
    			</td>
    			<td>由字母与数字组成，长度为6-20</td>
    		</tr>
    		<tr>
                <td><font color="red">*</font>&nbsp;用户类型:</td>
                <td><select name="accountType" id="accountType" style="width:156px" disabled="true">
                        <option value="2"<c:if test="${2 == account.accountType }">selected</c:if>>业务员</option>
                        <option value="3"<c:if test="${3 == account.accountType }">selected</c:if>>客户</option>
                    </select>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><font color="red">*</font>&nbsp;用户状态:</td>
                <td>
                    <select name="status" id="status" style="width:156px" disabled="true">
                        <option value="1" <c:if test="${1 == account.status }">selected</c:if>>有效</option>
                        <option value="0" <c:if test="${0 == account.status }">selected</c:if>>失效</option>
                    </select>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td valign="top">&nbsp;备注:</td>
                <td colspan="2"><textarea id="accountDesc" name="accountDesc" readonly cols="40" rows="2">${account.accountDesc }</textarea></td>
            </tr>
    	</table>
    </form>
</div>
</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>
</body>
</html>