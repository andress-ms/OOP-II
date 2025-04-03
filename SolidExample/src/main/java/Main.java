import models.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new PhysicalBook("The Hobbit", "J.R.R. Tolkien");
        Book book2 = new DigitalBook("Clean Architecture", "Robert C. Martin");

        BookRepository repo = new SQLBookRepository();
        LibraryService library = new LibraryService(repo);

        library.addBook(book1);
        library.addBook(book2);

        Report simple = new SimpleReport();
        Report detailed = new DetailedReport();

        library.printReport(book1, simple);
        library.printReport(book2, detailed);

        if (book2 instanceof Downloadable) {
            ((Downloadable) book2).download();
        }
    }
}
