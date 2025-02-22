<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>修改资料 <small>Modify Userinfo</small></h2>
    </div>
    <div class="media">
        <div class="media-left media-middle">
            <a href="#">
                <img class="media-object" src="${pageContext.request.contextPath}${user.image}"
                     alt="${user.name}" style="width: 200px;height: 200px">
            </a>
        </div>
        <div class="media-body" style="padding-left: 40px">
            <form method="post" action="${pageContext.request.contextPath}/modifyUser">
                <div class="form-group">
                    <label for="name">用户名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                </div>
                <div class="form-group">
                    <label for="sex">性别</label>
                    <input type="text" class="form-control" id="sex" name="sex" readonly="readonly" value="${user.sex}">
                </div>
                <div class="form-group">
                    <label for="tel">手机号</label>
                    <input type="text" class="form-control" id="tel" name="tel"  value="${user.tel}">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label for="signature">个性签名</label>
                    <input type="text" class="form-control" id="signature" name="signature" value="${user.signature}">
                </div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">保存修改</button>
            </form>
        </div>
        <hr>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
