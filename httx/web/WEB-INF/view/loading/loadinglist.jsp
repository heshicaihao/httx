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
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652144"></script>
<script type="text/javascript">
var queryParam;
$(function(){
    $('#listDiv').datagrid({
        title:'待装单列表',
        rownumbers:true,
        singleSelect:false,
        idField:'orderid',
        loadMsg:'正在努力加载中，请稍候...',
        fitColumns:true,
        autoRowHeight:false,
        border:false,
        columns:[[{checkbox:true},
            {field:'orderid',title:'订单编号',width:150},
            {field:'companyName',title:'公司',width:100},
            {field:'customerName',title:'客户',width:100},
            {field:'ordername',title:'收件人姓名',width:100},
            {field:'orderdate',title:'录入日期',width:100,formatter:function(value,row,index){
                return myformatter(new Date(value));
            }},
            {field:'status',title:'订单状态',width:60,formatter:function(value,row,index){
                switch(value*1){
                case 1:
                    return '放行';
                case 2:
                    return '出库';
                case 3:
                    return '发货';
                    default: return '清关中';
                }
          }},
          {field:'loading_no',title:'装载单号',width:100},
          {field:'null',title:'操作',width:100, formatter:function(value,row,index){
              if(row.status*1==3){
                  return "";
              }
                return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:beanReleased(' +index + ');" >&nbsp;&nbsp;关闭&nbsp;&nbsp;</a>';
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
        ,toolbar: [
            {
                 text: '新增装载单',
                 iconCls: 'icon-add',
                 handler: function(){showModify(1);}
             },                                       
             '-',{
                text: '批量关闭',
                iconCls: 'icon-edit',
                handler: function(){
                    var url = "${appName}/loading/released";
                    
                    var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                       $.messager.alert("提示信息","请选择要关闭的订单",'info');
                       return;
                    }
                    var idArr = new Array();
                    for(var i = 0; i < rows.length; i++){
                        if(!rows[i].loading_no){
                            $.messager.alert("提示信息","请选给订单" + rows[i].orderid + "生成装载单",'info');
                            return;
                        }
                        idArr.push(rows[i].orderid);
                    }
                    idArr.join(",");
                    $.messager.confirm("关闭订单确认","<font color='red'>确认要关闭所选订单吗？一旦关闭将无法恢复！</font>",function(ok){
                        if(ok){
		                    $.post('${appName}/loading/released',{ids:idArr.toString()},function(rtn){
		                        if(rtn){
		                            if(rtn.code == 0){
		                                $.messager.alert("提示信息","订单关闭成功!","info",function(){
		                                    search(1);
		                                });
		                            }else{
		                                $.messager.alert("提示信息","订单关闭失败," + rtn.errorMsg,"info");
		                            }
		                        }else{
		                            $.messager.alert("Error","系统通信失败!",'error');
		                        }
		                    },'json');
                        }
                    });
                }
            },
            '-',
             {
                 text:'生成海关报文',
                 iconCls: 'icon-edit',
                 handler: function(){
                     var url = "${appName}/loading/exportLoadinghg";
                     var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                        $.messager.alert("提示信息","请选择要生成的海关订单",'info');
                        return;
                    }
                    var idArr = new Array();
                     for(var i = 0; i < rows.length; i++){
                         if(!rows[i].loading_no){
                             $.messager.alert("提示信息","请先给订单" + rows[i].orderid + "生成装载单",'info');
                             return;
                         }
                         idArr.push(rows[i].orderid);
                     }
                     idArr.join(",");
                     $('#downloadForm').attr('action',url);
                     $('#ids').val(idArr.toString());
                     $('#downloadForm').submit();
                 }
             },
             '-',
             {
                 text:'生成检验局报文',
                 iconCls: 'icon-edit',
                 handler: function(){
                     var url = "${appName}/loading/exportLoadingCheck";
                     
                     var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                        $.messager.alert("提示信息","请选择要生成的检验局订单",'info');
                        return;
                    }
                    var idArr = new Array();
                     for(var i = 0; i < rows.length; i++){
                     if(!rows[i].loading_no){
                             $.messager.alert("提示信息","请选给订单" + rows[i].orderid + "生成装载单",'info');
                             return;
                         }
                         idArr.push(rows[i].orderid);
                     }
                     idArr.join(",");
                     $('#downloadForm').attr('action',url);
                    $('#ids').val(idArr.toString());
                    $('#downloadForm').submit();
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
function beanReleased(idx){
	var row = $('#listDiv').datagrid("getRows")[idx];
    if(row){
        if(!row.loading_no || row.loading_no=='' || row.loading_no=='null'){
            $.messager.alert("提示信息","请先生成装载单后才能关闭订单!",'info');
            return;
        }
    }
    $.messager.confirm("关闭订单确认","<font color='red'>确认要关闭所选订单吗？一旦放行将无法恢复！</font>",function(ok){
        if(ok){
            $.post('${appName}/loading/released',{ids:row.orderid},function(rtn){
                if(rtn){
                    if(rtn.code == 0){
                        $.messager.alert("提示信息","订单关闭成功!","info",function(){
                            search(1);
                        });
                    }else{
                        $.messager.alert("提示信息","订单关闭失败," + rtn.errorMsg,"info");
                    }
                }else{
                    $.messager.alert("Error","系统通信失败!",'error');
                }
            },'json');
        }
    });
}
</script>
</head>
<body>
<input type="hidden" id="appName" value="${appName }"/>
<div class="easyui-panel" title="待装载信息查询" border="0" data-options="iconCls:'icon-search',collapsible:true">
    <div style="border-bottom:solid 1px #95B8E7"><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td>
                     &nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input>&nbsp;
                     &nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate"></input>
                </td>
                <td>
                     &nbsp;订单编号:<input type="text" id="searchOrderNo" style="width:90px" name="searchOrderNo"></input>&nbsp;
                     &nbsp;装载单号:<input type="text" id="searchLoadingNo" style="width:90px" name="searchLoadingNo"></input>
                </td>
                <td>&nbsp;<input type="button" value=" 查询 " style="width:60px" onclick="search(1);"/></td>
                <td>&nbsp;<input type="button" value="未制装载单" onclick="search(2);"/></td>
            </tr>
        </table>
        </form>
    </div>
</div>
<div id="listDiv"></div>
<div id="modDlg"></div>
<div id="importDlg"></div>
<div id="detailDlg"></div>
<div id="ewaybillDlg"></div>
<div id="addewaybillDlg"></div>
<div>
    <form method="post" id="downloadForm" name="download" >
        <input type="hidden" id="ids" name="ids"></input>
    </form>
</div>

<script>
    function search(type){
        $('#listDiv').datagrid('loading');
        var params = {};
        params.startDateStr = $('#startDate').datebox('getValue');
        params.endDateStr = $('#endDate').datebox('getValue');
        if(type == 2){
            params.unloading="unloading";
        }else{
	        $('#searchOrderNo').val($.trim($('#searchOrderNo').val()));
	        if($('#searchOrderNo').val() != ''){
	        	params.orderid = $('#searchOrderNo').val();
	        }
	        $('#searchLoadingNo').val($.trim($('#searchLoadingNo').val()));
	        if($('#searchLoadingNo').val() != ''){
	            params.loading_no = $('#searchLoadingNo').val();
	        }
        }
        $('#listDiv').datagrid('loading');
        $('#listDiv').datagrid({url: "${appName}/loading/listPage",queryParams:params,pageNumber:1});
    }

    var modDlg;
    function showModify(typekey,rowid){
        var url = '${appName}/loading/add';
        var title = "新增装载单";
        if(typekey==1){
             var rows = $('#listDiv').datagrid('getSelections');
            if(rows && rows.length == 0){
                $.messager.alert("提示信息","请选择要生成装载单的订单",'info');
                return;
            }
        }
        if(!modDlg){
            modDlg = $('#modDlg').dialog({
            title:title,
            id:'modDlg',
            cache: false,
            top:50,
            height:150,
            width:300,
            closed:true,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    if(!checkSubmit()){
                        return;
                    }
                    var param = {};
                    
                    param.vename = $('#vename').val();
                    var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                        $.messager.alert("提示信息","请选择要生成装载单的订单",'info');
                        return;
                    }
                    var idArr = new Array();
                    for(var i = 0; i < rows.length; i++){
                        idArr.push(rows[i].orderid);
                    }
                    idArr.join(",");
                    param.orderids = idArr.toString();
                    
                    $.ajax({
                        url: '${appName}/loading/save',
                        type: 'POST',
                        dataType: 'json',
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8", 
                        timeout: 60000,
                        success: function(data){
                            if(data){
                                var t = $('#modDlg').panel('options').title;
                                var msg = "修改";
                                if(t == '新增装载单'){
                                    msg = "新增";
                                }
                                
                                if(data.success){
                                    $.messager.alert("提示信息",msg + "新增装载单成功!","info",function(){
                                        $(modDlg).dialog('close');
                                        search();
                                    });
                                }else{
                                    $.messager.alert("提示信息",msg + "新增装载单失败! " + data.errorMsg,"info");
                                    $(modDlg).dialog('close');
                                }
                            }else{
                                $.messager.alert("Error","系统通信失败!",'error');
                            }
                        }
                    });
                }
            },{
                text:'取消',
                handler:function(){$(modDlg).dialog('close');}
            }]
        });
        }
        $(modDlg).dialog('setTitle',title);
        $(modDlg).dialog('open');
        $(modDlg).dialog('refresh', url);
    }
    
    function checkSubmit(){
        return true;
    }
    
    function closedOnclick(id){
        var row = $('#listDiv').datagrid('getSelected');
        if(row){
            if(!row.loading_no || row.loading_no=='' || row.loading_no=='null'){
                $.messager.alert("提示信息","请先生成装载单后才能关闭订单!",'info');
                return;
            }
        }
        $.messager.confirm("关闭订单确认","<font color='red'>确认要关闭这条订单吗？一旦关闭将无法恢复！</font>",function(ok){
            if(ok){
                $.post('${appName}/loading/cancel/' + id,null,function(rtn){
                    if(rtn){
                        if(rtn.code == 0){
                            $.messager.alert("提示信息","关闭订单成功!","info",function(){
                                search();
                            });
                        }else{
                            $.messager.alert("提示信息","关闭订单失败," + rtn.errorMsg,"info");
                        }
                    }else{
                        $.messager.alert("Error","系统通信失败!",'error');
                    }
                },'json');
            }
        });
    }
</script>

</body>
</html>