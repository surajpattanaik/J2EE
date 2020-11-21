import java.sql.*;
public class SelectTest1{

	public static void main(String args[])throws Exception{
		



         Class.forName("oracle.jdbc.driver.OracleDriver");

	     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","illusio9");
         
		 Statement st=conn.createStatement();

		 ResultSet rs= st.executeQuery("SELECT * FROM EMP");
         
		 while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
             //Or
			//System.out.println(rs.getString("empno")+" "+rs.getString("ename")+" "+rs.getString("job"));
		 }

		 System.out.println("==============================================================");
		 ResultSet rs1= st.executeQuery("SELECT * FROM EMP");
		 while(rs1.next()){
			//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
           
			System.out.println(rs1.getString("empno")+" "+rs1.getString("ename")+" "+rs1.getString("job"));
		 }


	}
}