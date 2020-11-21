import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NonSelect2 {
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
			System.out.println("enter Dept No");
			int deptno = sc.nextInt();
			System.out.println("enter Dept Name");
			String dname = sc.next();
			System.out.println("enter Location");
			String loc = sc.next();
			// prepare SQL Query
			String query = "INSERT INTO DEPT VALUES("+deptno+",'" + dname.toUpperCase() + "',"+"'" + loc.toUpperCase() + "'"+")";
			// send and execute SQL query in DB s/w
			int rows = 0;
			if (st != null) {
				rows = st.executeUpdate(query);
			}
			if (rows >= 1)
				System.out.println(rows + " records inserted");
			else
				System.out.println("records coundn't be inserted");
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
