<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read month salary</title>
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
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>支給日</th>
				<th>社員番号</th>
				<th>国民年金</th>
				<th>健康保険</th>
				<th>長期介護保険</th>
				<th>雇用保険</th>
				<th>所得税</th>
				<th>地方税</th>
				<th>基本給</th>
				<th>食費</th>
				<th>保育手当</th>
				<th>役職手当</th>
				<th>車両維持費</th>
				<th>勤続手当</th>
				<th>当直手当</th>
				<th>賞与</th>
				<th>休日手当</th>
			</tr>
			<c:forEach var="payData" items="${monthData.monthEmpData }">
				<tr>
					<td>${ payData.paymentData}</td>
					<td>${ payData.emp_no}월05일</td>

					<td>${payData.nationPen}</td>

					<td>${ payData.healInsur}</td>
					<td>${payData.elderInsur }</td>
					<td>${ payData.incomeTex}</td>
					<td>${ payData.localeIncomeTex}</td>
					<td>${ payData.mutualAid}</td>
					<td>${ payData.basicPay}</td>
					<td>${ payData.foodExp}</td>
					<td>${ payData.childAllow}</td>
					<td>${ payData.posAllow}</td>
					<td>${ payData.vehMainten}</td>
					<td>${ payData.servAllow}</td>
					<td>${ payData.callAllow}</td>
					<td>${ payData.bonus}</td>
					<td>${ payData.holiBonus}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>