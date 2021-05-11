package com.twu.biblioteca;

import java.util.ArrayList;

public class Libary {
    private ArrayList<Book> books;

//    public final String SHOW_A_LIST_OF_BOOKS_IN_DETAIL_MES = "-- List of books in detail--" +
//            "\n1. Klara and the Sun (2017) - by Kazuo Ishiguro" +
//            "\n2. Luster (2020) - by Raven Leilani" +
//            "\n3. Aftershocks (2018) - by Nadia Owusu";

    Libary(){
        books = new ArrayList<Book>();

        books.add(new Book("Klara and the Sun", "Kazuo Ishiguro", "2017"));
        books.add(new Book("Luster", "Raven Leilani", "2020"));
        books.add(new Book("Aftershocks", "Nadia Owusu", "2018"));
    }

    public String showAListOfBooks () {
        StringBuilder messageBuilder = new StringBuilder().append("-- List of books --");

        for (Book book: books){
            messageBuilder
                    .append(String.format("\n%d. %s", books.indexOf(book) + 1, book.getBookName()));
        }
        messageBuilder.append("\n");
        return messageBuilder.toString();
    }

    public String showAListOfBooksInDetail () {
        StringBuilder messageBuilder = new StringBuilder().append("-- List of books in detail --");

        for (Book book: books){
            messageBuilder
                    .append(String.format("\n%d. %s (%s) - by %s", books.indexOf(book) + 1, book.getBookName(), book.getPullicationYear(), book.getAuthor()));
        }
        messageBuilder.append("\n");
        return messageBuilder.toString();
    }
}
