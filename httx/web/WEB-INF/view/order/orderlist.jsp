<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单信息列表</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css?r=132546546554" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
body{margin:0px;padding:0px}
form{margin:0px;padding:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652142"></script>
<script type="text/javascript">
var queryParam;
$(function(){
    $('#listDiv').datagrid({
    	title:'订单',
    	rownumbers:true,
    	striped:true,
    	singleSelect:false,
    	idField:'orderid',
    	loadMsg:'正在努力加载中，请稍候...',
    	pageList:[30,50,100],
    	rows:30,
    	pagination:true,
    	fitColumns:true,
        columns:[[{checkbox:true},
			{field:'orderid',title:'订单编号',width:90,formatter:function(value,row,index){
				 	return '<a  href="javascript:showorderdetail(\'' +row.orderid + '\');" >'+row.orderid+'</a>';
				}
			},
	        {field:'note',title:'备注',width:100},
			{field:'entrecordno',title:'电子订单编号',width:90},
	        {field:'companyName',title:'公司',width:120},
            {field:'customerName',title:'客户',width:120},
	        {field:'ordername',title:'收件人姓名',width:80},
	        {field:'orderdate',title:'录入日期',width:80,formatter:function(value,row,index){
	        	return myformatter(new Date(value));
	        }},
	        {field:'firstcreatename',title:'创建人',width:80},
	        {field:'status',title:'订单状态',width:60,formatter:function(value,row,index){
	        if(value =="0" || value == null)
	        {
	         	return '清关中';
	        }else if(value == "1")
	        {
	        	return '放行';
	        }else if(value == "2")
	        {
	        	return '出库';
	        }
	        else
	        {
	        	return '发货';
	        }
	        }},
	        {field:'pickgoodsno',title:'拣货单号',width:100},
			{field:'ewaysnum',title:'运单编号',width:100,formatter:function(value,row,index){
				if(value=="" || value == null)
				{
				 	return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:addewaybill(\'' +row.orderid + '\');" ><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">输入运单信息</span><span class="l-btn-icon icon-edit">&nbsp;</span></span></a>';
				}else
				{
					return '<a href="#" onclick="showewaybill(\''+ value +'\',\''+row.status+'\');" >'+value+'</a>';
				}

	        }},
			 {field:'null',title:'操作',width:50, formatter:function(value,row,index){
			 if(row.status == "2")
			 {
			 	  return '';			 	
			 }else
			 {
			 	  return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:showModify(2,\'' +row.orderid + '\');" ><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">修改</span><span class="l-btn-icon icon-edit">&nbsp;</span></span></a>&nbsp; '; 	
			 }
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
		 		text: '新增订单',
		 		iconCls: 'icon-add',
		 		handler: function(){showModify(1);}
		 	},		 			 			 	
		 	'-',
		 	{
		 		text:'模板下载',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/order/downloadOrderTemplate";
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'导入订单',
		 		iconCls: 'icon-add',
		 		handler: function(){showimport();}
		 	},
		 	'-',
		 	{
		 		text:'生成电子订单报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/order/exportOrderHG";
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要导出的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
		 			url += "?ids=" + idArr.toString();
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'生成电子运单报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/ewaybill/exportTransportHG";
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要导出的订单",'info');
						return;
					}

					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 				if(!rows[i].ewaysnum){
		 					$.messager.alert("提示信息","请先给订单" + rows[i].orderid + "输入运单信息",'info');
		 					return;
		 				}
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
		 			url += "?ids=" + idArr.toString();
	 				window.open(url);
		 		}
		 	},'-',
		 	{
		 		text:'生成拣货单',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/order/exportPickGoods";
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要导出的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 			/* if(rows[i].status == "3" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已发货",'info');
		 					return;
		 				} */
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
		 			url += "?ids=" + idArr.toString();
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'生成海关进境电子清单报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/order/exportImportlistHG";
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要导出的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 				if(!rows[i].ewaysnum){
		 					$.messager.alert("提示信息","请先给订单" + rows[i].orderid + "输入运单信息",'info');
		 					return;
		 				}
		 				
		 				if(rows[i].status == "3" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已发货",'info');
		 					return;
		 				}
		 				
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
		 			url += "?ids=" + idArr.toString();
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'生成商检进境电子清单报文',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var url = "${appName}/order/exportImportlistCheck";
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要导出的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 				if(!rows[i].ewaysnum){
		 					$.messager.alert("提示信息","请先给订单" + rows[i].orderid + "输入运单信息",'info');
		 					return;
		 				}
		 				if(rows[i].status == "3" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已发货",'info');
		 					return;
		 				}
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
		 			url += "?ids=" + idArr.toString();
	 				window.open(url);
		 		}
		 	},
		 	'-',
		 	{
		 		text:'出库',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要出库的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){

		 				if(rows[i].status == "1" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已出库并放行",'info');
		 					return;
		 				}
		 						 			
		 				if(rows[i].status == "2" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已出库",'info');
		 					return;
		 				}
		 				
		 				if(rows[i].status == "3" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已发货",'info');
		 					return;
		 				}
		 			   if(!rows[i].pickgoodsno){
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "还未生成拣货单",'info');
		 					return;
		 				}
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
	 				beanReleasedClose(idArr.toString());
		 		}
		 	},
		 	'-',
		 	{
		 		text:'放行',
		 		iconCls: 'icon-edit',
		 		handler: function(){
		 			var rows = $('#listDiv').datagrid('getSelections');
					if(rows && rows.length == 0){
						$.messager.alert("提示信息","请选择要放行的订单",'info');
						return;
					}
					var idArr = new Array();
		 			for(var i = 0; i < rows.length; i++){
		 				if(rows[i].status == "3" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已发货",'info');
		 					return;
		 				}else if(rows[i].status != "2" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "未出库",'info');
		 					return;
		 				}else if(rows[i].status == "1" )
		 				{
		 					$.messager.alert("提示信息","订单" + rows[i].orderid + "已放行",'info');
		 					return;
		 				}
		 				idArr.push(rows[i].orderid);
		 			}
		 			idArr.join(",");
	 				beanReleased(idArr.toString());
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
<div class="easyui-panel" title="订单信息查询" border="0" data-options="iconCls:'icon-search'">
	<div><form id="searchForm">
    	<table cellpadding="0">
    		<tr>
    			<td>&nbsp;拣货单号:<input type="text" id="pickgoodsnoqr" style="width:90px" name="pickgoodsnoqr"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;订单编号:<input type="text" id="orderidqr" style="width:90px" name="orderidqr"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;电子订单编号:<input type="text" id="entrecordnoqr" style="width:90px" name="entrecordnoqr"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;运单号:<input type="text" id="ewaysnumqr" style="width:90px" name="ewaysnumqr"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;创建人:<input type="text" id="firstcreatename" style="width:90px" name="firstcreatename"></input>&nbsp;&nbsp;&nbsp;</td>
    		</tr>
    		<tr>
    			<td>&nbsp;开始日期:<input type="text" id="startDate" style="width:150px" name="startDate"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;结束日期:<input type="text" id="endDate" style="width:150px" name="endDate"></input>&nbsp;&nbsp;&nbsp;</td>
    			<td>&nbsp;订单状态:        
    			<select name="statusqr" id="statusqr" style="width:65px">
    					<option value="" >全 部</option>
    					<option value="0" >清关中</option>
    					<option value="1" >放行</option>
    					<option value="2" >出库</option>
    					<option value="3" >发货</option>
    				</select>
    				&nbsp;
    			</td>
    			
    			<td>是否已制拣货单:        
    			<select name="pickgoodsnoqr2" id="pickgoodsnoqr2" style="width:65px">
    					<option value="" >全 部</option>
    					<option value="0" >是</option>
    					<option value="1" >否</option>
    				</select>
    				&nbsp;
    			</td>

    		<td>
    		客户:
           <select id="customerUser" name="customerUser"  class="easyui-combobox" style="width:120px">
            <option value="">请选择</option>
            <c:forEach items="${customerList}" var="customer">
            <option value="${customer.instkey}">${customer.gmusername}</option>
            </c:forEach>
           </select>
           </td>
    			<td><input type="button" value="查询" style="width:60px" onclick="search();"/>&nbsp;&nbsp;&nbsp;</td>
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

<script>
	function search(){
		$('#listDiv').datagrid('loading');
		var params = $('#listDiv').datagrid('options').queryParams;
		params.startDateStr = $('#startDate').datebox('getValue');
		params.endDateStr = $('#endDate').datebox('getValue');
		params.pickgoodsno = $('#pickgoodsnoqr').val();
		params.status = $('#statusqr').val();
		params.orderid = $('#orderidqr').val();
		params.entrecordno = $('#entrecordnoqr').val();
		params.ewaysnum = $('#ewaysnumqr').val();
		params.entrecordname = $('#customerUser').combobox('getValue');
		params.firstcreatename = $('#firstcreatename').val();
		params.unloading = $('#pickgoodsnoqr2').val();
		$('#listDiv').datagrid({url: "${appName}/order/listPage",queryParams:params,pageNumber:1});
	}

	
	var modDlg;
	function showModify(typekey,rowid){
		var url = '${appName}/order/add';
		var title = "新增订单";
		if(typekey == 2){
			title = "修改订单";
			url += "?id=" + rowid;
		}
		if(!modDlg){
			modDlg = $('#modDlg').dialog({
			title:title,
			id:'modDlg',
			cache: false,
			top:50,
			height:440,
			width:958,
			closed:true,
			modal: true,
			buttons:[{
				text:'关闭',
				handler:function(){$(modDlg).dialog('close');}
			}]
		});
		}
		$(modDlg).dialog('setTitle',title);
		$(modDlg).dialog('open');
		$(modDlg).dialog('refresh', url);
	}

	var importDlg;
	function showimport(){
        if(!importDlg){
        	importDlg = $('#importDlg').dialog({
            title:'订单单导入',
            id:'importDlg',
            cache: false,
            height:260,
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
        $(importDlg).dialog('refresh', '${appName}/order/importinit');
    }

	
	function checkSubmit(){

		/* var date = $('#chargedate').datebox("getValue");
		if(date == ''){
			$.messager.alert("提示信息","请输入日期","info",function(){$('#chargedate').focus();});
			return false;
		} */
		

		return true;
	}
	
	function del(id){
		$.messager.confirm("取消确认","<font color='red'>确认要取消这条订单吗？一旦取消将无法恢复！</font>",function(ok){
			if(ok){
				$.post('${appName}/order/cancel/' + id,null,function(rtn){
					if(rtn){
						if(rtn.code == 0){
							$.messager.alert("提示信息","取消订单成功!","info",function(){
								search();
							});
						}else{
							$.messager.alert("提示信息","取消订单失败," + rtn.errorMsg,"info");
						}
					}else{
						$.messager.alert("Error","系统通信失败!",'error');
					}
				},'json');
			}
		});
	}
	var detailDlg;
	function showorderdetail(orderid){
	   var url = '${appName}/order/showdetail?orderid='+ orderid;
		var title = "订单详情";
		if(!detailDlg){
			detailDlg = $('#detailDlg').dialog({
			title:title,
			id:'detailDlg',
			cache: false,
			top:50,
			height:440,
			width:850,
			closed:true,
			modal: true,
			buttons:[{
				text:'关闭',
				handler:function(){
					$(detailDlg).dialog('close');
				}
			}]
		});
		}
		$(detailDlg).dialog('setTitle',title);
		$(detailDlg).dialog('open');
		$(detailDlg).dialog('refresh', url);

	}

	var ewaybillDlg;
	function showewaybill(waybillno,status){
		var url = '${appName}/ewaybill/showdetail?waybillno='+ waybillno+'&status='+status;
		var title = "运单详情";
		if(!ewaybillDlg){
			ewaybillDlg = $('#ewaybillDlg').dialog({
			title:title,
			id:'ewaybillDlg',
			cache: false,
			top:50,
			height:250,
			width:380,
			closed:true,
			modal: true,
			buttons:[{
				text:'保存',
				handler:function(){
					if(!checkSubmit()){
						return;
					}
		if(!checkRequired('waybillno','运单编号') || !checkLength('waybillno','运单编号',0,30)){
			return;
		}					
		if(!checkRequired('freight','运费') || !checkLength('freight','运费',0,11) || !check2Digit('freight','运费')){
			return;
		}					
		if(!checkRequired('valuationfee','保价费') || !checkLength('valuationfee','保价费',0,11)|| !check2Digit('valuationfee','保价费')){
			return;
		}					
		if(!checkRequired('tax','税费') || !checkLength('tax','税费',0,11)|| !check2Digit('tax','税费')){
			return;
		}					
		if(!checkLength('noticeno','物流公司',0,130)){
			return;
		}					
			var param = {};
			param.orderid = $('#orderid').val();
			param.waybillno = $('#waybillno').val();
			param.freight = $('#freight').val();
			param.valuationfee = $('#valuationfee').val();
			param.noticeno = $('#noticeno').val();
			param.tax = $('#tax').val();
			param.id = $('#id').val();
					$.ajax({
						url: '${appName}/ewaybill/save',
						type: 'POST',
						dataType: 'json',
						data:JSON.stringify(param),
						contentType: "application/json; charset=utf-8", 
						timeout: 60000,
						success: function(data){
							if(data){
								if(data.success){
									$.messager.alert("提示信息", "修改运单成功!","info",function(){
										$(ewaybillDlg).dialog('close');
										search();
									});
								}else{
									$.messager.alert("提示信息", "修改运单失败! " + data.errorMsg,"info");
								}
							}else{
								$.messager.alert("Error","系统通信失败!",'error');
							}
						}
					});
				}
			},{
				text:'取消',
				handler:function(){$(ewaybillDlg).dialog('close');}
			}]
		});
		}
		$(ewaybillDlg).dialog('setTitle',title);
		$(ewaybillDlg).dialog('open');
		$(ewaybillDlg).dialog('refresh', url);
	}

	var addewaybillDlg;
	function addewaybill(orderid){
		var url = '${appName}/ewaybill/add?orderid='+ orderid;
		var title = "新增运单";
		if(!addewaybillDlg){
			addewaybillDlg = $('#addewaybillDlg').dialog({
			title:title,
			id:'addewaybillDlg',
			cache: false,
			top:50,
			height:250,
			width:380,
			closed:true,
			modal: true,
			buttons:[{
				text:'保存',
				handler:function(){
					if(!checkSubmit()){
						return;
					}
		if(!checkRequired('waybillno','运单编号') || !checkLength('waybillno','运单编号',0,30)){
			return;
		}					
		if(!checkRequired('freight','运费') || !checkLength('freight','运费',0,11) || !check2Digit('freight','运费')){
			return;
		}					
		if(!checkRequired('valuationfee','保价费') || !checkLength('valuationfee','保价费',0,11)|| !check2Digit('valuationfee','保价费')){
			return;
		}					
		if(!checkRequired('tax','税费') || !checkLength('tax','税费',0,11)|| !check2Digit('tax','税费')){
			return;
		}					
		if(!checkLength('noticeno','物流公司',0,130)){
			return;
		}					
			var param = {};
			param.orderid = $('#orderid').val();
			param.waybillno = $('#waybillno').val();
			param.freight = $('#freight').val();
			param.valuationfee = $('#valuationfee').val();
			param.noticeno = $('#noticeno').val();
			param.tax = $('#tax').val();
					$.ajax({
						url: '${appName}/ewaybill/save',
						type: 'POST',
						dataType: 'json',
						data:JSON.stringify(param),
						contentType: "application/json; charset=utf-8", 
						timeout: 60000,
						success: function(data){
							if(data){
								if(data.success){
									$.messager.alert("提示信息", "生成运单成功!","info",function(){
										$(addewaybillDlg).dialog('close');
										search();
									});
								}else{
									$.messager.alert("提示信息", "生成运单失败! " + data.errorMsg,"info");
								}
							}else{
								$.messager.alert("Error","系统通信失败!",'error');
							}
						}
					});
				}
			},{
				text:'取消',
				handler:function(){$(addewaybillDlg).dialog('close');}
			}]
		});
		}
		$(addewaybillDlg).dialog('setTitle',title);
		$(addewaybillDlg).dialog('open');
		$(addewaybillDlg).dialog('refresh', url);
	}
	
	function updateOrderStatus(orderids)
	{
		$.messager.confirm("取消确认","确认放行吗？",function(ok){
			if(ok){
				$.post('${appName}/order/updateOrderStatus?ids=' + orderids,null,function(rtn){
					if(rtn){
						if(rtn.code == 0){
							$.messager.alert("提示信息","订单放行成功!","info",function(){
								search();
							});
						}else{
							$.messager.alert("提示信息","订单放行失败," + rtn.errorMsg,"info");
						}
					}else{
						$.messager.alert("Error","系统通信失败!",'error');
					}
				},'json');
			}
		});
	}
	
	function beanReleased(orderids)
	{
		$.messager.confirm("取消确认","确认放行吗？",function(ok){
			if(ok){
				$.post('${appName}/order/updateOrderStatus?ids=' + orderids,null,function(rtn){
					if(rtn){
						if(rtn.code == 0){
							$.messager.alert("提示信息","订单放行成功!","info",function(){
								search();
							});
						}else{
							$.messager.alert("提示信息","订单放行失败," + rtn.errorMsg,"info");
						}
					}else{
						$.messager.alert("Error","系统通信失败!",'error');
					}
				},'json');
			}
		});
	}
	
	
	function beanReleasedClose(orderids)
	{
		$.messager.confirm("取消确认","确认出库吗？",function(ok){
			if(ok){
				$.post('${appName}/order/released?ids=' + orderids,null,function(rtn){
					if(rtn){
						if(rtn.code == 0){
							$.messager.alert("提示信息","订单出库成功!","info",function(){
								search();
							});
						}else{
							$.messager.alert("提示信息","订单出库失败," + rtn.errorMsg,"info");
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