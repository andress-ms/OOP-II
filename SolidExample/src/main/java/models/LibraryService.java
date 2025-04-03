package models;

import interfaces.BookRepository;
import interfaces.Report;

public class LibraryService {
    private BookRepository repository;

    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.save(book);
        book.lend();
    }

    public void printReport(Book book, Report report) {
        report.generate(book);
    }
}

