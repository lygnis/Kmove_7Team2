<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録</title>
<link rel="stylesheet" type="text/css" href="testFile.css">
</head>
<body>

	<nav>
		<a href="#">メイン</a> <a href="#">社員登録</a> <a href="#">社員現況</a>
	</nav>
	<div align=center>
		<p>基本情報</p>
		<table border="1" width="900px" height="300px">
			<tr>
				<td align=center>社員番号</td>
				<td><input type="text" name="empNo" /></td>
				<td align=center>署名</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align=center>入社日</td>
				<td><input type="date" name="joinDate" /></td>
				<td align=center>退社日</td>
				<td><input type="date" name="endDate" /></td>
			</tr>
			<tr>
				<td align=center>部署</td>
				<td><select name="department">
						<option value="">選択</option>
						<option value="社長室">社長室</option>
						<option value="開発チーム">開発チーム</option>
						<option value="コンテンツチーム">コンテンツチーム</option>
						<option value="業務支援チーム">業務支援チーム</option>
						<option value="デザインチーム">デザインチーム</option>
						<option value="管理チーム">管理チーム</option>
						<option value="機会戦略チーム">機会戦略チーム</option>
				</select></td>
				<td align=center>役職</td>
				<td><select name="spot">
						<option value="">選択</option>
						<option value="理事">理事</option>
						<option value="次長">次長</option>
						<option value="社長">社長</option>
						<option value="部長">部長</option>
						<option value="課長">課長</option>
						<option value="代理">代理</option>
						<option value="主任">主任</option>
						<option value="社員">社員</option>
						<option value="室長">室長</option>
				</select></td>
			</tr>
			<tr>
				<td align=center>内/外人</td>
				<td><select name="nation">
						<option value="選択">選択</option>
						<option value="内国人">内国人</option>
						<option value="外国人">外国人</option>
				</select></td>
				<td align=center>住民番号</td>
				<td><input type="text" name="secNumber"></td>
			</tr>
			<tr>
				<td align=center>住所</td>
				<td colspan="3"><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td align=center>電話番号</td>
				<td><input type="text" name="phNum"></td>
				<td align=center>携帯番号</td>
				<td><input type="text" name="cellPh"></td>
			</tr>
			<tr>
				<td align=center>E-mail</td>
				<td><input type="text" name="email"></td>
				<td align=center>SNS</td>
				<td><input type="text" name="sns"></td>
			</tr>
			<tr>
				<td align=center>その他の事項</td>
				<td colspan="3"><textarea name="etc" rows="4" cols="110"></textarea></td>
			</tr>
		</table>

		<p>給与 & ４代保険</p>
		<table border="1" width="900px" height="400px">
			<tr>
				<td align=center>４大保険</td>
				<td colspan="3"><input type="checkbox" name="nation_pens"
					value="国民年金">国民年金 <input type="checkbox" name="heal_insur"
					value="健康保険">健康保険 <input type="checkbox" name="elder_insur"
					value="老人長期療養保険">老人長期療養保険 <input type="checkbox"
					name="employ_insur" value="雇用保険">雇用保険</td>
			</tr>
			<tr>
				<td align=center>甲勤税</td>
				<td colspan="3"><input type="checkbox" name="tax_amount"
					value="勤労所得者税額">勤労所得者 税額 : <select name="tax_amount_per">
						<option value="">選択</option>
						<option value="30">30%</option>
						<option value="50">50%</option>
						<option value="80">80%</option>
						<option value="100">100%</option>
						<option value="120">120%</option>
				</select> <input type="checkbox" name="sm_busin" value="中小企業青年所得税の減免">中小企業青年所得税の減免
					<select name="sm_busin_per">
						<option value="">選択</option>
						<option value="50">50%</option>
						<option value="70">70%</option>
						<option value="90">90%</option>
						<option value="100">100%</option>
				</select> <input type="checkbox" name="busin_earner" value="事業所得者">事業所得者(3.3%)
					<br /> <input type="checkbox" name="day_laborer" value="日雇い">日雇い(2.97%)
					<input type="checkbox" name="etc_earner" value="その他の所得者">その他の所得者(8.8%)
					<input type="checkbox" name="earned_inc" value="勤労/事業所得者">勤労/事業所得者
					<input type="checkbox" name="exemp" value="免除">免除</td>
			</tr>
			<tr>
				<td align=center>ドゥルヌリ社会保険支援</td>
				<td colspan="3"><input type="checkbox" name="noselect"
					value="該当なし">該当なし <input type="checkbox" name="new_sub_80"
					value="新規加入者80">新規加入者(80% 支援) <input type="checkbox"
					name="new_sub_90" value="新規加入者90">新規加入者(90% 支援)</td>
			</tr>
			<tr>
				<td align=center>基本給/日給</td>
				<td><input type="text" name="#">円</td>
				<td>月給制の場合は月基本給、日雇い労働者の場合は日給を入力します。</td>
			</tr>
			<tr>
				<td align=center>給与口座</td>
				<td colspan="3"><input type="text" name="sal_acount"></td>
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
				<td><input type="text" name="nationPen"></td>
				<td><input type="date" name="nation_startdate" /></td>
				<td><input type="date" name="nation_enddate" /></td>
			</tr>
			<tr>
				<td>健康保険</td>
				<td><input type="text" name="healInsur"></td>
				<td><input type="date" name="heal_startdate" /></td>
				<td><input type="date" name="heal_enddate" /></td>
			</tr>
			<tr>
				<td>雇用保険</td>
				<td><input type="text" name="employInsur"></td>
				<td><input type="date" name="employ_startdate" /></td>
				<td><input type="date" name="employ_enddate" /></td>
			</tr>
			<tr>
				<td>労災保険</td>
				<td><input type="text" name="induInsur"></td>
				<td><input type="date" name="indu_startdate" /></td>
				<td><input type="date" name="indu_enddate" /></td>
			</tr>
		</table>
		<p />
		兵役.
		<p />
		<table border="1" width="900px" height="80px">
			<tr align=center>
				<td>兵役区分</td>
				<td>軍別</td>
				<td>服務期間(開始)</td>
				<td>服務期間(終了)</td>
				<td>最終階級</td>
				<td>兵科</td>
				<td>未畢の事由</td>
			</tr>
			<tr>
				<td><select name="mili_serv">
						<option value="">選択</option>
						<option value="兵役">兵役</option>
						<option value="未了">未了</option>
				</select></td>
				<td><select name="division">
						<option value="">選択</option>
						<option value="陸軍">陸軍</option>
						<option value="海軍">海軍</option>
						<option value="空軍">空軍</option>
						<option value="常備軍">常備軍</option>
						<option value="免除">免除</option>
				</select></td>
				<td><input type="date" name="serv_date" /></td>
				<td><input type="date" name="serv_end" /></td>
				<td><input type="text" name="final_rank" /></td>
				<td><input type="text" name="milt_class" /></td>
				<td><input type="text" name="exemp_reason" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="保存"> <input type="submit"
				value="キャンセル"> <input type="submit" value="リスト"> <input
				type="submit" value="新規社員登録">
		</p>
	</div>
</body>
</html>