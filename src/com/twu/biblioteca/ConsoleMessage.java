package com.twu.biblioteca;

public class ConsoleMessage {
    public final String STARTING_ASK_TO_CONINUE = "Welcome! type 'menu' to continue >>";
    public final String OPTIONS__SHOW_AVAILIABLE_OPTIONS = "*** Here is options" +
            "\n1. View a list of book" +
            "\n2. View a list of book (include author and publication year)" +
            "\n3. Check out book" +
            "\n4. Return a book";
    public final String OPTIONS__ASK_FOR_A_OPTION = "Choose 1 to 4 or \'quit\': ";
    public final String OPTIONS__INCORRECT_OPTION_WARNING = "Sorry, it isn\'t correct option. please try again.";
    public final String OPTION_SHOW_LIST_OF_BOOK = "-- List of available books --" +
            "\n- Klara and the Sun" +
            "\n- Luster" +
            "\n- Aftershocks";
    public final String OPTION_SHOW_LIST_OF_BOOK__AFTER_CHECKOUT = "-- List of available books --" +
            "\n- Luster" +
            "\n- Aftershocks";
    public final String OPTION_SHOW_LIST_OF_BOOK_IN_DETAIL = "-- List of books in detail --" +
            "\n- Klara and the Sun (2017) by Kazuo Ishiguro - available" +
            "\n- Luster (2020) by Raven Leilani - available" +
            "\n- Aftershocks (2018) by Nadia Owusu - available";
    public final String OPTION_CHECKOUT__ASK_THE_NAME_OF_BOOK_TO_CHECKOUT = "name of book: ";
    public final String OPTION_CHECKOUT__SUCCESS_CHECKOUT_MES = "checkout successful!";
    public final String OPTION_CHECKOUT__UNSUCCESS_CHECKOUT_MES = "checkout unsuccessful! please re-type the book name.";
    public final String OPTION_RETURNBOOK__ASK_THE_NAME_OF_BOOK_TO_RETURN = "name of returning book: ";
    public final String OPTION_RETURNBOOK__SUCCESS_RETURN = "return a book successfully";
    public final String OPTION_RETURNBOOK__UNSUCCESS_RETURN = "The book name is not correct.";
    public final String ENDING__END_MES = "Thanks!";
}
