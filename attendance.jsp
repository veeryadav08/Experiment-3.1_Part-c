<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type=submit] {
            background-color: #0078D7;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #005fa3;
        }
    </style>
</head>
<body>
    <form action="AttendanceServlet" method="post">
        <h2>Student Attendance Portal</h2>
        <label>Student ID:</label>
        <input type="text" name="studentId" required>

        <label>Date:</label>
        <input type="date" name="date" required>

        <label>Status:</label>
        <select name="status" required>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select>

        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
