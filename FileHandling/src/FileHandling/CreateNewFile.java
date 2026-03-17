package FileHandling;
import java.io.File;
import java.io.IOException;

public class CreateNewFile {
	public static void main(String[] args) {
		File file=new File("Example.txt");
		try
		{
			if(file.createNewFile())
			{
				System.out.println("File created "+file.getName());
				System.out.println(file.getAbsolutePath());
			}
			else
			{
				System.out.println("File exits");
			}
		}
		catch(IOException e)
		{
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

}
