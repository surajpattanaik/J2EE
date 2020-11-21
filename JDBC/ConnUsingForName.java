import java.sql.*;
class ConnUsingForName{
	

	public static void main(String args[])throws Exception{

         //oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();

	     //DriverManager.registerDriver(driver);
		 Class.forName("oracle.jdbc.driver.OracleDriver");

	     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","illusio9");

	     if(conn==null)
	        System.out.println("Connection failed");
	        else
	            System.out.println("Connection established");

       
            
       }
}