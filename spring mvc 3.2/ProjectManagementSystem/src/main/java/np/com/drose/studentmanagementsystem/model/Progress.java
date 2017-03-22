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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bibekshakya
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_progress")
public class Progress implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private int progressId;
    
   
    @OneToOne(mappedBy = "progress")
    private Project project;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "work_progress")
    private WorkProgress workProgress;
    
    public enum WorkProgress{
        Designer,SystemAnalysis,Coding,Testing,Implementation;
        
        public static int getWork(WorkProgress work){
            switch(work){
                case Designer:
                    return 1;
                case SystemAnalysis:
                    return 2;
                case Coding:
                    return 3;
                case Testing:
                    return 4;
                case Implementation: 
                    return 5;
                default: 
                    return 0;
            }
        }
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public WorkProgress getWorkProgress() {
        return workProgress;
    }

    public void setWorkProgress(WorkProgress workProgress) {
        this.workProgress = workProgress;
    }
    
    
   

 
    
    
}
