<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName" scope="request" />
<style type="text/css">
        .gray{ color:Gray; }
    </style>
<script type="text/javascript">
var countryList=${countryList};
var currList = ${currList};
var unitList = ${unitList};
var gnameUrl = "";
<c:if test="${loginAccount.accountType==3 }">
var gnameUrl = '${appName}/goods/listGoodsByUserKey?userKey=${loginAccount.custId}';
</c:if>
function cobFilter(q, row){
    var opts = $(this).combobox('options');
    return row[opts.textField].indexOf(q) >= 0;
}
$('#gname').combogrid({    
    panelWidth:580,
    <c:if test="${! empty goods.gname }">
    value:'${goods.gname }',
    </c:if>
    idField:'gname',
    <c:if test="${loginAccount.accountType==3 }">
    url: '${appName}/goods/listGoodsByUserKey?userKey=${loginAccont.custId }',
    </c:if>
    <c:if test="${loginAccount.accountType!=3 }">
    url: '${appName}/goods/listGoodsByUserKey?userKey=${goods.createuserid }',
    </c:if>
    textField:'gname', 
    model:'local',
    loadMsg:'正在努力加载中...',
    columns:[[    
        {field:'usergoodscode',title:'商品编码',width:80},    
        {field:'copgno',title:'货号',width:100},    
        {field:'gname',title:'中文名称',width:220},    
        {field:'registno',title:'海关备案号',width:140}    
    ]],hasDownArrow:false,
    filter:filterGName
});
$('#gname').combogrid('setValue','${goods.gname }');
</script>
    <div style="padding:4px 4px 4px 4px">
    <form id="ff" method="post">
        <table>
        <c:if test="${loginAccount.accountType!=3 }">
            <tr>
                <td width="150"><font color="red">*</font>&nbsp;<label for="createuserid">客户</label>:</td>
                <td width="156">
                    <input name="createuserid" id="createuserid" class="easyui-combobox" style="width:130px" data-options="
                        url:$('#appName').val() + '/common/listCustomers',
	                    valueField:'instkey',
	                    textField:'gmusername',
	                <c:if test="${!empty goods}">
	                    value:${goods.createuserid },
	                    disabled:true,
	                </c:if>
	                    filter:cobFilter,
	                    onSelect:function(rec){
	                       gnameUrl = '${appName}/goods/listGoodsByUserKey?userKey=' + rec.instkey;
                            $('#gname').combogrid({url: '${appName}/goods/listGoodsByUserKey?userKey=' + rec.instkey});
	                    }
                    ">
                </td>
                <td></td>
                <c:if test="${!empty goods}">
                    <td>&nbsp;<label for="usergoodscode">商品编码</label>:</td>
                    <td>${goods.usergoodscode }</td>
                    <td></td>
                </c:if>
                <td colspan="4">&nbsp;</td>
            </tr>
        </c:if>
             <tr>
                <td width="150">&nbsp;<label for="sellid">在销售网站上商品的ID</label>:</td>
                <td width="156"><input type="text" id="sellid" name="sellid" maxlength="30" value="${goods.sellid }" title="在销售网站上商品的ID"></input>
                 <input type="hidden" id="hiddenid" value="${goods.id }"></input>
                </td>
                <td width="30"></td>
                <td width="150"><font color="red">*</font>&nbsp;<label for="goodsenname">英文商品名称/规格型号</label>:</td>
                <td width="156"><input type="text" id="goodsenname" name="goodsenname" maxlength="200" value="${goods.goodsenname }" title="英文商品名称/规格型号"></input>
                </td>
                <td></td>
            </tr>
             <tr>
                <td width="90"><font color="red">*</font>&nbsp;<label for="gname">中文名称</label>:</td>
                <td width="156"><input type="text" id="gname" name="gname" maxlength="200" title="中文名称, 要求必须与英文的品名、规格类型严格一致！"></input>
                </td>
                <td></td>
                <td width="90"><font color="red">*</font>&nbsp;<label for="copgno">商品货号</label>:</td>
                <td width="156"><input type="text" id="copgno" name="copgno" maxlength="30" value="${goods.copgno }" title="商品货号"></input>
                </td>
                <td></td>
            </tr>
            <tr>
                <td width="90">&nbsp;<label for="country">原产地</label>:</td>
                <td width="156">
                    <input name="country" id="country" class="easyui-combobox" style="width:130px" data-options="
                        data:countryList,
                        valueField:'codeNo',
                        textField:'codeName',
                        title:'原产地',
                        emptyText:'原产地',
                        value:'${goods.country }',
                        filter:cobFilter
                    ">
                </td>
                <td></td>
                <td width="90"><font color="red">*</font>&nbsp;<label for="hscode">HS编码</label>:</td>
                <td width="156"><input type="text" id="hscode" name="hscode" maxlength="30" value="${goods.hscode }" title="HS编码"></input>
                </td>
                <td></td>
            </tr>
            <tr>
                <td width="90">&nbsp;<label for="curr">币制</label>:</td>
                <td width="156">
                    <input name="curr" id="curr" class="easyui-combobox" style="width:130px" data-options="
                        data:currList,
                        valueField:'codeNo',
                        textField:'codeName',
                        title:'币制',
                        value:'${goods.curr }',
                        filter:cobFilter
                    ">
                </td>
                <td></td>
                <td width="90">&nbsp;<label for="decprice">进口单价</label>:</td>
                <td width="156"><input type="text" id="decprice" name="decprice" onkeyup="clearNoNum(event,this)" maxlength="18" value="${goods.decprice }" title="请如实填写采购价，币制填外币，对于征税无影响，海关以销售价为基础征税"></input>
                </td>
                <td></td>
            </tr>

                <tr>
                <td><font color="red">*</font>&nbsp;<label for="posttariffcode">行邮税号</label>:</td>
                <td><input type="text" id="posttariffcode" name="posttariffcode" maxlength="12" value="${goods.posttariffcode }" title="行邮税号"></input></td>
                <td></td>
                <td><font color="red">*</font>&nbsp;<label for="posttariffname">行邮税名称</label>:</td>
                <td><input type="text" id="posttariffname" name="posttariffname" maxlength="255" value="${goods.posttariffname }" title="行邮税名称"></input></td>
                <td></td>
            </tr>
            <tr>
                <td><font color="red">*</font>&nbsp;<label for="unit">申报计量单位</label>:</td>
                <td>
                    <input name="unit" id="unit" class="easyui-combobox" style="width:130px" data-options="
                        data:unitList,
                        valueField:'codeNo',
                        textField:'codeName',
                        title:'申报计量单位',
                        value:'${goods.unit }',
                        filter:cobFilter
                    "></td>
                <td></td>
                <td width="90"><font color="red">*</font>&nbsp;<label for="networksellname">网站销售渠道</label>:</td>
                <td width="156"><input type="text" id="networksellname" name="networksellname" maxlength="200" value="${goods.networksellname }" title="网站销售渠道"></input>
                </td>
                <td></td>
            </tr>
            <tr>
                <td width="90"><font color="red">*</font>&nbsp;<label for="rmb">销售零售价（人民币）</label>:</td>
                <td width="156"><input type="text" id="rmb" name="rmb" maxlength="18" onkeyup="clearNoNum(event,this)" value="${goods.rmb }" title="销售零售价（人民币）"></input>
                </td>
                <td></td>
                <td><font color="red">*</font>&nbsp;<label for="grosswt">毛重</label>:</td>
                <td><input type="text" id="grosswt" name="grosswt" maxlength="19" onkeyup="clearNoNum(event,this)" value="${goods.grosswt }" title="毛重"></input></td>
                <td></td>
            </tr>
            <tr>
                <td><font color="red">*</font>&nbsp;<label for="netwt">净重</label>:</td>
                <td><input type="text" id="netwt" name="netwt" maxlength="19" value="${goods.netwt }" onkeyup="clearNoNum(event,this)" title="净重"></input></td>
                <td></td>
                <td width="90">&nbsp;<label for="yongtu">用途</label>:</td>
                <td width="156"><input type="text" id="yongtu" name="yongtu" maxlength="200" value="${goods.yongtu }" title="用途"></input>
                </td>
                <td></td>
            </tr>

            <tr>
                <td>&nbsp;<label for="pingming">品名</label>:</td>
                <td><input type="text" id="pingming" name="pingming" maxlength="200" value="${goods.pingming }" title="品名"></input></td>
                <td></td>
                <td>&nbsp;<label for="brand">品牌</label>:</td>
                <td><input type="text" id="brand" name="brand" maxlength="100" value="${goods.brand }" title="品牌"></input></td>
                <td></td>
            </tr>

            <tr>
                <td><font color="red">*</font>&nbsp;<label for="gmodel">包装/型号</label>:</td>
                <td><input type="text" id="gmodel" name="gmodel" maxlength="100" value="${goods.gmodel }" title="包装/型号"></input></td>
                <td></td>
                <td width="90"><font color="red">*</font>&nbsp;<label for="manufactory">生产厂家</label>:</td>
                <td width="156"><input type="text" id="manufactory" name="manufactory" maxlength="200" value="${goods.manufactory }" title="生产厂家"></input>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>&nbsp;<label for="chengfen">成分含量</label>:</td>
                <td><input type="text" id="chengfen" name="chengfen" maxlength="100" value="${goods.chengfen }" title="成分含量"></input></td>
                <td></td>
                <td width="90">&nbsp;<label for="batchid">商品批次号</label>:</td>
                <td width="156"><input type="text" id="batchid" name="batchid" maxlength="30" value="${goods.batchid }" title="商品批次号"></input>
                </td>
                <td></td>
            </tr>
             <tr>
                <td width="90"><font color="red">*</font>&nbsp;<label for="hyperlink">商品链接</label>:</td>
                <td width="156"><input type="text" id="hyperlink" name="hyperlink" maxlength="300" value="${goods.hyperlink }" title="商品链接"></input>
                </td>
                <td></td>
                <td>&nbsp;<label for="ciqgoodsno">商检备案号</label>:</td>
                <td><input type="text" id="ciqgoodsno" name="ciqgoodsno" maxlength="30" value="${goods.ciqgoodsno }" title="商检备案号,新增时可为空"></input></td>
                <td></td>
            </tr>
            <tr>
                <td>&nbsp;<label for="registno">海关备案号</label>:</td>
                <td><input type="text" id="registno" name="registno" maxlength="30" value="${goods.registno }" title="海关备案号,新增时可为空"></input></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form>
    </div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>
