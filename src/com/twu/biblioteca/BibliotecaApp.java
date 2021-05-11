package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        ConsoleMessage userMessage = new ConsoleMessage();
        Scanner in = new Scanner(System.in);
        System.out.print(userMessage.WELCOME_MES);

        // wait use pass "enter" key
        String userInput = in.nextLine();
        if (userInput.toLowerCase().equals("menu")) {
            System.out.print(userMessage.OPTIONS_MES);
        }
    }
}
