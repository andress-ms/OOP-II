package models;

import interfaces.Report;

public class SimpleReport implements Report {
    @Override
    public void generate(Book book) {
        System.out.println("Simple Report: " + book.getTitle());
    }
}

