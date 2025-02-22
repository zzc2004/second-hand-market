<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>个人中心 <small>Personal Center</small></h2>
    </div>
    <div class="media">
        <div class="media-left media-middle">
            <a href="#">
                <img class="media-object" src="${pageContext.request.contextPath}${user.image}"
                     alt="${user.name}" style="width: 200px;height: 200px">
            </a>
        </div>
        <div class="media-body" style="padding-left: 40px">
            <h2 class="media-heading" style="font-weight: bold">${user.name}</h2>
            <h4>性别：${user.sex}</h4>
            <h4>余额：${user.balance}</h4>
            <h4>手机号：${user.tel}</h4>
            <h4>邮箱：${user.email}</h4>
            <h4>注册日期：${user.birthday}</h4>
            <c:if test="${user.type == '1'}">
                <h4>用户等级：超级管理员</h4>
            </c:if>
            <c:if test="${user.type == '2'}">
                <h4>用户等级：普通用户</h4>
            </c:if>
        </div>
        <hr>
        <div class="panel panel-default">
            <div class="panel-heading">Signature</div>
            <div class="panel-body">
                ${user.signature}
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/modifyUser" type="button" class="btn btn-default btn-lg btn-block">编辑信息</a>
        <a href="${pageContext.request.contextPath}" type="button" class="btn btn-default btn-lg btn-block">返回首页</a>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
