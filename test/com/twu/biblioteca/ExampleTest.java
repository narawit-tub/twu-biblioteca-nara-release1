package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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

        ByteArrayInputStream inputBytes;
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
                .append(userMessage.WELCOME_MES + "\n").toString();
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(userKeyboardInput.getBytes());
        System.setIn(inputBytes);

        // When
        BibliotecaApp.main(new String[] {});

        // Then
        assertEquals(userMessage.WELCOME_MES, outputBytes.toString());
    }

    @Test
    public void PressEnterToViewMainMenuOfOptions() {
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
        BibliotecaApp.main(new String[] {});

        // Then
        assertEquals(String.format(expectedConsoleResult), outputBytes.toString());
    }
        InputStream inputConsole = System.in;
        ByteArrayInputStream inputBytes = new ByteArrayInputStream("\n\n2".getBytes());
        System.setIn(inputBytes);

        // When
        BibliotecaApp.main(new String[] {});

        // Then
        assertEquals(String.format(WELCOME_MES + "\n" + OPTIONS_MES), outputBytes.toString());
    }
}
