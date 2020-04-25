function checkRequired(id,lblName){
	$('#' + id).val($.trim($('#' + id).val()));
	var v = $('#' + id).val();
	if(v ==''){
		$.messager.alert("提示信息",lblName + "不能为空!","info",function(){
			$('#' + id).focus();
		});
		return false;
	}
	return true;
}

function checkLength(id,lblName,min,max){
	$('#' + id).val($.trim($('#' + id).val()));
	var v = $('#' + id).val();
	if(v.length >=min && v.length <= max){
		return true;
	}
	$.messager.alert("提示信息",lblName + "的长度必须在 " + min + " 到 " + max + " 之间!","info",function(){
		$('#' + id).focus();
	});
	return false;
}

function checkLetterDigit(id,lblName){
	$('#' + id).val($.trim($('#' + id).val()));
	var v = $('#' + id).val();
	var p = /^[a-zA-Z][a-zA-Z0-9]*$/;
	if(!p.test(v)){
		$.messager.alert("提示信息",lblName + "只能是以字母开头的，由字母、下划线和数字组成!","info",function(){
			$('#' + id).focus();
		});
		return false;
	}
	return true;
}

function checkInt(id,lblName){
	$('#' + id).val($.trim($('#' + id).val()));
	var v = $('#' + id).val() *1;
	var p = /^\d+$/;
	if(!p.test(v)){
		$.messager.alert("提示信息",lblName + "只能输入正整数!","info",function(){
			$('#' + id).focus();
		});
		return false;
	}
	return true;
}

function check2Digit(id,lblName){
	$('#' + id).val($.trim($('#' + id).val()));
	var v = $('#' + id).val() *1;
	var p = /^\d+\.?\d{0,2}$/;
	if(!p.test(v)){
		$.messager.alert("提示信息",lblName + "最多只能输入两有效小数","info",function(){
			$('#' + id).focus();
		});
		return false;
	}
	return true;
}

function clearNoNum(event,obj){ 
    event = window.event||event; 
    if(event.keyCode == 37 | event.keyCode == 39){ 
        return; 
    } 
    obj.value = obj.value.replace(/[^\d.]/g,""); 
    obj.value = obj.value.replace(/^\./g,""); 
    obj.value = obj.value.replace(/\.{2,}/g,"."); 
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
} 
function checkNum(obj){ 
    obj.value = obj.value.replace(/\.$/g,""); 
}

function checkInt2(val){
	var v = val;
	var p = /^\d+$/;
	if(!p.test(v)){
		return false;
	}
	return true;
}

function formatDate2(date){
	if(date instanceof Date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		var h = date.getHours();
		var mm = date.getMinutes();
		var s = date.getSeconds();
		return y+'-'+appendZero(m)+'-'+appendZero(d) + " " + appendZero(h) + ":" + appendZero(mm) + ":" + appendZero(s);
	}
}

function appendZero(val){
	if (val < 10){
		val = "0" + val;
	}
	return val;
}


function myformatter(date){
	if(date instanceof Date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        var h = date.getHours();
        var mm = date.getMinutes();
        var s = date.getSeconds();
        return y+'-'+appendZero(m)+'-'+appendZero(d) + " " + appendZero(h) + ":" + appendZero(mm) + ":" + appendZero(s);
    }
}
function myparser(s){
    if (!s) return new Date();
    var regexDT = /(\d{4})-?(\d{2})?-?(\d{2})?\s?(\d{2})?:?(\d{2})?:?(\d{2})?/g;  
    var matchs = regexDT.exec(s);  
    var date = new Array();  
    for (var i = 1; i < matchs.length; i++) {  
        if (matchs[i]!=undefined) {  
            date[i] = matchs[i];  
        } else {  
            if (i<=3) {  
                date[i] = '01';  
            } else {  
                date[i] = '00';  
            }  
        }  
    }  
    return new Date(date[1], date[2]-1, date[3], date[4], date[5],date[6]);  
}
