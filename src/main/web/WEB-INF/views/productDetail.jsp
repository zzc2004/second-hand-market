<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>商品详情 <small>Goods Detail</small></h2>
    </div>
    <div class="media">
        <div class="media-left media-middle">
            <a href="#">
                <img class="media-object" src="${pageContext.request.contextPath}${detail.image}"
                     alt="${detail.name}" style="width: 300px;height: 300px">
            </a>
        </div>
        <div class="media-body" style="padding-left: 40px">
            <h2 class="media-heading" style="font-weight: bold">${detail.name}</h2>
            <h4>发布者：${detail.publisher}</h4>
            <h4>发布时间：${detail.time}</h4>
            <h4>原价：${detail.oriPrice}</h4>
            <h4>现价：${detail.price}</h4>
            <h4>库存：${detail.quantity}</h4>
            <h4>取货地点：${detail.location}</h4>
            <h4>商品描述：${detail.description}</h4>
            <button class="btn btn-default" type="button" onclick="decrease()">-</button>
            <input type="text" value="1" id="quantity" readonly max="${detail.quantity}">
            <button class="btn btn-default" type="button" onclick="increase()">+</button>
        </div>
    </div>
    <p>
        <a href="${pageContext.request.contextPath}/checkOut?pid=${detail.id}&uid=${user.id}&price=${detail.price}&quantity=${detail.quantity}&image=${detail.image}&type=2"
           type="button" class="btn btn-default btn-lg btn-block" id="buy">购买</a>
        <a href="${pageContext.request.contextPath}/addGoods?id=${detail.id}&quantity=${detail.quantity}&price=${detail.price}"
           type="button" class="btn btn-default btn-lg btn-block" id="addCart">加入购物车</a>
    </p>
</div>
<script>
    $('#buy').click(function(event){
        event.preventDefault();
        let quantity = document.getElementById('quantity').value;
        window.location.href="${pageContext.request.contextPath}/checkOut?pid=${detail.id}&uid=${user.id}&price=${detail.price}&quantity="+quantity+"&image=${detail.image}&type=2"
    })
    $('#addCart').click(function(event){
        event.preventDefault();
        let quantity = document.getElementById('quantity').value;
        window.location.href="${pageContext.request.contextPath}/addGoods?id=${detail.id}&quantity="+quantity+"&price=${detail.price}&type=2"
    })
    function increase() {
        let quantity = document.getElementById('quantity');
        if (parseInt(quantity.value) < parseInt(quantity.max)) {
            quantity.value = parseInt(quantity.value) + 1;
        }
    }

    function decrease() {
        let quantity = document.getElementById('quantity');
        if (parseInt(quantity.value) > 1) {
            quantity.value = parseInt(quantity.value) - 1;
        }
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
