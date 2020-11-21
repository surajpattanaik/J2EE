import java.sql.*;
import java.util.*;

public class SelectTest2
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee job");
		String job=sc.next().toUpperCase();
		//convert input value as required SQL query
		job="'"+job+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","illusio9");

		Statement st=con.createStatement();

		String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB="+job;
         
		System.out.println(query);
		ResultSet rs=st.executeQuery(query);

		int count=0;

		while(rs.next()){
			
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" ");
            count++;		
		}
		if(count>0){
		System.out.println(count+" records found");}
		else{
			System.out.println("No records found");
		}
		rs.close();
		st.close();
		con.close();

	}
}
