package com.sms;

import com.sms.controller.StudentController;

public class Main{
    public static void main(String[] args) {
        StudentController controller= new StudentController();
        controller.start();
    }
}