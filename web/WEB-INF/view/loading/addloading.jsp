<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />

	<div style="padding:25px 10px 25px 10px">
    <form id="ff" method="post">
    	<table cellpadding="0">
     	    <tr>
    			<td><font color="red">*</font>&nbsp;车牌号:</td>
    			<td><input type="text" id="vename" name="vename" maxlength="30" value="${loadingInfo.vename}"></input></td>
    			<input type="hidden" id="orderids" name="orderids" value="${loadingInfo.orderids}"   ></input>
    			<input type="hidden" id="id" name="id" maxlength="30" value="${loadingInfo.id}"></input>
    			<td></td>
    		</tr>    		
    	</table>
    </form>
    </div>
<style scoped="scoped">
	.textbox{
		height:20px;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>