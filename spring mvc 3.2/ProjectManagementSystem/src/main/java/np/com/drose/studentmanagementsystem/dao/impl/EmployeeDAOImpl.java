/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.EmployeeDAO;
import np.com.drose.studentmanagementsystem.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bibekshakya
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    SessionFactory sessionfactory;

    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }
    
    
    @Override
    @Transactional
    public int insertEmployee(Employee employee) {
        Session session =sessionfactory.openSession();
        Transaction tx =session.beginTransaction();
        session.saveOrUpdate(employee);
        tx.commit();
        Serializable id= session.getIdentifier(employee);
        session.close();
        return (Integer)id;
    }

    @Transactional
    @Override
    public List<Employee> getEmployeeList() {
        Session session =sessionfactory.openSession();
        Transaction tx =session.beginTransaction();
        List<Employee> employeeList = session.createCriteria(Employee.class).list();
        tx.commit();
        session.close();
        return employeeList;
                
    }
    @Transactional
    @Override
    public Employee getEmployeeByid(int id) {
        Session session =sessionfactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee =(Employee)session.get(Employee.class,id);
        tx.commit();
        session.close();
        return employee;
    }
    
    
    
}
