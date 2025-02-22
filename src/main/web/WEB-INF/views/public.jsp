<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>发布闲置</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
    <style>
        /*#myimg{*/
        /*    width: 20%;*/
        /*    height: 20%;*/
        /*}*/
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>

<%--    <link rel="stylesheet" href="css/fore/publish.css"/>--%>

    <script>
        function select_single(file) {
            if (!file.files || !file.files[0]) {
                return;
            }

            var fileSize = 0;
            var fileMaxSize = 10*1024;//10M
            var filePath = file.value;
            if(filePath){
                fileSize =file.files[0].size;
                var size = fileSize / 1024;
                if (size > fileMaxSize) {
                    alert("文件大小不能大于10M！");
                    file.value = "";
                    return false;
                }else if (size <= 0) {
                    alert("上传失败，请重新选择图片！");
                    file.value = "";
                    return false;
                }
            }else{
                return false;
            }

            //定以一个读取文件的对象
            var reader = new FileReader();

            reader.onload = function (evt) {
                //获取的是图片的base64代码
                var replaceSrc = evt.target.result;
                // 再将获取值赋给img标签
                $('#myimg').attr("src", replaceSrc).css("width","20%").css("height","20%");
            };
            reader.readAsDataURL(file.files[0]);
        }

    </script>

</head>

<body>

<jsp:include page="header.jsp"/>


<%--<div class="container" style="margin-bottom: 10px;">--%>
<%--    <span class="publish-name">${user.name}&nbsp;&nbsp;发布闲置&nbsp;&nbsp;上传物品主体图片</span>--%>
<%--</div>--%>
<div class="container" style="width: 40%">
    <div class="page-header" style="margin-top: 0">
        <h2>发布商品 <small>Publish Goods</small></h2>
    </div>
    <form action="${pageContext.request.contextPath}/public" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="publisher">发布者</label>
            <input type="text" class="form-control" id="publisher" name="publisher" readonly="readonly" value="${user.name}">
        </div>
        <div class="form-group">
            <label for="pname">物品名称</label>
            <input type="text" class="form-control" id="pname" name="pname" placeholder="请输入要发布的物品名称" required>
        </div>
        <div class="form-group">
            <label for="type">物品种类</label>
            <select id="type" name="type" class="form-control">
                <option value="食品">食品</option>
                <option value="器材">器材</option>
                <option value="其他" selected>其他</option>
            </select>
        </div>
        <div class="form-group">
            <label for="originalPrice">原价</label>
            <input type="text" class="form-control" id="originalPrice" name="originalPrice" placeholder="请输入商品购买时的原价" required>
        </div>
        <div class="form-group">
            <label for="nowPrice">售价</label>
            <input type="text" class="form-control" id="nowPrice" name="nowPrice" placeholder="请输入您的商品售价" required>
        </div>
        <div class="form-group">
            <label for="quantity">数量</label>
            <input type="text" class="form-control" id="quantity" name="quantity" placeholder="请输入您要上架的商品数量" required>
        </div>
        <div class="form-group">
            <label for="location">提货地点</label>
            <input type="text" class="form-control" id="location" name="location" placeholder="请输入该商品的提货地点" required>
        </div>
        <div class="form-group">
            <label for="image">上传图片</label>
            <input type="file" id="image" name="image" accept="image/*" onchange="select_single(this)">
            <img src="" id="myimg"/>
        </div>
        <div class="input-group">
            <span class="input-group-addon" id="sizing-addon2">商品描述</span>
            <input type="text" id="description" name="description" class="form-control" placeholder="简单描述一下你的商品吧~" aria-describedby="sizing-addon2" required>
        </div>
        <hr>
        <button type="submit" class="btn btn-default" style="width: 100%">发布</button>
        <p class="help-block" style="text-align: center">请确认商品信息无误后进行发布哦~</p>
    </form>

<%--    <form id="form_2" action="${pageContext.request.contextPath}/UploadServlet?username=${user.name}" method="post" enctype="multipart/form-data"--%>
<%--          style="width: 600px;height: 160px; display: inline-block; float: right;">--%>
<%--        <div class="row" style="height: 120px;">--%>
<%--            <div class="col-25">--%>
<%--                <label for="itemImage_single">物品主图片</label>--%>
<%--            </div>--%>
<%--            <div class="col-75" style="margin-top: 20px;">--%>
<%--                <input type="file" id="itemImage_single" name="itemImage_single" accept="image/*"--%>
<%--                       onchange="select_single(this)" required style="width: 50%;">--%>
<%--&lt;%&ndash;                <img src="" id="img-single"/>&ndash;%&gt;--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <input type="hidden" name="type" value="type_single" />--%>
<%--                <input type="hidden" name="iid" value="${user.name}" />--%>

<%--                <button id="publishNext-submit-button" type="submit" class="btn btn-lg"  >立即发布</button>--%>
<%--            </div>--%>


<%--        </div>--%>
<%--    </form>--%>
</div>

<%--<div style="position: fixed ;bottom: 80px;right: 110px;">--%>
<%--    <a href="index.jsp"><img src="img/fore/index.png"></a>--%>
<%--</div>--%>

</body>

</html>