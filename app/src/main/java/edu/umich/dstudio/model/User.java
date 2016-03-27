package edu.umich.dstudio.model;

import java.util.Date;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class User {
    String username;
    String email;
    String createdTime;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.createdTime = new Date().toString();
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String deriveFirstName() {
        return User.deriveFirstName(this.username);
    }

    public static String deriveFirstName(String displayName) {
        if(displayName!=null) {
            return displayName.split(" ")[0];
        } else {
            return "";
        }
    }
}
