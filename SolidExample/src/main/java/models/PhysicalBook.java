package models;

import interfaces.Lendable;

public class PhysicalBook extends Book {
    public PhysicalBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void lend() {
        System.out.println("Physical book '" + getTitle() + "' by " + getAuthor() + " has been lent.");
    }
}

