import java.sql.*;

class Test {

	public static Connection getConnection()
	{
		Connection conn = null;
		try 
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","illusio9");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class Test1 {

	public static boolean isUserValid(String user_name,String password)
	{
		boolean validStatus = false;
		try
		{
			Connection conn = Test.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM login_info WHERE user_name = '"+user_name+"' AND password = '"+password+"'");
			while(rs.next())
			{
				validStatus = true;
			}
			
			Test.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return validStatus;
	}


	public static void main(String args[]){
		
		System.out.println(isUserValid("suraj","illusio9")); //true




	}
}
