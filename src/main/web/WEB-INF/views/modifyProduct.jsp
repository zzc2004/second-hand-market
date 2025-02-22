<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑商品信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
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
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>编辑商品信息 <small>Modify ProductInfo</small></h2>
    </div>
    <form action="${pageContext.request.contextPath}/modifyProduct" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="id">商品id</label>
            <input type="text" class="form-control" id="id" name="id" readonly="readonly" value="${param.pid}">
        </div>
        <div class="form-group">
            <label for="publisher">发布者</label>
            <input type="text" class="form-control" id="publisher" name="publisher" readonly="readonly" value="${user.name}">
        </div>
        <div class="form-group">
            <label for="pname">物品名称</label>
            <input type="text" class="form-control" id="pname" name="pname" placeholder="请输入新的物品名称" required>
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
            <input type="text" class="form-control" id="nowPrice" name="nowPrice" placeholder="请输入新的商品售价" required>
        </div>
        <div class="form-group">
            <label for="quantity">数量</label>
            <input type="text" class="form-control" id="quantity" name="quantity" placeholder="请输入目前的商品数量" required>
        </div>
        <div class="form-group">
            <label for="location">提货地点</label>
            <input type="text" class="form-control" id="location" name="location" placeholder="请输入该商品的提货地点" required>
        </div>
        <div class="form-group">
            <label for="image">更新图片</label>
            <input type="file" id="image" name="image" accept="image/*" onchange="select_single(this)">
            <img src="" id="myimg"/>
        </div>
        <div class="input-group">
            <span class="input-group-addon" id="sizing-addon2">商品描述</span>
            <input type="text" id="description" name="description" class="form-control" placeholder="简单描述一下你的商品吧~" aria-describedby="sizing-addon2" required>
        </div>
        <hr>
        <button type="submit" class="btn btn-default" style="width: 100%">提交修改</button>
        <p class="help-block" style="text-align: center">请确认商品信息无误后再提交修改哦~</p>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
