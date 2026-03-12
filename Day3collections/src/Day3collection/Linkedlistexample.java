package Day3collection;
import java.util.*;

public class Linkedlistexample {
	public static void main(String[] args)
	{
		//List<String>cities = new LinkedList<>();
		List<String> cities = listofcities();
		System.out.println(cities.contains("Delhi"));
		System.out.println(cities.contains("Chennai"));
		System.out.println(cities.lastIndexOf("Delhi"));
		System.out.println(cities.lastIndexOf("delhi"));
		//System.out.println(cities.remove("Mumbai"));
		System.out.println(cities.contains("Mumbai"));
		System.out.println(cities.set(2, "Chennai"));//sets or replaces elemsts at a particular index
		System.out.println(cities);
		//System.out.println(cities);
		//to get or extract methods 
		//downcasting
		//ifcities instanceof LL then do casting
		
		//private static void defensiveDownCasting(List<String> cities)
		{
			
			if (cities instanceof LinkedList<String>)
			{//safe coding 
				LinkedList<String> linkedlist =((LinkedList)cities);//downcasting
				linkedlist.addFirst("Chennai");
			}
		}
		System.out.println(cities);
		
		
	}

	private static List<String> listofcities() {
		List<String>cities=new ArrayList<>();
		
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Bangalore");
		return cities;
	}

}
