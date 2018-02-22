<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/15
  Time: 14:32
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
                新增VIP卡
            </h3>
        </div>
        <div class="panel-body">
            <form id="frm">
                <div id="errorTips" style="color: red;"></div>
                VIP卡账号:<input name="account" type="text"><br/>
                密码:<input name="password" type="text"><br/>
                积分:<input name="integral" type="text" value="0"><br/>
                状态:<input name="status" type="radio" value="1" checked>启用
                    <input name="status" type="radio" value="0">禁用<br/>
                手机号码:<input name="tel" type="text"><br/>
                电子邮箱:<input name="email" type="text"><br/>
                创建日期:<input name="createtime" type="date"><br/>
                <input type="button" value="新增" onclick="saveVIPCard();">
            </form>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">

    //新增用户
    function saveVIPCard(){
        $("#errorTips").html("");
        var url = "${pageContext.request.contextPath}/preferentialController/doSaveVIPCard";
        var params = $("#frm").serialize();
        $.get(url,params,function(data){
            if(data.code==401){
                $.each(data.value,function(i,v){
                    var opt = "<span style='display: block;'>"+v.defaultMessage+"</span>";
                    $("#errorTips").append(opt);
                });
            }else if(data.code==400){
                var opt = "<span style='display: block;'>"+data.message+"</span>";
                $("#errorTips").append(opt);
            }else if(data.code==200){
                var opt = "<span style='display: block; color: green;'>"+data.message+"</span>";
                $("#errorTips").append(opt);
            }
        },"json");
    }

    //验证输入信息
    /*function checkInfo(){
        var flag = true;
        var account = document.getElementsByName("account")[0].value;
        var password = document.getElementsByName("password")[0].value;
        var createtime = document.getElementsByName("createtime")[0].value;
        if(account==null||account.length<6||account.length>12){
            alert("工号输入不正确,长度范围6-12位!");
            flag = false;
        }
        if(password==null||password.length<6||password.length>12){
            alert("密码输入不正确,长度范围6-12位!");
            flag = false;
        }
        if(createtime==null||createtime.length<=0){
            alert("创建日期不能为空!");
            flag = false;
        }
        return flag;
    }*/


</script>
