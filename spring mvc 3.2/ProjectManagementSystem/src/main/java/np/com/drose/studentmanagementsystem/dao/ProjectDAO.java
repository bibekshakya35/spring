/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Project;

/**
 *
 * @author bibekshakya
 */

public interface ProjectDAO {
   public int insertProject(Project project);
   public List<Project> getProjectList();
   public Project getProjectById(int id);
   public int updateRow(Project project);
   

  
}
