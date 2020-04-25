$(function(){
	$('#orderGoodsDetails').datagrid({
		title:'商品列表',
		iconCls:'icon-edit',  
		width:$('#hdiv').width(),  
		height:306,
		border:false,
		singleSelect:true,rownumbers:true,
		columns:[
		[
		 	{field:'id',hidden:true},
			{field:'instkey',title:'商品编码',width:100},
			{field:'copgno',title:'商品货号',width:80},
			{field:'totalNo',title:'现有量',width:60},
			{field:'gname',title:'商品描述',width:100},
			{field:'gqty',title:'订单数量',width:60},
			{field:'unit_name',title:'计量单位',width:40},
			{field:'decprice',title:'单价',width:50},
			{field:'curr',title:'币制',width:40,formatter:function(){
				return "RMB";
			}},
			{field:'decltotal',title:'总价',width:40},
			{field:'grosswt',title:'毛重',width:40},
			{field:'netwt',title:'净重',width:40},
			{field:'gmodel',title:'包装/型号',width:60},
			{field:'note',title:'备注',width:120},
			{field:'projectkey',title:'操作',width:60, formatter:function(value,row,index){
				return '<a class="easyui-linkbutton l-btn l-btn-small" href="javascript:delDetails(\'' + row.id + '\');"><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">删除</span><span class="l-btn-icon icon-remove">&nbsp;</span></span></a>';
			}}
		]],
		onLoadSuccess:function(data){
			$('#orderGoodsDetails').datagrid('loaded');
			$('#orderGoodsDetails').datagrid('clearSelections');
				countTotal();
		},
		onLoadError:function(data){
			$('#orderGoodsDetails').datagrid('loaded');
		},
		toolbar:[{
			text: '添加商品',
			iconCls: 'icon-add',
			id:'addGoodsBtn',
			handler: function(){showSelectGoods();}
		}]
	});
	
	if($('#orderid').val() != ''){
		$('#orderGoodsDetails').datagrid('loading');
		$('#orderGoodsDetails').datagrid({url: $('#appName').val()+"/order/listGoods?orderid=" + $('#orderid').val()});
	}else{
		$('#addGoodsBtn').linkbutton("disable");
	}
});
var selectGoodsDlg;
function showSelectGoods(){
	var userKey = $('#entrecordname').val();
	
	if(!userKey){
		$.messager.alert("提示信息","请先选择用户!",'info');
		return;
	}
	var companyId = $('#companyid').val();
	if(!companyId){
		$.messager.alert("提示信息","请先选择公司!",'info');
		return;
	}
	if(!selectGoodsDlg){
		selectGoodsDlg = $('#selectGoodsDlg').dialog({
			title:'选择订单商品',
			id:'selectGoodsDlg',
			cache: false,
			top:20,
			height:200,
			width:400,
			closed:true,
			modal: true,
			buttons:[
				{text:"确定",handler:function(){
					var addGoodsId = $('#addGoodsId').combobox('getValue');
					if(!addGoodsId || addGoodsId == ''){
						$.messager.alert("提示信息",'请选择订单商品!','info');
						return;
					}
					if(!checkInt('gqty','数量')){
						return;
					}
					if(!checkRequired('decprice','单价') || !checkLength('decprice','单价',0,11)|| !check2Digit('decprice','单价')){
						return;
					}
					var param={};
					param.orderid=$('#orderid').val();
					
					param.goodsid=addGoodsId;
					param.gqty=$('#gqty').val() * 1;
					param.note = $('#goodsnote').val();
					param.decprice = $('#decprice').val();
					$.ajax({
						url: $('#appName').val() + '/order/saveDetails',
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
										$('#orderGoodsDetails').datagrid('loading');
										$('#orderGoodsDetails').datagrid({url: $('#appName').val()+"/order/listGoods?orderid=" + $('#orderid').val()});
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
	$(selectGoodsDlg).dialog('refresh', $('#appName').val() + "/order/showSelectGoods?userKey="+userKey);
}

function createorder(){

		if(!checkRequired('companyid','公司') ){
			return;
		}
		if(!checkRequired('entrecordname','客户') ){
			return;
		}
		if(!checkRequired('entrecordno','电子订单编号') || !checkLength('entrecordno','电子订单编号',0,40)){
			return;
		}
		if(!checkRequired('ordername','收件人姓名') || !checkLength('ordername','收件人姓名',0,30)){
			return;
		}
		
		var checkResult= checkIdcard('orderdocid');
		if( "true" != checkResult ){
			alert(checkResult);
			return;
		}
		if(!checkRequired('orderphone','联系电话') || !checkLength('orderphone','联系电话',0,20)){
			return;
		}
		if(!checkLength('orderaddress','详细地址',0,120)){
			return;
		}
		if(!checkLength('note','备注',0,100)){
			return;
		}
		if(!checkRequired('ordergoodtotalcurr','订单币制') ){
			return;
		}
var param = {};
			param.orderid = $('#orderid').val();
			param.companyid = $('#companyid').val();
			param.entrecordname = $('#entrecordname').val();
			param.ordername = $('#ordername').val();
			param.orderdocid = $('#orderdocid').val().toUpperCase();
			param.orderaddress = $('#orderaddress').val();
			param.orderphone = $('#orderphone').val();
			param.ordergoodtotal = $('#ordergoodtotal').val();
			param.ordergoodtotalcurr = $('#ordergoodtotalcurr').val();
			param.entrecordno = $('#entrecordno').val();
			param.province = $('#province').combobox('getValue');
			param.city = $('#city').combobox('getValue');
			param.area = $('#area').combobox('getValue');	
			param.note = $('#note').val();
					$.ajax({
						url: $('#appName').val()+'/order/save',
						type: 'POST',
						dataType: 'json',
						data:JSON.stringify(param),
						contentType: "application/json; charset=utf-8", 
						timeout: 60000,
						success: function(data){
							if(data){
								var t = $('#modDlg').panel('options').title;
								var msg = "修改";
								if(t == '新增订单'){
									msg = "新增";
								}
								if(data.success){
									$.messager.alert("提示信息",msg + "订单成功!","info",function(){
										 $('#createOrderBtn').hide();
										$('#orderid').val(data.rtnKey);
										$('#addGoodsBtn').linkbutton("enable");
										search();
									});
								}else{
									$.messager.alert("提示信息",msg + "订单失败! " + data.errorMsg,"info");
								}
							}else{
								$.messager.alert("Error","系统通信失败!",'error');
							}
						}
					});
}

function delDetails(id){
	$.messager.confirm("删除确认","<font color='red'>确认要删除这条数据吗？一旦删除将无法恢复！</font>",function(ok){
		if(ok){
			$.post($('#appName').val() + '/order/deleteDetails/' + id,null,function(rtn){
				if(rtn){
					if(rtn.code == 0){
						$.messager.alert("提示信息","删除商品订单信息成功!","info",function(){
							$('#orderGoodsDetails').datagrid('loading');
							$('#orderGoodsDetails').datagrid({url: $('#appName').val()+"/order/listGoods?orderid=" + $('#orderid').val()});
						});
					}else{
						$.messager.alert("提示信息","删除订单商品信息失败," + rtn.errorMsg,"info");
					}
				}else{
					$.messager.alert("Error","系统通信失败!",'error');
				}
			},'json');
		}
	});
}

function countTotal()
{
	var rows = $('#orderGoodsDetails').datagrid("getRows");
	if(rows && rows.length == 0)
	{
		return;
	}
	
	var totalnum = 0;
	for(var i = 0; i < rows.length; i++){
		totalnum = rows[i].decprice*10000*rows[i].gqty /10000 +totalnum;
	}
	$('#ordergoodtotal').val(totalnum);
		 			
}
function formatItem(row){
    var s = '<span style="font-weight:bold">' + row.gname + '</span><br/>' +
            '<span style="color:#888">' + row.usergoodscode + '</span>';
    return s;
}


function checkIdcard(txtIdcard){
var idcard = document.getElementById(txtIdcard).value.toUpperCase();//身份证号码
var Errors=new Array(
"true",
"身份证号码位数不对!",
"身份证号码出生日期超出范围或含有非法字符!",
"身份证号码校验错误! ",
"身份证地区非法!"
);
var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}

var idcard,Y,JYM;
var S,M;
var idcard_array = new Array();
idcard_array = idcard.split("");
//地区检验
if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];
//身份号码位数及格式检验
switch(idcard.length){
case 15:
if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性
} else {
ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
}
if(ereg.test(idcard)) return Errors[0];
else return Errors[2];
break;
case 18:
//18位身份号码检测
//出生日期的合法性检查 
//闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
//平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式
} else {
ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式
}
if(ereg.test(idcard)){//测试出生日期的合法性
//计算校验位
S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
+ parseInt(idcard_array[7]) * 1 
+ parseInt(idcard_array[8]) * 6
+ parseInt(idcard_array[9]) * 3 ;
Y = S % 11;
M = "F";
JYM = "10X98765432";
M = JYM.substr(Y,1);//判断校验位
if(M == idcard_array[17]) return Errors[0]; //检测ID的校验位
else return Errors[3];
}
else return Errors[2];
break;
default:
return Errors[1];
break;
}
}