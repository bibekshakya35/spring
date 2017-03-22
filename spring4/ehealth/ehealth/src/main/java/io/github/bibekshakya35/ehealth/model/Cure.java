/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import io.github.bibekshakya35.ehealth.enums.CureType;
import io.github.bibekshakya35.ehealth.model.modules.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@Table(name = "tbl_cure")
public class Cure implements Serializable, AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cure_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cure_type")
    private CureType cureType;

    @ElementCollection
    @CollectionTable(name = "cureProcess")
    @Column(name = "cure_process")
    private List<String> cureProcess;
    
    @ManyToOne
    @JoinColumn(name = "disease_code")
    private Disease disease;

    @Column(name = "is_active")
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CureType getCureType() {
        return cureType;
    }

    public void setCureType(CureType cureType) {
        this.cureType = cureType;
    }

    public List<String> getCureProcess() {
        return cureProcess;
    }

    public void setCureProcess(List<String> cureProcess) {
        this.cureProcess = cureProcess;
    }
    @Override
    public boolean isActive() {
        return active;
    }
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
    
}
