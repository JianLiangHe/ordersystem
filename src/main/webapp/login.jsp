<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/11
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="title.jsp" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/MyAnimation.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <style type="text/css">
        body {background-image: url(images/backgroundImage.jpg); background-repeat: no-repeat; background-size: 100% 100%;}
    </style>
</head>
<body>
    <div class="login">
        <div class="login-content">
            <!-- 标题盒子开始 -->
            <div class="login-content-title">
                <span>后台登陆</span>
            </div>
            <!-- 标题盒子结束 -->

            <!-- 输入内容盒子开始 -->
            <div class="login-content-input">
                <form id="frm" action="${pageContext.request.contextPath}/loginController/doLogin" method="post" onsubmit="return login();">
                    <div class="input-box input-account">
                        <span id="accountTip" class="input-tip">${param.message}</span>
                        <input name="account" class="input-txt" id="account" type="text" placeholder="请输入工号" onfocus="clearTip(1);">
                    </div>
                    <div class="input-box input-password">
                        <span id="passwordTip" class="input-tip"></span>
                        <input name="password" class="input-txt" id="password" type="password" placeholder="请输入密码" onfocus="clearTip(2);">
                    </div>
                    <div class="input-box input-submit">
                        <input class="input-submit-btn" type="submit" value="登陆">
                    </div>
                </form>
            </div>
            <!-- 输入内容盒子结束 -->
        </div>
    </div>
</body>
</html><script type="text/javascript">

    //处理登陆
    function login(){
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;
        if(checkAccount(account)&&chekPassword(password)){
            return true;
        }
        return false;
    }

    //校验工号
    function checkAccount(account){
        if(account==null||account.length<6){
            var accountTip = document.getElementById("accountTip");
            accountTip.innerHTML = "工号输入有误。(长度6-12位)";
            document.getElementById("account").style.animation = "ring 0.5s";
            return false;
        }
        return true;
    }

    //校验密码
    function chekPassword(password){
        if(password==null||password.length<6){
            var passwordTip = document.getElementById("passwordTip");
            passwordTip.innerHTML = "密码输入格式有误。(长度6-12位)";
            document.getElementById("password").style.animation = "ring 0.5s";
            return false;
        }
        return true;
    }

    //清除提示信
    function clearTip(num){
        switch (num){
            case 1:
                document.getElementById("accountTip").innerHTML = "";
                break;
            case 2:
                document.getElementById("passwordTip").innerHTML = "";
                break;
        }
    }

</script>
