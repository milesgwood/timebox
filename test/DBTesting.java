/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DbHandler;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vice
 */
public class DBTesting {
    
    public DBTesting() {
    }
    
    static DbHandler db = null;
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        db = new DbHandler();
        db.open();
        assert(null != db);
        db.createTablesWithDefaultData();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
            
    }
    
    /* Simply checking and adding tasks / rewards **/
        @Test
    public void addTaskTest() throws SQLException 
    {
        String name = "NewTestTaskJunitTest2";
        db.addTask(name);
        assertTrue(db.hasTask(name));
    }
    
    @Test
    public void addandDeleteTaskTest() throws SQLException 
    {
        String name = "NewTestTaskJunitTest3";
        db.addTask(name);
        assertTrue(db.hasTask(name));
        db.deleteTask(name);
        assertFalse(db.hasTask(name));
    }
    
    @Test
    public void addRewardkTest() throws SQLException 
    {
        String name = "addRewardkTest1";
        db.addReward(name);
        assertTrue(db.hasReward(name));
    }
    
    @Test
    public void addAndDeleteRewardTest() throws SQLException 
    {
        String name = "addandDeleteRewardkTest";
        db.addReward(name);
        assertTrue(db.hasReward(name));
        db.deleteReward(name);
        assertFalse(db.hasReward(name));
    }
    
    @Test
    public void checkCategories() throws SQLException 
    {
        int size;
        size = db.getCategories().size();
        assert(size > 0);
    }
}
