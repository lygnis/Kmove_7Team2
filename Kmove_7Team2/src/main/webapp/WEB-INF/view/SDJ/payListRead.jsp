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
					<label for="date">給与日付</label>
    <input type="month" name="date" id="date">
    <input type="submit" value="検索">
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
					<c:if test="${DEDUCTION_ITEM.hasNopayment_date()}">
						<tr>
							<td colspan='7'>NONE</td>
						</tr>
					</c:if>
					<c:forEach var='article' items="${articlePage.content}">
						<tr>
							<td>${article.number}</td>
							<td><a
								href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
									<c:out value="${article.title}" />
							</a></td>
							<td>${article.writer.name}</td>
							<td>${article.readCount}</td>
						</tr>
					</c:forEach>


					<!-- 여기에 급여 정보 데이터를 출력하는 부분 -->
				</table>
			</div>
		</div>
		<div class="right">
			<!-- 오른쪽 화면에 급여 및 공제 항목 입력 표시 -->
			<div align='center'>
				<h2>給与,控除項目入力</h2>

				<form action="processSalary.jsp" method="get">
					<table width='600'>
						<tr>
							<th>支給項目</th>
							<!--지급항목-->
							<th>共済項目</th>
						</tr>
						<tr>
							<th>基本給与<input type='text' name='normalPay'>
							</th>
							<th>国民年金<input type='text' name='nationPen'>
							</th>
						</tr>
						<tr>
							<th>食費<input type='text' name='foordExp'>
							</th>
							<th>健康保険<input type='text' name='healInsur'>
							</th>
						</tr>
						<tr>
							<th>保育手当<input type='text' name='childAllow '>
							</th>
							<th>長期療養保険<input type='text' name='elderInsur'>
							</th>
						</tr>
						<tr>
							<th>役職手当<input type='text' name='posAllow'>
							</th>
							<th>雇用保険<input type='text' name='employInsur '>
							</th>
						</tr>
						<tr>
							<th>車両維持費<input type='text' name='vehMainten'>
							</th>
							<th>所得税<input type='text' name='incTex'>
							</th>
						</tr>
						<tr>
							<th>勤続手当<input type='text' name='servAllow'>
							</th>
							<th>地方所得税<input type='text' name='locIncTex'>
							</th>
						</tr>
						<tr>
							<th>当直手当<input type='text' name='callAllow'>
							</th>
							<th>互助会費<input type='text' name='mutualAid'>
							</th>
						</tr>
						<tr>
							<th>賞与金<input type='text' name='bonus'>
							</th>

						</tr>
						<tr>
							<th>休日手当<input type='text' name='holiAllow'></th>
							<th>支給日<input type='text' name='payDay'></th>
							<th></th>
						</tr>

					</table>
					<br /> <br />
					<!-- 여기에 급여 항목과 급여량을 입력하는 부분 -->

					<input type="submit" name='貯蔵' value="save">
				</form>
			</div>
		</div>
	</div>
</body>
</html>