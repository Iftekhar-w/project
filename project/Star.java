package project;

import java.sql.SQLException;

import connecter.DB_Connect;

public class Star extends CelestialBody {
	double temperature;
    Star(String n, double r, double temp) {
        name = n;
        radius = r;
        temperature = temp;
    }
    @Override
    public void insert() {
		try {
			DB_Connect.stmt.execute("insert into celestial_db.star(name, radius, temperature) values('" + this.name + "','" + this.radius+ "','" + this.temperature + "')");
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
