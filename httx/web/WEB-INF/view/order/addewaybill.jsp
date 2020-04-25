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
    			<input type="hidden" id="orderid" name="orderid" maxlength="30" value="${ewaybill.orderid}"></input>
    			<input type="hidden" id="id" name="id" maxlength="30" value="${ewaybill.id}"></input>
    			<td></td>
    		</tr>
    	   		
    		<tr>
    			<td><font color="red">*</font>&nbsp;运单编号:</td>
    			<td><input type="text" id="waybillno" name="waybillno" maxlength="30" value="${ewaybill.waybillno}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;运费:</td>
    			<td><input type="text" id="freight" name="freight" maxlength="30" value="${ewaybill.freight}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;保价费:</td>
    			<td><input type="text" id="valuationfee" name="valuationfee" maxlength="12" value="${ewaybill.valuationfee}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;税费:</td>
    			<td><input type="text" id="tax" name="tax" maxlength="12" value="${ewaybill.tax}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">&nbsp;</font>&nbsp;物流公司:</td>
    			<td><input type="text" id="noticeno" name="noticeno" maxlength="12" value="${ewaybill.noticeno}"></input></td>
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