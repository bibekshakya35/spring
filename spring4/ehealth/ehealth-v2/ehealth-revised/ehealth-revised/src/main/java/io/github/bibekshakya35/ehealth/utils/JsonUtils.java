/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 *
 * @author Bibek Shakya
 */
public class JsonUtils {

    public static <T> String getJson(T t) {
        Gson gson = new Gson();
        return gson.toJson(t);
    }

    public static <T> T getObject(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<T>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
