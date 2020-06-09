<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>登录</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<h2>${msg}</h2>
	<div class="container">
      <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading" align="center">登    录</h2>
      
        <p>
        <input type="text"  class="form-control"  name="name" placeholder="用户名" required>
        </p>
        <p>
        <input type="password" class="form-control" name="password"  placeholder="密码" required>
        </p>
        
        <a href="${pageContext.request.contextPath}/toRegister">还没注册用户？去注册</a>
        <a class="a2" href="${pageContext.request.contextPath}/forgetPwd" >忘记密码？</a>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
      
    </div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</body>
</html>