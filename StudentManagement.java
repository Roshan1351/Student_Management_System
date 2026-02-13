// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.Scanner;

// public class StudentManagement{
//     public static Connection getConnection(){
//         Connection con= null;
//         try{
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");

//         }catch (Exception e){
//             e.printStackTrace();
//         }
//         return con;
//     }

//     public static void addstudent(){
//         try{
//             Scanner sc= new Scanner(System.in);
//             System.out.print("enter name: ");
//             String name= sc.nextLine().trim();

//             System.out.print("enter email: ");
//             String email= sc.nextLine().trim();

//             System.out.print("enter course: ");
//             String course= sc.nextLine().trim();

//             System.out.print("enter marks(0-100): ");
//             if(!sc.hasNextInt()){
//                 System.out.println("Invalid Input! Marks must be a number.");
//                 System.out.println("try again...");
//                 return;
//             }
//             int marks= sc.nextInt();
//             if(name.isEmpty() || email.isEmpty() || course.isEmpty()){
//                 System.out.println("Error: name, email and course cannot be empty!");
//                 return;
//             }
//             if(marks<0 || marks>100){
//                 System.out.println("Error: Marks must be between 0 and 100!");
//                 return;
//             }
//             Connection con= getConnection();
//             String sql= "insert into student(name, email, course, marks)  values(?, ?, ?, ?)";
//             PreparedStatement ps= con.prepareStatement(sql);
//             ps.setString(1,name);
//             ps.setString(2,email);
//             ps.setString(3,course);
//             ps.setInt(4,marks);
//             ps.executeUpdate();
//             System.out.println("student added successfully");

//         }catch(Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void viewstudent(){
//         try{
//             Connection con= getConnection();
//             Statement st= con.createStatement();
//             ResultSet rs= st.executeQuery("select * from student");
//             boolean isfound= false;
//             while(rs.next()){
//                 isfound= true;
//                 System.out.println(
//                         rs.getInt("id")+" "+ rs.getString("name")+" "
//                         +rs.getString("email")+ " "+ rs.getString("course")+
//                                 " "+ rs.getInt("marks")
//                 );
//             }
//             if(!isfound){
//                 System.out.println("No student in this list first add student then view...");
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void updatestudent(){
//         try{
//             Scanner sc= new Scanner(System.in);
//             System.out.print("enter student id: ");
//             int id= sc.nextInt();
//             sc.nextLine();
//             System.out.print("enter new course: ");
//             String course= sc.nextLine();

//             System.out.print("enter new marks: ");
//             int marks= sc.nextInt();

//             Connection con= getConnection();
//             String sql= "update student set course=?, marks=? where id=?";
//             PreparedStatement ps= con.prepareStatement(sql);
//             ps.setString(1,course);
//             ps.setInt(2,marks);
//             ps.setInt(3,id);
//             int rows= ps.executeUpdate();
//             if(rows>0){
//                 System.out.println("student update successful");
//             }else{
//                 System.out.println("student not found");
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void deletestudent(){
//         try {
//             System.out.print("enter student id for delete: ");
//             Scanner sc= new Scanner(System.in);
//             int id= sc.nextInt();

//             Connection con= getConnection();
//             String sql= "delete from student where id=?";
//             PreparedStatement ps= con.prepareStatement(sql);
//             ps.setInt(1,id);

//             int rows= ps.executeUpdate();
//             if(rows>0){
//                 System.out.println("student deleted successfully");
//             }else{
//                 System.out.println("student id not found");
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void SearchStudentById(){
//         try {
//             Scanner sc = new Scanner(System.in);
//             System.out.print("Enter Student Name to search: ");
//             String name= sc.nextLine();
//             Connection con= getConnection();
//             String sql= "select * from student where name like ?";
//             PreparedStatement ps= con.prepareStatement(sql);
//             ps.setString(1,"%"+name+"%");
//             boolean isfound= false;
//             ResultSet rs= ps.executeQuery();
//             while(rs.next()){
//                 isfound= true;
//                 System.out.println(rs.getInt("id")+" "+ rs.getString("name")+" "+
//                         rs.getString("email")+" "+ rs.getString("course")+" "+
//                         rs.getInt("marks"));
//             }
//             if(!isfound){
//                 System.out.println("no student found with this name: "+ name);
//             }
//         }catch(Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void totalStudent(){
//         try{
//             Connection con= getConnection();
//             Statement st= con.createStatement();
//             ResultSet rs= st.executeQuery("Select count(*) as total from student");
//             if(rs.next()){
//                 System.out.println("Total Student: "+ rs.getInt("total"));
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static boolean adminlogin(){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("-------Login-------");
//         System.out.print("Enter username: ");
//         String user= sc.nextLine();
//         System.out.print("Enter password: ");
//         String pass = sc.nextLine();

//         try {
//             Connection con= getConnection();
//             String sql= "select * from admin where username=? and password=?";
//             PreparedStatement ps= con.prepareStatement(sql);
//             ps.setString(1,user);
//             ps.setString(2,pass);

//             ResultSet rs= ps.executeQuery();
//             return rs.next();
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return false;
//         }
//     }
// }


// class Main{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);

// //        StudentManagement sm= new StudentManagement();
//         if(!StudentManagement.adminlogin()){
//             System.out.println("Invalid Credential Existing...");
//             return;
//         }
//         while(true){
//             System.out.println("\n-----Student Management System-----");
//             System.out.println("1.Add Student");
//             System.out.println("2.View Student");
//             System.out.println("3.Update Student");
//             System.out.println("4.Delete Student");
//             System.out.println("5.Search student by Name");
//             System.out.println("6.Total Student");
//             System.out.println("7.Exit.");
//             System.out.print("choice option: ");

//             int choice= sc.nextInt();
//             switch (choice){
//                 case 1:
//                     StudentManagement.addstudent();
//                     break;

//                 case 2:
//                     StudentManagement.viewstudent();
//                     break;

//                 case 3:
//                     StudentManagement.updatestudent();
//                     break;

//                 case 4:
//                     StudentManagement.deletestudent();
//                     break;

//                 case 5:
//                     StudentManagement.SearchStudentById();
//                     break;

//                 case 6:
//                     StudentManagement.totalStudent();
//                     break;

//                 case 7:
//                     System.out.println("thank you!...");
//                     System.exit(0);
//                     break;

//                 default:
//                     System.out.println("invalid choice! try again...");
//             }
//         }
//     }
// }

