/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bibekshakya
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_employee")
public class Employee implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    
    @Column(name = "employee_name")
    private String employeeName;
    
  
    @Column(name = "employee_dob")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String employeeDOB;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_gender")
    public Gender gender;
    
    public enum Gender{
        MALE,FEMALE;
        public static String getGenderName(Gender gen){
            switch(gen){
                case MALE:
                    return "MALE";
                case FEMALE:
                    return "FEMALE";
                default:
                    return null;
            }
        }
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_role")
    public Role roleEmployee;

    public enum Role{
        DEVELOPER,QA,DESIGNER,SYSTEMANALYST,SYSTEMTESTING;
        public static String getRoles(Role role){
            switch(role){
                case DEVELOPER:
                    return "DEVELOPER";
                case QA:
                    return "QA";
                case DESIGNER:
                    return "DESIGNER";
                case SYSTEMANALYST:
                    return "SYSTEMANALYST";
                case SYSTEMTESTING:
                    return "SYSTEMTESTING";
                default:
                    return null;
            }
        }
    }
    
    
    @Column(name = "employee_address")
    private String employeeAddress;
    
    @Column(name = "employee_email_id") 
    private String email;
    
 
    @Column(name = "employee_mobile_number")
    private String mobileNumber;
    
    @Transient
    private String teamName;
    

    public Employee() {
    }
       
   
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(String employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    
    
    public Role getRoleEmployee() {
        return roleEmployee;
    }

    public void setRoleEmployee(Role roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    
}

