<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="${appName}/static/favicon.ico" type="image/x-icon" ></link>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>
<script type="text/javascript" src="${appName}/static/js/jquery.blockUI.js"></script>
<title>EBS-跨境电商运营管理系统</title>
<script>
$(document).ready(function(){
	  if(window.parent != window){
	    parent.document.getElementById("iframe").style.height = (document.body.scrollHeight+30)+"px";
	  }
	 });
function showBlock() {
    $.blockUI(
    {   
        message:'<p>正在处理....请稍候...!</p>',
        css: {
            border: 'none',
            padding: '15px',
            backgroundColor: '#000',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: .5,
            color: '#fff'
        }
    });
}

function hideBlock() {
    $.unblockUI();
}
</script>
</head>
<body style="padding:0xp;margin:0px">
<iframe id="iframe" scrolling="no" style="padding:0px;margin:0px" noresize="noresize" frameborder="0" src="${appName}/main2" width="100%" height="100%"></iframe>
</body>
</html>