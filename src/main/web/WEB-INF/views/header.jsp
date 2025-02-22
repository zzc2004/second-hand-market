<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <title>二手交易平台</title>
</head>
<body>
<div class="page-header" style="margin-top: 20px">
    <h1 style="margin-left: 3%"><img src="${pageContext.request.contextPath}/static/images/icon/logo.png" style="width: 300px;height: 60px"><small>Let the second hand be brilliant again</small></h1>
</div>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="margin-left: 2%">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/static/images/icon/haust.jpg" alt="logo">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/index">首页 <span class="sr-only">(current)</span></a></li>
<%--                <li><a href="#">Link</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">商品分类 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/showByType?type=1">食品</a></li>
                        <li><a href="${pageContext.request.contextPath}/showByType?type=2">器材</a></li>
                        <li><a href="${pageContext.request.contextPath}/showByType?type=3">其他</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">商品管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/myProduct?id=${user.id}">我的商品</a></li>
                        <li><a href="${pageContext.request.contextPath}/public">发布商品</a></li>
                        <li><a href="${pageContext.request.contextPath}/shoppingCart">我的购物车</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/manageOrder?type=${user.type}">订单管理</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" method="post" action="${pageContext.request.contextPath}/search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="key" required>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/personal">个人中心</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">账号管理<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/modifyPasswordPage">修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/exit">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.js"></script>
</body>
</html>