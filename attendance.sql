CREATE DATABASE attendance_db;
USE attendance_db;

CREATE TABLE Attendance (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID VARCHAR(50),
    Date DATE,
    Status VARCHAR(10)
);
