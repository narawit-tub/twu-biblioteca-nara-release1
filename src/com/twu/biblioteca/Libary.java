package com.twu.biblioteca;

import java.util.ArrayList;

public class Libary {
    private ArrayList<Book> books;

    Libary(){
        books = new ArrayList<Book>();

        books.add(new Book("Klara and the Sun", "Kazuo Ishiguro", "2017"));
        books.add(new Book("Luster", "Raven Leilani", "2020"));
        books.add(new Book("Aftershocks", "Nadia Owusu", "2018"));
    }

    public Integer getNumberOfBooks() {
        return books.toArray().length;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book checkoutBook(String bookName) {
        Book checkedOutBook = null;

        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                checkedOutBook = book;
                break;
            }
        }

        books.remove(checkedOutBook);
        return (checkedOutBook != null) ? checkedOutBook : null;
    }
}
