package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    public static ConsoleMessage userMessage;

    public static void main(String[] args) {




//        // 2nd round
//        userInput = in.nextLine();
//        System.out.print(userInput);
    }

    public static void getMainMenu() {
        userMessage = new ConsoleMessage();
        Scanner in = new Scanner(System.in);
        System.out.print(userMessage.WELCOME_MES);

        // wait use pass "enter" key
        String userInput = in.nextLine();

        // 1st round
        if (!userInput.toLowerCase().equals("menu")) {
            if (!userInput.equals("")){
                System.out.print(userMessage.ERROR_MES_REPEAT_USER_OPTION);
            }
        } else {
            System.out.print(userMessage.OPTIONS_MES);
        }
    }
}
