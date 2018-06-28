
import java.sql.*;
import javax.swing.*;
public class javaconnect {
Connection conn=null;
  public static Connection connectDb() {
      try{
        Class.forName("org.sqlite.JDBC");
     Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Akshay\\Documents\\NetBeansProjects\\JavaApplication1\\project1.sqlite");
   //  JOptionPane.showMessageDialog(null,"Connection Estabilished");
     return conn;
    }
      catch(Exception e){
      System.out.print(e);
  return null;}}
}
