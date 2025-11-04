package com.attendance;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/attendance_db", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Attendance(StudentID, Date, Status) VALUES (?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("success.jsp");
            } else {
                out.println("Error inserting data!");
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
