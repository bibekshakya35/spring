/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.exception.config;

/**
 *
 * @author bibek
 */
public enum AppMessageType {
    USER_INVALID_CREDENTIAL("USER.INVALID.CREDENTIAL", "User are unable to found with given information", 401),
    SESSION_EXPIRED("SESSION.EXPIRED","Session has been expired, please login",401),
    PASSWORD_WONT_MATCH("PASSWORD.WONT.MATCH","password you have entered unable to match",401);
    
    private final String key;
    private final String message;
    private final int code;

    private AppMessageType(String key, String message, int code) {
        this.key = key;
        this.message = message;
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
