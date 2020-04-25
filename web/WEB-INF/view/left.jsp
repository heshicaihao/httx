<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
.tree-children {
    background: url("${appName}/static/images/left.gif") no-repeat;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script>
var he=$(document.body).outerHeight(true)-105;
document.write("<div id=tt style=height:"+he+";overflow:hidden>");

function clickNode(node){
}
$(function(){
    $('#treeMenu').tree({
    	animate:true,
    	lines:true,
        url: '${appName}/account/menu',
        onClick:function(node){
        	window.parent.parent.parent.document.getElementsByName('topFrame')[0].contentWindow.document.getElementById('navSpan').innerHTML="当前位置: " + $('#treeMenu').tree('getRoot').text + " >> " + node.text;
        	window.parent.document.getElementsByTagName("iframe")['ifCenter'].src='${appName}' + node.attributes.url;
        }
    }); 
});
</script>

<div class="STYLE1" style="height:28px;width:165px;background-image:url('${appName}/static/images/main_40.gif');text-align:center;line-height:28px">
管理菜单
</div>
<div><ul id="treeMenu"></ul></div>    	
<script>
</script>