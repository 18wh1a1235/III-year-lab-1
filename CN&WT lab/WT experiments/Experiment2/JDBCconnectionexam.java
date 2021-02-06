import java.sql.*;
public class JDBCConnectionExample {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","bhargavi");
			Statement stmt = con.createStatement();
			System.out.println("Connection established succesfully");
			ResultSet rs = stmt.executeQuery("select * from author");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			stmt.close();
			con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
