package Day6;

public class SecondLargestElementInanArray {
	public static void main(String[] args) {
		int[] array= {-5,-2,-7,-9,-8};
		
		
		int largest=Integer.MIN_VALUE;
		int secondlargest=Integer.MIN_VALUE;
		for(int n:array)
		{
			if(n>largest)
			{
				secondlargest=largest;
				largest=n;
			}
			else if(n>secondlargest && n!=largest)
			{
				secondlargest=n;
			}
			//try what if negative integer is there 
			else if(n<1)
			{
			   	System.out.println("Negative integer");
			}
		}
		System.out.println("SecondlargestElment="+secondlargest);
		{
			
		}
	}
	
	

}
