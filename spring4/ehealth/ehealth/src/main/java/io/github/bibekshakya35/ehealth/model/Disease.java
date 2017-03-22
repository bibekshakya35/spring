/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import io.github.bibekshakya35.ehealth.model.modules.AbstractEntity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@Table(name = "tbl_diseases")
public class Disease implements Serializable, AbstractEntity {

    @Id
    @Column(name = "disease_code")
    private String code;

    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "disease",orphanRemoval = true)
    private Set<Cure> cures = new HashSet<>(0);

    @Column(name = "is_active")
    private boolean active = true;
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Cure> getCures() {
        return cures;
    }

    public void setCures(Set<Cure> cures) {
        this.cures = cures;
    }
    

}
