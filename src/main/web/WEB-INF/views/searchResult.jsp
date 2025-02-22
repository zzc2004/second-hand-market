<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${empty sessionScope.searchResult}">
    <div class="container" style="margin-top: 10%">
        <div class="jumbotron">
            <h1>商品不存在</h1>
            <p>搜索不到您所需要的商品，可以尝试更换关键词搜索一下TvT</p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button">返回首页</a>
            </p>
        </div>
    </div>
</c:if>
<c:if test="${not empty sessionScope.searchResult}">
    <div class="container">
        <div class="page-header" style="margin-top: 0">
            <h2>搜索结果 <small>Search Results</small></h2>
        </div>
        <c:forEach var="product" items="${searchResult}">
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object" src="${pageContext.request.contextPath}${product.image}" alt="..." style="width: 90px;height: 90px">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">${product.name}</h4>
                        ${product.description}
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/detail?pid=${product.id}"
                       role="button" style="float: right">商品详情</a>
                        <%--                    <a class="btn btn-default" href="#" role="button" style="float: right">收藏</a>--%>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
