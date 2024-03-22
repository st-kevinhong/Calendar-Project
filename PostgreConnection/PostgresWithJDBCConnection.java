import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgresWithJDBCConnection {
	public static void main(String[] args) {
		//establishes database connection
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/hst", "hst", "hst")) {
			System.out.println("Connection established successfully");
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
}
