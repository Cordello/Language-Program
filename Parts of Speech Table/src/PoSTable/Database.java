/*
 * This class serves solely to insert items into the SQL database.
 * To run this code, you need to use NetBeans IDE and have access to a SQL database
 * Database user and pass are 'scott'
 */
package PoSTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andrew Ren
 */
public class Database 
{
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/Parts of Speech Database";
    
    public Database()
    {
        
    }
    
    public static void insertIntoPOSDB(String word, String pos)
    {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "scott", "scott"))
        {
            final PreparedStatement INSERT_STATEMENT = connection.prepareStatement("INSERT INTO partsofspeech VALUES (?, ?)");
            INSERT_STATEMENT.setString(1, word);
            INSERT_STATEMENT.setString(2, pos);
            INSERT_STATEMENT.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }    
    }
    
    public static void insertIntoNounsDB(String noun, String plural, boolean countable, String possessive)
    {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "scott", "scott"))
        {
            final PreparedStatement INSERT_STATEMENT = connection.prepareStatement("INSERT INTO nouns VALUES (?, ?, ?, ?)");
            INSERT_STATEMENT.setString(1, noun);
            INSERT_STATEMENT.setString(2, plural);
            INSERT_STATEMENT.setBoolean(3, countable);
            INSERT_STATEMENT.setString(4, possessive);
            INSERT_STATEMENT.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }   
    }
    
    public static void insertIntoVerbsDB(String infinitive, String past, String pp, boolean isTransitive, String third)
    {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "scott", "scott"))
        {
            final PreparedStatement INSERT_STATEMENT = connection.prepareStatement("INSERT INTO verbs VALUES (?, ?, ?, ?, ?)");
            INSERT_STATEMENT.setString(1, infinitive);
            INSERT_STATEMENT.setString(2, past);
            INSERT_STATEMENT.setString(3, pp);
            INSERT_STATEMENT.setBoolean(4, isTransitive);
            INSERT_STATEMENT.setString(5, third);
            INSERT_STATEMENT.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }   
    }
}
