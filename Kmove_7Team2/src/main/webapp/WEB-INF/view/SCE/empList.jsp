<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style type="text/css">
select {
	width: 150px;
	padding: 5px;
	margin-bottom: 20px;
	margin-right: 100px;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #e2e2e2;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
		<div id="top_menu">
			<div class="navi_2017">
				<ul class="navi_L_2017">
					<span id="SK01">HOME</span>


					<a href="empReg.do" title="社員登録"> <span id="SK02">社員登録</span></a>

					<a href="empList.do" title="社員現況"> <span id="SK03">社員現況</span></a>

					<a href="payRead.do" title="給与入力/管理"> <span id="SK07">給与入力/管理</span></a>

					<a href="AllPay.do" title="給与台帳"> <span id="SK09">給与台帳</span></a>

				</ul>
			</div>
		</div>
	</nav>
	<div align="center">
		<table border="1">
			<tr>
				<th>社員番号</th>
				<th>氏名</th>
				<th>入社日</th>
				<th>退社日</th>
				<th>部署</th>
				<th>役職</th>
			</tr>
			<c:forEach var="info" items="${emplist.list }">
			<tr>
				<td>${info.empNo}</td>
				<td>${info.name}</td>
				<td>${info.joinDate}</td>
				<td>${info.quitDate}</td>
				<td>${info.department}</td>
				<td>${info.spot}</td>
			</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>