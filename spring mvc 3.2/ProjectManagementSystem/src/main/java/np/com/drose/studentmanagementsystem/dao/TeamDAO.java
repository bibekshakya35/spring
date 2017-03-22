/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao;

import java.util.List;
import java.util.Set;
import np.com.drose.studentmanagementsystem.model.Employee;
import np.com.drose.studentmanagementsystem.model.Team;

/**
 *
 * @author bibekshakya
 */
public interface TeamDAO {
    public int addTeam(Team team);
    public List<String> getTeamList();
    public List<Team> getTeam();
    public List<Team> getTeamMember(String teamName);
}
