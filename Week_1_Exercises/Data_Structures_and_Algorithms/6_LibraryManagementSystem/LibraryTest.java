import java.util.*;

public class LibraryTest {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        // Linear Search
        Book book = LibraryManagementSystem.linearSearchByTitle(books, "1984");
        System.out.println("Linear Search Result: " + book);

        // Prepare for Binary Search
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        // Binary Search
        book = LibraryManagementSystem.binarySearchByTitle(books, "To Kill a Mockingbird");
        System.out.println("Binary Search Result: " + book);
    }
}
