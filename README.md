# 🎓 Student Management System

A Console-Based Student Management System developed using Java, JDBC, MySQL, and MVC Architecture. The application provides a menu-driven interface to manage student records and perform CRUD operations efficiently.

## ✨ Features

* Add Student Records
* View All Students
* Search Student by ID
* Search Student by Name
* Update Student Information
* Delete Student Records
* Display Total Student Count
* Input Validation
* JDBC Database Connectivity
* MVC Design Pattern

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* MVC Architecture
* OOP Concepts

## 🗄️ Database Schema

```sql
CREATE DATABASE sms;

USE sms;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL,
    marks INT NOT NULL
);
```

## ▶️ Sample Menu

```text
------ Student Management System ------

1. Add Student
2. View Student
3. Search Student by ID
4. Search Student by Name
5. Update Student
6. Delete Student
7. Total Student Count
8. Exit
```

## 🏗️ MVC Architecture

### Model

Contains student data.

```java
Student.java
```

### View

Handles user interaction and displays data.

```java
StudentView.java
```

### Controller

Processes user requests and coordinates between View and DAO.

```java
StudentController.java
```

### DAO

Handles database operations using JDBC.

```java
StudentDAOimpl.java
```

## 🎯 Learning Outcomes

* Core Java Programming
* Object-Oriented Programming (OOP)
* JDBC Connectivity
* MySQL Database Operations
* MVC Design Pattern
* Exception Handling
* Collections Framework

## 👨‍💻 Author

Roshan Giri

GitHub: https://github.com/Roshan1351

## ⭐ Support

If you like this project, consider giving it a star on GitHub.
