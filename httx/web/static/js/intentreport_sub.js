$(function(){
	$('#intEntrepotGoodsDetails').datagrid({
		title:'商品列表',
		iconCls:'icon-edit',  
		width:$('#hdiv').width(), 
		border:false,
		height:320,
		singleSelect:false,rownumbers:true,
		columns:[
		[
		 	{checkbox:true},
		 	{field:'id',hidden:true},
			{field:'usergoodscode',title:'商品编码',width:60},
			{field:'batchNo',title:'批次号',width:60},
			{field:'copgno',title:'商品货号',width:80},
			{field:'gname',title:'商品描述',width:100},
			{field:'gqty',title:'数量',width:60},
			{field:'actNo',title:'实际入库数量',width:80,editor:{type:'numberbox'}},
			{field:'unit_name',title:'计量单位',width:60},
			{field:'decprice',title:'单价',width:40},
			{field:'curr',title:'币制',width:40,formatter:function(){
				return "RMB";
			}},
			{field:'decltotal',title:'总价',width:40},
			{field:'grosswt',title:'毛重',width:40},
			{field:'netwt',title:'净重',width:40},
			{field:'note',title:'备注',width:60},
			{field:'barCode',title:'条码',width:80,formatter:function(value,row,index){
				if(!value){
					return '';
				}
				var imgUrl = $('#appName').val() + "/common/barCode?msg=" + value;
				return '<a href="javascript:downloadBarCode(\''+imgUrl + '\')">' + value+'</a>';
			}},
			{field:'projectkey',title:'操作',width:60, formatter:function(value,row,index){
				
				return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:delDetails(\'' + row.id + '\');"><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">删除</span><span class="l-btn-icon icon-remove">&nbsp;</span></span></a>';
			}}
		]],
		onLoadSuccess:function(data){
			$('#intEntrepotGoodsDetails').datagrid('loaded');
			$('#intEntrepotGoodsDetails').datagrid('clearSelections');
		},
		onLoadError:function(data){
			$('#intEntrepotGoodsDetails').datagrid('loaded');
		},
		toolbar:[{
			text: '添加商品',
			iconCls: 'icon-add',
			id:'addGoodsBtn',
			handler: function(){showSelectGoods();}
		},'-',{
			text: '入库',
			iconCls: 'icon-ok',
			id:'addGoodsBtn',
			handler: function(){
				confirmIn();
			}
		}]
	});
	if($('#hiddenid').val() != ''){
		$('#intEntrepotGoodsDetails').datagrid('loading');
		$('#intEntrepotGoodsDetails').datagrid({url: $('#appName').val()+"/intentrepot/listGoods?id=" + $('#hiddenid').val()});
	}else{
		$('#addGoodsBtn').linkbutton("disable");
	}
});
var confirmInDlg;
var editRows;
function confirmIn(){
	var rows = $('#intEntrepotGoodsDetails').datagrid('getSelections');
	if(!rows || rows.length == 0){
		$.messager.alert("提示信息","请选择商品进行入库",'info');
		return;
	}
	var rowIndex = -1;
	if(!editRows){
		editRows = new Array();
		for(var i = 0; i < rows.length; i++){
			rowIndex = $('#intEntrepotGoodsDetails').datagrid('getRowIndex',rows[i]);
			if(rows[i].actNo > 0){
				$('#intEntrepotGoodsDetails').datagrid('unselectRow',rowIndex);
			}else{
				$('#intEntrepotGoodsDetails').datagrid('beginEdit',rowIndex);
				var ed = $('#intEntrepotGoodsDetails').datagrid('getEditor', {index:rowIndex,field:'actNo'});
				$(ed.target).numberbox('setValue', rows[i].gqty);
				editRows.push(rowIndex);
			}
		}
	}else{
		if(editRows.length != rows.length){
			$.messager.alert('提示信息','钩选行数量不匹配! 请关闭后再重新入库','info');
			return;
		}else{
			var param = {};
			var ids = [];
			var actNoArr = [];
			var usergoodsArr = [];
			for(var i = 0; i < rows.length; i++){
				$('#intEntrepotGoodsDetails').datagrid('endEdit',editRows[i]);
				ids.push(rows[i].id);
				actNoArr.push(rows[i].actNo);
				usergoodsArr.push(rows[i].usergoodscode);
			}
			ids.join(',');
			actNoArr.join(',');
			usergoodsArr.join(',');
			param.idsArr = ids.toString();
			param.actNoArr = actNoArr.toString();
			param.usergoodsArr = usergoodsArr.toString();
			param.hiddenid = $('#hiddenid').val() * 1;
			$.ajax({
				url: $('#appName').val() + '/intentrepot/saveActNo',
				type: 'POST',
				dataType: 'json',
				data:JSON.stringify(param),
				contentType: "application/json; charset=utf-8", 
				timeout: 60000,
				success: function(data){
					if(data){
						if(data.success){
							$.messager.alert("提示信息","入库成功!","info",function(){
								$('#intEntrepotGoodsDetails').datagrid('acceptChanges');
								$('#intEntrepotGoodsDetails').datagrid('loading');
								$('#intEntrepotGoodsDetails').datagrid({url: $('#appName').val()+"/intentrepot/listGoods?id=" + $('#hiddenid').val()});
								$('#txtActNo').val('');
								editRows=null;
								$(confirmInDlg).dialog('close');
							});
						}else{
							$.messager.alert("提示信息","入库失败! " + data.errorMsg,"info");
							$('#intEntrepotGoodsDetails').datagrid('rejectChanges');
							editRows=null;
						}
					}else{
						$.messager.alert("Error","系统通信失败!",'error');
						editRows=null;
					}
				}
			});
		}
	}
	/*
	var title = '确认入库:' + row.usergoodscode;
	if(!confirmInDlg){
		confirmInDlg=$('#confirmInDlg').dialog({
			title:title,
			id:'confirmInDlg',
			cache: false,
			iconCls:'icon-save',
			top:20,
			height:184,
			width:400,
			closed:true,
			modal: true,
			content:'<div style="line-height:22px;padding:4px;text-align:center"><label for="txtActNo">请输入实际入库数量</label>:<br/><input type="text" style="width:130px" id="txtActNo"/></div>',
			buttons:[
			    {text:"确认",handler:function(){
			    	var selectedRow = $('#intEntrepotGoodsDetails').datagrid('getSelected');
			    	if(!selectedRow){
			    		$.messager.alert("提示信息","请选择商品进行入库",'info');
			    		return;
			    	}
			    	var r = $('#txtActNo').val();
			    	var p = new RegExp(/^\d+$/);
					if(!/^\d+$/.test(r)){
						$.messager.alert("提示信息","实际入库数必须是整型数字",'info',function(){
							confirmIn();
						});
					}else{
						var param = {};
						param.id=selectedRow.id;
						param.actNo=r*1;
						param.usergoodscode=selectedRow.usergoodscode;
						$.ajax({
							url: $('#appName').val() + '/intentrepot/saveActNo',
							type: 'POST',
							dataType: 'json',
							data:JSON.stringify(param),
							contentType: "application/json; charset=utf-8", 
							timeout: 60000,
							success: function(data){
								if(data){
									if(data.success){
										$.messager.alert("提示信息","入库成功!","info",function(){
											$('#intEntrepotGoodsDetails').datagrid('loading');
											$('#intEntrepotGoodsDetails').datagrid({url: $('#appName').val()+"/intentrepot/listGoods?id=" + $('#hiddenid').val()});
											$('#txtActNo').val('');
											$(confirmInDlg).dialog('close');
										});
									}else{
										$.messager.alert("提示信息","入库失败! " + data.errorMsg,"info");
									}
								}else{
									$.messager.alert("Error","系统通信失败!",'error');
								}
							}
						});
					}
				}},
			    {text:"取消",handler:function(){
			    	$('#txtActNo').val('');
					$(confirmInDlg).dialog('close');
				}}
			]
		});
	}
	$(confirmInDlg).dialog('setTitle',title);
	$(confirmInDlg).dialog('open');
	$('#txtActNo').val(row.gqty);*/
}

var selectGoodsDlg;
function showSelectGoods(){
	var userKey = $('#custidSelection').val();
	if(!userKey){
		$.messager.alert("提示信息","请先选择用户!",'info');
		return;
	}
	var companyId = $('#companyidSelection').val();
	if(!companyId){
		$.messager.alert("提示信息","请先选择公司!",'info');
		return;
	}
	if(!selectGoodsDlg){
		selectGoodsDlg = $('#selectGoodsDlg').dialog({
			title:'选择入库商品',
			id:'selectGoodsDlg',
			cache: false,
			top:20,
			height:184,
			width:400,
			closed:true,
			modal: true,
			buttons:[
				{text:"确定",handler:function(){
					var addGoodsId = $('#addGoodsId').combobox('getValue');
					if(!addGoodsId || addGoodsId == ''){
						$.messager.alert("提示信息",'请选择要入库的商品!','info');
						return;
					}
					if(!checkRequired('gqty','数量') || !checkInt('gqty','数量')){
						return;
					}
					var param={};
					
					param.entrepotid=$('#hiddenid').val();
					param.goodsid=addGoodsId;
					param.gqty=$('#gqty').val() * 1;
					param.note = $('#goodsnote').val();
					$.ajax({
						url: $('#appName').val() + '/intentrepot/saveDetails',
						type: 'POST',
						dataType: 'json',
						data:JSON.stringify(param),
						contentType: "application/json; charset=utf-8", 
						timeout: 60000,
						success: function(data){
							if(data){
								if(data.success){
									$.messager.alert("提示信息","添加成功!","info",function(){
										$(selectGoodsDlg).dialog('close');
										$('#intEntrepotGoodsDetails').datagrid('loading');
										$('#intEntrepotGoodsDetails').datagrid({url: $('#appName').val()+"/intentrepot/listGoods?id=" + $('#hiddenid').val()});
									});
								}else{
									$.messager.alert("提示信息","添加失败! " + data.errorMsg,"info");
								}
							}else{
								$.messager.alert("Error","系统通信失败!",'error');
							}
						}
					});
				}},
				{text:"取消",handler:function(){
					$(selectGoodsDlg).dialog('close');
				}}
			]
		});
	}
	$(selectGoodsDlg).dialog('open');
	$(selectGoodsDlg).dialog('refresh', $('#appName').val() + "/intentrepot/showSelectGoods?userKey="+userKey);
}

function createIntentRepot(){
	var userKey = $('#custidSelection').val();
	if(!userKey){
		$.messager.alert("提示信息","请先选择用户!",'info');
		return;
	}
	var companyId = $('#companyidSelection').val();
	if(!companyId){
		$.messager.alert("提示信息","请先选择公司!",'info');
		return;
	}
	var params={};
	params.companyid=companyId*1;
	params.custid = userKey*1;
	params.remark = $('#remark').val();
	$.ajax({
		url: $('#appName').val()+'/intentrepot/save',
		type: 'POST',
		dataType: 'json',
		data:JSON.stringify(params),
		contentType: "application/json; charset=utf-8",
		timeout: 60000,
		success: function(data){
			if(data){
				if(data.success){
					$.messager.alert("提示信息","创建入库单成功，请添加入库商品信息","info",function(){
						$('#createIntentRepotBtn').hide();
						$('#hiddenid').val(data.rtnKey);
						$('#addGoodsBtn').linkbutton("enable");
						$('#remark').attr("disabled",true);
						$('#custidSelection').attr("disabled",true);
						$('#companyidSelection').attr("disabled",true);
						search();
					});
				}else{
					$.messager.alert("提示信息","创建入库单失败! " + data.errorMsg,"info");
				}
			}else{
				$.messager.alert("Error","系统通信失败!",'error');
			}
		}
	});
}

function delDetails(id){
	var row = $('#intEntrepotGoodsDetails').datagrid('getSelected');
	if(!row){
		return;
	}else{
		if(row.actNo*1 > 0){
			$.messager.alert("提示信息","该商品[" + row.usergoodscode + "]已经入库，不能删除!","info");
			return;
		}
	}
	$.messager.confirm("删除确认","<font color='red'>确认要删除这条入库商品数据吗？一旦删除将无法恢复！</font>",function(ok){
		if(ok){
			$.post($('#appName').val() + '/intentrepot/deleteDetails/' + id,null,function(rtn){
				if(rtn){
					if(rtn.code == 0){
						$.messager.alert("提示信息","删除入库商品信息成功!","info",function(){
							$('#intEntrepotGoodsDetails').datagrid('loading');
							$('#intEntrepotGoodsDetails').datagrid({url: $('#appName').val()+"/intentrepot/listGoods?id=" + $('#hiddenid').val()});
						});
					}else{
						$.messager.alert("提示信息","删除入库商品信息失败," + rtn.errorMsg,"info");
					}
				}else{
					$.messager.alert("Error","系统通信失败!",'error');
				}
			},'json');
		}
	});
}

function downloadBarCode(url){
	$("#barCodeForm").attr("action",url);
	$("#barCodeForm").submit();
}
function formatItem(row){
    var s = '<span style="font-weight:bold">' + row.gname + '</span><br/>' +
            '<span style="color:#888">' + row.usergoodscode + '</span>';
    return s;
}
