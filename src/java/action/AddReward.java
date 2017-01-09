/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import db.DbHandler;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author vice
 */
public class AddReward extends ActionSupport  {
    private String name;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() throws Exception {
        DbHandler db = new DbHandler();
        System.out.println("Adding Reward " + name);
        db.addReward(name);
        inputStream = new ByteArrayInputStream(name.getBytes("UTF-8"));
        return SUCCESS;
    }
}
