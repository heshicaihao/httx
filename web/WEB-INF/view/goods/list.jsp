<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品信息列表</title>
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
        title:'商品信息列表',
        rownumbers:true,
        striped:true,
        singleSelect:false,
        idField:'id',
        loadMsg:'正在努力加载中，请稍候...',
        pageList:[30],
        pageSize:30,
        pagination:true,
        fitColumns:true,
        columns:[[<c:if test="${loginAccount.accountType!=3 }">{checkbox:true},</c:if>
            {field:'id',hidden:true},
            {field:'appdate',title:'申请日期',width:100,formatter:function(value,row,index){
                return myformatter(new Date(value));
            }},
            {field:'usergoodscode',title:'商品编码',width:100,formatter:function(value,row,index){
                return '<a href="javascript:showModify(2,' +row.id + ');" >' + value + '</a>';
            }},
            {field:'copgno',title:'商品货号',width:100},
            {field:'gname',title:'商品名称',width:100},
            {field:'gmodel',title:'商品规格',width:100},
            {field:'decprice',title:'申报单价',width:60},
            {field:'posttariffcode',title:'行邮税号',width:60},
            //{field:'grosswt',title:'毛重',width:60},
            //{field:'netwt',title:'净重',width:60},
            {field:'posttariffname',title:'行邮税名称',width:60},
            {field:'registno',title:'海关备案号',width:60},
            {field:'ciqgoodsno',title:'商检备案号',width:60},
            {field:'active',title:'状态',width:60,formatter:function(value,row,index){
            	if(value){
            		if(value * 1 == 1){
            			return '有效';
            		}else{
            			return '失效';
            		}
            	}
            }},
            {field:'projectkey',title:'操作',width:100, formatter:function(value,row,index){
                return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:showModify(2,' +row.id + ');" ><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">修改</span><span class="l-btn-icon icon-edit">&nbsp;</span></span></a>&nbsp;<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:del(\'' + row.id + '\');"><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">失效</span><span class="l-btn-icon icon-remove">&nbsp;</span></span></a>';
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
                text: '新增商品',
                iconCls: 'icon-add',
                handler: function(){showModify(1);}
            }
        <c:if test="${loginAccount.accountType<3}">,
	        '-',
	        {
	            text:'模板下载',
	            iconCls: 'icon-edit',
	            handler: function(){
	                var url = "${appName}/goods/downloadTemplate";
	                window.open(url);
	            }
	        },
            '-',
            {
                text:'商品信息导入',
                iconCls: 'icon-edit',
                handler: function(){
                    showImport();
                }
            },
            '-',
            {
                text:'导出商品海关备案报文',
                iconCls: 'icon-edit',
                handler: function(){
                    var url = "${appName}/export/goodsHG";
                    var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                        $.messager.alert("提示信息","请选择要导出的商品",'info');
                        return;
                    }
                    var idArr = new Array();
                    for(var i = 0; i < rows.length; i++){
                        idArr.push(rows[i].id);
                    }
                    idArr.join(",");
                    url += "?ids=" + idArr.toString();
                    window.open(url);
                }
            },
            '-',
            {
                text:'导出商品商检备案报文',
                iconCls: 'icon-edit',
                handler: function(){
                    var url = "${appName}/export/goodsCheck";
                    var rows = $('#listDiv').datagrid('getSelections');
                    if(rows && rows.length == 0){
                        $.messager.alert("提示信息","请选择要导出的商品",'info');
                        return;
                    }
                    var idArr = new Array();
                    for(var i = 0; i < rows.length; i++){
                        idArr.push(rows[i].id);
                    }
                    idArr.join(",");
                    url += "?ids=" + idArr.toString();
                    window.open(url);
                }
            }
        </c:if>
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
<div class="easyui-panel" title="商品信息查询" border="0" data-options="iconCls:'icon-search'">
    <div><form id="searchForm">
        <table cellpadding="0">
            <tr>
                <td>&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input></td>
                <td>&nbsp;&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate"></input></td>
                <td>&nbsp;<input type="button" value="查询" style="width:60px" onclick="search();"/></td>
            </tr>
        </table>
        </form>
    </div>
</div>
<div id="listDiv"></div>
<div id="modDlg"></div>
<div id="selectProject"></div>
<div id="importDlg"></div>
<script>
    function search(){
        $('#listDiv').datagrid('loading');
        var params = $('#listDiv').datagrid('options').queryParams;
        params.startDate = $('#startDate').datebox('getValue');
        params.endDate = $('#endDate').datebox('getValue');
        $('#listDiv').datagrid({url: "${appName}/goods/listPage",queryParams:params,pageNumber:1});
    }

    var modDlg;
    function showModify(typekey,rowid){
        var url = '${appName}/goods/add';
        var title = "新增商品";
        if(typekey == 2){
            title = "修改商品";
            url += "?id=" + rowid;
        }
        if(!modDlg){
            modDlg = $('#modDlg').dialog({
            title:title,
            id:'modDlg',
            cache: false,
            top:20,
            height:480,
            width:700,
            closed:true,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    if(!checkSubmit()){
                        return;
                    }
                    var param = {};
                    <c:if test="${loginAccount.accountType!=3 }">
                    param.createuserid    =$('#createuserid').combobox('getValue') * 1;
                    </c:if>
                    param.id=$('#hiddenid').val();
                    param.copgno          = $('#copgno').val();
                    param.sellid          =$('#sellid').val();
                    param.goodsenname     =$('#goodsenname').val();
                    param.gname           =$('#gname').combogrid('getValue');
                    param.manufactory     =$('#manufactory').val();
                    param.country         =$('#country').combobox('getValue');
                    param.hscode          =$('#hscode').val();
                    param.curr            =$('#curr').combobox('getValue');
                    param.rmb             =$('#rmb').val();
                    param.decprice        =$('#decprice').val();
                    param.netwt           =$('#netwt').val();
                    param.grosswt         =$('#grosswt').val();
                    param.pingming        =$('#pingming').val();
                    param.brand           =$('#brand').val();
                    param.yongtu          =$('#yongtu').val();
                    param.gmodel          =$('#gmodel').val();
                    param.chengfen        =$('#chengfen').val();
                    param.networksellname =$('#networksellname').val();
                    param.hyperlink       =$('#hyperlink').val();
                    param.batchid         =$('#batchid').val();
                    param.unit            =$('#unit').combobox('getValue');
                    param.posttariffcode  =$('#posttariffcode').val();
                    param.posttariffname  =$('#posttariffname').val();
                    param.eportgoodsno    =$('#eportgoodsno').val();
                    param.registno        =$('#registno').val();
                    param.appdate         =$('#appdate').val();
                    param.appenddate      =$('#appenddate').val();
                    param.lastupdateuserid=$('#lastupdateuserid').val();
                    param.lastupdatetime  =$('#lastupdatetime').val();
                    param.gdesc           =$('#gdesc').val();
                    param.sellrmb         =$('#sellrmb').val();
                    param.ciqgoodsno=$('#ciqgoodsno').val();
                    $.ajax({
                        url: '${appName}/goods/save',
                        type: 'POST',
                        dataType: 'json',
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8",
                        timeout: 60000,
                        success: function(data){
                            if(data){
                                var t = $('#modDlg').panel('options').title;
                                var msg = "修改";
                                if(t == '新增商品'){
                                    msg = "新增";
                                }

                                if(data.success){
                                    $.messager.alert("提示信息",msg + "商品成功!","info",function(){
                                        $(modDlg).dialog('close');
                                        search();
                                    });
                                }else{
                                    $.messager.alert("提示信息",msg + "商品失败! " + data.errorMsg,"info");
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
        var fields =$('#ff').serializeArray();
        var flag = true;
        var exclude={"registno":1,"ciqgoodsno":1,"usergoodscode":1,"sellid":1,'decprice':1,'decprice2':1,'country':1,"curr":1,
        		"pingming":1,'yongtu':1,"brand":1,'chengfen':1,'batchid':1};
        var cbo = {'createuserid':1,'unit':1};
        var cboGrid = {'gname':1};
        $.each( fields, function(i, field){
            if(!exclude[field.name]){
                var lbl = $("label[for='"+field.name+"']").html();
                if(cbo[field.name]==1){
                    if($('#' + field.name).combobox('getValue') == ''){
                        $.messager.alert('提示信息',"必填项 " + lbl + " 不能为空!",'info',function(){
                        	$('#' + field.name).combobox().next('span').find('input').focus();
                        });
                        flag=false;
                        return false;
                    }
                }else if(cboGrid[field.name]==1){
                    if($('#' + field.name).combogrid('getValue') == ''){
                        $.messager.alert('提示信息',"必填项 " + lbl + " 不能为空!",'info',function(){
                            $('#' + field.name).combogrid().next('span').find('input').focus();
                        });
                        flag=false;
                        return false;
                    }
                }
                else if($.trim($('#' + field.name).val()) == ''){
                    $.messager.alert('提示信息',"必填项 " + lbl + " 不能为空!",'info',function(){
                        $('#' + field.name).focus();
                    });
                    flag=false;
                    return false;
                }
            }
        });
        return flag;
    }

    function del(id){
        $.messager.confirm("取消确认","<font color='red'>确认要失效这条商品信息吗？</font>",function(ok){
            if(ok){
                $.post('${appName}/goods/delete/' + id,null,function(rtn){
                    if(rtn){
                        if(rtn.code == 0){
                            $.messager.alert("提示信息","失效商品成功!","info",function(){
                                search();
                            });
                        }else{
                            $.messager.alert("提示信息","失效商品失败," + rtn.errorMsg,"info");
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
            title:'商品信息导入',
            id:'importDlg',
            cache: false,
            height:200,
            width:400,
            closed:true,
            modal: true,
            buttons:[{
                text:'提交',
                handler:function(){
                    $('#import').submit();
                }
            }]
        });
        }
        $(importDlg).dialog('open');
        $(importDlg).dialog('refresh', '${appName}/goods/showImport');
    }
    
    function filterGName(q, row){
        var text = row.gname;
        if(q.length > 0){
        	q = q.toUpperCase();
            var qArr = new Array();
            for(var i = 0; i < q.length; i++){
                qArr.push(q.charCodeAt(i));
            }
            qArr.join(',');
            q = qArr.toString();
            var textArr = new Array();
            text = text.toUpperCase();
            for(var i = 0; i < text.length; i++){
                textArr.push(text.charCodeAt(i));
            }
            textArr.join(',');
            text = textArr.toString();
        }
        return text.indexOf(q) == 0;
    }
</script>
</body>
</html>