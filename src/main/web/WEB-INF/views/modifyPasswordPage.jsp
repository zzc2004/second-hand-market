<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="page-header" style="margin-top: 0">
        <h2>修改密码 <small>Modify Password</small></h2>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/modifyPassword">
        <div class="input-group">
            <span class="input-group-addon" id="sizing-addon2">原密码</span>
            <input type="text" class="form-control" placeholder="Original Password" aria-describedby="sizing-addon2" name="oriPassword" required>
        </div>
        <hr>
        <div class="input-group">
            <span class="input-group-addon" id="sizing-addon3">新密码</span>
            <input type="text" class="form-control" placeholder="New Password" aria-describedby="sizing-addon2" name="newPassword" required>
        </div>
        <hr>
        <button type="submit" class="form-control btn-primary">提交</button>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
</body>
</html>
