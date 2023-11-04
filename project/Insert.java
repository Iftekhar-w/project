package project;

import java.io.*;

public class Insert {
	public static void display() throws IOException{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String planet, star;
		int num;
		double radius, temp;
		for(;;) {
			System.out.println("\nInsert Menu:");
			System.out.println("1.Planet  2.Star  3.Previous Menu");
			choice = Integer.parseInt(scan.readLine());
			try {
				switch(choice) {
				case 1:
					System.out.print("Enter the name of the planet: ");
				    planet = scan.readLine();
				    System.out.print("Enter the radius of the planet in kms: ");
				    radius = Double.parseDouble(scan.readLine());
				    System.out.print("Enter it's number of moons: ");
				    num = Integer.parseInt(scan.readLine());
				    Planet p = new Planet(planet, radius, num);	
				    p.insert();
					break;
				case 2:				
					System.out.print("Enter the name of the star: ");
				    star = scan.readLine();
				    System.out.print("Enter the radius of the star in kms: ");
				    radius = Double.parseDouble(scan.readLine());
				    System.out.print("Enter it's temperature in K: ");
				    temp = Double.parseDouble(scan.readLine());
				    Star s = new Star(star, radius, temp);
				    s.insert();
					break;
				case 3: return;
				default: System.out.println("Invalid choice!");
				} 
			}catch(NumberFormatException ex) {
				System.out.println("Please Enter a double value for the respective fields");
				System.out.println("-------------------------------------------------------------");
			}
		}
	}
}
