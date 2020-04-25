<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>上传身份证</title>
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${appName}/static/jquery/themes/icon.css" />
<style>
a{border:0px}
</style>
<script type="text/javascript" src="${appName}/static/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${appName}/static/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${appName}/static/js/common.js?r=14325652142"></script>

</head>
<body>
<style>
.demo-info{
    background:#FFFEE6;
    color:#8F5700;
    width:800px;
    hieght:300px;
}
.demo-tip{
    width:24px;
    height:16px;
}
</style>
<div class="easyui-panel" title="上传身份证" style="width:800px">
    <form id="import" method="post" enctype="multipart/form-data">
    	<table cellpadding="0">
    	   <tr>
    	       <td colspan="2" class="demo-info" height="120">
    	           <div class="demo-tip icon-tip"></div>
                    <div style="padding-left:10px;line-height:22px">
                        1. 身份证号码与影印文件都要和收件人姓名保持一致，必须如实填写，否则将延误包裹清关进程<br/>
                        2. 身份证影印件电子版可以通过复印扫描或者手机、相机拍照获得<br/>
                        3. 身份证影印件只能为jpg格式，分正反面上传
                    </div>
    	       </td>
    	   </tr>
    		<tr>
    			<td width="100" align="right"><font color="red">*</font>&nbsp;身份证姓名:</td>
    			<td width="600">
    				<input type="text" id="name" name="name" maxlength="20" style="width:300px"></input>
    			</td>
    		</tr>
    		<tr>
    			<td align="right"><font color="red">*</font>&nbsp;身份证号码:</td>
    			<td ><input type="text" id="cardNo" name="cardNo" maxlength="18"  style="width:300px"></input></td>
    		</tr>
    		<tr>
                <td width="200" align="right"><font color="red">*</font>&nbsp;上传身份正面:</td>
                <td width="400">
                    <input type="file" id="a" name="a" style="width:300px" onchange="PreviewImg(this,'preview')"></input><br/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <div id="divpreview" style="display:none;width:354px;height:217px"></div>
                    <img id="preview" style="display:none;width:354px;height:217px" /> 
                 </td>
            </tr>
            <tr>
                <td width="200" align="right"><font color="red">*</font>&nbsp;上传身份反面:</td>
                <td width="400">
                    <input type="file" id="imgb" name="b" style="width:300px" onchange="PreviewImg(this,'preview1')"></input>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <div id="divpreview1" style="display:none;width:354px;height:217px"></div>
                    <img id="preview1" style="display:none;width:354px;height:217px" /> 
                </td>
            </tr>
    	</table>
    </form>
    <div style="text-align:center;padding:5px">
    	<input type="button" id="btnSubmit" value="提交" style="width:60px" onclick="submitForm();"/>
    </div>
    </div>
</div>
<style scoped="scoped">
	.textbox{
		height:20px;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>
<script>
$(function(){
    $('#import').form({
        url:'${pageContext.request.contextPath}/idcard/save',
        onSubmit: function(){
            if(!checkBeforeSubmit()){
                return false;
            }else{
                return true;
            }
        },
        success:function(data){
            try{
                if(typeof(data) != 'object'){
                    if(JSON){
                        data = JSON.parse(data);
                    }else{
                        data = eval('(' + data + ')');
                    }
                }
                if (data.success == false){
                	if(data.code=98){
                	    $.messager.alert("提示信息", data.errorMsg,"info");
                	}
                }else{
                    $.messager.alert("提示信息","上传身份证成功",'info',function(){
                    	$('#name').val('');
                    	$('#cardNo').val('');
                    	$('#a').val('');
                    	$('#imgb').val('');
                    	$('#divpreview1').hide();
                        $('#preview1').hide();
                        $('#divpreview').hide();
                        $('#preview').hide();
                    });
                }
            } catch(e){
            }
        }
    });
});

function checkBeforeSubmit(){
    var name=$('#name').val();
    if(name == ''){
        $.messager.alert("提示信息", "身份证姓名不能为空","info",function(){
            $('#name').focus();
        });
        return false;
    }
    var cardNo=$('#cardNo').val();
    if(cardNo == ''){
        $.messager.alert("提示信息", "身份证号码不能为空","info",function(){
            $('#cardNo').focus();
        });
        return false;
    }
    var checkResult= checkIdcard('cardNo');
    if( "true" != checkResult ){
    	$.messager.alert("提示信息", checkResult,"info",function(){
                $('#cardNo').focus();
	    });
	    return false;
    }
    var regext = /\.jpg$/gi;
    var aimg = $('#a').val();
    var bimg = $('#imgb').val();
    if(!regext.test(aimg)){    
        $.messager.alert("提示信息", "身份证正面，系统仅支持标准格式的照片，请您调整格式后重新上传！");
        return false;
    }
    var regext2 = /\.jpg$/gi;
    if(!regext2.test(bimg)){    
        $.messager.alert("提示信息", "身份证反面，系统仅支持标准格式的照片，请您调整格式后重新上传！");
        return false;
    }
    return true;
}

function submitForm(){
	$('#import').submit();
}
function getPath(obj){   
    if(obj) {   
        if(navigator.userAgent.indexOf("MSIE")>0) {  
            obj.select();   
            return document.selection.createRange().text;  
        } else if(isFirefox=navigator.userAgent.indexOf("Firefox")>0) {  
             if (obj.files) {
                return files.item(0).getAsDataURL();   
             }   
             return obj.value;   
         }  
         return obj.value;   
    }   
} 
function PreviewImg(img,previewId) {  
    var regext = /\.jpg$/gi;   
    if(!regext.test(img.value)){    
        alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
    }else{
        if(navigator.userAgent.indexOf("Chrome")>0) {
            $('#div' + previewId).hide();
            $('#' + previewId).show();
            var imgPath = getFileUrl(img.id);
            var imgPre = document.getElementById(previewId); 
            imgPre.src = imgPath;
        }else{
            $('#' + previewId).hide();
            $('#div' + previewId).show();
            var imgPath = getPath(img);
            var newPreview = document.getElementById('div' + previewId); 
            newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";    
            newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgPath;  
            newPreview.style.width = "354px";    
            newPreview.style.height = "217px";
        }
    }    

}  

function getFileUrl(sourceId) { 
    var url; 
    url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
    return url; 
    } 

function checkIdcard(txtIdcard){
var idcard = document.getElementById(txtIdcard).value;//身份证号码
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
</script>
</body>
</html>