<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册界面</title>
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
    <h1 style="text-align: center">注册</h1>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="name">昵称</label>
        <input type="text" id="name" name="name"  class="form-control" required>
        <label for="username">用户名</label>
        <input type="text" id="username" name="username"  class="form-control" required>

        <label for="password">密码</label>
        <input type="password" id="password" name="password" class="form-control" required>

        <label for="confirm_password">确认密码</label>
        <input type="password" id="confirm_password" name="confirm_password" class="form-control" required
               oninput="checkPasswordMatch()">
        <div id="passwordError" style="color:red; margin-bottom:10px;"></div>
        <label for="phone">手机号</label>
        <input type="text" id="phone" name="phone" class="form-control" required>

        <label for="email">邮箱</label>
        <input type="text" id="email" name="email" class="form-control" required>

        <label for="gender">性别</label>
        <select id="gender" name="gender" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>

        <label for="birthdate">出生日期</label>
        <input type="date" id="birthdate" name="birthdate" class="form-control" required>
        <hr>
        <button type="submit">注册</button>
    </form>

</div>
<script>
    // 实时检查密码匹配情况
    function checkPasswordMatch() {
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm_password').value;
        const errorDiv = document.getElementById('passwordError');

        if (password !== confirmPassword) {
            errorDiv.textContent = "密码不一致！";
            return false;
        }
        errorDiv.textContent = "";
        return true;
    }

    // 提交时最终验证
    function validatePassword() {
        if (!checkPasswordMatch()) {
            alert("请确认两次输入的密码一致");
            return false;
        }
        return true;
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.js"></script>
</body>
</html>
