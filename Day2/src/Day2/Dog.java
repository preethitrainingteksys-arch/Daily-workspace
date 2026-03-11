package Day2;

//public class Dog implements Pet {
	public class Dog extends Animal implements Pet{
	private String  breed;
	
	public Dog(String breed)
	{
		this.breed=breed;
	}

	public String getBreed() {
		return breed;
	}
	public void sound()
	{
		System.out.println("Dog makes sound");
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing with dog");
		
		
	}
	public void bark()
	{
		System.out.println(getName()+ " is barking");
	}
	
	

}
