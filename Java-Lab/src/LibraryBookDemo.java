final class LibraryBook {
    final String ISBN;
    String title;
    String author;
    double price;

    LibraryBook(String ISBN, String title, String author, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    final void displayBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(
            "978-0135166307",
            "Java Programming",
            "James Gosling",
            850
        );

        book.displayBook();

        // book.ISBN = "123456";
        // This will give an error because ISBN is final.
    }
}