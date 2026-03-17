package FileHandling;
import java.io.FileWriter;
import java.io.IOException;
public class WriterFileExample {
	public static void main(String[] args)throws IOException {
		try {
		FileWriter writer=new FileWriter("Example.txt");
		writer.write("\nWelcome to File handling concept ");
		writer.write("\nVery important for a programmer");
		writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully done");
		
		
	}

}
