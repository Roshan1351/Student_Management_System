package com.sms.view;

import  java.util.List;
import java.util.Scanner;

import com.sms.model.Student;
public class StudentView {
    private Scanner sc= new Scanner(System.in);
    public int showMenus(){
        System.out.println("\n------Student Management System------\n");
        System.out.println("1.Add student");
        System.out.println("2.view student");
        System.out.println("3.Search student by ID");
        System.out.println("4.Search student by Name");
        System.out.println("5.Update student");
        System.out.println("6.Delete student");
        System.out.println("7.Total student count");
        System.out.println("8.Exit");
        System.out.print("Enter your choice: ");
        while (true){
            String input= sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("invalid choice! enter number only...");
            }
        }
    }

    public Student getStudentDetail(){

        System.out.print("Enter name: ");
        String name= sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email= sc.nextLine().trim();

        System.out.print("Enter course: ");
        String course= sc.nextLine().trim();


        int marks= 0;
        while (true) { 
            System.out.print("Enter marks (0-100): ");
            String input = sc.nextLine().trim();

            try {
                marks = Integer.parseInt(input); 
                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                System.out.println("Marks must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number only.");
            }
        }
        return new Student(marks, name, email, course, marks);
    }

    public void Displaystudent(List<Student> students){
        if(students.isEmpty()){
            System.out.println("no student found");
            return;
        }
        System.out.println("\n-----student list------");
        for(Student s: students){
            System.out.println(s);
        }
    }

    public void showmessage(String message){
        System.out.println(message);
    }

    public int getidfordelete(){
        System.out.println("Enter student id to delete: ");
        while (true) { 
            String input= sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("invalid id! enter number only...");
            }
        }
    }
    
    public int searchstudentid(){
        System.out.print("Enter student id to search: ");
        while (true) { 
            String input= sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("invalid id! enter number only...");
            }
        }
    }

    public String searchstudentname(){
        System.out.print("Enter student name to search: ");
        String input= sc.nextLine().trim();
        return input;
    }

    public int updateid(){
        System.out.println("Enter student id to update: ");
        
        while (true) { 
            String input= sc.nextLine().trim();
            try{
                return Integer.parseInt(input);
            }catch(Exception e){
                System.out.println("invalid input! enter number only");
            }
        }
    }

    public Student getdetailupdate(int id){
        System.out.print("Enter new name: ");
        String name= sc.nextLine().trim();

        System.out.print("Enter new email: ");
        String email= sc.nextLine().trim();

        System.out.print("Enter new course: ");
        String course= sc.nextLine().trim();

        int marks= 0;
        while (true) { 
            System.out.println("Enter new marks(0-100): ");
            String input= sc.nextLine().trim();
            try{
                marks= Integer.parseInt(input);
                if(marks>= 0 && marks<= 100){
                    break;
                }else{
                    System.out.println("marks must be between 0 and 100.");
                }
            }catch(Exception e){
                System.out.println("invalid input! enter number only...");
            }
        }
        return new Student(id, name, email, course, marks);
    }

    public void getsinglestudent(Student student){
        System.out.println(student.getId()+" | "+ student.getName()+" | "+ student.getEmail()+" | "+ student.getCourse()+" | "+ student.getMarks());
    }
}
