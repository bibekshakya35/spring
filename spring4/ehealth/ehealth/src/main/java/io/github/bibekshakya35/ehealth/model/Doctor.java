/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@Table(name = "tbl_doctor")
@PrimaryKeyJoinColumn(name = "username")
public class Doctor extends User {
    
    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private DoctorType doctorType;
    
    private String hospital;
    
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startWorkDate;
    
    public DoctorType getDoctorType() {
        return doctorType;
    }
    
    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }
    
    public String getHospital() {
        return hospital;
    }
    
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    
    public Date getStartWorkDate() {
        return startWorkDate;
    }
    
    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

   
    
}
