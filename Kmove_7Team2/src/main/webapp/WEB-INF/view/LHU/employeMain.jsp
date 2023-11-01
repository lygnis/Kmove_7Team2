<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>給与管理</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul li {
	list-style: none;
}

a {
	text-decoration: none;
	color: #333;
}

#top_menu {
	font: bold 16px "malgun gothic";
	width: 1400px;
	height: 50px;
	background: #ccc;
	color: black;
	line-height: 50px;
	margin: 0 auto;
	text-align: center;
}

#menu {
	font: bold 12px "malgun gothic";
	width: 1400px;
	height: 35px;
	background: #ccc;
	color: black;
	line-height: 35px;
	margin: 0 auto;
	text-align: center;
}

#menu>ul>li {
	float: left;
	width: 140px;
	position: relative;
}

#menu>ul>li>ul {
	width: 130px;
	display: none;
	position: absolute;
	font-size: 14px;
	background: skyblue;
}

#menu>ul>li:hover>ul {
	display: block;
}

#menu>ul>li>ul>li:hover {
	background: orange;
	transition: ease 1s;
}

body {
	font-family: Arial, sans-serif;
}

header {
	text-align: center;
	font-size: 24px;
}

nav ul {
	list-style: none;
	padding: 0;
}

nav ul li {
	display: inline;
	margin-right: 20px;
}

section {
	width: 80%;
	margin: 0 auto;
}

hr {
	border: solid #e2e2e2;
	border-width: 1px 0 0;
	padding-bottom: 10px;
	clear: both;
	height: 0;
	width: 100%;
	margin-left: 30px;
}

hr {
	display: block;
	unicode-bidi: isolate;
	margin-block-start: 0.5em;
	margin-block-end: 0.5em;
	margin-inline-start: auto;
	margin-inline-end: auto;
	overflow: hidden;
	border-style: inset;
	border-width: 1px;
}

#employee-details table {
	width: 100%;
	border-collapse: collapse;
}

#employee-details table td {
	border: 1px solid #000;
	padding: 10px;
}

.container1 {
	background-color: #fff;
	padding: 10px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: left;
}

div.emreg_lt {
	float: left;
	width: 308px;
	margin: 10px 0 0 0px;
	padding: 11px;
}

.emreg_lt ul.em_photo {
	width: 120px;
	margin: 0px 0px 10px 0px;
	padding: 0px;
	float: left;
	display: inline-block;
}

ol, ul, li {
	list-style: none;
	padding: 0px;
	margin: 0px;
}

.emreg_lt ul div.emreg_table {
	margin: 1px 0px 10px 15px;
	display: inline-block;
}

.emreg_table ul {
	float: left;
	border-left: 1px solid #e7e7dc;
	border-bottom: 1px solid #e1e5dc;
	color: #333333;
}

.emreg_lt ul {
	padding: px;
	float: left;
}

.border_emreg {
	border-top: 1px solid #c1c1a6;
	border-bottom: 1px solid #c1c1a6;
}

div {
	display: block;
}



body {
	color: #666;
	font: 14px/24px "Open Sans", "HelveticaNeue-Light",
		"Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial,
		"Lucida Grande", Sans-Serif;
}

table {
	border-collapse: separate;
	border-spacing: 0;
	width: 100%;
}

th, td {
	padding: 6px 15px;
}

th {
	background: #42444e;
	color: #fff;
	text-align: left;
}

tr:first-child th:first-child {
	border-top-left-radius: 6px;
}

tr:first-child th:last-child {
	border-top-right-radius: 6px;
}

td {
	border-right: 1px solid #c6c9cc;
	border-bottom: 1px solid #c6c9cc;
}

td:first-child {
	border-left: 1px solid #c6c9cc;
}

tr:nth-child(even) td {
	background: #eaeaed;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 6px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 6px;
}

.notice ul.list {
	float: left;
	width: 400px;
}

.notice ul.list li.date {
	display: inline-block;
	width: 50px;
	text-align: right;
}

.notice ul.list li {
	float: left;
	height: 22px;
}
</style>
</head>
<body>
	<nav>
		<div id="top_menu">
			<div class="navi_2017">
				<ul class="navi_L_2017">
					<li class="n01">
						<a	href="/" title="HOME"><span id="SK01">HOME</span>
						</a></li>
					<li class="n03">
						<a href="/" title="社員現況"><span id="SK03">社員現況</span>
						</a></li>
					<li class="n07">
						<a  href="/" title="給与入力/管理"><span id="SK07">給与入力/管理</span>
						</a></li>
					<li class="n09">
						<a href="/" title="給与台帳"><span id="SK09">給与台帳</span>
						</a></li>


				</ul>
			</div>
		</div>
	</nav>
	


	<section>
		<div>

			


			<div class="emreg_lt">
				<h3>使用者情報</h3>
				<ul class="em_photo w_120">
					<li class="border_box b_gray ph"><img
						id="disEmployeeDefaultImg" src="./imgs/ttt2.png"
						style="height: 117px;" vspace="10"></li>
					<!-- ID:disEmployeeDefaultImg, alt:Info -->
					<li class="p_t10 c"></li>
				</ul>
				<ul>
					<li>
						<table border="1" width="300" height="100" align="center"
							style="color: black">
							<thead>
								<tr bgcolor="gray">
									<td >社員番号</td>
									<td>No-00001</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>氏名</td>
									<td>name</td>
								</tr>
								<tr>
									<td>部署</td>
									<td>部署</td>
								</tr>
								<tr>
									<td>職位</td>
									<td>職位</td>
								</tr>
								<tr>
									<td>入社日</td>
									<td>YYYY/MM/DD</td>
								</tr>
								

							</tbody>
							<div class="notice p_t10 p_b10">
						</table>
					</li>

				</ul>
			</div>
		</div>
		<br>
	
	
	</section>
	
	<hr>
	<section>
		<div align="left">
			<h3>給与現況</h3>
		</div>
		<div align="right">給与現況</div>
		<table>
			<thead align="left">
				<tr>
					<th>帰属年月</th>
					<th>精算期間</th>
					
					<th>支給日</th>
					<th>人員</th>
					<th>支払総額</th>
					<th>控除総額</th>
					<th>実支給額</th>

				</tr>
			</thead>
			<tbody align="center">
				<tr>
					<td>2023-01</td>
					
					<td>2023/01/01 ~ 2023/01/31</td>
					<td>2023/01/05</td>
					<td>10</td>
					<td>26,300,000</td>
					<td>3,144,830</td>
					<td>23,155,170</td>
				</tr>
				<tr>
					<td>2023-02</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>2023/02/05</td>
					<td>10</td>
				<td>26,300,000</td>
					<td>3,144,830</td>
					<td>23,155,170</td>
				</tr>
				<tr>
					<td>2023-03</td>
					
					<td>2023/03/01 ~ 2023/02/31</td>
					<td>2023/03/05</td>
					<td>10</td>
				<td>26,300,000</td>
					<td>3,144,830</td>
					<td>23,155,170</td>
				</tr>
				<tr>
					<td>2023-04</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-9</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
					<td>10</td>
				</tr>
				<tr>
					<td>2023-05</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-9</td>
					<td>225</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
					
				</tr>
				<tr>
					<td>2023-06</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-7</td>
					<td>193</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-07</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-4</td>
					<td>190</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-08</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-10</td>
					<td>250</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-09</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-11</td>
					<td>232</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-10</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-10</td>
					<td>235</td>
					<td>10</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-11</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>5-9</td>
					<td>180</td>
					<td>220</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr>
					<td>2023-12</td>
					
					<td>2023/02/01 ~ 2023/02/28</td>
					<td>6-3</td>
					<td>190</td>
					<td>220</td>
					<td>220</td>
					<td>220</td>
				</tr>
				<tr bgcolor="lightyellow">
					<td>合計<td>
					
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>									
				</tr>
			</tbody>
		</table>
	</section>


</body>
</html>