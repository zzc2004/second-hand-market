<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${empty sessionScope.shoppingCart}">
    <div class="container" style="margin-top: 10%">
        <div class="jumbotron">
            <h1>购物车为空</h1>
            <p>购物车里空空如也，快去选购商品吧~</p>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/index"
                  role="button">去首页选购商品</a></p>
        </div>
    </div>
</c:if>
<c:if test="${not empty sessionScope.shoppingCart}">
    <div class="container">
        <div class="page-header" style="margin-top: 0">
            <h2>我的购物车 <small>My Shopping-Cart</small></h2>
        </div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>商品预览</th>
                <th>商品名称</th>
                <th>单价</th>
                <th>发布者</th>
                <th>数量</th>
                <th>总价</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.shoppingCart}" var="product">
                <tr>
                    <td><img src="${pageContext.request.contextPath}${product.image}" style="width: 30px;height: 30px" alt=""></td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.publisher}</td>
                    <td><input type="number" class="form-control" value="${product.quantity}" min="1"
                               max="${product.quantity}"></td>
                    <td>${product.price*product.quantity}</td>
                    <td><a class="btn btn-default"
                           href="${pageContext.request.contextPath}/checkOut?pid=${product.pid}&uid=${user.id}&price=${product.price}&quantity=${product.quantity}&image=${product.image}&type=1"
                           role="button" style="float: left">购买</a>
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/deleteGoods?image=${product.image}" role="button" style="float: left">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr>
        <a href="${pageContext.request.contextPath}" class="btn btn-primary" id="checkout" style="width: 100%">返回首页</a>
    </div>
</c:if>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script>
    $(document).ready(function () {
        // 更新总价
        $('input[type="number"]').on('input', function () {
            var price = parseFloat($(this).closest('tr').find('td:eq(2)').text());
            var quantity = parseInt($(this).val());
            var totalPrice = price * quantity;
            // console.log($(this).closest('tr').find('td:eq()').text())
            $(this).closest('tr').find('td:eq(5)').text(totalPrice);
        });
    });

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
