/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DbHandler;
import java.util.ArrayList;

/**
 *
 * @author vice
 */
public class CategoryList {
    DbHandler db = new DbHandler();
    ArrayList<String> categories = db.getCategories();
    ArrayList<String> taskCategories = new ArrayList<String>();
    ArrayList<String> rewardCategories = new ArrayList<String>();

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getTaskCategories() {
        for(String s: categories)
        {
            taskCategories.add(s);
            if(s.equalsIgnoreCase("Show All Tasks")) break;
        }
        return taskCategories;
    }

    public void setTaskCategories(ArrayList<String> taskCategories) {
        this.taskCategories = taskCategories;
    }

    public ArrayList<String> getRewardCategories() {
        boolean rewardsStarted = false;
        for(String s: categories)
        {
            if(s.equals("Material Love")) rewardsStarted = true;
            if(!rewardsStarted) continue;
            rewardCategories.add(s);
        }
        return rewardCategories;
    }

    public void setRewardCategories(ArrayList<String> rewardCategories) {
        this.rewardCategories = rewardCategories;
    }
    
}
