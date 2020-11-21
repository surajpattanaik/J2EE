import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest5 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// register jdbc driver by loading jdbc driver class (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "illusio9");
			// create Statement object
			if (con != null)
				st = con.createStatement();
			// prepare SQL Query
			String query = "SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
			// send and execute SQL query in DB s/w
			if (st != null)
				rs = st.executeQuery(query);
			// process the ResultSet
			boolean flag = false;
			if (rs != null) {
				while (rs.next()) {
					flag = true;
					System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
				}
			}
			if (flag == false)
				System.out.println("No Records found---Db table is empty");
			else
				System.out.println("Records found and displayed");
		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}
	}
}