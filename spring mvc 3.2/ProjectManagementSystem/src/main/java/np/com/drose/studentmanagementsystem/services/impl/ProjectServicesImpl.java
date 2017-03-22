/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.ProjectDAO;
import np.com.drose.studentmanagementsystem.model.Project;
import np.com.drose.studentmanagementsystem.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */
@Service
@Transactional
public class ProjectServicesImpl implements ProjectServices{
    @Autowired
    ProjectDAO projectDAO;

    @Override
    public int addProject(Project project) {
        return projectDAO.insertProject(project);
    }

    @Override
    public List<Project> getProjectList() {
        return projectDAO.getProjectList();
    }

    @Override
    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public int updateRow(Project project) {
        return projectDAO.updateRow(project);
    }


    
    
    
    
    
}
