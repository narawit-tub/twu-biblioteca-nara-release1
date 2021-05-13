package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    public void setUp() {
        userMessage = new ConsoleMessage();
        outputBytes = new ByteArrayOutputStream();
        outputConsole = System.out;
        inputConsole = System.in;
        System.setOut(new PrintStream(outputBytes));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Klara and the Sun", "Kazuo Ishiguro", "2017"));
        books.add(new Book("Luster", "Raven Leilani", "2020"));
        books.add(new Book("Aftershocks", "Nadia Owusu", "2018"));
        libary = new Libary(books);
    }

    @After
    public void tearDown() {
        System.setOut(outputConsole);
        System.setIn(inputConsole);
    }

    @Test
    public void UserSeesAWelcomeMessage() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append("\n" + userMessage.OPTIONS__INCORRECT_OPTION_WARNING + "\n").toString();
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
                .append("\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n").toString();
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
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append("\n" + userMessage.OPTIONS__INCORRECT_OPTION_WARNING + "\n").toString();
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
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append("\n" + userMessage.OPTIONS__INCORRECT_OPTION_WARNING + "\n")
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
    public void ViewAListOfBooks() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("1\n")
                .append("quit")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append("\n" + userMessage.OPTION_SHOW_LIST_OF_BOOK + "\n")
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
    public void ViewAListOfBooksInDetail() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("2\n")
                .append("quit")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE)
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION)
                .append("\n" + userMessage.OPTION_SHOW_LIST_OF_BOOK_IN_DETAIL + "\n")
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
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("3\n")
                .append("Klara and the Sun\n")
                .append("1\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE) // >> menu
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 3
                .append(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT) // >> Klara and the Sun
                .append(userMessage.OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES + "\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 1
                .append("\n" + userMessage.OPTION_SHOW_LIST_OF_BOOK__AFTER_CHECKOUT + "\n")
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
        assertEquals(Integer.valueOf(2), libary.getNumberOfAvailableBooks());
    }

    @Test
    public void invalidCheckoutBook() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("3\n")
                .append("Klara and the Sun (wrong name)\n")
                .append("1\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE) // >> menu
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 3
                .append(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT) // >> Klara and the Sun (wrong name)
                .append(userMessage.OPTION_CHECKOUT__UNSUCCESS_CHECKOUT_MES + "\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 1
                .append("\n" + userMessage.OPTION_SHOW_LIST_OF_BOOK + "\n")
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
        assertEquals(Integer.valueOf(3), libary.getNumberOfBooks());
    }

    @Test
    public void returnBook() {
        // Given
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("3\n")
                .append("Klara and the Sun\n")
                .append("4\n")
                .append("Klara and the Sun\n")
                .append("1\n")
                .append("quit\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.STARTING_ASK_TO_CONINUE) // >> menu
                .append("\n" + userMessage.OPTIONS__SHOW_AVAILIABLE_OPTIONS + "\n\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 3
                .append(userMessage.OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT) // >> Klara and the Sun
                .append(userMessage.OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES + "\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 4
                .append(userMessage.OPTION_RETURNBOOK__ASK_THE_NAME_OF_BOOK_TO_RETURN) // >> Klara and the Sun
                .append(userMessage.OPTION_RETURNBOOK__SUCCESS_RETURN + "\n")
                .append(userMessage.OPTIONS__ASK_FOR_A_OPTION) // >> 1
                .append("\n" + userMessage.OPTION_SHOW_LIST_OF_BOOK + "\n")
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
        assertEquals(Integer.valueOf(3), libary.getNumberOfBooks());
    }
}
