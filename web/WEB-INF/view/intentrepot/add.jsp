<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<script src="${appName}/static/js/intentreport_sub.js?r=14425652142" type="text/javascript"></script>
<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}

legend {
	color: #15428B;
	font-size: 12px;
	font-weight: bold;
	line-height: 15px;
}

label {
	display: inline-block;
	text-align: right
}
</style>

<div style="line-height: 26px; border-bottom: 1px solid #95B8E7"
	id="hDiv">
	<form id="ff" method="post" style="margin:0px;padding:0px;">
		<table cellpadding="0" style="margin:0px;padding:0px;" cellspacing="0">
			<tr>
				<td width="40">&nbsp;<font color="red">*</font>公司:
			    </td>
			    <td>
				    <select name="companyidSelection" id="companyidSelection"
				    <c:if test="${! empty intEntrepot}">disabled="true"</c:if>
				    >
				    <option value=""></option>
				    <c:forEach items="${companyList }" var="company">
				    <option value="${company.id }" 
				    <c:if test="${company.id==intEntrepot.companyid }">selected</c:if>
				    >${company.name }</option>
				    </c:forEach>
				    </select>
                    <input type="hidden" id="hiddenid" value="${intEntrepot.id }"></input>
					&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">*</font>&nbsp;客户:
					<select name="custidSelection" id="custidSelection" <c:if test="${! empty intEntrepot}">disabled="true"</c:if>
                    >
                    <option value=""></option>
                    <c:forEach items="${customerList }" var="customer">
                    <option value="${customer.instkey }"
                    <c:if test="${customer.instkey==intEntrepot.custid }">selected</c:if>
                    >${customer.gmusername }</option>
                    </c:forEach>
                    </select>
                </td>
			</tr>
			<tr height="40">
			 <td>&nbsp;备注:</td>
			 <td>
                <textarea <c:if test="${! empty intEntrepot}">disabled="true"</c:if>
                     id="remark" cols="70" style="margin:0px;padding:0px;height:34px">${intEntrepot.remark }</textarea>
             </td>
			</tr>
		</table>
	</form>
	<c:if test="${empty intEntrepot }">
    <div><input type="button" id="createIntentRepotBtn" value=" 创建入库单 " onclick="createIntentRepot()"/></div>
    </c:if>
</div>
<div id="intEntrepotGoodsDetails"></div>
<div id="selectGoodsDlg"></div>
<div id="confirmInDlg">
</div>