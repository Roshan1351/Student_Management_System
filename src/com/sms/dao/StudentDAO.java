package com.sms.dao;
import java.util.List;

import com.sms.model.Student;
public interface  StudentDAO {
    void addStudent(Student student);

    List<Student> getAllStudent();
    Student getStudentByID(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
    List<Student> searchStudentByName(String name);
    int getTotalStudent();
}
