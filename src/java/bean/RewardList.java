/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DbHandler;
import db.Reward;
import java.util.ArrayList;

/**
 *
 * @author vice
 */
public class RewardList {
    DbHandler db = new DbHandler();
    ArrayList<Reward> rewards= db.getAllRewards();

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    } 
}
