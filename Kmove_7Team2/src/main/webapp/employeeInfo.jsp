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
				<td><input type="text" name="#"></td>
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
				<td><select name="#">
						<option value="201">社長</option>
				</select></td>
			</tr>
			<tr>
				<td align=center>内/外人</td>
				<td><select name="#">
						<option value="301">内国人</option>
						<option value="302">外国人</option>
				</select></td>
				<td align=center>住民番号</td>
				<td>610101-0000000</td>
			</tr>
			<tr>
				<td align=center>住所</td>
				<td colspan="3">서울특별시 성동구 성수동1가 코오롱디지털 타워 3차 901호</td>
			</tr>
			<tr>
				<td align=center>電話番号</td>
				<td>02-1588-2390</td>
				<td align=center>携帯番号</td>
				<td>010-1111-0000</td>
			</tr>
			<tr>
				<td align=center>E-mail</td>
				<td>ceo@naver.com</td>
				<td align=center>SNS</td>
				<td><input type="text" name="#"></td>
			</tr>
			<tr>
				<td align=center>その他の事項</td>
				<td colspan="3"><textarea name="#" rows="4" cols="110"></textarea></td>
			</tr>
		</table>

		<p>給与 & ４代保険</p>
		<table border="1" width="900px" height="400px">
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
				<td colspan="3"><input type="checkbox" name="#" value="checked"
					checked>勤労所得者 税額 : <select name="#">
						<option value="300">100%</option>
						<option value="300">30%</option>
						<option value="300">50%</option>
						<option value="300">80%</option>
						<option value="300">120%</option>
				</select> <input type="checkbox" name="#" value="#">中小企業青年所得税の減免 <select
					name="#">
						<option value="300">選択</option>
						<option value="300">50%</option>
						<option value="300">70%</option>
						<option value="300">90%</option>
						<option value="300">100%</option>
				</select> <input type="checkbox" name="#" value="#">事業所得者(3.3%) <br />
					<input type="checkbox" name="#" value="#">日雇い(2.97%) <input
					type="checkbox" name="#" value="#">その他の所得者(8.8%) <input
					type="checkbox" name="#" value="#">勤労/事業所得者 <input
					type="checkbox" name="#" value="#">免除</td>
			</tr>
			<tr>
				<td align=center>ドゥルヌリ社会保険支援</td>
				<td colspan="3"><input type="checkbox" name="#" value="checked"
					checked>該当なし <input type="checkbox" name="#" value="#">新規加入者(80%
					支援) <input type="checkbox" name="#" value="#">新規加入者(90% 支援)<br />
					*基本情報から外国人に設定された社員は、国民年金保険料の支援対象から除外されます。</td>
			</tr>
			<tr>
				<td align=center>基本給/日給</td>
				<td>5,000,000円</td>
				<td>月給制の場合は月基本給、日雇い労働者の場合は日給を入力します。</td>
			</tr>
			<tr>
				<td align=center>国民年金基準所得月額</td>
				<td>5,000,000円</td>
				<td rowspan="3">入力時に4大保険控除時に優先適用され、<br /> 未入力時に当該勤続月の非課税を
					除く課税合計で適用されます。
				</td>
			</tr>
			<tr>
				<td align=center>健康保険報酬月額</td>
				<td>5,000,000円</td>
			</tr>
			<tr>
				<td align=center>雇用保険報酬月額</td>
				<td>5,000,000円</td>
			</tr>
			<tr>
				<td align=center>給与口座</td>
				<td colspan="3"><select name="#">
						<option value="301">ウリィ</option>
						<option value="301">ハナ</option>
						<option value="301">KB</option>
				</select> 120-86-50680</td>
			</tr>
		</table>
		<table border="1" width="900px" height="100px">
			<tr>
				<td align=center>区分</td>
				<td align=center>記号番号</td>
				<td align=center>取得日</td>
				<td align=center>喪失日</td>
			</tr>
			<tr>
				<td>国民年金</td>
				<td>10028589911</td>
				<td>2000-02-28</td>
				<td><input type="date" name="#" /></td>
			</tr>
			<tr>
				<td>健康保険</td>
				<td>71223653611</td>
				<td>2000-02-28</td>
				<td><input type="date" name="#" /></td>
			</tr>
			<tr>
				<td>雇用保険</td>
				<td><input type="text" name="#"></td>
				<td><input type="date" name="#" /></td>
				<td><input type="date" name="#" /></td>
			</tr>
			<tr>
				<td>労災保険</td>
				<td><input type="text" name="#"></td>
				<td><input type="date" name="#" /></td>
				<td><input type="date" name="#" /></td>
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
			<tr>
				<td><select name="#">
						<option value="401">兵役</option>
						<option value="402">未了</option>
				</select></td>
				<td><select name="#">
						<option value="501">陸軍</option>
						<option value="502">空軍</option>
				</select></td>
				<td>1984-02-06</td>
				<td>1987-02-05</td>
				<td>兵長</td>
				<td>步兵</td>
				<td><input type="text" name="#" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="保存"> <input type="submit"
				value="キャンセル"> <input type="submit" value="リスト"> <input
				type="submit" value="新規社員登録">
		</p>
	</div>
</body>
<style>
#S{
margin-right: 200px;

}


aside{float:left;
margin-left:30px;}
</style>
</html>