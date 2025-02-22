<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类展示</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${empty sessionScope.typeProducts}">
    <div class="container" style="margin-top: 10%">
        <div class="jumbotron">
            <h1>暂无商品</h1>
            <p>当前分分类下暂无商品，请耐心等待其他同学发布~</p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/index"
                  role="button">去首页选购其他商品</a></p>
        </div>
    </div>
</c:if>
<c:if test="${not empty sessionScope.typeProducts}">
    <div class="container">
        <div class="page-header" style="margin-top: 0">
            <h2>分类展示 <small>There are:${type==1?"食品":(type==2)?"器材":"其他"}</small></h2>
        </div>
        <div class="row">
            <c:set var="index" value="${(pageNumber-1)*4}" scope="page"/>
            <c:forEach items="${typeProducts}" var="item" begin="${(pageNumber-1)*pageSize}" end="${pageNumber*pageSize-1}">
                <c:set var="index" value="${index+1}" scope="page"/>
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}${item.image}" alt="${item.name}" style="width: 200px;height: 200px">
                        <div class="caption">
                            <h3 style="text-align: center">${item.name}</h3>
                            <hr>
                            <h4 style="text-align: center">${item.publisher}</h4>
                            <p style="text-align: center">单价：${item.price} | 库存：${item.quantity}</p>
                            <p style="text-align: center"><a
                                    href="${pageContext.request.contextPath}/detail?pid=${item.id}"
                                    class="btn btn-primary" role="button">详情</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>

<nav aria-label="Page navigation" style="text-align: center">
    <ul class="pagination">
        <li>
            <a href="${pageContext.request.contextPath}/prev?pageNumber=${pageNumber}&type=${type}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${maxPages}">
            <li><a href="${pageContext.request.contextPath}/load?pageNumber=${i}&type=${type}">${i}</a></li>
        </c:forEach>
        <li>
            <a href="${pageContext.request.contextPath}/next?pageNumber=${pageNumber}&type=${type}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
