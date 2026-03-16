package Day4;
import java.io.*;

public class Uncheckedexample {
	public static void main(String[] args) {
		//String str = null;
		//System.out.println(str.length());
		
		try {
			validteAge(17);
			
		} catch (IllegalArgumentException e) {//gemerally we dont catch unchecked excetions but technically its possible 
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Finished");
	}
	private static void validteAge(int age)
	{
		if(age<18)
		{
			throw new IllegalArgumentException("Age must be 18");
		}
	}

}
