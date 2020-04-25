<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>入库信息列表</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css?r=132546546554" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
body{margin:0px;padding:0px}
form{margin:0px;padding:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652144"></script>
<script type="text/javascript">
var queryParam;
$(function(){
    $('#listDiv').datagrid({
    	title:'接收信息列表',
    	rownumbers:true,
    	striped:true,
    	singleSelect:false,
    	idField:'id',
    	loadMsg:'正在努力加载中，请稍候...',
    	pageList:[30],
    	pageSize:30,
    	pagination:true,
    	fitColumns:true,
        columns:[[{checkbox:true},
			{field:'id',hidden:true},
	        {field:'writedate',title:'接收日期',width:100,formatter:function(value,row,index){
	        	return myformatter(new Date(value));
	        }},
	        {field:'no',title:'接收单编号',width:80, formatter:function(value,row,index){
	        	return '<a href="javascript:showModify(2,' +row.id + ');" >' + value + '</a>';
            }},
	        {field:'customerName',title:'客户',width:80},
	        {field:'companyName',title:'公司',width:160},
	        {field:'productKey',title:'操作',width:100, formatter:function(value,row,index){
	        	return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:showModify(2,' +row.id + ');" ><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">修改</span><span class="l-btn-icon icon-edit">&nbsp;</span></span></a>&nbsp;<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:del(\'' + row.id + '\');"><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">删除</span><span class="l-btn-icon icon-remove">&nbsp;</span></span></a>';
	        }}
        ]],
        onLoadSuccess:function(data){
        	 $('#listDiv').datagrid('loaded');
        	 $('#listDiv').datagrid('clearSelections');
        },
        onLoadError:function(data){
			$('#listDiv').datagrid('loaded');
		}
		
		,toolbar: [
			{
		 		text: '新增入库信息',
		 		iconCls: 'icon-add',
		 		handler: function(){showModify(1);}
		 	},                                  
            '-',
            {
                text:'模板下载',
                iconCls: 'icon-edit',
                handler: function(){
                    var url = "${appName}/intentrepot/downloadTemplate";
                    window.open(url);
                }
            },                                  
            '-',
            {
                text:'接收单导入',
                iconCls: 'icon-edit',
                handler: function(){
                    showImport();
                }
            },                                  
            '-',
            {
                text:'导出接收入库单',
                iconCls: 'icon-edit',
                handler: function(){
                	var url = "${appName}/intentrepot/exportIncomOrder";
                    var row = $('#listDiv').datagrid('getSelected');
                    if(!row){
                    	$.messager.alert('提示信息','请选择要导出的接收单!','info');
                    	return;
                    }
                    url +="?id=" + row.id;
                    window.open(url);
                }
            },
		 	'-',
		 	{
		 		text:'导出海关进仓报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/intentrepot/exportIntenrepotHG";
		 			var rows = $('#listDiv').datagrid('getSelections');
		 			if(!rows){
		 				$.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
                        return;
		 			}
					if(rows.length >1){
						$.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
						return;
					}
					var row = $('#listDiv').datagrid('getSelected');
					if(!row){
						$.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
                        return;
					}
		 			url += "?id=" + row.id;
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'导出商检进仓报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/intentrepot/exportIntenrepotCheck";
		 			var rows = $('#listDiv').datagrid('getSelections');
                    if(!rows){
                        $.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
                        return;
                    }
                    if(rows.length >1){
                        $.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
                        return;
                    }
                    var row = $('#listDiv').datagrid('getSelected');
                    if(!row){
                        $.messager.alert("提示信息","请选择要导出的入库单，一次只能选择一个入库单",'info');
                        return;
                    }
                    url += "?id=" + row.id;
	 				window.open(url);
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
<div class="easyui-panel" title="接收信息查询" border="0" data-options="iconCls:'icon-search'">
	<div><form id="searchForm">
    	<table cellpadding="0">
    		<tr>
    			<td>&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input></td>
    			<td>&nbsp;&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate"></input></td>
    			<td>&nbsp;&nbsp;<label for="searchInOrderNo">接收单编号:</label><input type="text" maxlength="8" id="searchInOrderNo" name="searchInOrderNo" /></td>
    			<td>&nbsp;<input type="button" value="查询" style="width:60px" onclick="search();"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
</div>
<div id="listDiv"></div>
<div id="modDlg"></div>
<div id="modDlgGoods"></div>
<div id="selectProject"></div>
<script>
	function search(){
		$('#listDiv').datagrid('loading');
		var params = $('#listDiv').datagrid('options').queryParams;
		params.startDateStr = $('#startDate').datebox('getValue');
		params.endDateStr = $('#endDate').datebox('getValue');
		params.no = $.trim($('#searchInOrderNo').val());
		$('#listDiv').datagrid({url: "${appName}/intentrepot/listPage",queryParams:params,pageNumber:1});
	}

	var modDlg;
	function showModify(typekey,rowid){
		var url = '${appName}/intentrepot/add';
		var title = "新增入库信息";
		if(typekey == 2){
			title = "修改入库信息";
			url += "?id=" + rowid;
		}
		
		if(!modDlg){
			modDlg = $('#modDlg').dialog({
			title:title,
			id:'modDlg',
			cache: false,
			top:20,
			height:480,
			width:1000,
			closed:true,
			modal: true,
			onClose:function(){
				editRows = null;
			},
			buttons:[{
				text:'关闭',
				handler:function(){
					$(modDlg).dialog('close');
				}
			}]
		});
		}
		$(modDlg).dialog('setTitle',title);
		$(modDlg).dialog('open');
		$(modDlg).dialog('refresh', url);
	}
	function del(id){
		$.messager.confirm("删除确认","<font color='red'>确认要删除这条入库单数据吗？一旦删除将无法恢复！</font>",function(ok){
			if(ok){
				$.post('${appName}/intentrepot/delete/' + id,null,function(rtn){
					if(rtn){
						if(rtn.code == 0){
							$.messager.alert("提示信息","删除入库单成功!","info",function(){
								search();
							});
						}else{
							$.messager.alert("提示信息","删除入库单失败," + rtn.errorMsg,"info");
						}
					}else{
						$.messager.alert("Error","系统通信失败!",'error');
					}
				},'json');
			}
		});
	}
	var importDlg;
    function showImport(){
        if(!importDlg){
        	importDlg = $('#importDlg').dialog({
            title:'接收单导入',
            id:'importDlg',
            cache: false,
            height:250,
            width:400,
            closed:true,
            modal: true,
            buttons:[{
                text:'提交',
                id:'btnImportIncom',
                handler:function(){
                	$('#btnImportIncom').linkbutton("disable");
                	$('#import').submit();
                }
            }]
        });
        }
        $(importDlg).dialog('open');
        $('#btnImportIncom').linkbutton("enable");
        $(importDlg).dialog('refresh', '${appName}/intentrepot/showImport');
    }
</script>
<form id="barCodeForm" style="display:hidden" method="post" target="downloadFram"></form>
<div id="importDlg"></div>
</body>
</html>