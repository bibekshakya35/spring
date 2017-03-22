/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Role;

/**
 *
 * @author bibekshakya
 */
public interface RoleServices {
   public int insertRow(Role role);
   public List<Role> getRolesList();
   public Role getRole(int id);
}
