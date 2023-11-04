package connecter;
import java.sql.*;

public class DB_Connect {
	public static Connection conn = null;
	public static Statement stmt = null;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/celestial_db", "root", "");
			System.out.println("DataBase Connection Successful");
			stmt = conn.createStatement();
			project.Main.display();
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			try {
				create_db();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
	public static void create_db() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		System.out.println("Localhost Connection Successful");
		System.out.println("Creating DB");
		String cs = "CREATE SCHEMA `celestial_db`";
		String ctp = "CREATE TABLE `celestial_db`.`star` (\r\n"
				+ "  `id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `name` VARCHAR(100) NOT NULL,\r\n"
				+ "  `radius` DOUBLE NOT NULL,\r\n"
				+ "  `temperature` DOUBLE NOT NULL,\r\n"
				+ "  PRIMARY KEY (`id`))";
		String cts = "CREATE TABLE `celestial_db`.`planet` (\r\n"
				+ "  `id` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `name` VARCHAR(100) NOT NULL,\r\n"
				+ "  `radius` DOUBLE NOT NULL,\r\n"
				+ "  `numberOfMoons` INT NOT NULL,\r\n"
				+ "  PRIMARY KEY (`id`))";
		
		stmt = conn.createStatement();
		stmt.addBatch(cs);
		stmt.addBatch(cts);
		stmt.addBatch(ctp);
		stmt.executeBatch();
		System.out.println("DB created Successfully");
		main(null);
	}
}
