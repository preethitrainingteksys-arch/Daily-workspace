package Day4;

import java.io.FileNotFoundException;

public class CheckedExceptionexample {
	public static void main(String[] args) {
		try
		{
			readfile();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();;
		}
	}

	private static void readfile()throws FileNotFoundException {//deferred
		// TODO Auto-generated method stub
		FileReader file = new FileReader("data.txt");
		
	}

}
