<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<title>注册</title>
</head>
<body>
<div class="container">
      <form class="form-signin" action="${pageContext.request.contextPath}/register" method="post">
        <h2 class="form-signin-heading" align="center">注册</h2>
       <p>
        <input type="email" name="email" id="email"class="form-control" placeholder="邮箱地址" required onblur="verifyemail()">
        <span id="emailInfo"></span>
       </p>
       <p>
        <input type="text"  name="name" id="name" class="form-control"  placeholder="用户名" required onblur="verifyname()">
        <span id="nameInfo"></span>
       </p>
       <p>
        <input type="password" name="password" id="password" class="form-control" placeholder="密码(长度8~16位)" required onblur="verifypassword()">
        <span id="passwordInfo"></span>
       </p>
        <p>
        <input type="password" name="password2" id="password2" class="form-control" placeholder="确认密码" required onblur="verifypassword2()">
        <span id="password2Info"></span>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        
      </form>
      
    </div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

<script type="text/javascript">
	function verifyemail(){
	    $.post({
	        url:"${pageContext.request.contextPath}/Ajax/verifyemail",
	        data:{'email':$("#email").val()},
	        success:function (data) {
	            if (data.toString()=='OK'){
	                $("#emailInfo").css("color","green");
	           }else {
	                $("#emailInfo").css("color","red");
	           }
	            $("#emailInfo").html(data);
	       }
	   });
	}
	
	function verifyname(){
	    $.post({
	        url:"${pageContext.request.contextPath}/Ajax/verifyname",
	        data:{'name':$("#name").val()},
	        success:function (data) {
	            if (data.toString()=='OK'){
	                $("#nameInfo").css("color","green");
	           }else {
	                $("#nameInfo").css("color","red");
	           }
	            $("#nameInfo").html(data);
	       }
	   });
	}
	function verifypassword(){
	    $.post({
	        url:"${pageContext.request.contextPath}/Ajax/verifypassword",
	        data:{'password':$("#password").val()},
	        success:function (data) {
	            if (data.toString()=='OK'){
	                $("#passwordInfo").css("color","green");
	           }else {
	                $("#passwordInfo").css("color","red");
	           }
	            $("#passwordInfo").html(data);
	       }
	   });
	}
	function verifypassword2(){
	    $.post({
	        url:"${pageContext.request.contextPath}/Ajax/verifypassword2",
	        data:{'password':$("#password").val(),'password2':$("#password2").val()},
	        success:function (data) {
	            if (data.toString()=='OK'){
	                $("#password2Info").css("color","green");
	           }else {
	                $("#password2Info").css("color","red");
	           }
	            $("#password2Info").html(data);
	       }
	   });
	}
</script>

</body>
</html>