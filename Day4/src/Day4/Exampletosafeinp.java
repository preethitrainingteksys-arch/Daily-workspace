package Day4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exampletosafeinp {
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("OUTPUT.txt");
		 try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your message");
			String msg = sc.nextLine();
			System.out.println("Enter your Name:");
			String name = sc.nextLine();
			writer.write("Message: "+ msg +"\n");
			writer.write("Name: " +name +"\n");
			writer.flush();
			System.out.println("Can add more info");
			writer.write("Details updated");
			System.out.println("Files updated succesfully");
		 }
			finally
			{
				writer.close();
				
				
			}

	}

}
