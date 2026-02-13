package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;
import com.sms.util.DBConnection;
public class StudentDAOimpl implements StudentDAO{

    @Override
    public void addStudent(Student student){
        String sql= "insert into student(name, email, course, marks) values(?,?,?,?)";
        try(Connection con= DBConnection.getConnection()){
            PreparedStatement psmt= con.prepareStatement(sql);

            psmt.setString(1, student.getName());
            psmt.setString(2, student.getEmail());
            psmt.setString(3, student.getCourse());
            psmt.setInt(4, student.getMarks());

            psmt.executeUpdate();
            System.out.println("student added successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudent(){
        List<Student>  students= new ArrayList<>();
        String sql= "select * from student";

        try {
            Connection con= DBConnection.getConnection();
            PreparedStatement psmt= con.prepareStatement(sql);
            ResultSet rs= psmt.executeQuery();
            while(rs.next()){
                Student student = new Student( rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("course"), rs.getInt("marks"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int getTotalStudent(){
        int count= 0;
        String sql= "select count(*) from student";
        try {
            Connection con= DBConnection.getConnection();
            PreparedStatement psmt= con.prepareStatement(sql);
            ResultSet rs= psmt.executeQuery();
            if(rs.next()){
                count= rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
        
    }

    @Override
    public Student getStudentByID(int id) {
        // TODO Auto-generated method stub
        String query= "select * from student where id= ?";
        Student student = null;

        try(Connection con= DBConnection.getConnection()){
            PreparedStatement psmt= con.prepareStatement(query);
            psmt.setInt(1, id);
            ResultSet rs= psmt.executeQuery();
            if(rs.next()){
                student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("marks")
                );
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        String sql= "update student set name= ?,  email= ?, course= ?, marks= ? where id= ?";
        try(Connection con= DBConnection.getConnection()){
            PreparedStatement psmt= con.prepareStatement(sql);
            psmt.setString(1, student.getName());
            psmt.setString(2, student.getEmail());
            psmt.setString(3, student.getCourse());
            psmt.setInt(4, student.getMarks());
            psmt.setInt(5, student.getId());
            int rows= psmt.executeUpdate();
            if(rows>0){
                System.out.println("student update successful");
            }else{
                System.out.println("student no found with id: "+ student.getId());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql= "delete from student where id= ?";
        try(Connection con= DBConnection.getConnection()) {
            PreparedStatement psmt= con.prepareStatement(sql);
            psmt.setInt(1, id);
            int rowaffect= psmt.executeUpdate();
            if(rowaffect>0){
                System.out.println("student deleted successfully");
            }else{
                System.out.println("no student found with id: "+ id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        List<Student> list= new ArrayList<>();
        String query= "select * from student where name like ?";
        try(Connection con= DBConnection.getConnection()){
            PreparedStatement psmt= con.prepareStatement(query);
            psmt.setString(1, "%"+name+"%");
            ResultSet rs= psmt.executeQuery();
            while(rs.next()){
                Student student= new Student(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getString("email"), 
                    rs.getString("course"),
                    rs.getInt("marks")
                );
                
                list.add(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
