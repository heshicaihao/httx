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
        title:'订单出仓列表',
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
            {field:'orderno',title:'订单编号',width:70},
            {field:'usergoodscode',title:'商品编码',width:60},
            {field:'custName',title:'客户',width:60},
            {field:'copGNo',title:'客户商品<br/>货号',width:60},
            {field:'entRecordNo',title:'电子订单编号',width:80},
            {field:'goodDesc',title:'商品描述',width:80},
            {field:'gqty',title:'数量',width:30},
            {field:'unit',title:'计量单位',width:50},
            {field:'declTotal',title:'金额(RMB)',width:50},
            {field:'totalWT',title:'海关申报<br/>重量',width:60},
            {field:'ewaysnum',title:'国内<br/>运单号',width:60},
            {field:'noticeNo',title:'国内物流<br/>供应商',width:60},
            {field:'recname',title:'收件人姓名',width:60},
            {field:'reccellno',title:'收件人电话',width:60},
            {field:'province',title:'省',width:60},
            {field:'city',title:'市',width:60},
            {field:'recaddr',title:'收件人地址',width:100},
            {field:'dealtime',title:'发货日期',width:60},
            {field:'username',title:'创建人',width:60}
        ]],
        onLoadSuccess:function(data){
             $('#listDiv').datagrid('loaded');
        },
        onLoadError:function(data){
            $('#listDiv').datagrid('loaded');
        }
        
        ,toolbar: [
            
             {
                 text:'导出excell',
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
<div class="easyui-panel" title="订单出仓报表查询" border="0" data-options="iconCls:'icon-search'">
    <div><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td align="right">&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" data-options="required:true"  name="startDate"></input></td>
            <c:if test="${loginAccount.accountType != 3 }">
                <td align="right">&nbsp;客户:
                <input id="userId" name="userId" style="width:124px" class="easyui-combobox" data-options="
                    url:$('#appName').val() + '/common/listCustomers',
                    valueField:'instkey',
                    textField:'gmusername'
                "/>
                </td>
            </c:if>
                <td align="right">&nbsp;商品编码:<input type="text" id="searchUsergoodscode" name="searchUsergoodscode" style="width:120px" /></td>
                <td align="right">&nbsp;订单编号:<input type="text" id="searchOrderNo" name="searchOrderNo" style="width:120px"/></td>
            <c:if test="${loginAccount.accountType == 3 }">
                <td align="right">&nbsp;
                </td>
            </c:if>
            </tr>
            <tr>
               <td align="right">&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" data-options="required:true"  name="endDate" ></input></td>
                <td align="right">&nbsp;电子订单编号:<input type="text" id="searchentRecordNo" name="searchentRecordNo" style="width:120px"/></td>
                <td align="right">&nbsp;收件人:<input type="text" id="searchrecname" name="searchrecname" style="width:120px" /></td>
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
                params.custid=$('#userId').combobox('getValue') * 1;
            }
        }
        params.orderno = $('#searchOrderNo').val();
        params.usergoodscode = $('#searchUsergoodscode').val();
        params.entRecordNo = $('#searchentRecordNo').val();
        params.recname = $('#searchrecname').val();
        
        $('#hideusergoodscode').val($('#searchUsergoodscode').val());
        $('#hideorderno').val($('#searchOrderNo').val());
        $('#hideentRecordNo').val($('#searchentRecordNo').val());
        $('#hiderecname').val($('#searchrecname').val());
        
        $('#listDiv').datagrid({url: "${appName}/report/listOrderPage",queryParams:params,pageNumber:1});
    }
</script>
<form id="exportExcel" method="post" target="_blank" action="${appName}/report/exportOrderlist">
    <input type="hidden" name="startDateStr" id="startDateStr"></input>
    <input type="hidden" name="endDateStr" id="endDateStr"></input>
    <input type="hidden" name="userIdHidden" id="userIdHidden"></input>
    <input type="hidden" name="usergoodscode" id="hideusergoodscode"></input>
    <input type="hidden" name="orderno" id="hideorderno"></input>
    <input type="hidden" name="entRecordNo" id="hideentRecordNo"></input>
    <input type="hidden" name="recname" id="hiderecname"></input>
</form>
</body>
</html>