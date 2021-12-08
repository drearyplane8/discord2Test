package com.example.discord2test;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class HelperFunctions {

    public static String GetDatabaseVersion(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        return String.format("JDBC version %d.%d\n", metaData.getJDBCMajorVersion(), metaData.getJDBCMinorVersion());
    }

    //this is purely a debug function now so we can just run it with false.
    public static void PrintMessageTableNicely(MessagesTable table){
        for(MessagesRow row : table.getRows()){
            PrintMessageNicely(row, false);
        }
    }

    /***
     *
     * @param row the message row to print nicely
     * @param authormsg a boolean value to say whether this message should be displayed as an author message or not
     */
    public static void PrintMessageNicely(MessagesRow row, boolean authormsg) {

        final Attribute nameColour = authormsg ? Attribute.RED_TEXT() : Attribute.BLUE_TEXT();
        final Attribute DATE_GREY = Attribute.TEXT_COLOR(128, 128, 128);

        System.out.printf("%s: %s    | %s\n", Ansi.colorize(row.Author, nameColour), row.Text, Ansi.colorize(row.TimeSent.toString(), DATE_GREY));
    }

    public static String StatementToNiceString(String SQL, Statement statement) throws SQLException {
        return new MessagesTable(statement.executeQuery(SQL)).toNiceString();
    }

    /***
     *
     * @param statement the SQL statement object to work with
     * @return the number of rows in the messages table
     * @throws SQLException because intellij made me
     */
    public static int GetMessageCount(Statement statement) throws SQLException {
        ResultSet CountRS = statement.executeQuery("SELECT count(*) FROM messages"); //get the amount of messages
        CountRS.first();                     //since result is returned as a 1x1 table, look at the first and only row
        return CountRS.getInt(1); //and the first and only column

    }

    public static boolean isValidInteger(String numberString){
        //let's use a regex, its more performance efficient than using Integer.ParseInt
        //regex found online, only matches integers, which is the desired behaviour.

        //^: only at the start of the string
        //[+-] : only the '+' and '-' characters
        //? : matches only once?
        // \\d : digits
        // +: match as many digits as possible
        // $ : only find digits at the end

        Pattern pattern = Pattern.compile("^[-+]?\\d+$");
        return pattern.matcher(numberString).find();
    }

    public static LocalDate nextDay(LocalDate date){
        return date.withDayOfMonth(date.getDayOfMonth() + 1);
    }


}
