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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author bibekshakya
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "Shit!!! Are You Dumb")
    private String firstName;

    @NotNull(message = "OH!! You must be batman. Right??")
    private String lastName;

    @NotNull(message = "You're Killing me today")
    @Column(unique = true)
    private String username;

    @Email(message = "create a new email id and come back!! till then Adios mucha cha")
    private String email;

    @Pattern.List({
        @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
        @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
        @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
        @Pattern(regexp = "(?=\\S+$)", message = "Password must not contain whitespace.")
    })
    private String password;

    @Transient
    private String confirmPassword;

    private boolean enabled;

    @Transient
    private Integer roleData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id",
                        referencedColumnName = "id")})
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getRoleData() {
        return roleData;
    }

    public void setRoleData(Integer roleData) {
        this.roleData = roleData;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
