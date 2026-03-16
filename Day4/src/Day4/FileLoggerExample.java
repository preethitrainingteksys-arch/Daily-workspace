package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class FileLoggerExample {
	private static final Logger=Logger.getLogger(FileLoggerExample.class.getName());
	public static void main(String[] args)
	{
		try(BufferedReader reader=new BufferedReader(new FileReader("data.txt")))
		{
			String line;
			while((line=reader.readLine())!=null)
			{
				Logger.info(line);
			}
		}
		catch (IOException e)
		{
			logger.severe("File rading error: "+e.getMessage());
		}
	}
}
