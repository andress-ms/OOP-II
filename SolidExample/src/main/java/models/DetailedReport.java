package models;

import interfaces.Report;

public class DetailedReport implements Report {
    @Override
    public void generate(Book book){
        System.out.println("Detailed report: " + book.getTitle() + "by" + book.getAuthor());
    }
}
