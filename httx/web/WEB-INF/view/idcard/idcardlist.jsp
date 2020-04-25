<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>待装载信息列表</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css?r=132546546554" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
body{margin:0px;padding:0px}
form{margin:0px;padding:0px}
.datagrid-cell{height:20px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14305652144"></script>
<script type="text/javascript">
var queryParam;
$(function(){
    $('#listDiv').datagrid({
        title:'身份证列表',
        rownumbers:true,
        singleSelect:true,
        idField:'id',
        loadMsg:'正在努力加载中，请稍候...',
        fitColumns:true,
        autoRowHeight:false,
        border:false,
        columns:[[
            {field:'id',hidden:true},
            {field:'name',title:'身份证姓名',width:100},
            {field:'cardNo',title:'身份证号码',width:100,formatter:function(value){
            	if(value != ''){
            		return '<a href="javascript:downloadIDCard(\''+ value + '\')">' + value + '</a>';
            	}
            }},
            {field:'createDate',title:'上传日期',width:100,formatter:function(value,row,index){
            	if(value){
            		return formatDate2(new Date(value));
            	}
            	return '';
            }},
          {field:'null',title:'操作',width:100, formatter:function(value,row,index){
                return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:del(' +row.id + ');" >&nbsp;&nbsp;删除&nbsp;&nbsp;</a>';
            }}     
        ]],
        onLoadSuccess:function(data){
             $('#listDiv').datagrid('loaded');
             $('#listDiv').datagrid('clearSelections');
        },
        onLoadError:function(data){
            $('#listDiv').datagrid('loaded');
            $('#listDiv').datagrid('clearSelections');
        }
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
function del(id){
    $.messager.confirm("删除确认","<font color='red'>确认要删除这条身份证信息吗？</font>",function(ok){
        if(ok){
            $.post('${appName}/idcard/del',{id:id},function(rtn){
                if(rtn){
                    if(rtn.code == 0){
                        $.messager.alert("提示信息","删除身份证信息成功!","info",function(){
                            search(1);
                        });
                    }else{
                        $.messager.alert("提示信息","删除身份证信息失败," + rtn.errorMsg,"info");
                    }
                }else{
                    $.messager.alert("Error","系统通信失败!",'error');
                }
            },'json');
        }
    });
}

function downloadIDCard(cardNo){
	var url = $('#appName').val() + "/idcard/download/"+ cardNo; 
	$('#downloadForm').attr("action",url);
	$('#downloadForm').submit();
}
</script>
</head>
<body>
<input type="hidden" id="appName" value="${appName }"/>
<div class="easyui-panel" title="身份证信息查询" border="0" data-options="iconCls:'icon-search',collapsible:true">
    <div style="border-bottom:solid 1px #95B8E7"><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td>
                     &nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input>&nbsp;
                     &nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate"></input>
                </td>
                <td>&nbsp;<input type="button" value=" 查询 " style="width:60px" onclick="search();"/></td>
            </tr>
        </table>
        </form>
    </div>
</div>
<div id="listDiv"></div>
<div>
    <form method="post" id="downloadForm" name="download" >
    </form>
</div>

<script>
    function search(){
        $('#listDiv').datagrid('loading');
        var params = {};
        params.startDateStr = $('#startDate').datebox('getValue');
        params.endDateStr = $('#endDate').datebox('getValue');
        $('#listDiv').datagrid('loading');
        $('#listDiv').datagrid({url: "${appName}/idcard/listPage",queryParams:params,pageNumber:1});
    }
</script>

</body>
</html>