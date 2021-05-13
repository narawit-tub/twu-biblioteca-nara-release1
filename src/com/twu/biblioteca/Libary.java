package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Libary {
    private ArrayList<Book> books;

    Libary(ArrayList books){
        this.books = books;
    }

    public Integer getNumberOfBooks() {
        return books.toArray().length;
    }

    public Integer getNumberOfAvailableBooks() {
        return books.stream()
                .filter(book -> book.getAvailable())
                .collect(Collectors.toList())
                .toArray().length;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book checkoutBook(String bookName) {
        Book checkedOutBook = null;

        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                checkedOutBook = book;
                book.setAvailable(false);
                break;
            }
        }

        return (checkedOutBook != null) ? checkedOutBook : null;
    }
}
