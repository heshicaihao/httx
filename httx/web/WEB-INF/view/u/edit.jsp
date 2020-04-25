<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
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
    				<select name="userstatus" id="userstatus" style="width:156px">
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
</div>