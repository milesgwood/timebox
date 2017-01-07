/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author vice
 */
public class Task {
    int id;
    String category = "default";
    String name;
    int score = 0;

    /**
     * For adding to the database
     * @param taskName 
     */
    Task(String taskName) {
        this.name = taskName;
    }
    
    Task(int id, int score, String category, String name)
    {
        this.id = id;
        this.score = score;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
