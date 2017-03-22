/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.security;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 *
 * @author bibekshakya
 */
public class Sha3Utils {
    
    public static String hashPassword(String plainText) throws Exception{
        ShaPasswordEncoder shaPassword = new ShaPasswordEncoder();
        String encryption= shaPassword.encodePassword(plainText, null);
        return encryption;
    }
    
}
