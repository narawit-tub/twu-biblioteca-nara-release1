package com.twu.biblioteca;

public class Book {


    private String author;
    private String pullicationYear;
    private String bookName;


    public Book(String bookName, String author, String pullicationYear) {
        this.author = author;
        this.pullicationYear = pullicationYear;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPullicationYear() {
        return pullicationYear;
    }

    public String getBookName() {
        return bookName;
    }

    public String getInformationDetail() {
        return String.format("%s (%s) - by %s", this.getBookName(), this.getPullicationYear(), this.getAuthor());
    }
}
