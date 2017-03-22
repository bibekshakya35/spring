/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.UserDAO;
import np.com.drose.studentmanagementsystem.model.User;
import np.com.drose.studentmanagementsystem.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */
@Service
@Transactional
public class UserServicesImpl  implements UserServices{
    
    @Autowired
    UserDAO userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUsername(username);
    }
    
    
    
    
}
