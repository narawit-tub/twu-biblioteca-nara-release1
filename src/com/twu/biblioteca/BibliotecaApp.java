package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Welcome! Press 'Enter' Key to continue.");

        // wait use pass "enter" key
        String tmp = in.nextLine();
        System.out.println(tmp);
        System.out.print("\n\t*** What do you want to do\n" +
                "\t1. View a list of book\n" +
                "\t2. Check out book\n" +
                "\t3. Return a book\n" +
                "\t4. Quit this app\n\n");

    }

    public void showIns(){

    }
}
