<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ログイン</title>
    
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    text-align: center;
}

form {
    margin-top: 20px;
}

label {
    display: block;
    margin-top: 10px;
}

input[type="text"], input[type="password"] {
    width: 90%;
    padding: 10px;
    margin: 5px 0;
}

input[type="submit"], button[type="button"] {
    background-color: #007BFF;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 4px;
}

input[type="submit"]:hover, button[type="button"]:hover {
    background-color: #0056b3;
}


</style>
</head>
<body>
    <div class="container">
        <h2>給与管理</h2>
        <form method="post" action="login.do">
        <c:if test="${errors.odOrPwNotMarch}">
		아이디와 암호가 일치하지 않습니다.
		</c:if>
		<p>
            <label for="username">ID</label>
            <input type="text" id="username" name="id" required>
        </p>
            <br>
            <label for="password">PASSWORD</label>
            <input type="password" id="password" name="password" required>
            <br>
            <input type="submit" value="LOGIN">
            <button type="button" onclick="location.href='./joinUser.jsp'">JOIN</button>
        </form>
        
    </div>
</body>
</html>

