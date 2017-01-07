/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DbHandler;
import db.Task;
import java.util.ArrayList;

/**
 *
 * @author vice
 */
public class TaskList {
    DbHandler db = new DbHandler();
    ArrayList<Task>tasks = db.getAllTasks();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    
    
}
