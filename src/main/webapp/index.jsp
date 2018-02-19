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
    <title>点餐系统</title>
    <style rel="stylesheet" type="text/css">
        * {margin: 0;}

        .content {width: 100%; height: 600px; border: 1px solid black;}
        .float-left {float: left;}
        .content .content-left {width: 20%; height: 100%;}
        .content .content-right {width: 80%; height: 100%; padding-left: 6px; background: gray;}
    </style>
</head>
<body>
    <div class="content">
        <!-- 内容左边部分开始 -->
        <div class="content-left float-left">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <ul>
                                <li><a href="javascript:loadPage('${pageContext.request.contextPath}/pages/user/saveUser.jsp');">新增用户</a></li>
                                <li><a href="javascript:loadPage('${pageContext.request.contextPath}/pages/user/userMain.jsp');">用户列表</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo">
                                食品类型管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul>
                                <li><a href="">新增类型</a></li>
                                <li><a href="">类型列表</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree">
                                优惠管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul>
                                <li><a href="">新增优惠</a></li>
                                <li><a href="">优惠列表</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 内容左边部分结束 -->

        <!-- 内容右边部分开始 -->
        <div id="content-right" class="content-right float-left">

        </div>
        <!-- 内容右边部分结束 -->
    </div>
</body>
</html>
<script type="text/javascript">

    function loadPage(url){
        $("#content-right").html("").load(url);
    }

</script>
