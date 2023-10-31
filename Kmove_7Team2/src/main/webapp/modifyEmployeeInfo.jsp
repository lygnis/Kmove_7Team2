<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報</title>
</head>
<body>

	<nav>
		<a href="#">メインメニュー</a> <a href="#">社員登録 </a> <a href="#">社員現状</a>
	</nav>
	<div align=center>
		<p>基本情報</p>
		<aside>
			<table border="1" width="170px">
				<tr>
					<td>社員番号</td>
					<td>No-140034</td>
				</tr>
				<tr>
					<td>社員名</td>
					<td>이응열</td>
				</tr>
				<tr>
					<td>部署</td>
					<td>社長室</td>
				</tr>
				<tr>
					<td>職位</td>
					<td>社長</td>
				</tr>
				<tr>
					<td>入社日</td>
					<td>2000-02-22</td>
				</tr>
			</table>
		</aside>
		<table id="S" border="1" width="900px" height="300px">
			<tr>
				<td align=center>社員番号</td>
				<td>No-140034</td>
				<td align=center>社員名</td>
				<td>이응열</td>
			</tr>
			<tr>
				<td align=center>入社日</td>
				<td>2000-02-22</td>
				<td align=center>退社日</td>
				<td><input type="text" name="quitDate"></td>
			</tr>
			<tr>
				<td align=center>部署</td>
				<td><select name="#">
						<option value="101">社長室</option>
						<option value="102">開発チーム</option>
						<option value="103">コンテンツチーム</option>
						<option value="104">業務支援チーム</option>
						<option value="105">デザインチーム</option>
						<option value="106">管理チーム</option>
						<option value="107">機会戦略チーム</option>
				</select></td>
				<td align=center>役職</td>
				<td><select name="spot">
						<option value="201">社長</option>
				</select></td>
			</tr>

			<td align=center>住民番号</td>
			<td>610101-0000000</td>
			<td align=center>住所</td>
			<td colspan="3">서울특별시 성동구 성수동1가 코오롱디지털 타워 3차 901호</td>
			</tr>
			<tr>
				<td align=center>携帯番号</td>
				<td>010-1111-0000</td>
				<td align=center>E-mail</td>
				<td>ceo@naver.com</td>
			</tr>
			<tr>
				<td align=center>その他の事項</td>
				<td colspan="3"><textarea name="#" rows="4" cols="110"></textarea></td>
			</tr>
		</table>

		<p>給与 & ４代保険</p>
		<table border="1" width="900px" height="200px">
			<tr>
				<td align=center>４大保険</td>
				<td colspan="3"><input type="checkbox" name="#" value="checked"
					checked>国民年金 <input type="checkbox" name="#"
					value="checked" checked>健康保険 <input type="checkbox"
					name="#" value="checked" checked>老人長期療養保険 <input
					type="checkbox" name="#" value="#">雇用保険</td>
			</tr>
			<tr>
				<td align=center>甲勤税</td>
				<td colspan="3"><input type="checkbox" name="gapgeun"
					value="勤労所得者税額" checked>勤労所得者 税額 : <select
					name="sm_busin_per">
						<option value="100">100%</option>
						<option value="30">30%</option>
						<option value="50">50%</option>
						<option value="80">80%</option>
						<option value="120">120%</option>
				</select> <input type="checkbox" name="smBusinPer" value="中小企業青年所得税の減免">中小企業青年所得税の減免
					<select name="sm_busin_per">
						<option value="">選択</option>
						<option value="50">50%</option>
						<option value="70">70%</option>
						<option value="90">90%</option>
						<option value="100">100%</option>
				</select>
			</tr>
			<tr>
				<td align=center>基本給/日給</td>
				<td>5,000,000円</td>
				<td>月給制の場合は月基本給、日雇い労働者の場合は日給を入力します。</td>
			</tr>
			<tr>
				<td align=center>給与口座</td>
				<td colspan="3"></select> 120-86-50680</td>
			</tr>
		</table>
		<p />
		兵役.
		<p />
		<table border="1" width="900px" height="80px">
			<tr align=center>
				<td>兵役区分</td>
				<td>群別</td>
				<td>服務期間(開始)</td>
				<td>服務期間(終了)</td>
				<td>最終階級</td>
				<td>兵科</td>
				<td>未畢の事由</td>
			</tr>
			<tr align=center>
				<td><select name="兵役区分">
						<option value="">選択</option>
						<option value="兵役">兵役</option>
						<option value="未了">未了</option>
				</select></td>
				<td><select name="群別">
						<option value="">選択</option>
						<option value="陸軍">陸軍</option>
						<option value="空軍">空軍</option>
				</select></td>
				<td>1984-02-06</td>
				<td>1987-02-05</td>
				<td>兵長</td>
				<td>步兵</td>
				<td><input type="text" name="未畢の事由" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="保存"> <input type="submit"
				value="キャンセル">
		</p>
	</div>
</body>
<style>
#S {
	margin-right: 200px;
}

aside {
	float: left;
	margin-left: 30px;
}
</style>
</html>