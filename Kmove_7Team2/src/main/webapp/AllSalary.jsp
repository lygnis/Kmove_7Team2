<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>급여대장</title>

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
     <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .graph-container {
            width: 600px;
            height: 400px;
            border: 1px solid #ccc;
            margin: auto;
        }
    </style>
</head>
<body>

<div>
    <select name="year">
        <option value="2020">2020</option>
        <option value="2021">2021</option>
        <option value="2022">2022</option>
        <!-- 연도 옵션들 추가 -->
    </select>
</div>

<div align="center">
<table border="1">
    <tr>
        <th>귀속연월</th>
        <th>지급일</th>
        <th>인원</th>
        <th>지급총액</th>
        <th>공제총액</th>
        <th>실지급액</th>
        <th>삭제</th>
    </tr>
    
</table>
</div>

<div class="graph-container">
    <canvas id="combinedChart" width="600" height="400"></canvas>
</div>

<script>
    const combinedCtx = document.getElementById('combinedChart').getContext('2d');
    const combinedChart = new Chart(combinedCtx, {
        type: 'bar',
        data: {
            labels: ['1', '2', '3','4','5','6','7','8','9','10','11','12'], // 연도
            datasets: [{
                label: '급여',
                data: [2000, 3000, 4000, 5000 ,6000, 7000,
                	2000,3000,4000,5000,5000,5000], // 각 연도별 급여 데이터
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }, {
                label: '인원수',
                data: [10, 20, 30, 40, 40, 30, 20, 10, 15,18, 17, 30], // Data for the number of employees for each year
                yAxisID: 'employees',
                type: 'line',
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                },
                employees: {
                    position: 'right',
                    suggestedMin: 0,
                    suggestedMax: 50,
                    ticks: {
                        stepSize: 5
                    }
                }
            }
        }
    });
</script>

</body>
</html>