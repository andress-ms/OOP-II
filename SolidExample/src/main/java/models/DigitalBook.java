package models;

public class DigitalBook extends Book implements Downloadable {
    public DigitalBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void lend() {
        System.out.println("Digital access granted for '" + getTitle() + "' by " + getAuthor() + ".");
    }

    @Override
    public void download() {
        System.out.println("Downloading digital book: " + getTitle());
    }
}

