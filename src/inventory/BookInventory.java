package inventory;

import java.time.Year;
import java.util.*;
import books.Book;

public class BookInventory {

    // private Dictionary<String, Book> books = new Dictionary<>();
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new RuntimeException("Book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
        System.out.println("Book '" + book.getTitle() + "' added.");
    }

    public List<Book> removeOutdatedBooks(int yearLimit) {
        int currentYear = Year.now().getValue();
        List<Book> removed = new ArrayList<>();

        // if (yearLimit < 0) {
        // throw new RuntimeException("Year limit must be non-negative.");
        // }
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > yearLimit) {
                removed.add(book);
                iterator.remove();
                System.out.println(" outdated book removed: '" + book.getTitle() + "'");
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found.");
        }

        double amount = book.buy(quantity, email, address);
        System.out.println("Successfully bought '" + book.getTitle() + "' for " + amount);
        return amount;
    }
}
