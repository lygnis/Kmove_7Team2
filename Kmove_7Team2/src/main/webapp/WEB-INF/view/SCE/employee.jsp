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
<form action="empReg.do" method="post">
	<div align=center>
		<p>基本情報</p>
		<table border="1" width="900px" height="300px">
			<tr>
				<td align=center>社員番号</td>
				<td><input type="text" name="empNo"/></td>
				<td align=center>署名</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align=center>入社日</td>
				<td><input type="date" name="joinDate" /></td>
				<td align=center>退社日</td>
				<td><input type="date" name="quitDate" /></td>
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
				<td align=center>住民番号</td>
				<td><input type="text" name="secNumber"></td>
				<td align=center>住所</td>
				<td colspan="3"><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td align=center>携帯番号</td>
				<td><input type="text" name="cellPh"></td>
			
				<td align=center>E-mail</td>
				<td><input type="text" name="email"></td>
				</tr>
			<tr>
				<td align=center>その他の事項</td>
				<td colspan="3"><textarea name="etc" rows="4" cols="110"></textarea></td>
			</tr>
		</table>

		<p>給与 & ４代保険</p>
		<table border="1" width="900px" height="200px">
			<tr>
				<td align=center>４大保険</td>
				<td colspan="3"><input type="checkbox" name="nation_pens" value="国民年金">国民年金
					<input type="checkbox" name="heal_insur" value="健康保険">健康保険 <input
					type="checkbox" name="elder_insur" value="老人長期療養保険">老人長期療養保険 <input
					type="checkbox" name="employ_insur" value="雇用保険">雇用保険</td>
			</tr>
			<tr>
				<td align=center>甲勤税</td>
				<td colspan="3"><input type="checkbox" name="tax_amount" value="勤労所得者税額">勤労所得者
					税額 : <select name="tax_amount_per">
						<option value="">選択</option>
						<option value="30">30%</option>
						<option value="50">50%</option>
						<option value="80">80%</option>
						<option value="100">100%</option>
						<option value="120">120%</option>
				</select> <input type="checkbox" name="sm_busin" value="中小企業青年所得税の減免">中小企業青年所得税の減免 <select
					name="sm_busin_per">
						<option value="">選択</option>
						<option value="50">50%</option>
						<option value="70">70%</option>
						<option value="90">90%</option>
						<option value="100">100%</option>
				</select> 
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
				value="キャンセル"> <input type="submit" value="リスト">
		</p>
	</div>
	</form>
</body>
</html>