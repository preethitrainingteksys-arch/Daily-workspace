package Day3collection;
import java.util.List;
import java.util.*;

public class Collectionexample {
	public static void main(String args[])
	{
		//List<String> fruits =new ArrayList<>();
		List<String>fruits=new LinkedList();
		//List<String>fruits=new Vectort();
		fruits.add("apple");
		fruits.add("mango");
		fruits.add("mango");
		fruits.add("banana");
		
		System.out.println(fruits);
		System.out.println(fruits.get(1)==fruits.get(2));
		//in list indexing starts from 0
		
		
	}

}
