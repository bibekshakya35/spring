package io.github.bibekshakya35.ehealth.dto;

import com.google.gson.Gson;
import java.io.Serializable;

/**
 *
 * @author Bibek Shakya
 */
public class Response implements Serializable {

    private ResponseStatus status;

    private String message;

    private Object data;

    public enum ResponseStatus {
        OK(200),
        CREATED(201),
        ERROR(401);
        private final int code;

        private ResponseStatus(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }

    Response() {

    }

    private Response(ResponseStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Response(ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response ok(String messsage, Object data) {
        return new Response(ResponseStatus.OK, messsage, data);
    }

    public static Response ok(Object data) {
        return new Response(ResponseStatus.OK, "", new Gson().toJson(data));
    }

    public static Response ok() {
        return new Response(ResponseStatus.OK, "", "");
    }

    public static Response error(String message, String data) {
        return new Response(ResponseStatus.ERROR, message, data);
    }

    public static Response error(String message) {
        return new Response(ResponseStatus.ERROR, message);
    }

    public static Response error() {
        return new Response(ResponseStatus.ERROR, "", "");
    }

}
