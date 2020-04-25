<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE2 {font-size: 9px}
.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
-->
</style></head>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="${appName}/static/images/main_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="24" background="${appName}/static/images/main_03.gif">&nbsp;</td>
            <td width="505" background="${appName}/static/images/main_04.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="${appName}/static/images/main_07.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="370" height="38" style="background-image:url('${appName}/static/images/main_09.gif');background-repeat:no-repeat">&nbsp;&nbsp
			<font color="white" style="font-weight:bold;font-size:20px">&nbsp;EBS-跨境电商运营管理系统</font>
			</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="50%" height="25" valign="bottom" height="19"></td>
                <td width="50%" valign="bottom" align="right"><div align="right" style="float:right;"><span class="STYLE1">当前用户：${loginAccount.loginName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${appName }/logout" style="color:white">退出</a></span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="${appName}/static/images/main_11.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="${appName}/static/images/main_29.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="${appName}/static/images/main_30.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="${appName}/static/images/main_31.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="${appName}/static/images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" style="background-image:url('${appName}/static/images/main_32.gif');background-repeat: no-repeat">
	        <table width="177" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="35.4"  height="22">&nbsp;</td>
	            <td width="104.43" valign="bottom">&nbsp;</td>
	            <td width="37.17">&nbsp;</td>
	          </tr>
	        </table>
        </td>
        <td align="left" style="padding-left:4px"><span id="navSpan" class="STYLE3">当前位置: </span></td>
        <td width="21" align="right"><img src="${appName}/static/images/main_37.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>