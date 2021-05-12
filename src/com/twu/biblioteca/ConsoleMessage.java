package com.twu.biblioteca;

public class ConsoleMessage {
    public final String STARTING_ASK_TO_CONINUE = "Welcome! type 'menu' to continue >>";
    public final String OPTIONS__SHOW_AVAILIABLE_OPTIONS = "\n*** Here is options" +
            "\n1. View a list of book" +
            "\n2. View a list of book (include author and publication year)" +
            "\n3. Check out book" +
            "\n4. Return a book\n\n";
    public final String OPTIONS__ASK_FOR_A_OPTION = "Choose 1 to 4 or \'quit\': ";
    public final String OPTIONS__INCORRECT_OPTION_WARNING = "\nSorry, it isn\'t correct option. please try again.\n";
    public final String OPTION_SHOW_LIST_OF_BOOK = "\n-- List of books --" +
            "\n- Klara and the Sun" +
            "\n- Luster" +
            "\n- Aftershocks" +
            "\n";
    public final String OPTION_SHOW_LIST_OF_BOOK_IN_DETAIL = "\n-- List of books in detail --" +
            "\n- Klara and the Sun (2017) - by Kazuo Ishiguro" +
            "\n- Luster (2020) - by Raven Leilani" +
            "\n- Aftershocks (2018) - by Nadia Owusu" +
            "\n";
    public final String OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT = "name of book: ";
}
