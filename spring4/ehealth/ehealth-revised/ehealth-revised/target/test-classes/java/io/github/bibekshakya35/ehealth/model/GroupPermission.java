/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import io.github.bibekshakya35.ehealth.enums.UserType;
import io.github.bibekshakya35.ehealth.model.modules.AbstractEntity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@EntityListeners(AuditInfo.class)
@Table(name = "tbl_groupppermission")
public class GroupPermission implements Serializable, AbstractEntity {

    @Id
    @Column(name = "group_code", unique = true)
    private String code;

    @Column(name = "group_name")
    private String name;

    @Column(name = "group_description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group",orphanRemoval = true)
    private Set<Permission> permissions = new HashSet<>(0);

    @Enumerated(EnumType.STRING)
    @Column(name = "usertype_grouppermission")
    private UserType userType;

    @Embedded
    @Column(name = "audit_info")
    private AuditInfo auditInfo;

    @Column(name = "is_active")
    private boolean active;

    @Transient
    private Permission permission;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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

    @Override
    public String toString() {
        return "GroupPermission{" + "code=" + code + ", name=" + name + ", description=" + description + ", permission=" + permission + ", userType=" + userType + ", auditInfo=" + auditInfo + ", active=" + active + '}';
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    public void addPermission(Permission permission){
        if (this.permissions.contains(permission)) {
            this.permissions.remove(permission);
        }
        permission.setActive(true);
        this.permissions.add(permission);
    }
    public void addPermissions(Set<Permission> permissions){
        this.permissions.addAll(permissions);
    }
}
