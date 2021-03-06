package com.example.discord2test;


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
