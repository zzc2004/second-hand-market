<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加成功</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container"  style="margin-top:10%">
    <div class="jumbotron">
        <h1>添加成功</h1>
        <p>商品已经成功添加到您的购物车，单击下方按钮返回主页~</p>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button">返回首页</a></p>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
