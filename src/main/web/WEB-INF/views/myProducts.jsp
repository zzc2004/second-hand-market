<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${empty sessionScope.myProducts}">
    <div class="container" style="margin-top: 10%">
        <div class="jumbotron">
            <h1>商品不存在</h1>
            <p>您目前还没有发布任何商品哦~</p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/public"
                  role="button">发布商品</a></p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button">返回首页</a>
            </p>
        </div>
    </div>
</c:if>
<c:if test="${not empty sessionScope.myProducts}">
    <div class="container">
        <div class="page-header" style="margin-top: 0">
            <h2>我的商品 <small>My Goods</small></h2>
        </div>
        <c:forEach var="product" items="${myProducts}">
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object" src="${pageContext.request.contextPath}${product.image}" alt="..." style="width: 90px;height: 90px">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">${product.name}</h4>
                        ${product.description}
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/removeProduct?pid=${product.id}"
                       role="button" style="float: right">下架</a>
                    <a class="btn btn-default"
                       href="${pageContext.request.contextPath}/modifyProduct?pid=${product.id}" role="button"
                       style="float: right">编辑</a>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
