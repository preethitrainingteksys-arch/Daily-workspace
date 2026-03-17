package FileHandling;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReaderFileExample {
	public static void main(String[] args) throws IOException {
		try
		{
			File file=new File("Example.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				String data=reader.nextLine();
				System.out.println(data);
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			
		}
		
		
	}

}
