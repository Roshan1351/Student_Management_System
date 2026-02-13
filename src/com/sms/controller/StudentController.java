package com.sms.controller;

import java.util.List;

import com.sms.dao.StudentDAO;
import com.sms.dao.StudentDAOimpl;
import com.sms.model.Student;
import com.sms.view.StudentView;

public class StudentController {
    private StudentDAO dao;
    private StudentView view;

    public StudentController(){
        dao= new StudentDAOimpl();
        view= new StudentView();
    }

    public void start(){
        while(true){
            int choice= view.showMenus();
            switch(choice){
                case 1:
                    Student student= view.getStudentDetail();
                    dao.addStudent(student);
                    break;
                case 2:
                    List<Student>students= dao.getAllStudent();
                    view.Displaystudent(students);
                    break;
                case 8:
                    view.showmessage("thank you");
                    System.exit(0);
                    break;
                case 7:
                    int total= dao.getTotalStudent();
                    view.showmessage("Total Students: "+ total);
                    break;
                case 6:
                    int id= view.getidfordelete();
                    dao.deleteStudent(id);
                    break;
                case 3:
                    int id1= view.searchstudentid();
                    Student studs= dao.getStudentByID(id1);
                    if(studs!= null){
                        view.getsinglestudent(studs);
                    }else{
                        view.showmessage("student not found.");
                    }
                    break;
                case 4:
                    String name1= view.searchstudentname();
                    List<Student> list= dao.searchStudentByName(name1);
                    if(list.isEmpty()){
                        view.showmessage("student not found");
                    }else{
                        view.Displaystudent(list);
                    }
                    break;
                case 5:
                    int id2= view.updateid();
                    Student stud= view.getdetailupdate(id2);
                    dao.updateStudent(stud);
                    break;
                default:
                    view.showmessage("invalid choice try again.");

            }
        }
    }
}
