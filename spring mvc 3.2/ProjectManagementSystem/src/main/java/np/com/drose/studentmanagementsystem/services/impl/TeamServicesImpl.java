/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.TeamDAO;
import np.com.drose.studentmanagementsystem.model.Employee;
import np.com.drose.studentmanagementsystem.model.Team;
import np.com.drose.studentmanagementsystem.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */

@Service
@Transactional
public class TeamServicesImpl implements TeamServices{
    @Autowired
    TeamDAO teamDAO;

    @Override
    public int addTeam(Team team) {
          return teamDAO.addTeam(team);//To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<String> getTeamList() {
           return teamDAO.getTeamList();
    }

    @Override
    public List<Team> getTeam() {
       return teamDAO.getTeam();
    }

    @Override
    public List<Team> getTeamMemeber(String teamName) {
        return teamDAO.getTeamMember(teamName);
    }

  
    
    
    
    
}
