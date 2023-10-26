<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<style type="text/css">
body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
}

.container {
    background-color: #e6e6e6;
    padding: 20px;
    margin: 20px;
}

.employee-info {
    float: left;
    width: 30%;
}

.employee-info table {
    width: 100%;
}

.employee-info table, .employee-info th, .employee-info td {
    border: 1px solid #999;
}

.employee-info th, .employee-info td {
    padding: 5px;
    text-align: left;
}

.employee-info th {
    background-color: #cccccc;
}

.notice-container {
    float: right;
    width: 60%;
    background-color: #e6e6e6;
    padding: 20px;
}
</style>
</head>
<body>
    <div class="container">
        <div class="employee-info">
            <h2>Employee Information</h2>
            <table>
                <%-- Your Java code to fetch and display employee data here --%>
                <tr>
                    <th>Employee ID:</th>
                    <%-- Employee ID value here --%>
                </tr>
                <tr>
                    <th>Name:</th>
                    <%-- Employee name value here --%>
                </tr>
                <tr>
                    <th>Department:</th>
                    <%-- Department value here --%>
                </tr>
                <tr>
                    <th>Position:</th>
                    <%-- Position value here --%>
                </tr>
                <tr>
                    <th>Hire Date:</th>
                    <%-- Hire date value here --%>
                </tr>
            </table>
        </div>
        <div class="notice-container">
            <h2>Notice Board</h2>
            
            <%-- Your Java code to fetch and display notice data here --%>
        </div>
        <div style="clear:both;"></div>
    </div>
</body>
</html>