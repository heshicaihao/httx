<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.blockUI.js"></script>
<script>
$(function(){
    $('#import').form({
        url:'${pageContext.request.contextPath}/intentrepot/import',
        onSubmit: function(){
            if(!checkBeforeSubmit()){
                $('#btnImportIncom').linkbutton("enable");
                return false;
            }else{
            	window.parent.top.showBlock();
                return true;
            }
        },
        success:function(data){
        	window.parent.top.hideBlock();
            try{
                if(typeof(data) != 'object'){
                    if(JSON){
                        data = JSON.parse(data);
                    }else{
                        data = eval('(' + data + ')');
                    }
                }
                if (data.success == false){
                    $.messager.alert("提示信息", data.errorMsg,"info",function(){
                        $('#btnImportIncom').linkbutton("enable");
                    });
                }else{
                    $.messager.alert("提示信息","入库单导入成功",'info',function(){
                        $(importDlg).dialog('close');
                        search();
                    });
                }
            } catch(e){
            }
        }
    });
});

function checkBeforeSubmit(){
    var companyId=$('#importCompany').combobox('getValue');
    if(companyId == ''){
        $.messager.alert("提示信息", "请选择公司!","info");
        return false;
    }
    var userId=$('#importUser').combobox('getValue');
    if(userId == ''){
        $.messager.alert("提示信息", "请选择客户!","info");
        return false;
    }
    var fileName = $('#importFile').val();
    if(fileName == ''){
        $.messager.alert("提示信息", "请选择要导入库单excel文件!","info");
        return false;
    }
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
    if(ext.toUpperCase() != 'XLS'){
        $.messager.alert("提示信息","请使用excel 2003格式的文件!","info");
        return false;
    }
    return true;
}
</script>
  <div style="padding:10px 60px 20px 60px">
  <form id="import" action="${pageContext.request.contextPath}/intentrepot/import" enctype="multipart/form-data" method="post" style="margin:0px;padding:0px">
     <div style="height:40px">
         <font color="red">*</font>&nbsp;请选择公司:
         <select id="importCompany" name="importCompany" style="width:140px" class="easyui-combobox">
            <option value=""></option>
            <c:forEach items="${companyList }" var="company">
            <option value="${company.id }" >${company.name }</option>
            </c:forEach>
         </select>
      </div>
      <div style="height:40px">
         <font color="red">*</font>&nbsp;请选择客户:
         <select id="importUser" name="importUser"  class="easyui-combobox" style="width:140px">
          <option value=""></option>
          <c:forEach items="${customerList }" var="customer">
          <option value="${customer.instkey }">${customer.gmusername }</option>
          </c:forEach>
         </select>
      </div>
         <font color="red">*</font>&nbsp;请选择需要导入的入库单文件:<br/>
         <input type="file" name="importFile" id="importFile" />
  </form>
  </div>

