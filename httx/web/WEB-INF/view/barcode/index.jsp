<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript"> 
function pagesetup_null(){
	try{
		var RegWsh = new ActiveXObject("WScript.Shell");
		hkey_key="header" 
		RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"&w&b页码，&p/&p")
		hkey_key="footer"
		RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")
	}catch(e){
	}
}  
function _printme(){
	pagesetup_null();
	var a= document.title;
	document.title="";
	var htmls=document.body.innerHTML;
    document.body.innerHTML=document.getElementById('d1').innerHTML;
    //document.getElementById("page_td").style.display='none'; 
    window.print();
    document.body.innerHTML=htmls;
    //document.getElementById("page_td").style.display=document.all?"block":"";
}    
</script>
<body>
<div id="d1">
<img src="<%=request.getContextPath() %>/barcode?msg=09900014A29" />
</div>
<input type="button"  value="打印" class="button" onClick="_printme()">
</body>
</html>
