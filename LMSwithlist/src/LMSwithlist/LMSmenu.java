package LMSwithlist;
import java.util.Scanner;

public class LMSmenu {
	Library lib;
	Scanner sc=new Scanner(System.in);
	
	LMSmenu(Library lib)
	{
		this.lib=lib;
		
	}
	void displaymenu()
	{
		System.out.println("Library Management system");
		String options="Options:\n\t1.Add book \n\t2.Remove book \n\t3.Reserve book \n\t4.Display book \n\t0.Exit";
		System.out.println(options);
		
	}
	
	void start()
	{
		int choice;
		while(true)
		{
			displaymenu();
			choice=-1;
			System.out.println("\n Enter choice");
			try
			{
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					handleaddition();
					break;
				case 2:
					handleremoval();
					break;
				case 3:
					handlereservation();
					break;
				case 4:
					lib.displaybook();
					break;
				default:
					System.out.println("Invalid choice");
				}
			}
			catch(Exception e)
			{
				sc.nextLine();
			}
		}
	}
	void handleaddition()throws Exception
	{
		String authors,title,id;
		float price;
		System.out.print("Enter book title");
		title=sc.next();
		if(title.trim().equals(" "))
		{
			throw new Exception("Invalid book name");
		}
		System.out.println("Enter book author: ");
		authors=sc.next();
		if(authors.trim().equals(""))
		{
			throw new Exception("Invalid author name");
		}
		System.out.print("Enter id");
		id=sc.next();
		System.out.print("Enter price");
		price=sc.nextFloat();
		lib.addbook(id,Title,price,author);
		
	}
	void handlereservation() throws Exception
	{
		System.out.print("Enter book name: ");
		String name=sc.nextLine();
		lib.reservebook(name);
	}
	void handleremoval() throws Exception
	{
		System.out.print("Enter id: ");
		String id=sc.next();
		lib.removebook(id);
	}
	
	
}
