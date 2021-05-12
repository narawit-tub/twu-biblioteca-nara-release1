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
            "\n- Aftershocks" +
            "\n- Klara and the Sun" +
            "\n- Luster" +
            "\n";
    public final String OPTION_SHOW_LIST_OF_BOOK__AFTER_CHECKOUT = "\n-- List of books --" +
            "\n- Aftershocks" +
            "\n- Luster" +
            "\n";
    public final String OPTION_SHOW_LIST_OF_BOOK_IN_DETAIL = "\n-- List of books in detail --" +
            "\n- Aftershocks (2018) - by Nadia Owusu" +
            "\n- Klara and the Sun (2017) - by Kazuo Ishiguro" +
            "\n- Luster (2020) - by Raven Leilani" +
            "\n";
    public final String OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT = "\nname of book: ";
    public final String OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES = "\ncheckout successful!\n";
    public final String OPTION_CHECKOUT__UNSUCCESS_CHECKOUT_MES = "\ncheckout unsuccessful! please re-type the book name.\n";
    public final String OPTION_RETURNBOOK__ASK_THE_NAME_OF_BOOK_TO_RETURN = "\nname of returning book: ";
    public final String OPTION_RETURNBOOK__SUCCESS_RETURN = "\nreturn a book successfully\n";
    public final String ENDING__END_MES = "Thanks!";
}
