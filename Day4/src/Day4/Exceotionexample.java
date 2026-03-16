package Day4;

public class Exceotionexample {
	public static void main(String args[])
	{
		try
		{
			int result =10/0;
			System.out.println(result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by 0");
		}
		finally {
			System.out.println("program finished");
		}
	}

}
