package Day6;
public class LargestElementInArray {
	public static void main(String[] args) {
		int[] arr={5,9,2,7,1};
		int largest=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>largest)
			{
				largest=arr[i];
				System.out.println("Largest");
			}
					
		}
		System.out.println("Largest Element:"+largest);
	}

}
