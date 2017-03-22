/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.model;

import io.github.bibekshakya35.ehealth.model.modules.AbstractEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Entity
@Table(name = "permissions_roles")
@NamedQueries(value = {
    @NamedQuery(name = PermissionRole.PERMISSION_ROLE_FIND_BY_ROLECODE, query = "select p from PermissionRole p where p.roleCode =:code"),
    @NamedQuery(name = PermissionRole.PERMISSION_ROLE_FIND_BY_ALL, query = "select p from PermissionRole p"),
    @NamedQuery(name = PermissionRole.PERMISSION_ROLE_FIND_BY_PRID, query = "SELECT p FROM PermissionRole p where p.id =:id"),
    @NamedQuery(name = PermissionRole.PERMISSION_ROLE_DELETE_BY_ROLEID, query = "DELETE FROM PermissionRole p WHERE p.roleCode=:code")
})
public class PermissionRole implements Serializable, AbstractEntity {

    public static final String PERMISSION_ROLE_FIND_BY_ROLECODE = "io.github.bibekshakya35.ehealth.model.PERMISSION_ROLE_FIND_BY_ROLECODE";
    public static final String PERMISSION_ROLE_FIND_BY_ALL = "io.github.bibekshakya35.ehealth.model.PERMISSION_ROLE_FIND_BY_ALL";
    public static final String PERMISSION_ROLE_FIND_BY_PRID = "io.github.bibekshakya35.ehealth.model.PERMISSION_ROLE_FIND_BY_PRID";
    public static final String PERMISSION_ROLE_DELETE_BY_ROLEID = "io.github.bibekshakya35.ehealth.model.PERMISSION_ROLE_DELETE_BY_ROLEID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String roleCode;

    private String permissionCode;
   
    @Column(name = "is_active")
    private boolean active;

    public PermissionRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.roleCode);
        hash = 83 * hash + Objects.hashCode(this.permissionCode);
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
        final PermissionRole other = (PermissionRole) obj;
        if (!Objects.equals(this.roleCode, other.roleCode)) {
            return false;
        }
        if (!Objects.equals(this.permissionCode, other.permissionCode)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

}
