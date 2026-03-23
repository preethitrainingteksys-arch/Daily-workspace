package LibraryTest;

public class Library {
	private int books;
	public Library(int books)
	{
		this.books=books;
	}
	public int addbook(int count)
	{
		books=books+count;
		return books;
	}
	public int borrowbook()
	{
		if(books<=0)
		{
			throw new IllegalArgumentException("No books available");
		}
		books=books-1;
		return books;
	}
	public int getAvailablebooks()
	{
		return books;
	}
	

}
