<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />

	<div style="padding:10px 60px 20px 60px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    	    <tr>
    			<td><font color="red">*</font>&nbsp;订单编号:</td>
    			<td>${ewaybill.orderid}</td>
    			<td></td>
    		</tr>
    		
    		<tr>
    			<td><font color="red">*</font>&nbsp;运单编号:</td>
    			<td>${ewaybill.waybillno}</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;运费:</td>
    			<td>${ewaybill.freight}</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;保价费:</td>
    			<td>${ewaybill.valuationfee}</input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;税费:</td>
    			<td>${ewaybill.tax}</input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;物流公司:</td>
    			<td>${ewaybill.noticeno}</input></td>
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