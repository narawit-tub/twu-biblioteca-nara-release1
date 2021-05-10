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

    public final String WELCOME_MES = "Welcome! Press 'Enter' Key to continue.";
    public final String OPTIONS_MES = "\n\t*** What do you want to do\n" +
            "\t1. View a list of book\n" +
            "\t2. Check out book\n" +
            "\t3. Return a book\n" +
            "\t4. Quit this app\n\n";

    public ByteArrayOutputStream outputBytes;
    public PrintStream outputConsole;

    @Before
    public void setUp(){
        outputBytes = new ByteArrayOutputStream();
        outputConsole = System.out;
        System.setOut(new PrintStream(outputBytes));
    }

    @After
    public void tearDown(){
        System.setOut(outputConsole);
    }

    @Test
    public void UserSeesAWelcomeMessage() {
        // When
        BibliotecaApp.main(new String[] {});

        // Then
        // 1. "welcome" message in terminal
        // 2. show "press enter key to continue"
        assertEquals(WELCOME_MES, outputBytes.toString());
    }

    @Test
    public void PressEnterToViewMainMenuOfOptions() {
        // Given
        InputStream inputConsole = System.in;
        ByteArrayInputStream inputBytes = new ByteArrayInputStream("\n\n2".getBytes());
        System.setIn(inputBytes);

        // When
        BibliotecaApp.main(new String[] {});

        // Then
        assertEquals(String.format(WELCOME_MES + "\n" + OPTIONS_MES), outputBytes.toString());
    }
}
