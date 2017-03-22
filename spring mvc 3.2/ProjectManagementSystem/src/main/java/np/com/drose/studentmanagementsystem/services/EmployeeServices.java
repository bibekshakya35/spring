/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Employee;

/**
 *
 * @author bibekshakya
 */
public interface EmployeeServices {

    public int addEmployee(Employee employee);

    public List<Employee> getEmployeeList();

    public Employee getEmpById(int id);
}
