import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NonSelect1 {
	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		// ResultSet rs = null;
		try {
			// register jdbc driver by loading jdbc driver class (optional)
			// Class.forName("oracle.jdbc.driver.OracleDriver"); //optional
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "illusio9");
			// create Statement object
			if (con != null)
				st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter job name to delete");
			String job = sc.next();
			// prepare SQL Query
			String query = "DELETE FROM EMP WHERE JOB='" + job.toUpperCase() + "'";
			// send and execute SQL query in DB s/w
			int rows = 0;
			if (st != null) {
				rows = st.executeUpdate(query);
			}
			if (rows >= 1)
				System.out.println(rows + " records deleted");
			else
				System.out.println("no such job");
		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs

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
