<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>订单管理 <small>Orders Manege</small></h2>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>订单编号</th>
            <th>商品id</th>
            <th>购买用户id</th>
            <th>购买数量</th>
            <th>交易额</th>
            <th>订单生成时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.oid}</td>
                <td>${order.pid}</td>
                <td>${order.uid}</td>
                <td>${order.quantity}</td>
                <td>${order.price}</td>
                <td>${order.time}</td>
                <td><a class="btn btn-default" href="${pageContext.request.contextPath}/deleteOrder?oid=${order.oid}" role="button" style="float: left">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}" type="button" class="btn btn-primary btn-lg btn-block">返回首页</a>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
