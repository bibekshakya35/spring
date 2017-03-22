/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services;

import np.com.drose.studentmanagementsystem.model.User;

/**
 *
 * @author bibekshakya
 */
public interface UserServices {
    public int insertUser(User user);
    public User findByUserName(String username);
    
}
