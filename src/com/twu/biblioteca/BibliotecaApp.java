package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        getMainMenu(in);
        chooseOption(in);
    }

    public static void getMainMenu(Scanner in) {
        ConsoleMessage userMessage = new ConsoleMessage();
        System.out.print(userMessage.STARTING_ASK_TO_CONINUE);

        String userInput = in.nextLine();
        if (!userInput.toLowerCase().equals("menu")) {
            if (!userInput.equals("")){
                System.out.print(userMessage.OPTIONS__INCORRECT_OPTION_WARNING);
            }
        }
    }

    public static void chooseOption(Scanner in){
        ConsoleMessage userMessage = new ConsoleMessage();
        String[] options = new String[] {"1", "2", "3", "4"};
        Libary libary = new Libary();


        System.out.print(userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS);
        String userInput = "";
        while (!userInput.equals("quit")){
            System.out.print(userMessage.OPTIONS__ASK_FOR_A_OPTION);
            userInput = in.nextLine();
            if (userInput.equals("quit")) {
                System.out.print(userMessage.ENDING__END_MES);
            } else if(Arrays.asList(options).contains(userInput)) {
                switch (userInput) {
                    case "1":
                        System.out.print(libary.showAListOfBooks());
                        break;
                    case "2":
                        System.out.print(libary.showAListOfBooksInDetail());
                        break;
                    case "3":
                        System.out.print(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT);
                        userInput = in.nextLine();
                        Book checkedoutBook = libary.checkoutBook(userInput);
                        if (checkedoutBook != null) {
                            System.out.print(userMessage.OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES);
                        } else {
                            System.out.print(userMessage.OPTION_CHECKOUT__UNSUCCESS_CHECKOUT_MES);
                        }
                    default:
                        break;
                }
            } else {
                System.out.print(userMessage.OPTIONS__INCORRECT_OPTION_WARNING);
            }
        }

    }
}
