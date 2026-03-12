package LMSwithlist;

import java.util.LinkedList;
import java.util.List;

public class Book {
	private int id;
	private String Title;
	private float price;
	private String authors;
	
	public int getId() {
		return id;
	}



	public String getTitle() {
		return Title;
	}



	public float getPrice() {
		return price;
	}



	public String getAuthors() {
		return authors;
	}
	
	
	public Book(int id,String Title,float price,String authors)
	{
		this.id=id;
		this.Title=Title;
		this.price=price;
		this.authors=authors;
	}
	
	
	@Override
	public String toString()
	{
		String json="""
				{
				"id":"%d",
				"Title":"%s",
				"price":"%.2f",
				"authors":"%s"
				}
				""".formatted(id,Title,price,authors);
		return json;
		
	}
	
}
