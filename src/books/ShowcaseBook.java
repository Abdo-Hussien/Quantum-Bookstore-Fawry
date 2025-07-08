package books;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, author, year, price);
    }

    // iSavailable(){
    // }
    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        throw new RuntimeException("Showcase Book is not for sale.");
    }
}
