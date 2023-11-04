<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>会員加入</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
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
    width: 350px;
  	height: 525px;
  	position: relative;
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

input[type="submit"] {
    background-color: #007BFF;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 4px;
     position: absolute;
  	bottom: 35px; /* 원하는 위치의 상단 여백 */
  	left: 150px;
}

input[type="submit"]:hover {
    background-color: #0056b3;
    /* 원하는 위치의 왼쪽 여백 */
}


</style>
</head>
<body>
    <div class="container">
        <h2>会員加入</h2>
        <form method="post" action="join.do">
        <p>
            <label for="username">ID(社員番号)</label>
            <input type="text" id="username" name="emp_no">
            <c:if test="${errors.emp_no}">ID(社員番号)を入力してください。</c:if>
			<c:if test="${errors.duplicateId}">すでに使用中のIDです。</c:if>
			<c:if test="${errors.IdNotExist}">ない社員番号です。</c:if>
        </p>
            <br>
        <p>
            <label for="password">暗号</label>
            <input type="password" id="password" name="password">
            <c:if test="${errors.password}">パスワードを入力してください。</c:if>
        </p>    
            <br>
        <p>    
            <label for="password">暗号確認</label>
            <input type="password" id="confirmPassword" name="confirmPassword">
            <c:if test="${errors.confirmPassword}">パスワード確認を入力してください。</c:if>
			<c:if test="${errors.notMatch}">パスワードと確認が一致しません···</c:if>
         </p>  
            <br>
            <input type="submit" value="JOIN">
            
        </form>
    </div>
</body>
</html>

