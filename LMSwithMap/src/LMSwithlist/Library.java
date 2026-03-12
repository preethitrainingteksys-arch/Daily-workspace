package LMSwithlist;
import java.util.*;

public class Library {
	List<Book> books= new LinkedList<>();
	
	public void addbook(Book b) {
		books.add(b);
		System.out.println(b.getTitle()+" Book is added");
	}
	
	public void removebook(int id)
	{
		if(id<0)
		{
			System.out.println("Invalid Id");
		}
		books.removeIf(b->b.getId()==id);
		System.out.println(" Book is removed");
	}
	public void reservebook(int id)
	{
		for(Book b:books)
		{
			if(b.getId()==id)
			{
				System.out.println("Book is reserved"+ b.getTitle());
				return;
			}
		}
		
		System.out.println("book is not reserved");
}

	
public static void main(String[] args)
{
	
    Scanner sc =new Scanner(System.in);
	Library lib=new Library();
	int id;
	String Title;
	float price;
	String authors;
	System.out.println("Library Management System :");
	id=sc.nextInt();
	Title=sc.nextChar();
	
	Book b1= new Book(10,"Mythology",345.9f,"Jimmy");
	Book b2= new Book(98,"Cultures and traditions",568f,"Kvishwanath");
	
	lib.addbook(b1);
	lib.addbook(b2);
	lib.reservebook(10);
	
	System.out.println("Remove the book");
	System.out.println(b1);//nned to override
	lib.removebook(98);
	
	
	System.out.println("Title of the book is " +b1.getTitle());
	System.out.println("Title of the book is " +b2.getTitle());
	
	
	
	

}
	

}
