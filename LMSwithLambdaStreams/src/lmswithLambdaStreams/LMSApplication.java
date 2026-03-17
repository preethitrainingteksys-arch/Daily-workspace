
/*package lmswithLambdaStreams;

import java.util.*;

public class LMSApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library = new LibraryService();

        library.setBooks(FileService.loadBooks());

        while(true) {

            System.out.println("\n1 Add Book");
            System.out.println("2 Display Books");
            System.out.println("3 Search Book");
            System.out.println("4 Borrow Book");
            System.out.println("5 Show Available Books");
            System.out.println("6 Sort Books");
            System.out.println("7 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    library.addBook(
                        new Book(id,title,author,true));

                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:

                    System.out.print("Enter title: ");
                    String search = sc.nextLine();

                    library.searchByTitle(search);
                    break;

                case 4:

                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();

                    library.borrowBook(bookId);
                    break;

                case 5:

                    library.showAvailableBooks();
                    break;

                case 6:

                    library.sortBooksByTitle();
                    break;

                case 7:

                    FileService.saveBooks(
                        library.getBooks());

                    System.out.println("Saved to file.");
                    System.exit(0);
            }
        }
    }
}
*/
package lmswithLambdaStreams;
import java.util.Scanner;  // Import Scanner for input

public class LMSApplication {

    public static void main(String[] args) {
        // Create scanner and LibraryService objects
        Scanner sc = new Scanner(System.in);  // Create scanner object to read input
        LibraryService library = new LibraryService();  // LibraryService to manage books

        // Load books from the file when starting the program
        library.setBooks(FileService.loadBooks());

        // Start of the user menu loop
        while (true) {
            // Display menu to the user
            System.out.println("\n1 Add Book");
            System.out.println("2 Display Books");
            System.out.println("3 Search Book");
            System.out.println("4 Borrow Book");
            System.out.println("5 Show Available Books");
            System.out.println("6 Sort Books");
            System.out.println("7 Exit");

            // Read user's choice
            int choice = sc.nextInt();  // Read user choice (integer)
            sc.nextLine();  // Consume newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Add a new book
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // Consume newline character after nextInt()

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    // Add book to the library
                    library.addBook(new Book(id, title, author, true));
                    break;

                case 2:
                    // Display all books
                    library.displayBooks();
                    break;

                case 3:
                    // Search for a book by title
                    System.out.print("Enter title: ");
                    String search = sc.nextLine();
                    library.searchByTitle(search);
                    break;

                case 4:
                    // Borrow a book
                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    library.borrowBook(bookId);
                    break;

                case 5:
                    // Show available books
                    library.showAvailableBooks();
                    break;

                case 6:
                    // Sort books by title
                    library.sortBooksByTitle();
                    break;

                case 7:
                    // Save books to file and exit
                    FileService.saveBooks(library.getBooks());
                    System.out.println("Exiting program...");
                    System.exit(0);  // Exit the program

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}