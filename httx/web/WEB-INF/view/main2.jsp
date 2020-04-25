<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="${appName}/static/favicon.ico" type="image/x-icon" ></link>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js?r=14325652142"></script>

<title>EBS-跨境电商运营管理系统</title>
</head>
<frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
  <frame src="${appName }/top" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="${appName }/center" name="mainFrame" id="mainFrame" />
  <frame src="${appName }/down" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes><body>
</body>
</noframes></html>