package com.twu.biblioteca;

import java.util.ArrayList;

public class Libary {
    private ArrayList<Book> books;

    Libary(ArrayList books){
        this.books = books;
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
