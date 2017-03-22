/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import io.github.bibekshakya35.ehealth.enums.UserType;
import io.github.bibekshakya35.ehealth.model.modules.AbstractEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@Table(name = "users")
public class User implements Serializable, AbstractEntity {

    @Id
    @Column(name = "username", unique = true)
    private String userName;

    @NotNull(message = "password cannot be empty")
    @Column(name = "users_password")
    private String userPassword;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
//    @JoinColumn(name = "role_id")
//    private Role role;
    @Embedded
    private UserProfile userProfile;

    @Embedded
    private AuditInfo auditInfo;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String userKey;

    @Column(name = "is_active")
    private boolean active = true;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    public String getUserKey() {
        return userKey;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", userPassword=" + userPassword + ", userProfile=" + userProfile + ", auditInfo=" + auditInfo + ", userType=" + userType + ", userKey=" + userKey + ", active=" + active + '}';
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

}
