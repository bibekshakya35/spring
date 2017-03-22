/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.EmployeeDAO;
import np.com.drose.studentmanagementsystem.model.Employee;
import np.com.drose.studentmanagementsystem.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */
@Service
@Transactional
public class EmployeeServicesImpl implements EmployeeServices{
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public int addEmployee(Employee employee) {
       return employeeDAO.insertEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeDAO.getEmployeeList();
    }

    @Override
    public Employee getEmpById(int id) {
        return employeeDAO.getEmployeeByid(id);
    }
    
    
    
    
    
    
}
