<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員現状</title>
<style>
.table-container {
	margin-bottom: 20px;
}

#M_tb {
margin-right: 600px;

}

</style>

</head>
<body>
	<nav>
		<a href="#">メインメニュー</a> <a href="#">社員登録 </a> <a href="#">社員現状</a>
	</nav>
	<div align=center>
		<p>社員現況/管理</p>


		<table id="M_tb" border="1" width="300px" height="80px">
			<tr>
				<td align=center>在職者</td>
				<td align=center>退社者</td>
				<td align=center>全体</td>
			</tr>
			<tr>
				<td align=center>10</td>
				<td align=center>2</td>
				<td align=center>12</td>
		</table>
		<div class="table-container"></div>
		<table border="1" width="900px">
			<tr align=center>
				<td>入社日</td>
				<td>社員番号</td>
				<td>社員名</td>
				<td>部署</td>
				<td>役職</td>
				<td>住民番号</td>
				<td>携帯番号</td>
				<td>メール </td>
				<td>退社日</td>
				<td>在職状態</td>
			</tr>
			<tr align=center>
				<td>2000-02-22</td>
				<td>No-140034</td>
				<td>이응열</td>
				<td>社長室</td>
				<td>社長</td>
				<td>610101-0000000</td>
				<td>010-1111-0000</td>
				<td>ceo@naver.com</td>
				<td></td>
				<td>在職</td>
			</tr>
			<tr align=center>
				<td>2006-10-26</td>
				<td>No-140033</td>
				<td>이호중</td>
				<td>管理チーム</td>
				<td>課長</td>
				<td>740819-0000000</td>
				<td>010-7777-0000</td>
				<td>s5@naver.com</td>
				<td>2017-02-01</td>
				<td>退職</td>
			</tr>
		</table>
	</div>

</body>
</html>