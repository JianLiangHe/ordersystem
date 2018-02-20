<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/20
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                新增食品类型
            </h3>
        </div>
        <div class="panel-body">
            <form id="frm">
                食品名称:<input name="name" type="text"><br/>
                状态:<input name="status" type="radio" value="1" checked>启用
                <input name="status" type="radio" value="0">禁用
                <br/>
                创建日期:<input name="createtime" type="date"><br/>
                <input type="button" value="新增" onclick="saveFoodType();">
            </form>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">

    //新增商品类型
    function saveFoodType(){
        if(checkFoodTypeInfo()){
            var url = "${pageContext.request.contextPath}/foodTypeController/doSaveFoodType";
            var params = $("#frm").serialize();
            $.get(url,params,function(data){
                alert(data.message);
            },"json");
        }
    }

    //检查商品信息
    function checkFoodTypeInfo(){
        var name = $("input[name='name']")[0].value;
        var createtime = $("input[name='createtime']")[0].value;
        var flag = true;
        if(name.length<=0){
            alert("食品类型名称不能为空.");
            flag = false;
        }
        if(createtime.length<=0){
            alert("创建时间不能为空.");
            flag = false;
        }
        return flag;
    }

</script>
