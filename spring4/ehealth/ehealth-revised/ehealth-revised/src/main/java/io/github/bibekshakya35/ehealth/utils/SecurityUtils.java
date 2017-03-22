package io.github.bibekshakya35.ehealth.utils;

import com.google.common.hash.Hashing;
import io.github.bibekshakya35.ehealth.exception.EhealthException;
import io.github.bibekshakya35.ehealth.exception.config.AppMessageType;
import io.github.bibekshakya35.ehealth.security.APISecurityDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.logging.Logger;
import org.apache.commons.lang3.time.DateUtils;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
public class SecurityUtils {

    private static final Logger LOG = Logger.getLogger(SecurityUtils.class.getName());

    public static final int KEY_SIZE = 16;

    private SecurityUtils() {

    }

    public static String generateToken(APISecurityDetail aPISecurityDetail) {
        final int EXPIRE_AFTER_TWO_HOUR = 2;
        Claims claims = Jwts.claims().setSubject(aPISecurityDetail.getSubject());
        claims.putAll(aPISecurityDetail.getMap());
        return Jwts.builder().setClaims(claims)
                .setExpiration(DateUtils.addHours(new Date(), EXPIRE_AFTER_TWO_HOUR))
                .signWith(SignatureAlgorithm.HS256, aPISecurityDetail.getKey()).compact();
    }

    public static APISecurityDetail parseToken(String token, String key) {
        try {
            Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            APISecurityDetail securityDetail = new APISecurityDetail(body.getSubject(), key);
            for (String pKey : body.keySet()) {
                securityDetail.put(pKey, body.get(pKey));
            }
            return securityDetail;
        } catch (ExpiredJwtException e) {
            throw new EhealthException(AppMessageType.SESSION_EXPIRED);
        }
    }

    public static String encodeString(String plainText) {
        return Hashing.sha256().hashString(plainText, StandardCharsets.UTF_8).toString();
    }

    public static boolean isEqualEncoding(String encodedText, String plainText) {
        String encodedTextOfPlainText = encodeString(plainText);
        return encodedText.equals(encodedTextOfPlainText);
    }
}
