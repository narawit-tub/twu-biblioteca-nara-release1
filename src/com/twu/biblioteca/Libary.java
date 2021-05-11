package com.twu.biblioteca;

import java.util.ArrayList;

public class Libary {
    private ArrayList<String> books;

    Libary(){
        books = new ArrayList<String>();

        books.add("Klara and the Sun by Kazuo Ishiguro");
        books.add("Luster by Raven Leilani");
        books.add("Aftershocks by Nadia Owusu");
    }

    public String showAListOfBooks () {
        StringBuilder messageBuilder = new StringBuilder().append("-- List of books --");

        for (String book: books){
            messageBuilder
                    .append("\n" + (books.indexOf(book) + 1) + ". ")
                    .append(book);
        }
        return messageBuilder.toString();
    }
}
