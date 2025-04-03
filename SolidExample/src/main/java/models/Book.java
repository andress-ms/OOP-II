package models;

import interfaces.Downloadable;
import interfaces.Lendable;

public abstract class Book{
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract void lend();
}

