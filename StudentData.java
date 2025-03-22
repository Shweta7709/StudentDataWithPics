import java.sql.*;
import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/symbiosis";
        String username = "root";
        String password = "12345678";

        // Paths to image files
        String imagePath1 = "D:\\\\DELL\\\\College_Training\\\\JDBC\\\\wallpaper.png";
        String imagePath2 = "D:\\\\DELL\\\\College_Training\\\\JDBC\\\\wallpaper.png";
        String imagePath3 = "D:\\\\DELL\\\\College_Training\\\\JDBC\\\\wallpaper.png";
        String imagePath4 = "D:\\\\DELL\\\\College_Training\\\\JDBC\\\\wallpaper.png";
        String imagePath5 = "D:\\\\DELL\\\\College_Training\\\\JDBC\\\\wallpaper.png";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sql  = "INSERT INTO student (RNo, Sname, course, email, phone_No, profile_pic) VALUES (?, ?, ?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE Sname = VALUES(Sname), course = VALUES(course), email = VALUES(email), phone_No = VALUES(phone_No), profile_pic = VALUES(profile_pic)";

            
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                
                //  First Student
                File file1 = new File(imagePath1);
                FileInputStream fis1 = new FileInputStream(file1);
                pstmt.setInt(1, 1); // RNo
                pstmt.setString(2, "Shweta"); // Sname
                pstmt.setString(3, "ENTC"); // course
                pstmt.setString(4, "snnashte@gmail.com"); // email
                pstmt.setInt(5, 234); // phone_No
                pstmt.setBinaryStream(6, fis1, (int) file1.length()); // profile_pic
                pstmt.addBatch();  // Add to batch

//                //  Second Student
                File file2 = new File(imagePath2); //  Declare file2
                FileInputStream fis2 = new FileInputStream(file2); //  Declare fis2
                pstmt.setInt(1, 2); // RNo
                pstmt.setString(2, "Vaishnavi"); // Sname
                pstmt.setString(3, "ENTC"); // course
                pstmt.setString(4, "vspatil@gmail.com"); // email
                pstmt.setInt(5, 121); // phone_No
                pstmt.setBinaryStream(6, fis2, (int) file2.length()); // profile_pic
                pstmt.addBatch();  // Add to batch
                
                File file3 = new File(imagePath3);
                FileInputStream fis3 = new FileInputStream(file3);
                pstmt.setInt(1, 3);
                pstmt.setString(2, "Shivanjali");
                pstmt.setString(3, "CSE");
                pstmt.setString(4, "rautshivanjali15@gmail.com");
                pstmt.setInt(5, 345);
                pstmt.setBinaryStream(6, fis3, (int) file3.length());
                pstmt.addBatch();  // Add to batch
              
               File file4 = new File(imagePath4);
             FileInputStream fis4 = new FileInputStream(file4);
                pstmt.setInt(1, 4);
                pstmt.setString(2, "Alfiya");
                pstmt.setString(3, "ENTC");
                pstmt.setString(4, "alfiyakhatib@gmail.com");
                pstmt.setInt(5, 567);
                pstmt.setBinaryStream(6, fis4, (int) file4.length());
                pstmt.addBatch();  // Add to batch
            	
            	 File file5 = new File(imagePath5);
                 FileInputStream fis5 = new FileInputStream(file5);
                 pstmt.setInt(1, 5);
                 pstmt.setString(2, "Rahul");
                 pstmt.setString(3, "IT");
                 pstmt.setString(4, "rahulverma@gmail.com");
                 pstmt.setInt(5, 678);
                 pstmt.setBinaryStream(6, fis5, (int) file5.length());
                 pstmt.addBatch();  // Add to batch

                //  Execute Batch
                int[] results = pstmt.executeBatch();
                System.out.println("Inserted " + results.length + " records successfully.");

                // Close file streams
                fis1.close();
                fis2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
