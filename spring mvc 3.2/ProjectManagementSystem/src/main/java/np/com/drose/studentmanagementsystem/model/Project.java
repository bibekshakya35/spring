/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bibekshakya
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_project")
public class Project implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id",nullable = false)
    private Integer projectId;
    
    @Column(name = "project_name")
    @NotEmpty
    private String projectName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "project_resource")
    public Resource projectResource;
    
    public enum Resource{
        EJB,SPRING,STRUT,PHP,OTHERS;
        public static String getResourceName(Resource res){
            switch(res){
                case EJB:
                    return "EJB";
                case SPRING:
                    return "SPRING";
                case STRUT:
                    return "STRUT";
                case PHP:
                    return "PHP";
                case OTHERS:
                    return  "OTHERS";
                default:
                    return null;
            }
        }
    }
    
    @Column(name = "project_starting_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String projectStartingDate;
    
    @Column(name = "project_ending_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String projectEndingDate;
    

    @NotNull
    @Column(name = "team_name")
    private String teamName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    public ProjectStatus projectStatus;
    
    public enum ProjectStatus{
        PLANNED,STARTED,FINISHED;
        public static String getProjectStatus(ProjectStatus status){
            switch(status){
                case PLANNED:
                    return "PLANNED";
                case STARTED:
                    return "STARTED";
                case FINISHED:
                    return "FINISHED";
                default:
                    return null;
            }
        }
    }
    @Column(name = "project_requirement_file")
    private String projectRequirementFile; 

    @OneToOne
    @JoinColumn(name = "progress_id")
    private Progress progress;
   
  
    
    public Project() {
    }
    
    

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Resource getProjectResource() {
        return projectResource;
    }

    public void setProjectResource(Resource projectResource) {
        this.projectResource = projectResource;
    }

    public String getProjectStartingDate() {
        return projectStartingDate;
    }

    public void setProjectStartingDate(String projectStartingDate) {
        this.projectStartingDate = projectStartingDate;
    }

    public String getProjectEndingDate() {
        return projectEndingDate;
    }

    public void setProjectEndingDate(String projectEndingDate) {
        this.projectEndingDate = projectEndingDate;
    }

    

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    


    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectRequirementFile() {
        return projectRequirementFile;
    }

    public void setProjectRequirementFile(String projectRequirementFile) {
        this.projectRequirementFile = projectRequirementFile;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
    
        
   
    
    
    
}
