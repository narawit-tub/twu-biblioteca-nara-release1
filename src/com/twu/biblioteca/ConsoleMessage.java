package com.twu.biblioteca;

public class ConsoleMessage {
    public final String WELCOME_MES = "Welcome! type 'menu' to continue >>";
    public final String OPTIONS_MES = "\n*** Here is options" +
            "\n1. View a list of book" +
            "\n2. View a list of book (include author and publication year)" +
            "\n3. Check out book" +
            "\n4. Return a book\n\n";
    public final String GUIDE_PREFIX = "Choose 1 to 4 or \'quit\': ";
    public final String ERROR_MES_REPEAT_USER_OPTION = "\nSorry, it isn\'t correct option. please try again.\n";
    public final String SHOW_A_LIST_OF_BOOKS_MES = "\n-- List of books --" +
            "\n- Klara and the Sun" +
            "\n- Luster" +
            "\n- Aftershocks" +
            "\n";
    public final String SHOW_A_LIST_OF_BOOKS_IN_DETAIL_MES = "\n-- List of books in detail --" +
            "\n- Klara and the Sun (2017) - by Kazuo Ishiguro" +
            "\n- Luster (2020) - by Raven Leilani" +
            "\n- Aftershocks (2018) - by Nadia Owusu" +
            "\n";
    public final String THANK_USER_MES = "Thanks!";
}
