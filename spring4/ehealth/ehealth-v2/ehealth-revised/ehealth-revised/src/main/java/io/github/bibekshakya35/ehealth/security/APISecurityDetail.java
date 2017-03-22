package io.github.bibekshakya35.ehealth.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
public class APISecurityDetail {

    public static final String AUTH_SECURITY_TOKEN_HEADER = "AUTH-SECURITY-TOKEN";
    public static final String CLIENT_ID = "CLIENT-ID";

    private String subject;
    private String key;
    private Map<String, Object> map;

    public APISecurityDetail(String subject, String key) {
        this.map = new HashMap<>();
        this.subject = subject;
        this.key = key;
    }

    public String getSubject() {
        return subject;
    }

    public String getKey() {
        return key;
    }

    public Map<String, Object> getMap() {
        return Collections.unmodifiableMap(map);
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }
}
