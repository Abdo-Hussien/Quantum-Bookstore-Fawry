import books.*;
import inventory.BookInventory;

// You can easily add a new book type for example, AudioBook by:

// Creating a class AudioBook that extends Book
// Implementing isAvailable() and buy() logic
public class QuantumBookstore {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();

        // books
        inventory.addBook(new PaperBook("B343f", "shakespeare", "hamoda", 2008, 30.0, 5));
        inventory.addBook(new EBook("fg354", "farming town", "Tarek Abdalah", 2016, 25.0, "PDF"));
        inventory.addBook(new ShowcaseBook("ffl23", "grimmer", "we2am", 1900, 0.0));

        // PaperBook
        inventory.buyBook("B343f", 2, "user@example.com", "el nozha, Cairo , st 123");

        // EBook
        inventory.buyBook("fg354", 1, "user@example.com", "None");

        // attempting to buy ShowcaseBook
        try {
            inventory.buyBook("ffl23", 1, "user@example.com", "none");
        } catch (RuntimeException e) {
            System.out.println("Error - " + e.getMessage());
        }

        // remove outdated books > 50 years
        inventory.removeOutdatedBooks(50);
    }
}
