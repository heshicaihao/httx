<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>库存报表</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css?r=132546546554" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
body{margin:0px;padding:0px}
form{margin:0px;padding:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652142"></script>
<script type="text/javascript">
var queryParam;
$(function(){
    $('#listDiv').datagrid({
    	title:'库存报表列表',
    	rownumbers:true,
    	striped:true,
    	singleSelect:false,
    	idField:'id',
    	loadMsg:'正在努力加载中，请稍候...',
    	pageList:[30],
    	pageSize:30,
    	pagination:true,
    	fitColumns:true,
        columns:[[
			{field:'id',hidden:true},
	        {field:'usergoodscode',title:'商品编码',width:60},
	        {field:'batchno',title:'批次',width:60},
	        {field:'writeDate',title:'批次入库时间',width:80},
	        {field:'custUnit',title:'单位',width:40},
	        {field:'currentInventory',title:'现有量',width:40},
			{field:'gmodel',title:'商品型号',width:100},
			{field:'goodDesc',title:'商品描述',width:200},
			{field:'custName',title:'客户',width:80},
			{field:'copGNo',title:'客户货号',width:80}
        ]],
        onLoadSuccess:function(data){
        	 $('#listDiv').datagrid('loaded');
        },
        onLoadError:function(data){
			$('#listDiv').datagrid('loaded');
		}
		,toolbar: [
		 	{
		 		text:'导出结果到excell',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			$('#startDateStr').val($('#startDate').datebox('getValue'));
		 			$('#endDateStr').val($('#endDate').datebox('getValue'));
		 	        if($('#userId').length > 0){
		 	        	$('#userIdHidden').val($('#userId').combobox('getValue'));
		 	        }
		 			$('#exportExcel').submit();
		 		}
		 	}
		]
    });
    $('#startDate').datetimebox({
        formatter: myformatter,
        parser:myparser
    });
    $('#endDate').datetimebox({
        formatter: myformatter,
        parser:myparser
    });
    var endDate = new Date();
    $('#endDate').datetimebox('setValue',myformatter(endDate));
    var startDate = new Date(endDate.getFullYear(),endDate.getMonth(),1);
    $('#startDate').datetimebox('setValue',myformatter(startDate));
});

</script>
</head>
<body>
<input type="hidden" id="appName" value="${appName }"/>
<div class="easyui-panel" title="库存报表" border="0" data-options="iconCls:'icon-search'">
	<div><form id="searchForm">
    	<table cellpadding="0">
    		<tr>
    			<td>&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input></td>
    			<td>&nbsp;&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate" ></input></td>
    		<c:if test="${loginAccount.accountType != 3 }">
                <td>&nbsp;客户:
                 <input id="userId" name="userId" class="easyui-combobox" data-options="
                    url:$('#appName').val() + '/common/listCustomers',
                    valueField:'instkey',
                    textField:'gmusername'
                "/>
                </td>
            </c:if>
                <td>&nbsp;商品编码:<input type="text" id="searchGoodsCode" name="searchGoodsCode" /></td>
                <td>&nbsp;查询类型:
                    <select id="searchType" name="searchType">
                        <option value="1" selected>明细</option>
                        <option value="2">汇总</option>
                    </select>
                </td>
    			<td>&nbsp;<input type="button" value="查询" style="width:60px" onclick="search();"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
</div>
<div id="listDiv"></div>
<div id="modDlg"></div>
<div id="selectProject"></div>
<script>
	function search(){
		$('#listDiv').datagrid('loading');
		var params = $('#listDiv').datagrid('options').queryParams;
		params.startDate = $('#startDate').datebox('getValue');
		params.endDate = $('#endDate').datebox('getValue');
		params.usergoodscode = $('#searchGoodsCode').val();
		if($("#userId").length > 0 ){
			var val = $('#userId').combobox('getValue');
			if(val != ''){
	            params.custid=$('#userId').combobox('getValue') * 1;
			}
		}
		params.type=$('#searchType').val();
		$('#hideusergoodscode').val($('#searchUsergoodscode').val());
		$('#hidetype').val($('#searchType').val());
		$('#listDiv').datagrid({url: "${appName}/report/storagelistPage",queryParams:params,pageNumber:1});
	}
</script>
<form id="exportExcel" method="post" target="_blank" action="${appName}/report/exportStorageExcel">
    <input type="hidden" name="startDateStr" id="startDateStr"></input>
    <input type="hidden" name="endDateStr" id="endDateStr"></input>
    <input type="hidden" name="userIdHidden" id="userIdHidden"></input>
    <input type="hidden" name="usergoodscode" id="hideusergoodscode"></input>
    <input type="hidden" name="type" id="hidetype"></input>
</form>
</body>
</html>