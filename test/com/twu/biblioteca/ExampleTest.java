package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    public ByteArrayOutputStream outputBytes;
    public PrintStream outputConsole;
    public InputStream inputConsole;
    public ConsoleMessage userMessage;
    public Libary libary;
    public ByteArrayInputStream inputBytes;

    @Before
    public void setUp(){
        userMessage = new ConsoleMessage();
        outputBytes = new ByteArrayOutputStream();
        outputConsole = System.out;
        inputConsole = System.in;
        System.setOut(new PrintStream(outputBytes));
        libary = new Libary();
    }

    @After
    public void tearDown(){
        System.setOut(outputConsole);
        System.setIn(inputConsole);
    }

    @Test
    public void UserSeesAWelcomeMessage() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);

        // Then
        assertEquals(expectedConsoleResult, outputBytes.toString());
    }

    @Test
    public void KeyMenuToViewMainMenuOfOptions() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n") // enter to continue
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void DidNotKeyMenuToViewMainMenuOfOptions() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("somethingelsethatisn\'tmenu\n") // enter to continue
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append(userMessage.OPTIONS__INCORRECT_OPTION_WARNING).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void NotifiedWhenChoseInvalidOption() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("5\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append(userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.OPTIONS__INCORRECT_OPTION_WARNING)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.ENDING__END_MES).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.processLibaryOperation(in, libary);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void ViewAListOfBooks(){
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("1\n")
                .append("quit")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append(userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.OPTION_SHOW_LIST_OF_BOOK)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.ENDING__END_MES).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.processLibaryOperation(in, libary);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void ViewAListOfBooksInDetail(){
        // Given
        Libary libary = new Libary();
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("2\n")
                .append("quit")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append(userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.OPTION_SHOW_LIST_OF_BOOK_IN_DETAIL)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append(userMessage.ENDING__END_MES).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.processLibaryOperation(in, libary);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void checkoutBook() {
        // Given
        Libary libary = new Libary();
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("3\n")
                .append("Klara and the Sun\n")
                .append("1\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE) // >> menu
                .append(userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 3
                .append(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT) // >> Klara and the Sun
                .append(userMessage.OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 1
                .append(userMessage.OPTION_SHOW_LIST_OF_BOOK__AFTER_CHECKOUT)
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> quit
                .append(userMessage.ENDING__END_MES).toString();
        inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.processLibaryOperation(in, libary);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
        // there are 2 book left
        assertEquals (Integer.valueOf(2), libary.getNumberOfBooks());
    }
}
