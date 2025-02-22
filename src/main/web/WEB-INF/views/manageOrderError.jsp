<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>T权限不足</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<body>
<jsp:include page="header.jsp"/>
<div class="container"  style="margin-top:10%">
    <div class="jumbotron">
        <h1>权限不足</h1>
        <p>您没有权限访问此界面！</p>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button">返回首页</a></p>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
