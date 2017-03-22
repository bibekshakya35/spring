/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Role;

/**
 *
 * @author bibekshakya
 */
public interface RoleDAO {
    public int insertRow(Role role);
    public List<Role> getRoleList();
    public Role getRole(int id);
}
