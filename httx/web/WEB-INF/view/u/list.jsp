<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>客户列表</title>
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
        title:'客户信息列表',
        rownumbers:true,
        striped:true,
        singleSelect:true,
        idField:'instkey',
        loadMsg:'正在努力加载中，请稍候...',
        pageList:[30],
        pageSize:30,
        queryParams:{},
        pagination:true,
        fitColumns:true,
        columns:[[{checkbox:true},
            {field:'instkey',hidden:true},
            {field:'gmusername',title:'客户名称',width:100},
            {field:'coname',title:'电商平台',width:100},
            {field:'contactor',title:'联系人',width:100},
            {field:'phoneNo',title:'联系电话',width:100},
            {field:'userstatus',title:'客户状态',width:60,formatter:function(value,row,index){
                    switch(value * 1){
                    case 1:
                        return "有效";
                    case 0:
                        return "失效";
                    default:return "";
                }
            }},
            {field:'desc',title:'备注',width:100}
        ]],
        toolbar:[
            {text:'新增客户',iconCls:'icon-addUser',handler:function(){
                showModify(1);
            }},'-',
            {text:'客户信息',iconCls:'icon-editUser',handler:function(){
                showModify(2);
            }},'-',
            {text:'失效客户',iconCls:'icon-deleteUser',handler:function(){
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
</script>
</head>
<body>
<div class="easyui-panel" title="客户信息查询" border="0" data-options="iconCls:'icon-search'">
    <div><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td>&nbsp;客户名称:<input type="text" id="uu" name="gmusername" maxlength="20"></input></td>
                <td>&nbsp;客户状态:
                    <select name="userstatus" id="uuserstatus" style="width:156px">
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
<script>
    function search(){
        $('#listDiv').datagrid('loading');
        var params={};
        var fields = $('#searchForm').serializeArray();
        $.each(fields, function(i, field) {
            if($.trim(field.value) != ''){
                params[field.name] = field.value;
            }
        });    
        $('#listDiv').datagrid('options').pageNumber = 1;
        $('#listDiv').datagrid('getPager').pagination({pageNumber: 1});
        $('#listDiv').datagrid({url: "${appName}/u/listPage",queryParams:params});
    }
    var modDlg;
    function showModify(type){
        var title="修改客户";
        var url='${appName}/u/editInit';
        if(type == 1){
            title="新客客户";
        }else{
            var row = $('#listDiv').datagrid('getSelected');
            if(null !=row){
                url += "?instkey=" + row.instkey;
                title += ": "+row.gmusername;
            }else{
                $.messager.alert("提示信息","请选择要修改客户",'info');
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
                    if(!checkRequired('u','客户名称')){
                        return;
                    }
                    if(!checkRequired('coname','电商平台')){
                        return;
                    }
                    if(!checkRequired('contactor','联系人')){
                        return;
                    }
                    if(!checkRequired('phoneNo','联系电话')){
                        return;
                    }
                    if(!checkRequired('userstatus','客户状态')){
                        return;
                    }
                    var param = {};
                    param.instkey=$('#hiddenInstkey').val();
                    param.gmusername = $('#u').val();
                    param.userstatus = $('#userstatus').val();
                    param.contactor = $('#contactor').val();
                    param.phoneNo = $('#phoneNo').val();
                    param.coname = $('#coname').val();
                    param.desc = $('#desc').val();
                    var saveUrl = '${appName}/u/editSave';
                    var flag = 1;
                    if(param.instkey == ''){
                        saveUrl = '${appName}/u/add';
                        flag = 2;
                    }
                    $.ajax({
                        url: saveUrl,
                        type: 'POST',
                        dataType: 'json',
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8", 
                        timeout: 30000,
                        success: function(data){
                            if(data){
                                if(data.success){
                                    var msg = "修改";
                                    if(flag == 2){
                                        msg="新增";
                                    }
                                    $.messager.alert("提示信息",msg + "客户[" + param.gmusername + "]成功!","info",function(){
                                        $(modDlg).dialog('close');
                                        search();
                                    });
                                }else{
                                    $.messager.alert("提示信息",msg+"客户[" + param.gmusername + "]失败! " + data.errorMsg,"info");
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
             $.messager.alert("提示信息","请选择要修改客户",'info');
             return;
         }
         if(row.userstatus*1==0){
        	 $.messager.alert("提示信息","该客户已经是失效状态!",'info');
             return;
         }
        var url = '${appName}/u/delete/' + row.instkey;
        $.messager.confirm("失效确认","<font color='red'>确认要失效这个客户吗？</font>",function(ok){
            if(ok){
                $.post(url,null,function(rtn){
                    if(rtn){
                        if(rtn.code == 0){
                            $.messager.alert("提示信息","失效客户成功!","info",function(){
                                search();
                            });
                        }else{
                            $.messager.alert("提示信息","失效客户失败," + rtn.errorMsg,"info");
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