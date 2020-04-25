<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<div style="padding:10px 20px 10px 20px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    		<tr>
    			<td width="90"><font color="red">*</font>&nbsp;登陆用户名称:</td>
    			<td width="156">
    				<input type="text" id="u" name="loginName" maxlength="20" value="${account.loginName }"
    				<c:if test="${!empty account }">
    				disabled="true"
    				</c:if>
    				></input>
    				<input type="hidden" id="hiddenId" value="${account.id }"></input>	
    			</td>
    			<td>由字母与数字组成，长度为6-20</td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;登陆密码:</td>
    			<td><input type="text" id="p" name="loginPWD" maxlength="20" value="${account.loginPWD }"></input></td>
    			<td>支持英文和数字，长度为6-20</td>
    		</tr>
    		<tr>
                <td><font color="red">*</font>&nbsp;用户类型:</td>
                <td><select name="accountType" id="accountType" style="width:156px" onchange="enableCustomer(this.value)"
	                <c:if test="${!empty account }">
                    disabled="true"
                    </c:if>
	                >
                        <option value="2"<c:if test="${2 == account.accountType }">selected</c:if>>业务员</option>
                        <option value="3"<c:if test="${3 == account.accountType }">selected</c:if>>客户</option>
                    </select>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><font color="red">*</font>&nbsp;用户状态:</td>
                <td>
                    <select name="status" id="status" style="width:156px">
                        <option value="1" <c:if test="${1 == account.status }">selected</c:if>>有效</option>
                        <option value="0" <c:if test="${0 == account.status }">selected</c:if>>失效</option>
                    </select>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td valign="top">&nbsp;备注:</td>
                <td colspan="2"><textarea id="accountDesc" name="accountDesc" cols="40" rows="2">${account.accountDesc }</textarea></td>              
            </tr>
            <tr>
                <td valign="top">&nbsp;客户:</td>
                <td>
                    <input name="custId" id="custId" class="easyui-combobox" style="width:130px" data-options="
                        url:'${appName }/common/listCustomers',
                        valueField:'instkey',
                        textField:'gmusername',
                    <c:if test="${!empty account.custId}">
                        value:${account.custId},
                    </c:if>
                        disabled:true,
                        filter:cobFilter
                    ">
                </td>
                <td></td>
            </tr>
    	</table>
    </form>
</div>