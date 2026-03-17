package Day6;

public class ArrayExample {
	public static void main(String[] args) {
		// int[] numbers= {10,20,30,40,50};
		/*
		int numbers[] = new int[10];
		System.out.println(numbers[2]);

	}*/
	arrayWithCustomObjects();
}
	private static void arrayWithCustomObjects()
	{
		Book[] books=new Book[10];
		books[0]=new Book();
		books[1]=new Book();
		books[2]=new Book();
		books[3]=new Book();
		System.out.println(books[0]);
		}
	
	private static void basicArray()
	{
		//int[] numbers= {10,20,30,40,50};
		int[] numbers = new int[10];
		numbers[1]=10;
		System.out.println(numbers[2]);
		Object[] books;
		System.out.println(books[0].author);
	}
}
