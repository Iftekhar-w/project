package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import connecter.DB_Connect;

public class Display {
	public static ResultSet rs = null;

	public static void display() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		for(;;)
		{
			System.out.println("\nDisplay Menu:");
			System.out.println("1.Planet  2.Star  3.Previous Menu");
			choice = Integer.parseInt(input.readLine());
			System.out.println("---------------------------------------------------------------------------------");
			try {
				switch(choice) {
				case 1:
					rs = DB_Connect.stmt.executeQuery("SELECT * FROM celestial_db.planet;");					  
					System.out.printf("%3s | %15s | %20s | %10s ", "ID", "NAME", "RADIUS", "NUMBER OF MOONS");
					System.out.println();  
					System.out.println("---------------------------------------------------------------------------------"); 
					while(rs.next()) 
						System.out.format("%3s | %15s | %20s | %10s \n", rs.getInt("id"),rs.getString("name"), rs.getDouble("radius"), rs.getInt("numberOfMoons"));
					break;
				case 2:
					rs = DB_Connect.stmt.executeQuery("select * from celestial_db.star");					 
					System.out.printf("%3s | %15s | %20s | %10s ", "ID", "NAME", "RADIUS", "TEMPERATURE");
					System.out.println();  
					System.out.println("---------------------------------------------------------------------------------");
					while(rs.next())
						System.out.format("%3s | %15s | %20s | %10s \n", rs.getInt("id"),rs.getString("name"), rs.getDouble("radius"), rs.getDouble("temperature"));
					break;
				case 3: rs.close(); return;
				default: System.out.println("Invalid choice!");
				}
				System.out.println("---------------------------------------------------------------------------------"); 
			} catch(SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
}
