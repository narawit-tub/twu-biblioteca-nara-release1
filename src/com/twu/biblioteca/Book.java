package com.twu.biblioteca;

public class Book implements Comparable<Book>{

    private String author;
    private String pullicationYear;
    private String bookName;
    private Boolean isAvailable;

    public Book(String bookName, String author, String pullicationYear) {
        this.author = author;
        this.pullicationYear = pullicationYear;
        this.bookName = bookName;
        this.isAvailable = true;
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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getInformationDetail() {
        return String.format("%s (%s) by %s - %s", this.getBookName(), this.getPullicationYear(), this.getAuthor(), this.isAvailable ? "available" : "not available");
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
