package Day2;
import java.util.ArrayList;
import java.util.List;

public class PetClinic {
	public static void main(String[] args)
	{
		//demo1();
		methodOverriding();
	}
	private static void methodOverriding()
	{
		Pet pet=new Dog("Husky");
		Animal animal=(Animal)pet;//upcasting
		animal.sound();
	}
	private static void demo1() {
		
	
		Dog dog = new Dog("Husky");
		dog.setName("Happy");
		Pet dog1=new Dog("Husky");
		dog.setName("Pluto");
		Cat cat =new Cat();
		cat.setName("bruno");
		//dog1.bark();
		dog.bark();
		List<Pet> pets=new ArrayList<Pet>();
		pets.add(dog);
		pets.add(dog1);
		pets.add(cat);
		pets.forEach((pet)->pet.play());
	}

}
