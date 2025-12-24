# Student Management System (Java + MySQL)

This is a simple console-based Student Management System built using Java, JDBC, and MySQL.  
The project allows an admin to perform CRUD operations on student records such as add, view, update, delete, search, and count total students.

## Features
- Admin login authentication
- Add new student
- View all students
- Update student course and marks
- Delete student by ID
- Search student by name
- Display total number of students
- Basic input validation

## Technologies Used
- Java (Core Java)
- JDBC
- MySQL
- MySQL Connector/J
- Any Java IDE (IntelliJ, Eclipse, VS Code)

## Database Setup
Create database and tables using the following SQL commands:

CREATE DATABASE college;
USE college;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100),
    marks INT
);

CREATE TABLE admin (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO admin VALUES ('admin', 'admin123');

## JDBC Configuration
Update database credentials in the code if required:

jdbc:mysql://localhost:3306/college  
username: root  
password: root  

Ensure MySQL Connector/Jar file is added to the project libraries.

## How to Run
1. Clone the repository:
   git clone https://github.com/Roshan1351/Student_Management_System.git
2. Open the project in your IDE
3. Add MySQL JDBC Driver
4. Run StudentManagement.java
5. Login using admin credentials
6. Use the menu to manage students

## Project Structure
Student_Management_System  
├── StudentManagement.java  
├── README.md  

## Sample Menu
-----Student Management System-----  
1. Add Student  
2. View Student  
3. Update Student  
4. Delete Student  
5. Search student by Name  
6. Total Student  
7. Exit  

If you like this project, please give it a star ⭐ on GitHub.

Thank you!
