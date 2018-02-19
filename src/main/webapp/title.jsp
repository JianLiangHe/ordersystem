<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/13
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style rel="stylesheet" type="text/css">
        * {margin: 0;}

        .head-content {width: 80%;}

    </style>
</head>
<body>
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid head-content">
            <div class="navbar-header">
                <img width="50" height="50" src="images/logo.jpg">
            </div>

            <c:if test="${loginUser!=null}">
            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">点餐</a></li>
                    <c:if test="${loginUser.privilege==2}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            操作 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:loadHtml('${pageContext.request.contextPath}/pages/user/userMain.jsp');">用户管理</a></li>
                            <li class="divider"></li>
                            <li><a href="#">食品类型管理</a></li>
                            <li class="divider"></li>
                            <li><a href="#">优惠管理</a></li>
                            <li class="divider"></li>
                            <li><a href="#">销售报表</a></li>
                        </ul>
                    </li>
                    </c:if>
                    <li><a href="#">个人设置</a></li>
                </ul>
            </div>
            </c:if>
        </div>
    </nav>
</body>
</html>