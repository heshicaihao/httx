<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />

<div style="padding:4px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    		<tr>
    		<input type="hidden" id="orderid2" id="orderid2" name="orderid2" maxlength="30" value="${order.orderid}">
    			<td><font color="red">*</font>&nbsp;公司:</td>
    			<td>
    				<select name="companyid2" id="companyid2" style="width:156px" disabled="true">
    				    <option value=""></option>
    					<c:forEach  items="${companyList}" var="item">
    					<option value="${item.id}"  <c:if test="${item.id==order.companyid}">selected</c:if> >${item.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td></td>

    			<td><font color="red">*</font>&nbsp;电子订单编号:</td>
    			<td><input type="text" id="entrecordno2" name="entrecordno2" maxlength="40" value="${order.entrecordno}" disabled="true"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;客户:</td>
    			<td>   
    			
    			<c:choose>  
 	  			<c:when test="${empty order }">   
   				   		<select name="entrecordname2" id="entrecordname2" style="width:156px" disabled="true" >
   				   		   			<option value="" />
    						<c:forEach  items="${customerList}" var="item">
    								<option value="${item.instkey}">${item.gmusername}</option>
    						</c:forEach>
    					</select> 	    
   				</c:when>  
				<c:otherwise>
   					<select name="entrecordname2" id="entrecordname2" style="width:156px" disabled="true">
    						<c:forEach  items="${customerList}" var="item">
    							<c:if test="${item.instkey==order.entrecordname}">
    								<option value="${item.instkey}" selected>${item.gmusername}</option>
    							</c:if>
    					</c:forEach>
    				</select>   
				</c:otherwise>  
				</c:choose>  
		
    			</td>
    			<td></td>
    			<td><font color="red">*</font>&nbsp;收件人姓名:</td>
    			<td><input type="text" id="ordername2" name="ordername2" maxlength="20" value="${order.ordername}" disabled="true"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;收件人证件号:</td>
    			<td><input type="text" id="orderdocid2" name="orderdocid2" maxlength="18" value="${order.orderdocid}" disabled="true"></input></td>
    			<td></td>
    			
    			<td><font color="red">*</font>&nbsp;联系电话:</td>
    			<td><input type="text" id="orderphone2" name="orderphone2" maxlength="12" value="${order.orderphone }" disabled="true"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">&nbsp;</font>&nbsp;收件人地址:</td>
    			<td colspan="4"><input type="text" id="province2" size="10" class="easyui-combobox" disabled="true" data-options="
                        url:$('#appName').val() + '/common/listProvince',
                        valueField:'id',
                        <c:if test="${!empty order.province }">value:${order.province },</c:if>
                        textField:'name',
                        onSelect: function(rec){
                            $('#city').combobox('setValue','');
                            var url = $('#appName').val() + '/common/listCity?provinceId='+rec.id;
                            $('#city').combobox('reload', url);
                        }
                    "/>省&nbsp;
                    <input type="text" id="city2"  size="10" class="easyui-combobox" disabled="true" data-options="
                        url:$('#appName').val() + '/common/listCity?provinceId='<c:if test="${!empty order.province }"> + ${order.province }</c:if>,
                        valueField:'id',
                        textField:'name',
                        <c:if test="${!empty order.city }">value:${order.city },</c:if>
                        onSelect: function(rec){
                            $('#area').combobox('setValue','');
                            var url = $('#appName').val() + '/common/listArea?cityId='+rec.id;
                            $('#area').combobox('reload', url);
                        }
                    "/>市&nbsp;
                    <input type="text" id="area2"   size="10" class="easyui-combobox" disabled="true" data-options="
                        url:$('#appName').val() + '/common/listArea?cityId='<c:if test="${!empty order.city }"> + ${order.city }</c:if>,
                        valueField:'id',
                        <c:if test="${!empty order.area }">value:${order.area },</c:if>
                        textField:'name'
                    "/>区(县)</td>
    		</tr>
    		<tr>
    		  <td><font color="red">*</font>&nbsp;详细地址:</td>
    		  <td colspan="4"><input type="text" id="orderaddress2" name="orderaddress2" maxlength="100" value="${order.orderaddress}" size="58" readonly ="true"></input></td>

    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;订单总额:</td>
    			<td><input type="text" id="ordergoodtotal2" name="ordergoodtotal2" maxlength="12" value="${order.ordergoodtotal }" readonly ="true" ></input></td>
    			<td></td>
    			 
    		<td><font color="red">*</font>&nbsp;订单币制:</td>
    			<td>    				
    				<select name="ordergoodtotalcurr2" id="ordergoodtotalcurr2" style="width:156px" disabled="true" >

    					<option value="142">人民币</option>
    				</select>
    			</td>
    			<td></td>
    		</tr> 
    		<tr>
    			<td><font color="red">&nbsp;</font>&nbsp;备注:</td>
    			<td colspan="4"><input type="text" id="note2" name="note" maxlength="12" value="${order.note}" size="58" readonly ="true" ></input></td>
    			<td></td>
    		</tr>  		    		
    	</table>
    </form>
<style scoped="scoped">
	.textbox{
		height:20px;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>
<div id="orderGoodsDetails2"></div>
<script>
$(function(){
	$('#orderGoodsDetails2').datagrid({
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
			{field:'note',title:'备注',width:120}
		]],
		onLoadSuccess:function(data){
			$('#orderGoodsDetails2').datagrid('loaded');
			$('#orderGoodsDetails2').datagrid('clearSelections');
				countTotal2();
		},
		onLoadError:function(data){
			$('#orderGoodsDetails2').datagrid('loaded');
		}
	});
	
	if($('#orderid').val() != ''){
		$('#orderGoodsDetails2').datagrid('loading');
		$('#orderGoodsDetails2').datagrid({url: $('#appName').val()+"/order/listGoods?orderid=" + $('#orderid2').val()});
	}else{
	}
});

function countTotal2()
{
	var rows = $('#orderGoodsDetails2').datagrid("getRows");
	if(rows && rows.length == 0)
	{
		return;
	}
	
	var totalnum = 0;
	for(var i = 0; i < rows.length; i++){
		totalnum = rows[i].decprice*10000*rows[i].gqty /10000 +totalnum;
	}
	$('#ordergoodtotal2').val(totalnum);
		 			
}
</script>