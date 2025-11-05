package com.example.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Attendance(StudentID, Date, Status) VALUES (?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);

            int rows = ps.executeUpdate();
            conn.close();

            if (rows > 0) {
                response.sendRedirect("success.jsp");
            } else {
                out.println("<h3 style='color:red;'>Failed to record attendance.</h3>");
            }

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
