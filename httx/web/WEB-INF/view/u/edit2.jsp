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
                <td width="90"><font color="red">*</font>&nbsp;客户名称:</td>
                <td width="156">
                    <input type="text" id="u" name="gmusername" maxlength="20" value="${gmUser.gmusername }"></input>
                    <input type="hidden" id="hiddenInstkey" value="${gmUser.instkey }"></input> 
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><font color="red">*</font>&nbsp;客户状态:</td>
                <td>
                    <select name="userstatus" id="userstatus" style="width:156px" disabled="true">
                        <option value="1" <c:if test="${1 == gmUser.userstatus }">selected</c:if>>有效</option>
                        <option value="0" <c:if test="${0 == gmUser.userstatus }">selected</c:if>>失效</option>
                    </select>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="90"><font color="red">*</font>&nbsp;电商平台:</td>
                <td width="156">
                    <input type="text" id="coname" name="coname" maxlength="100" value="${gmUser.coname }"></input>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="90"><font color="red">*</font>&nbsp;联系人:</td>
                <td width="156">
                    <input type="text" id="contactor" name="contactor" maxlength="20" value="${gmUser.contactor }"></input>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="90"><font color="red">*</font>&nbsp;联系电话:</td>
                <td width="156">
                    <input type="text" id="phoneNo" name="phoneNo" maxlength="20" value="${gmUser.phoneNo }"></input>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td valign="top">&nbsp;备注:</td>
                <td colspan="2"><textarea id="desc" name="desc" cols="40" rows="2">${gmUser.desc }</textarea></td>
            </tr>
        </table>
    </form>
    <div style="text-align:center;padding:5px">
    	<input type="button" value="提交" style="width:60px" onclick="submitForm();"/>
    </div>
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
<script>
	function submitForm(){
		if(!checkRequired('u','用户名称')){
			return;
		}
		if(!checkRequired('coname','电商平台')){
			return;
		}
		if(!checkRequired('contactor','联系人')){
            return;
        }
		if(!checkRequired('phoneNo','联系电话')){
            return;
        }
		var param = {};
		param.gmusername = $('#u').val();
		param.coname = $('#coname').val();
		param.contactor = $('#contactor').val();
		param.desc = $('#desc').val();
		param.phoneNo=$('#phoneNo').val();
		param.instkey=$('#hiddenInstkey').val();
		$.ajax({
			url: '${appName}/u/editSave',
			type: 'POST',
			dataType: 'json',
			data:JSON.stringify(param),
			contentType: "application/json; charset=utf-8", 
			timeout: 30000,
			success: function(data){
				if(data){
					if(data.success){
						$.messager.alert("提示信息","修改信息[" + param.gmusername + "]成功!","info",function(){
							clearForm();
						});
					}else{
						$.messager.alert("提示信息","修改信息[" + param.gmusername + "]失败! " + data.errorMsg,"info");
					}
				}else{
					$.messager.alert("Error","系统通信失败!",'error');
				}
			}
		});
	}
</script>
</body>
</html>