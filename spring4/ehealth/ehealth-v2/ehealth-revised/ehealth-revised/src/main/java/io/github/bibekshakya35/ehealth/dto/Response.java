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
        ERROR(401);
        private final int code;

        private ResponseStatus(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public int getCode() {
        return status.getCode();
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    Response() {
    }

    private Response(ResponseStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Response okWithMessage(String message) {
        return new Response(ResponseStatus.OK, message, "");
    }

    public static Response okWithDataAndMessage(String message, Object data) {
        return new Response(ResponseStatus.OK, message, new Gson().toJson(data));
    }

    public static Response okWithData(Object data) {
        return new Response(ResponseStatus.OK, "", new Gson().toJson(data));
    }

    public static Response ok() {
        return new Response(ResponseStatus.OK, "", "");
    }

    public static Response error(String message, Object data) {
        return new Response(ResponseStatus.ERROR, message, new Gson().toJson(data));
    }

    public static Response error(String message) {
        return new Response(ResponseStatus.ERROR, message, "");
    }
}
