package project;

import java.sql.SQLException;

import connecter.DB_Connect;

public class Planet extends CelestialBody {
	int numberOfMoons;
	Planet(String n, double r, int Moons) {
		name = n;
		radius = r;
		numberOfMoons = Moons;
	}
	@Override
	public void insert() {
		try {
			DB_Connect.stmt.execute("insert into celestial_db.planet(name, radius, numberOfMoons) values('" + this.name + "','" + this.radius+ "','" + this.numberOfMoons + "')");
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
