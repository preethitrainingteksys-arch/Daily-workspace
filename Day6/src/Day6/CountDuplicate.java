package Day6;

public class CountDuplicate {
	public static void main(String[] args) {
		int[] array= {1,2,3,3,2,1,4,5,7,7,6,5};
		for(int i=0;i<array.length;i++)
		{
			int count=1;
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]==array[j])
				{
					count++;
					
				}
			}
			if(count>1)
			{
				System.out.println("The Count of duplicates present in the Array are: "+count);
			}
			
			
		}
		
	}

}
