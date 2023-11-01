<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>給与管理システム</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<nav>
		<ul>
			<li><a href="main.jsp">メイン画面</a></li>
			<li><a href="salaryManagement.jsp">給与入力</a></li>
			<li><a href="salaryQuery.jsp">給与支給管理</a></li>

		</ul>
	</nav>

	<div class="container">
		<div class="left">
			<!-- 왼쪽 화면에 급여 정보 표시 -->
			<div align='center'>
				<h2>給与情報</h2>
				<div align='right'>
					<label for="date"> 給与日 <input type="date" id="date"
						max="2077-12-31" value="급여일">
					</label>
				</div>
				<table border='1' width='600'>
					<tr>
						<th>社員名</th>
						<th>部署</th>
						<th>役職区分</th>
						<th>給与日付</th>
						<th>給与支給</th>
						<th>控除金額</th>
						<th>実支給額</th>
					</tr>


					<!-- 여기에 급여 정보 데이터를 출력하는 부분 -->
				</table>
			</div>
		</div>
		<div class="right">
			<!-- 오른쪽 화면에 급여 및 공제 항목 입력 표시 -->
			<div align='center'>
				<h2>給与と控除項目の入力</h2>

				<form action="processSalary.jsp" method="post">
					<table width='600'>
						<tr>
							<th>支給項目</th><!--지급항목-->
							<th>共済項目</th>
						</tr>
						<tr>
							<th>基本給与<input type='text' name='id'>
							</th>
							<th>国民年金<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>食費<input type='text' name='id'>
							</th>
							<th>健康保険<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>保育手当<input type='text' name='id'>
							</th>
							<th>長期療養保険<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>役職手当<input type='text' name='id'>
							</th>
							<th>雇用保険<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>車両維持費<input type='text' name='id'>
							</th>
							<th>所得税<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>勤続手当<input type='text' name='id'>
							</th>
							<th>地方所得税<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>当直手当<input type='text' name='id'>
							</th>
							<th>互助会費<input type='text' name='?'>
							</th>
						</tr>
						<tr>
							<th>賞与金<input type='text' name='id'>
							</th>
							<th></th>
						</tr>
						<tr>
							<th>休日手当<input type='text' name='id'>
							</th>
							<th></th>
						</tr>

					</table>
					<br/>
					<br/>
					<!-- 여기에 급여 항목과 급여량을 입력하는 부분 -->

					<input type="submit" name='貯蔵'value="貯蔵">
				</form>
			</div>
		</div>
	</div>
</body>
</html>