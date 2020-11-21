import java.sql.*;

public class ConnTest{

       public static void main(String args[])throws Exception{

             oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();

	     DriverManager.registerDriver(driver);

	     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","illusio9");

	     if(conn==null)
	        System.out.println("Connection failed");
	        else
	            System.out.println("Connection established");

       
            
       }
}