<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>二手交易平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <style>
        .mydiv {
            margin-left: 10%;
            margin-right: 10%;
            text-align: center;
            width: 80%;
            height: auto;
        }

        .myimg {
            width: 50%;
            height: 50%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container" style="width: 80%">
    <div class="jumbotron">
        <h2 style="text-align: center">望周知</h2>
        <p style="text-align: center">大家在交易时请先对方身份，谨防网络诈骗！如有任何问题请及时与有关部门联系！</p>
    </div>
</div>
<div class="mydiv">
    <div class="row">
        <c:set var="index" value="${(pageNumber-1)*4}" scope="page"/>
        <c:forEach items="${products}" var="item" begin="${(pageNumber-1)*pageSize}" end="${pageNumber*pageSize-1}">
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
                                <%--                            <a href="#"--%>
                                <%--                               class="btn btn-default"--%>
                                <%--                               role="button">收藏</a>--%>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<nav aria-label="Page navigation" style="text-align: center">
    <ul class="pagination">
        <li>
            <a href="${pageContext.request.contextPath}/prev?pageNumber=${pageNumber}&type=0" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" begin="1" end="${totalPages}">
            <li><a href="${pageContext.request.contextPath}/load?pageNumber=${i}&type=0">${i}</a></li>
        </c:forEach>
        <li>
            <a href="${pageContext.request.contextPath}/next?pageNumber=${pageNumber}&type=0" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<script>
    <%--$(".pagination li").click(function () {--%>
    <%--    $.ajax({--%>
    <%--        url: "${pageContext.request.contextPath}/load",--%>
    <%--        type: 'POST',--%>
    <%--        data: {--%>
    <%--            pageNumber:${pageNumber}--%>
    <%--        },--%>
    <%--        dataType: 'json',--%>
    <%--        success: function (data) {--%>
    <%--            console.log(data);--%>
    <%--            var productsHtml = '';--%>
    <%--            for (var i = 0; i < data.length; i++) {--%>
    <%--                productsHtml += `--%>
    <%--        <div class="col-sm-6 col-md-4">--%>
    <%--          <div class="thumbnail">--%>
    <%--            <img src="${data[i].imageUrl}" alt="${data[i].name}">--%>
    <%--            <div class="caption">--%>
    <%--              <h3 style="text-align: center">${data[i].name}</h3>--%>
    <%--              <hr>--%>
    <%--              <h4 style="text-align: center">${data[i].publisher}</h4>--%>
    <%--              <p style="text-align: center">单价：${data[i].price} | 库存：${data[i].quantity}</p>--%>
    <%--              <p style="text-align: center"><a href="#" class="btn btn-primary" role="button">购买</a> <a href="#" class="btn btn-default" role="button">加入购物车</a></p>--%>
    <%--            </div>--%>
    <%--          </div>--%>
    <%--        </div>--%>
    <%--      `;--%>
    <%--            }--%>
    <%--            $('.row').html(productsHtml);--%>
    <%--        },--%>
    <%--        error()--%>
    <%--    })--%>
    <%--    console.log("执行了！");--%>
    <%--    $(".pagination li").removeClass("active"); // 移除所有按钮的active类--%>
    <%--    $(this).addClass("active"); // 为当前点击的按钮添加active类--%>
    <%--});--%>
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>