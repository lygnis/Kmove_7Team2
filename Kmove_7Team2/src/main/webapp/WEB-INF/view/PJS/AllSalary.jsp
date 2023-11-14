<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>급여대장</title>

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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.graph-container {
	width: 600px;
	height: 400px;
	border: 1px solid #ccc;
	margin: auto;
}
</style>
</head>
<body>
	<nav>
		<div id="top_menu">
			<div class="navi_2017">
				<ul class="navi_L_2017">
					<span id="SK01">HOME</span>


					<a href="/empReg.do" title="社員登録"> <span id="SK02">社員登録</span></a>

					<a href="/" title="社員現況"> <span id="SK03">社員現況</span></a>

					<a href="payRead.do" title="給与入力/管理"> <span id="SK07">給与入力/管理</span></a>

					<a href="AllPay.do" title="給与台帳"> <span id="SK09">給与台帳</span></a>
			

				</ul>
			</div>
		</div>
	</nav>

	<form id="myForm" method="post" action="AllPay.do">
		<div>
			<select name="year">
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<!-- 연도 옵션들 추가 -->
			</select> <input type="submit" value="연도 선택">
		</div>
	</form>

	<div align="center">
		<table border="1">
			<tr>
				<th>帰属年月</th>
				<th>支給日</th>
				<th>人数</th>
				<th>支給総額</th>
				<th>控除総額</th>
				<th>差引支給額</th>
				<th>削除</th>
			</tr>

			<c:forEach var="payData" items="${allPay.mapPay }">
				<tr onclick="window.location='monthPay.do?month=${payData.key}'">
					<td>${ payData.key}</td>
					<td>${ payData.key}月05日</td>

					<td>${empCount[payData.key]}</td>

					<td>${ payData.value}</td>
					<td>${allPay.mapDed[payData.key] }</td>
					<td>${ payData.value - allPay.mapDed[payData.key]}</td>
					<td>削除</td>
				</tr>
			</c:forEach>

		</table>
	</div>



	<div class="graph-container">
		<canvas id="combinedChart" width="600" height="400"></canvas>
	</div>

	<div align="center">
		<table border="1">
			<tr>
				<th>区分</th>
				<c:forEach var="payData" items="${allPay.mapPay }">
					<th width="70">${ payData.key}</th>
				</c:forEach>
			</tr>
			<tr>
				<th>差引支給額</th>
				<c:forEach var="realData" items="${allPayList }">
					<th width="70">${ realData}</th>
				</c:forEach>
			</tr>
			<tr>
				<th>増加率</th>
				<c:forEach var="perData" items="${per }">
					<th width="70">${ perData}</th>
				</c:forEach>
			</tr>
			<tr>
				<th>人数</th>
				<c:forEach var="empCount" items="${empCount }">
					<th width="70">${ empCount.value}</th>
				</c:forEach>
			</tr>

		</table>
	</div>

	<script>
		var arrayList = [];
		var empList = [];
	<%List<Integer> TarrayList = (List<Integer>) request.getAttribute("allPayList");
if (TarrayList != null) {%>
		
	<%for (Integer item : TarrayList) {%>
		arrayList.push(
	<%=item%>
		);
	<%}
}%>
		
	<%Map<Integer, Integer> myMap = (Map<Integer, Integer>) request.getAttribute("empCount");%>
		
	<%if (myMap != null) {
	for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {%>
		empList.push(
	<%=entry.getValue()%>
		);
	<%}
}%>
		const combinedCtx = document.getElementById('combinedChart')
				.getContext('2d');
		const combinedChart = new Chart(combinedCtx, {
			type : 'bar',
			data : {
				labels : [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10',
						'11', '12' ], // 연도
				datasets : [ {
					label : '給与',
					data : arrayList, // 각 연도별 급여 데이터
					backgroundColor : 'rgba(54, 162, 235, 0.2)',
					borderColor : 'rgba(54, 162, 235, 1)',
					borderWidth : 1
				}, {
					label : '人数',
					data : empList, // Data for the number of employees for each year
					yAxisID : 'employees',
					type : 'line',
					fill : false,
					borderColor : 'rgb(75, 192, 192)',
					tension : 0.1
				} ]
			},
			options : {
				scales : {
					y : {
						beginAtZero : true
					},
					employees : {
						position : 'right',
						suggestedMin : 0,
						suggestedMax : 50,
						ticks : {
							stepSize : 5
						}
					}
				}
			}
		});
	</script>

</body>
</html>