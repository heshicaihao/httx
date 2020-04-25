<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<script type="text/javascript">
function cobFilter(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0 || row['usergoodscode'].indexOf(q.toUpperCase()) >=0;
}

function defaultPrice(rec){
    $('#decprice').val(rec.decprice);
}
</script>
<center>
<table cellspacing="0" cellpadding="0" border="0">
    <tr height="30">
        <td align="right" width="60">
            <label for="addGoodsId"><font color="red">*</font>商品:</label>
        </td>
        <td align="left">&nbsp;
            <input name="addGoodsId" id="addGoodsId" class="easyui-combobox" data-options="
                    url:$('#appName').val() + '/goods/listGoodsByUserKey?userKey=${userKey }',
                    valueField:'id',
                    textField:'gname',
                    formatter:formatItem,
                    filter:cobFilter, 
                    onSelect:function(rec){
					    $('#decprice').val(rec.rmb);
				    }
                "/>
        </td>
    </tr>
    <tr height="30">
        <td align="right">
            <label for="gqty"><font color="red">*</font>数量:</label>
        </td>
        <td align="left">&nbsp;
            <input type="text" id="gqty" />
        </td>
    </tr>
    <tr height="30">
        <td align="right">
            <label for="decprice"><font color="red">*</font>单价:</label>
        </td>
        <td align="left">&nbsp;
            <input type="text" id="decprice" />
        </td>
    </tr>
    <tr height="30">
        <td align="right">
            <label for="goodsnote">备注:</label>
        </td>
        <td align="left">&nbsp;
            <textarea id="goodsnote" name="goodsnote" cols="30" style="height:36px;margin:0px;padding:0px"></textarea>
        </td>
    </tr>
</table>
</center>