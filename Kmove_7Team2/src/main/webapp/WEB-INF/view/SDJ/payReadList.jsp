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
<title>給与管理システム</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
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

	<script>
    function validateForm() {
        var dateInput = document.getElementById('date');
        var checkboxes = document.querySelectorAll('.empCheckbox');

        // Check if either the date or at least one checkbox is not filled
        if (dateInput.value === '' || !Array.from(checkboxes).some(checkbox => checkbox.checked)) {
            alert('Please fill in both the date and select at least one employee.');
            return false; // Prevent form submission
        }

        // Continue with form submission if everything is filled
        return true;
    }
</script>
	<script>
						document
								.addEventListener(
										'DOMContentLoaded',
										function() {
											var checkboxes = document
													.querySelectorAll('.empCheckbox');

											checkboxes
													.forEach(function(checkbox) {
														checkbox
																.addEventListener(
																		'change',
																		function() {
																			checkboxes
																					.forEach(function(
																							otherCheckbox) {
																						if (otherCheckbox !== checkbox) {
																							otherCheckbox.checked = false;
																						}
																					});
																		});
													});
										});
					</script>

	<div class="container">
		<div class="left">
			<!-- 왼쪽 화면에 급여 정보 표시 -->
			<div align='center'>
				<h2>給与情報</h2>
				<form action="payRead.do" method="post"
					onsubmit="return validateForm()">
					<div align='right'>
						<label for="date">給与日付</label> <input type="month" name="date"
							id="date"> </label>
					</div>
					<table border='1' width='600'>
						<tr>
							<th>選択</th>
							<th>社員番号</th>
							<th>氏名</th>
							<th>入社日</th>
							<th>退社日</th>
							<th>部署</th>
							<th>役職</th>
						</tr>
						<c:forEach var="info" items="${emplist.list }">
							<tr>
								<td><input type="checkbox" name="empNo"
									value="${info.empNo}" class="empCheckbox"></td>
								<td>${info.empNo}</td>
								<td>${info.name}</td>
								<td>${info.joinDate}</td>
								<td>${info.quitDate}</td>
								<td>${info.department}</td>
								<td>${info.spot}</td>
							</tr>
						</c:forEach>


						<input type="submit" value="検索">
						<!-- 여기에 급여 정보 데이터를 출력하는 부분 -->
					</table>
				</form>
			</div>
		</div>
		<div class="right">
			<!-- 오른쪽 화면에 급여 및 공제 항목 입력 표시 -->
			<div align='center'>
				<h2>給与,控除項目入力</h2>

				<form action="payModify.do" method="post">
					<table width='600'>
						<tr>
							<th>支給項目</th>
							<!--지급항목-->
							<th>共済項目</th>
						</tr>
						<tr>
							<th>基本給与<input type='text' name='normalPay'
								value="${selEmpData.basicPay }">
							</th>
							<th>基本給与<input type='text' name='nationpen'
								value="${selEmpData.nationPen }">
							</th>

						</tr>
						<tr>
							<th>食費<input type='text' name='foordExp'
								value="${selEmpData.foodExp }">
							</th>
							<th>健康保険<input type='text' name='healInsur'
								value="${selEmpData.healInsur }">
							</th>
						</tr>
						<tr>
							<th>保育手当<input type='text' name='childAllow '
								value="${selEmpData.childAllow }">
							</th>
							<th>長期療養保険<input type='text' name='elderInsur'
								value="${selEmpData.elderInsur }">
							</th>
						</tr>
						<tr>
							<th>役職手当<input type='text' name='posAllow'
								value="${selEmpData.posAllow }">
							</th>
							<th>雇用保険<input type='text' name='employInsur '
								value="${selEmpData.elderInsur }">
							</th>
						</tr>
						<tr>
							<th>車両維持費<input type='text' name='vehMainten'
								value="${selEmpData.vehMainten }">
							</th>
							<th>所得税<input type='text' name='incTex'
								value="${selEmpData.incomeTex }">
							</th>
						</tr>
						<tr>
							<th>勤続手当<input type='text' name='servAllow'
								value="${selEmpData.servAllow }">
							</th>
							<th>地方所得税<input type='text' name='locIncTex'
								value="${selEmpData.localeIncomeTex }">
							</th>
						</tr>
						<tr>
							<th>当直手当<input type='text' name='callAllow'
								value="${selEmpData.callAllow }">
							</th>
							<th>互助会費<input type='text' name='mutualAid'
								value="${selEmpData.mutualAid }">
							</th>
						</tr>
						<tr>
							<th>賞与金<input type='text' name='bonus'
								value="${selEmpData.bonus }">
							</th>

						</tr>
						<tr>
							<th>休日手当<input type='text' name='holiAllow'
								value="${selEmpData.holiBonus }"></th>
							<th>支給日<input type='text' name='payDay'
								value="${selEmpData.paymentData }"></th>
							<th></th>
						</tr>

					</table>
					<br /> <br />
					<!-- 여기에 급여 항목과 급여량을 입력하는 부분 -->
					<input type="hidden" name="dateTime" value="${date }"> <input
						type="hidden" name="empNo" value="${selEmpData.emp_no }">
					<input type="submit" value="저장">
				</form>
			</div>
		</div>
	</div>
</body>
</html>