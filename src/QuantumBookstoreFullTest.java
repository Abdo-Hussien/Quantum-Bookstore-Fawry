import java.util.ArrayList;
import java.util.List;
import books.*;
import inventory.BookInventory;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();

        // Add books
        inventory.addBook(new PaperBook("001", "Clean Code", "Robert C. Martin", 2008, 30.0, 5));
        inventory.addBook(new EBook("002", "Deep Learning", "Ian Goodfellow", 2016, 25.0, "PDF"));
        inventory.addBook(new ShowcaseBook("003", "Rare Manuscript", "Unknown", 1900, 0.0));

        // Buy PaperBook
        inventory.buyBook("001", 2, "user@example.com", "123 Elm St, Cairo");

        // Buy EBook
        inventory.buyBook("002", 1, "user@example.com", "N/A");

        // Attempt buying ShowcaseBook
        try {
            inventory.buyBook("003", 1, "user@example.com", "N/A");
        } catch (RuntimeException e) {
            System.out.println("Quantum Bookstore: Error - " + e.getMessage());
        }

        // Remove outdated books (> 50 years)
        inventory.removeOutdatedBooks(50);
    }
}
