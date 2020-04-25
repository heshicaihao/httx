<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css?r=132546546554" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
body{margin:0px;padding:0px}
form{margin:0px;padding:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652142"></script>
<script type="text/javascript">
$(function(){
    $('#listDiv').datagrid({
        title:'用户信息列表',
        rownumbers:true,
        striped:true,
        singleSelect:true,
        idField:'id',
        loadMsg:'正在努力加载中，请稍候...',
        pageList:[30],
        pageSize:30,
        queryParams:{},
        pagination:true,
        fitColumns:true,
        columns:[[{checkbox:true},
            {field:'id',hidden:true},
            {field:'loginName',title:'用户名称',width:100},
            {field:'loginPWD',title:'密码',width:100},
            {field:'accountDesc',title:'备注',width:100},
            {field:'accountType',title:'用户类型',width:60,formatter:function(value,row,index){
                switch(value * 1){
                    case 1:
                        return '管理员';
                    case 2:
                        return "业务员";
                    case 3:
                        return "客户";
                    default:return "";
                }
            }},
            {field:'status',title:'用户状态',width:60,formatter:function(value,row,index){
                    switch(value * 1){
                    case 1:
                        return "有效";
                    case 0:
                        return "失效";
                    default:return "";
                }
            }},
            {field:'custName',title:'客户名称',width:100},
            {field:'lastLoginDate',title:'最近登录时间',width:140, formatter:function(value,row,index){
                if(value){
                    return myformatter(new Date(value));
                }
                return value;
            }}
        ]],
        toolbar:[
            {text:'新增用户',iconCls:'icon-addAccount',handler:function(){
                   showModify(1);
            }},'-',
            {text:'用户信息',iconCls:'icon-editAccount',handler:function(){
                showModify(2);
            }},'-',
            {text:'失效用户',iconCls:'icon-delAccount',handler:function(){
                del();
            }}
        ],
        onLoadSuccess:function(data){
             $('#listDiv').datagrid('loaded');
             $('#listDiv').datagrid('clearSelections');
        },
        onLoadError:function(data){
            $('#listDiv').datagrid('loaded');
       }
    });
});
function cobFilter(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].indexOf(q) >= 0;
}
function search(){
    $('#listDiv').datagrid('loading');
    var params = {};
    var fields = $('#searchForm').serializeArray();
    $.each(fields, function(i, field) {
        if($.trim(field.value) != ''){
            params[field.name] = field.value;
        }
    }); 
    $('#listDiv').datagrid('options').pageNumber = 1;
    $('#listDiv').datagrid('getPager').pagination({pageNumber: 1});alert(JSON.stringify(params));
    $('#listDiv').datagrid({url: "${appName}/account/listPage",queryParams:params});
}
var modDlg;
function showModify(type){
    var title="修改用户";
    var url='${appName}/account/editInit';
    if(type == 1){
        title="新增用户";
    }else{
        var row = $('#listDiv').datagrid('getSelected');
        if(null !=row){
            url += "?id=" + row.id;
            title += ": "+row.loginName;
        }else{
            $.messager.alert("提示信息","请选择要修改用户",'info');
            return;
        }
    }
    if(!modDlg){
        modDlg = $('#modDlg').dialog({
        title: title,
        id:'modDlg',
        cache: false,
        top:50,
        height:280,
        width:500,
        closed:true,
        modal: true,
        buttons:[{
            text:'保存',
            handler:function(){
                if(!checkRequired('u','用户名称') || !checkLength('u','用户名称',6,20) || !checkLetterDigit('u','用户名称')){
                    return;
                }
                if(!checkRequired('p','密码') || !checkLength('p','密码',6,20)){
                    return;
                }
                if(!checkRequired('accountType','用户类型')){
                    return;
                }
                var param = {};
                var flag = 2;
                if($('#hiddenId').val() != ''){
                    flag = 1;
                    param.id=$('#hiddenId').val();
                    param.status = $('#status').val();
                }else{
                    param.accountType = $('#accountType').val()*1;
                    param.loginName = $('#u').val();
                }
                if($('#accountType').val()*1 == 3){
                	if($('#custId').combobox('getValue') == ''){
                		$.messager.alert('提示信息','请选择客户!','info',function(){
                			$('#custId').combobox().next('span').find('input').focus();
                		});
                	}
                	param.custId = $('#custId').combobox('getValue') * 1;
                }
                param.loginPWD = $('#p').val();
                param.accountDesc = $('#accountDesc').val();
                var saveUrl = '${appName}/account/save';
                $.ajax({
                    url: saveUrl,
                    type: 'POST',
                    dataType: 'json',
                    data:JSON.stringify(param),
                    contentType: "application/json", 
                    timeout: 30000,
                    success: function(data){
                        if(data){
                            if(data.success){
                                var msg = "修改";
                                if(flag == 2){
                                    msg="新增";
                                }
                                $.messager.alert("提示信息",msg + "用户[" + $('#u').val() + "]成功!","info",function(){
                                    $(modDlg).dialog('close');
                                    search();
                                });
                            }else{
                                $.messager.alert("提示信息",msg+"用户[" + $('#u').val() + "]失败! " + data.errorMsg,"info");
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
    $(modDlg).dialog('open');
    $(modDlg).dialog('setTitle',title);
    $(modDlg).dialog('refresh', url);
}

function del(){
	 var row = $('#listDiv').datagrid('getSelected');
     if(null ==row){
         $.messager.alert("提示信息","请选择要修改用户",'info');
         return;
     }
     if(row.status*1==0){
         $.messager.alert("提示信息","该用户已经是失效状态!",'info');
         return;
     }
     var url = '${appName}/account/delete/' +row.id;
    $.messager.confirm("失效确认","<font color='red'>确认要失效这个用户 [" + row.loginName+"] 吗？</font>",function(ok){
        if(ok){
            $.post(url,null,function(rtn){
                if(rtn){
                    if(rtn.code == 0){
                        $.messager.alert("提示信息","失效用户成功!","info",function(){
                            search();
                        });
                    }else{
                        $.messager.alert("提示信息","失效用户失败," + rtn.errorMsg,"info");
                    }
                }else{
                    $.messager.alert("Error","系统通信失败!",'error');
                }
            },'json');
        }
    });
}

function enableCustomer(value){
	var disabled = "enable";
	if(value * 1 != 3){
		disabled = "disable";
		$('#custId').combobox('reset');
	}
	$('#custId').combobox(disabled);
}
</script>
</head>
<body>
<div class="easyui-panel" title="用户信息查询" border="0" data-options="iconCls:'icon-search'">
    <div><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td>&nbsp;用户名称:<input type="text" id="uu" name="loginName" maxlength="20"></input></td>
                <td>&nbsp;用户类型:
                    <select name="accountType" id="uusertype" style="width:156px">
                        <option value="" selected>所有</option>
                        <option value="2">业务员</option>
                        <option value="3">客户</option>
                    </select>
                </td>
                <td>&nbsp;用户状态:
                    <select name="status" id="uuserstatus" style="width:156px">
                        <option value="" selected>所有</option>
                        <option value="1" >有效</option>
                        <option value="0">失效</option>
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
</body>
</html>