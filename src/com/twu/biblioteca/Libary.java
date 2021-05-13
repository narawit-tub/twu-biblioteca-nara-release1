package com.twu.biblioteca;

import java.util.ArrayList;

public class Libary {
    private ArrayList<Book> booksList;

    Libary(ArrayList books){
        this.booksList = books;
    }

    public Integer getNumberOfBooks() {
        return booksList.toArray().length;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public Book checkoutBook(String bookName) {
        Book checkedOutBook = null;

        for (Book book : booksList) {
            if (book.getBookName().equals(bookName)) {
                checkedOutBook = book;
                break;
            }
        }

        booksList.remove(checkedOutBook);
        return (checkedOutBook != null) ? checkedOutBook : null;
    }
}
