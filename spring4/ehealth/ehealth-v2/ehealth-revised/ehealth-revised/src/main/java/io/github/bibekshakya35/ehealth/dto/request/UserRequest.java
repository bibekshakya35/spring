package io.github.bibekshakya35.ehealth.dto.request;

import java.io.Serializable;

/**
 *{Insert class description here}
 * @author bibek
 */
public class UserRequest implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
