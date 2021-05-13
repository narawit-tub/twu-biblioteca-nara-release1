package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Klara and the Sun", "Kazuo Ishiguro", "2017"));
        books.add(new Book("Luster", "Raven Leilani", "2020"));
        books.add(new Book("Aftershocks", "Nadia Owusu", "2018"));
        Libary libary = new Libary(books);

        getMainMenu(in);
        processLibaryOperation(in, libary);
    }

    public static void getMainMenu(Scanner in) {
        ConsoleMessage userMessage = new ConsoleMessage();
        System.out.print(userMessage.STARTING_ASK_TO_CONINUE);
        String[] options = new String[] {"menu"};
        String userInput;

        while(true) {
            userInput = in.nextLine();
            if (userInput.equals("quit")) break;

            if (!Arrays.asList(options).contains(userInput)) {
                System.out.print("\n" + userMessage.OPTIONS__INCORRECT_OPTION_WARNING + "\n");
            } else {
                System.out.print("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n");
                break;
            }
        }

    }

    public static void processLibaryOperation(Scanner in, Libary libary){
        ConsoleMessage userMessage = new ConsoleMessage();

        String userInput;
        while (true){
            System.out.print(userMessage.OPTIONS__ASK_FOR_A_OPTION);
            userInput = in.nextLine();
            if (userInput.equals("quit")) {
                System.out.print(userMessage.ENDING__END_MES);
                break;
            }

            switch (userInput) {
                case "1":
                    System.out.print("\n-- List of available books --");
                    for (Book book: libary.getBooks()){
                        if (book.getAvailable()) System.out.print(String.format("\n- %s", book.getBookName()));
                    }
                    System.out.print("\n");
                    break;
                case "2":
                    System.out.print("\n-- List of books in detail --");
                    for (Book book: libary.getBooks()){
                        System.out.print(String.format("\n- %s", book.getInformationDetail()));
                    }
                    System.out.print("\n");
                    break;
                case "3":
                    System.out.print(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT);
                    userInput = in.nextLine();
                    Book checkedoutBook = libary.checkoutBook(userInput);
                    if (checkedoutBook != null) {
                        System.out.print(userMessage.OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES + "\n");
                    } else {
                        System.out.print(userMessage.OPTION_CHECKOUT__UNSUCCESS_CHECKOUT_MES + "\n");
                    }
                    break;
                case "4":
                    break;
                default:
                    System.out.print("\n" + userMessage.OPTIONS__INCORRECT_OPTION_WARNING + "\n");
                    break;
            }
        }

    }
}
