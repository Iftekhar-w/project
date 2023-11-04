package project;

import java.io.*;

public class Main {
	public static void display() throws IOException {
		int choice;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
			try {
				System.out.println("\nMain Menu:");
				System.out.println("1.Insert  2.Display  3.Exit");
				choice = Integer.parseInt(input.readLine());
				switch(choice) {
				case 1:	Insert.display(); break;
				case 2: Display.display(); break;
				case 3: return;
				default: System.out.println("Invalid choice!");
				}
			} catch(NumberFormatException ex) {
				System.out.println("Please Enter an Integer for the choice");
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

}
