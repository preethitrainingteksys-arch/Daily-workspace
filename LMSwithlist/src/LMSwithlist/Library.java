package LMSWithList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Library {

	Map<Integer, Book> books = new HashMap<Integer, Book>();

	void add(String id, String title, float price, String author) {
		Integer id1 = new Integer(id);
		Book book = new Book(id, title, price, author);
		books.put(id1, book);
	}

	void reserve(String title) throws Exception {
		Collection<Book> booksOnly = books.values();
		Iterator<Book> iterator = booksOnly.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.title.equals(title) && book.getStatus() == STATUS.AVAILABLE) {
				book.setStatus(STATUS.BOOKED);
				System.out.println("Borrowed: " + title);
				return;
			}
		}
		/*
		 * 
		 */ throw new Exception("Book is not availaible.");
	}

	List<Book> find(String title) {
		List<Book> books = new ArrayList<>();
		for (Book book : books) {
			if (book.title.toLowerCase().contains(title.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	Book remove(String id) throws Exception {
		Collection<Book> booksOnly = books.values();
		Iterator<Book> iterator = booksOnly.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId().toLowerCase().equals(id.toLowerCase())) {
				books.remove(book);
				return book;
			}
		}
		throw new Exception("No book was availaible for the id: " + id);
	}

	void displayBooks() {
		System.out.println("BOOKS AVAILIABLE");
		System.out.println("============================================");
		Collection<Book> booksOnly = books.values();
		Iterator<Book> iterator = booksOnly.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getStatus() == STATUS.AVAILABLE)
				System.out.println(book + "\n\n");
			System.out.println("============================================");
		}
	}
}