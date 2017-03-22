/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Employee;

/**
 *
 * @author bibekshakya
 */
public interface EmployeeDAO {

    public int insertEmployee(Employee employee);

    public List<Employee> getEmployeeList();

    public Employee getEmployeeByid(int id);

    
}
