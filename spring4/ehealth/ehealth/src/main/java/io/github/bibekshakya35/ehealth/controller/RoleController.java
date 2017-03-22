/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.model.AuditInfo;
import io.github.bibekshakya35.ehealth.model.GroupPermission;
import io.github.bibekshakya35.ehealth.model.Permission;
import io.github.bibekshakya35.ehealth.model.PermissionRole;
import io.github.bibekshakya35.ehealth.model.Role;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Controller
public class RoleController {
    
    private static final Logger LOG = Logger.getLogger(RoleController.class.getName());
    List<PermissionRole> permissionRoles;
    @Autowired
    EhealthService<Role> roleEhealthService;
    
    @Autowired
    EhealthService<GroupPermission> groupEhealthService;
    
    @Autowired
    EhealthService<Permission> permissionEhealthService;
    
    @Autowired
    EhealthService<PermissionRole> peEhealthService;
    
    AuditInfo auditInfo;
    
    Map<String, List<Permission>> map;
   
    
    @PostConstruct
    public void init() {
        auditInfo = new AuditInfo();
        auditInfo.setCreatedOn(new Date());
        auditInfo.setModifiedOn(new Date());
        auditInfo.setVerifiedOn(new Date());
        map = new HashMap<>();
       
    }
    
    @RequestMapping(value = "/role/add", method = RequestMethod.GET)
    public String getRoleForm(@ModelAttribute("role") Role role, Model model) {
        try {
            LOG.info("--------------------------inside role add form");
            model.addAttribute("role", role);
            groupEhealthService.getList().stream().forEach((g) -> {
                map.put(g.getCode(), new ArrayList<>(g.getPermissions()));
                LOG.log(Level.INFO, "-------------------------g code{0}", g.getCode());
            });
            model.addAttribute("group", map);
            model.addAttribute("org.springframework.validation.BindingResult.role", model.asMap().get("addRoleForm"));
        } catch (Exception e) {
            LOG.log(Level.INFO, "role form showing{0}", e.getMessage());
        }
        return "/role/add";
    }
    
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public String saveRoleForm(@ModelAttribute("role") Role role,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        try {
            LOG.info("inside save function of role");
            if (bindingResult.hasErrors()) {
                LOG.info("--------------error----------------");
                redirectAttributes.addAttribute("addRoleForm", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "not able to add role");
                return "redirect:/role/add";
            }
            LOG.info("--------------------inside the save form------------------------");
            role.getPermissions().stream().forEach((pr) -> {
                PermissionRole permissionRole = new PermissionRole();
                permissionRole.setRoleCode(role.getCode());
                permissionRole.setPermissionCode(pr);
                peEhealthService.add(permissionRole);
            });
            role.setAuditInfo(auditInfo);
            roleEhealthService.add(role);
            LOG.info("successfully added");
        } catch (Exception e) {
            LOG.log(Level.INFO, "error while saving form of role{0}", e.getMessage());
            return "redirect:/role/add";
        }
        return "redirect:/role/list";
    }
    
    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public String getRoleListForm(Model model) {
        try {
            LOG.info("----------------------list of role-------------");
            
            LOG.log(Level.INFO, "Size of ROLE LIST{0}", roleEhealthService.getList().size());
            model.addAttribute("roles", roleEhealthService.getList());
        } catch (Exception e) {
            LOG.log(Level.INFO, "error while listing out the ROLE{0}", e);
        }
        return "/role/list";
    }
    
    @RequestMapping(value = "/role/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editRole(@PathVariable Integer id, @Valid @ModelAttribute("role") Role role,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model
    ) {
        LOG.info("going inside of role edit form");
        Set<Permission> permissions = new HashSet<>();
        try {
            role = this.roleEhealthService.findOne(id);
            if (role == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "role is unable to find with code : " + id);
                return new ModelAndView("redirect:/role/list");
            }
            permissionRoles = peEhealthService.findAll(role.getCode());
            permissionRoles.stream().forEach((pr) -> {
                Permission permission = permissionEhealthService.findOne(pr.getPermissionCode());
                permissions.add(permission);
            });   
            groupEhealthService.getList().stream().forEach((g) -> {
                permissions.stream().forEach((p)->{
                    g.getPermissions().forEach((pe)->{
                        if (pe.getCode().equals(p.getCode())) {
                            p.setChecked(Boolean.TRUE);
                        }
                    });
                });
                map.put(g.getCode(), new ArrayList<>(g.getPermissions()));
                LOG.log(Level.INFO, "-------------------------g code{0}", g.getCode());
            });
            
            model.addAttribute("group", map);
            model.addAttribute("pr", permissions);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit data");
            LOG.log(Level.INFO, "error in edit role data>>>>>>>>>>>>>{0}", e);
            return new ModelAndView("redirect:/role/list");
        }
        return new ModelAndView("/role/edit", "role", role);
        
    }
    
    @RequestMapping(value = "/role/editRole/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("role") Role role,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        try {
            LOG.info("inside edit of the role controller---------->");
            if (bindingResult.hasErrors()) {
                LOG.log(Level.INFO, "error handling or binding form data{0}", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "error in binding form data");
                return new ModelAndView("redirect:/role/edit/" + role.getCode());
            }
            
            peEhealthService.deleteAll(permissionRoles);
            LOG.info("-----------> successfully delete all");
            role.getPermissions().stream().forEach((pr) -> {
                PermissionRole permissionRole = new PermissionRole();
                permissionRole.setRoleCode(role.getCode());
                permissionRole.setPermissionCode(pr);
                peEhealthService.add(permissionRole);
            });
            LOG.info("successfully added inside permission role");
            role.setAuditInfo(auditInfo);
            roleEhealthService.edit(role);
            LOG.info("successfully edited data");
            redirectAttributes.addFlashAttribute("message", "Record : " + role.getCode() + " has been Successfully edited");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit data");
            LOG.log(Level.INFO, "error in edit role data>>>>>>>>>>>>>{0}", e);
            return new ModelAndView("redirect:/role/edit/" + role.getCode());
        }
        return new ModelAndView("redirect:/role/list");
    }
    
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }
    
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }
    
    public Map<String, List<Permission>> getMap() {
        return map;
    }
    
    public void setMap(Map<String, List<Permission>> map) {
        this.map = map;
    }
    
}
