<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            width: 40%;
            padding: 16px;
            background-color: white;
            margin: 100px auto;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 24px;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            border-radius: 4px;
        }
        button:hover {
            opacity: 0.8;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<div class="page-header">
    <h1 style="margin-left: 3%">科大二手交易平台 <small>Let the second hand be brilliant again</small></h1>
</div>
<div class="container">
    <h2>登录</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username"><b>用户名</b></label>
        <input type="text" placeholder="输入用户名" name="username" required>

        <label for="password"><b>密码</b></label>
        <input type="password" placeholder="输入密码" name="password" required>
        <p><a href="${pageContext.request.contextPath}/register" style="text-align: right">还没有账号？点我注册</a></p>
        <button type="submit">登录</button>
    </form>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.js"></script>
</body>
</html>

