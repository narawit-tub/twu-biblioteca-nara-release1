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
        System.out.print(userMessage.WELCOME_MES);

        String userInput = in.nextLine();
        if (!userInput.toLowerCase().equals("menu")) {
            if (!userInput.equals("")){
                System.out.print(userMessage.ERROR_MES_REPEAT_USER_OPTION);
            }
        }
    }

    public static void chooseOption(Scanner in){
        ConsoleMessage userMessage = new ConsoleMessage();
        String[] options = new String[] {"1", "2", "3", "4"};
        Libary libary = new Libary();


        System.out.print(userMessage.OPTIONS_MES);
        String userInput = "";
        while (!userInput.equals("quit")){
            System.out.print(userMessage.GUIDE_PREFIX);
            userInput = in.nextLine();
            if (userInput.equals("quit")) {
                System.out.print(userMessage.THANK_USER_MES);
            } else if(Arrays.asList(options).contains(userInput)) {
                switch (userInput) {
                    case "1":
                        System.out.print(libary.showAListOfBooks());
                        break;
                    case "2":
                        System.out.print(libary.showAListOfBooksInDetail());
                        break;
                    default:
                        break;
                }
            } else {
                System.out.print(userMessage.ERROR_MES_REPEAT_USER_OPTION);
            }
        }

    }
}
