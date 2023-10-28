<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav>
		<ul>
			<li><a href="main.jsp">메인화면</a></li>
			<li><a href="salaryManagement.jsp">급여입력</a></li>
			<li><a href="salaryQuery.jsp">급여대장</a></li>

		</ul>
	</nav>
	<div class="right">
	<div align='center'>
				<h2>급여 대장</h2>
				<div align='right'>
				<form action="processSelectedYear.jsp" method="post">
        <label for="year">연도 선택</label>
        <select id="year" name="selectedYear">
            <%
                // 현재 연도 가져오기
                java.util.Calendar now = java.util.Calendar.getInstance();
                int currentYear = now.get(java.util.Calendar.YEAR);
                
                // 5년 동안의 연도 옵션 생성
                for (int year = currentYear; year <= currentYear + 5; year++) {
            %>
                <option value="<%= year %>"><%= year %></option>
            <%
                }
            %>
        </select>
				</div>
						</label>
							<table border='1' width='600'>
					<tr>
						<th>귀속연월</th>
						<th>급여차수</th>
						<th>정산기간</th>
						<th>지급일</th>
						<th>인원</th>
						<th>지급총액</th>
						<th>실지급액</th>
					</tr>
					</table>
						
						</div>
						</div>
						
						
</body>
</html>