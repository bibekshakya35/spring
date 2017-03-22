/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Project;

/**
 *
 * @author bibekshakya
 */
public interface ProjectServices {
    public int addProject(Project project);
    public List<Project> getProjectList();
    public Project getProjectById(int id);
    public int updateRow(Project project);

}
