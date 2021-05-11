package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {

    }

    public static void getMainMenu(Scanner in) {
        ConsoleMessage userMessage = new ConsoleMessage();
        System.out.print(userMessage.WELCOME_MES);

        String userInput = in.nextLine();
        if (!userInput.toLowerCase().equals("menu")) {
            if (!userInput.equals("")){
                System.out.print(userMessage.ERROR_MES_REPEAT_USER_OPTION);
            }
        } else {
            System.out.print(userMessage.OPTIONS_MES);
        }
    }

    public static void chooseOption(Scanner in){
        ConsoleMessage userMessage = new ConsoleMessage();
        int[] options = {1, 2, 3, 4};

        Integer userInput = Integer.parseInt(in.nextLine());
        if(Arrays.asList(options).contains(userInput)) {
           // do something
        } else {
            System.out.print(userMessage.ERROR_MES_REPEAT_USER_OPTION);
        }
    }
}
