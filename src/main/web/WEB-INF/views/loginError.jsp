<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<div class="page-header">
    <h1 style="margin-left: 3%">科大二手交易平台 <small>Let the second hand be brilliant again</small></h1>
</div>
<div class="container"  style="margin-top:10%">
    <div class="jumbotron">
        <h1>登录失败</h1>
        <p>账号或密码错误，登录失败！</p>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button">返回登录页面</a></p>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
