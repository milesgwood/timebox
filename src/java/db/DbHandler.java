/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NoInitialContextException;

/**
 *
 * @author vice
 */
public class DbHandler {

    //Database access credentials if needed
    protected String driverName = null, url = null, userId = null, password = null;
    
    //Connection and entities
    Connection c;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    boolean isOpen = false;
    
    /**
     * Constructor that gets the needed info from the application context
     * Info is stored in the web.xml AND in the exception below for if I'm testing.
     */
    public DbHandler() {
    try {
            Context envCtx = (Context) (new InitialContext()).lookup("java:comp/env");
            driverName = (String) envCtx.lookup("DriverClassName");
            url = (String) envCtx.lookup("Url");
            userId = (String) envCtx.lookup("UserId");
            password = (String) envCtx.lookup("Password");
            
            //This catch is for Testing JUnit tests. Where no server context is setup.
        } catch (NoInitialContextException contextError) {
            driverName = "org.sqlite.JDBC";
            url = "jdbc:sqlite:/home/vice/NetBeansProjects/TimeBoxer/timeBoxerDB.sqlite";
            userId = "defaultNoContextUsername";
            password = "defaultNoContextPassword";
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the DB connection
     *
     * @throws SQLException if the DB connection cannot be established
     */
    public void open() throws SQLException {
        try {
            Class.forName(driverName);
            c = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        isOpen = true;
    }

    /**
     * Test to see if the database exists in the location specified.
     * @param args 
     */
    public static void main(String[] args) {

        DbHandler db = new DbHandler();
        try {
            db.createTablesWithDefaultData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("Success!!!\n");

    }

    /**
     * Close the DB connection.
     *
     * @throws SQLException if the DB connection close fails
     */
    public void close() throws SQLException {
        stmt.close();
        c.close();
        isOpen = false;
    }

    public void addTask(Task t) throws SQLException {
        if (!isOpen) {
            open();
        }
        //INSERT INTO tasks(name, cat) VALUES ("Prototype timeboxer", 1);
        sql = "INSERT INTO tasks(name, cat) VALUES (?)";
        stmt = c.prepareStatement(sql);
        stmt.setString(1, t.name);
        stmt.executeUpdate();
    }
    
    public void addTask(String name) throws SQLException {
        if (!isOpen) {
            open();
        }
        //INSERT INTO tasks(name, cat) VALUES ("Prototype timeboxer", 1);
        sql = "INSERT INTO tasks(name, cat) VALUES (?)";
        stmt = c.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.executeUpdate();
    }
    
    public void addReward(String name) throws SQLException {
        if (!isOpen) {
            open();
        }
        //INSERT INTO tasks(name, cat) VALUES ("Prototype timeboxer", 1);
        sql = "INSERT INTO rewards(name) VALUES (?)";
        stmt = c.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.executeUpdate();
    }
    
    /**
     * Get all of the tasks that are not yet completed in a list of Task
     * objects.
     *
     * @return task list includes id, name, category, and score
     */
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        int id;
        String name;
        String category;
        int score;

        try {
            if (!isOpen) {
                open();
            }
            sql = "SELECT tasks.id, name, c_name, score FROM tasks JOIN category ON cat == category.id;";
            stmt = c.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                score = rs.getInt("score");
                category = rs.getString("c_name");
                tasks.add(new Task(id, score, category, name));
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tasks;
    }

    /**
     * Creates the tables with default data. The location of the database needs
     * to be set before deployment.
     */
    public void createTablesWithDefaultData() throws SQLException {
        if (!isOpen) {
            open();
        }
        sql = "CREATE TABLE IF NOT EXISTS rewards (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, cat INTEGER  DEFAULT 1, score INTEGER DEFAULT 0 );";
        stmt = c.prepareStatement(sql);
        stmt.execute();
        sql = "CREATE TABLE IF NOT EXISTS category ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, c_name TEXT NOT NULL);";
        stmt = c.prepareStatement(sql);
        stmt.execute();
        sql = "CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, cat INTEGER  DEFAULT 1, score INTEGER DEFAULT 0 );";
        stmt = c.prepareStatement(sql);
        stmt.execute();
        sql = "INSERT INTO category (c_name) VALUES ('no category');";
        stmt = c.prepareStatement(sql);
        stmt.execute();
    }

    /**
     * Gets all of the reward objects from the dataase.
     * @return 
     */
    public ArrayList<Reward> getAllRewards() {
        ArrayList<Reward> rewards = new ArrayList<Reward>();
        int id;
        String name;
        String category;
        int score;

        try {
            if (!isOpen) {
                open();
            }
            sql = "SELECT rewards.id, name, c_name, score FROM rewards JOIN category ON cat == category.id;";
            stmt = c.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                score = rs.getInt("score");
                category = rs.getString("c_name");
                rewards.add(new Reward(id, score, category, name));
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rewards;
    }
}
