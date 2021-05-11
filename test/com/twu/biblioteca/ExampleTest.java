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

    @Before
    public void setUp(){
        userMessage = new ConsoleMessage();
        outputBytes = new ByteArrayOutputStream();
        outputConsole = System.out;
        inputConsole = System.in;
        System.setOut(new PrintStream(outputBytes));
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
                .append(userMessage.WELCOME_MES).toString();
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
                .append(userMessage.WELCOME_MES)
                .append(userMessage.OPTIONS_MES).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
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
                .append(userMessage.WELCOME_MES)
                .append(userMessage.ERROR_MES_REPEAT_USER_OPTION).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
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
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.WELCOME_MES)
                .append(userMessage.OPTIONS_MES)
                .append(userMessage.ERROR_MES_REPEAT_USER_OPTION).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.chooseOption(in);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }

    @Test
    public void ViewAListOfBooks(){
        // Given
        Libary libary = new Libary();
        String userKeyboardInput = new StringBuilder()
                .append("menu\n")
                .append("1\n")
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.WELCOME_MES)
                .append(userMessage.OPTIONS_MES)
                .append(userMessage.SHOW_A_LIST_OF_BOOKS_MES).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.chooseOption(in);

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
                .toString();
        String expectedConsoleResult = new StringBuilder()
                .append(userMessage.WELCOME_MES)
                .append(userMessage.OPTIONS_MES)
                .append(userMessage.SHOW_A_LIST_OF_BOOKS_IN_DETAIL_MES).toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        Scanner in = new Scanner(System.in);
        BibliotecaApp.getMainMenu(in);
        BibliotecaApp.chooseOption(in);

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }
}
