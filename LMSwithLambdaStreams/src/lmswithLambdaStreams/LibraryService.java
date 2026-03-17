/*
package lmswithLambdaStreams;
import java.util.*;
import java.util.stream.*;

public class LibraryService {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {

        books.stream()
             .forEach(book -> System.out.println(book));
    }

    public void searchByTitle(String title) {

        books.stream()
             .filter(book -> book.getTitle()
             .toLowerCase()
             .contains(title.toLowerCase()))
             .forEach(System.out::println);
    }

    public void showAvailableBooks() {

        books.stream()
             .filter(book -> book.isAvailable())
             .forEach(System.out::println);
    }

    public void borrowBook(int id) {

        books.stream()
             .filter(book -> book.getId() == id)
             .findFirst()
             .ifPresent(book -> book.borrowBook());
    }

    public void sortBooksByTitle() {

        books.stream()
             .sorted((b1,b2) -> b1.getTitle()
             .compareTo(b2.getTitle()))
             .forEach(System.out::println);
    }

    public long countAvailableBooks() {

        return books.stream()
                    .filter(Book::isAvailable)
                    .count();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
*/
package lmswithLambdaStreams;
import java.util.*;
import java.util.stream.*;

public class LibraryService {
    private List<Book> books = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    // Display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Displaying all books:");
            books.stream().forEach(book -> System.out.println(book));
        }
    }

    // Search for books by title
    public void searchByTitle(String title) {
        System.out.println("Searching for books with title: " + title);
        books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
            .forEach(System.out::println);
    }

    // Show available books
    public void showAvailableBooks() {
        System.out.println("Displaying available books:");
        books.stream()
            .filter(Book::isAvailable)
            .forEach(System.out::println);
    }

    // Borrow a book
    public void borrowBook(int id) {
        books.stream()
            .filter(book -> book.getId() == id)
            .findFirst()
            .ifPresent(book -> {
                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("Book borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
            });
    }

    // Sort books by title
    public void sortBooksByTitle() {
        System.out.println("Sorting books by title:");
        books.stream()
            .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
            .forEach(System.out::println);
    }

    // Count available books
    public long countAvailableBooks() {
        return books.stream().filter(Book::isAvailable).count();
    }

    // Get all books in the library
    public List<Book> getBooks() {
        return books;
    }

    // Set books list (used for loading books from file)
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

