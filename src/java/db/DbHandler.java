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

/**
 *
 * @author vice
 */
public class DbHandler {

    Connection c;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    boolean isOpen = false;

    /**
     * Open the DB connection
     *
     * @throws SQLException if the DB connection cannot be established
     */
    public void open() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:dbIsInApacheBinFolder.sqlite");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        isOpen = true;
    }

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
}
