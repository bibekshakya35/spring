/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.pojo;

/**
 *
 * @author bibekshakya
 */
public class Member {
    private String teamName;
    private String employeeName;
    private String roleEmployee;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRoleEmployee() {
        return roleEmployee;
    }

    public void setRoleEmployee(String roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public Member(String teamName, String employeeName, String roleEmployee) {
        this.teamName = teamName;
        this.employeeName = employeeName;
        this.roleEmployee = roleEmployee;
    }
    
    
}
