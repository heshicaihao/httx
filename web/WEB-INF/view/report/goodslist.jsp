<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单出仓报表</title>
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
    	title:'商品备案信息列表',
    	rownumbers:true,
    	striped:true,
    	singleSelect:false,
    	idField:'usergoodscode',
    	loadMsg:'正在努力加载中，请稍候...',
    	pageList:[30],
    	pageSize:30,
    	pagination:true,
    	fitColumns:true,
        columns:[[
	        {field:'usergoodscode',title:'商品编码',width:60},
	        {field:'copgno',title:'货号',width:60},
	        {field:'sellid',title:'销售网站上<br/>商品的ID',width:60},
	        {field:'goodsenname',title:'英文商品<br/>名称/规格型号',width:80},
	        {field:'gname',title:'中文名称',width:60},
			{field:'country',title:'原产地',width:60},
			{field:'curr',title:'币制',width:40},
			{field:'decprice',title:'进口单价',width:60},
			{field:'unit',title:'销售计量<br/>单位',width:60},
			{field:'rmb',title:'销售零售价<br/>(人民币)',width:60},
            {field:'netwt',title:'净重<br/>(KG)',width:40},
            {field:'grosswt',title:'毛重<br/>(KG)',width:40},
            {field:'pingming',title:'品名',width:60},
            {field:'yongtu',title:'用途',width:60},
            {field:'gmodel',title:'包装/型号',width:60},
            {field:'brand',title:'品牌',width:60},
            {field:'chengfen',title:'成分含量',width:60},
            {field:'manufactory',title:'生产厂家',width:60},
            {field:'networksellname',title:'网站销售<br/>渠道',width:60},
            {field:'hyperlink',title:'商品链接',width:60},
            {field:'registno',title:'海关备案号',width:60},
            {field:'ciqgoodsno',title:'商检备案号',width:60},
            
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
<div class="easyui-panel" title="商品备案信息查询" border="0" data-options="iconCls:'icon-search'">
	<div><form id="searchForm">
    	<table cellpadding="0">
    		<tr>
    			<td align="right">&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input></td>
    			<td align="right">&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate" ></input></td>
    		<c:if test="${loginAccount.accountType != 3 }">
                <td align="right">&nbsp;客户:
                 <input id="userId" name="userId" class="easyui-combobox" style="width:104px" data-options="
                    url:$('#appName').val() + '/common/listCustomers',
                    valueField:'instkey',
                    textField:'gmusername'
                "/>
                </td>
            </c:if>
                <td align="right">&nbsp;商品编码:<input type="text" id="searchUsergoodscode" name="searchUsergoodscode" style="width:100px" /></td>
            <c:if test="${loginAccount.accountType == 3 }">
                <td align="right">&nbsp;
                </td>
            </c:if>
            </tr>
            <tr>
                <td align="right">&nbsp;商品货号:<input type="text" id="searchcopgno" name="searchcopgno" style="width:100px" /></td>
                <td align="right">&nbsp;海关备案号:<input type="text" id="searchregistno" name="searchregistno" style="width:100px" /></td>
                <td align="right">&nbsp;商检备案号:<input type="text" id="searchciqgoodsno" name="searchciqgoodsno" style="width:100px" /></td>
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
		if($("#userId").length > 0 ){
			var val = $('#userId').combobox('getValue');
			if(val != ''){
	            params.createuserid=$('#userId').combobox('getValue') * 1;
			}
		}
		params.usergoodscode = $('#searchUsergoodscode').val();
		params.copgno = $('#searchcopgno').val();
		params.registno = $('#searchregistno').val();
		params.ciqgoodsno = $('#searchciqgoodsno').val();
		
		$('#hideusergoodscode').val($('#searchUsergoodscode').val());
        $('#hidecopgno').val($('#searchcopgno').val());
        $('#hideregistno').val($('#searchregistno').val());
        $('#hideciqgoodsno').val($('#searchciqgoodsno').val());
		
		$('#listDiv').datagrid({url: "${appName}/report/goodslistPage",queryParams:params,pageNumber:1});
	}
</script>
<form id="exportExcel" method="post" target="_blank" action="${appName}/report/exportGoodsExcel">
    <input type="hidden" name="startDateStr" id="startDateStr"></input>
    <input type="hidden" name="endDateStr" id="endDateStr"></input>
    <input type="hidden" name="usergoodscode" id="hideusergoodscode"></input>
    <input type="hidden" name="copgno" id="hidecopgno"></input>
    <input type="hidden" name="registno" id="hideregistno"></input>
    <input type="hidden" name="ciqgoodsno" id="hideciqgoodsno"></input>
    <input type="hidden" name="userIdHidden" id="userIdHidden"></input>
</form>
</body>
</html>