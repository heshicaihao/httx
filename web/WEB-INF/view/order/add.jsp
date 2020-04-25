<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<script src="${appName}/static/js/order_sub.js?r=123d" type="text/javascript"></script>

<div style="padding:4px">
    <form id="ff" method="post">
    	<table cellpadding="0">
    		<tr>
    		<input type="hidden" id="orderid" id="orderid" name="orderid" maxlength="30" value="${order.orderid}">
    			<td><font color="red">*</font>&nbsp;公司:</td>
    			<td>
    				<select name="companyid" id="companyid" style="width:156px">
    				    <option value=""></option>
    					<c:forEach  items="${companyList}" var="item">
    					<option value="${item.id}"  <c:if test="${item.id==order.companyid}">selected</c:if> >${item.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td></td>

    			<td><font color="red">*</font>&nbsp;电子订单编号:</td>
    			<td><input type="text" id="entrecordno" name="entrecordno" maxlength="40" value="${order.entrecordno}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;客户:</td>
    			<td>   
    			
    			<c:choose>  
 	  			<c:when test="${empty order }">   
   				   		<select name="entrecordname" id="entrecordname" style="width:156px">
   				   		   			<option value="" />
    						<c:forEach  items="${customerList}" var="item">
    								<option value="${item.instkey}">${item.gmusername}</option>
    						</c:forEach>
    					</select> 	    
   				</c:when>  
				<c:otherwise>
   					<select name="entrecordname" id="entrecordname" style="width:156px">
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
    			<td><input type="text" id="ordername" name="ordername" maxlength="20" value="${order.ordername}"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;收件人证件号:</td>
    			<td><input type="text" id="orderdocid" name="orderdocid" maxlength="18" value="${order.orderdocid}"></input></td>
    			<td></td>
    			
    			<td><font color="red">*</font>&nbsp;联系电话:</td>
    			<td><input type="text" id="orderphone" name="orderphone" maxlength="12" value="${order.orderphone }"></input></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td><font color="red">&nbsp;</font>&nbsp;收件人地址:</td>
    			<td colspan="4"><input type="text" id="province" size="10" class="easyui-combobox" data-options="
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
                    <input type="text" id="city" size="10" class="easyui-combobox" data-options="
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
                    <input type="text" id="area" size="10" class="easyui-combobox" data-options="
                        url:$('#appName').val() + '/common/listArea?cityId='<c:if test="${!empty order.city }"> + ${order.city }</c:if>,
                        valueField:'id',
                        <c:if test="${!empty order.area }">value:${order.area },</c:if>
                        textField:'name'
                    "/>区(县)</td>
    		</tr>
    		<tr>
    		  <td><font color="red">*</font>&nbsp;详细地址:</td>
    		  <td colspan="4"><input type="text" id="orderaddress" name="orderaddress" maxlength="100" value="${order.orderaddress}" size="58"></input></td>

    		</tr>
    		<tr>
    			<td><font color="red">*</font>&nbsp;订单总额:</td>
    			<td><input type="text" id="ordergoodtotal" name="ordergoodtotal" maxlength="12" value="${order.ordergoodtotal }" readonly ="true"></input></td>
    			<td></td>
    			 
    		<td><font color="red">*</font>&nbsp;订单币制:</td>
    			<td>    				
    				<select name="ordergoodtotalcurr" id="ordergoodtotalcurr" style="width:156px">

    					<option value="142">人民币</option>
    				</select>
    			</td>
    			<td></td>
    		</tr> 
    		<tr>
    			<td><font color="red">&nbsp;</font>&nbsp;备注:</td>
    			<td colspan="4"><input type="text" id="note" name="note" maxlength="12" value="${order.note}" size="58"></input></td>
    			<td></td>
    		</tr>  		    		
    	</table>
    </form>
    <c:if test="${empty order }">
    <div><input type="button" id="createOrderBtn" value=" 创建订单 " onclick="createorder()"/></div>
    </c:if>
    <c:if test="${not empty order }">
    <div><input type="button" id="createOrderBtn" value="保存修改 " onclick="createorder()"/></div>
    </c:if>
    </div>
<style scoped="scoped">
	.textbox{
		height:20px;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>
<div id="orderGoodsDetails"></div>
<div id="selectGoodsDlg"></div>