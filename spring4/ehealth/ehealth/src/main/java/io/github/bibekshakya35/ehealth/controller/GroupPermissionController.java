/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.enums.UserType;
import io.github.bibekshakya35.ehealth.model.AuditInfo;
import io.github.bibekshakya35.ehealth.model.GroupPermission;
import io.github.bibekshakya35.ehealth.model.Permission;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
public class GroupPermissionController {

    private static final Logger LOG = Logger.getLogger(GroupPermissionController.class.getName());

    @Autowired
    EhealthService<GroupPermission> groupPermissionEhealthService;

    List<Permission> permissions;

    AuditInfo auditInfo;

    @PostConstruct
    public void init() {
        auditInfo = new AuditInfo();
        auditInfo.setCreatedOn(new Date());
        auditInfo.setModifiedOn(new Date());
        auditInfo.setVerifiedOn(new Date());
        permissions = new ArrayList<>();
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.GET)
    public String getGroupForm(@ModelAttribute("group") GroupPermission group, Model model) {
        try {
            LOG.info("---------inside get form of group permission-------");
            LOG.log(Level.INFO, "group permission {0}", group.toString());
            model.addAttribute("group", group);
            model.addAttribute("usertype", UserType.values());
            model.addAttribute("permissions", permissions);
            model.addAttribute("org.springframework.validation.BindingResult.grouppermission", model.asMap().get("addGroupPermissionForm"));
        } catch (Exception e) {
            LOG.log(Level.INFO, "error while getting form in add{0}", e.getMessage());
        }
        return "/group/add";
    }

    @RequestMapping(value = {"/group/save", "/group/editGroup/{code}"}, params = "addPermission", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addPermission(@ModelAttribute("group") GroupPermission group, RedirectAttributes redirectAttributes) {
        LOG.log(Level.INFO, "group value inside add permission{0}", group.toString());
        group.getPermission().setGroup(group);
        for (Permission permission : permissions) {
            if (permission.getCode().equalsIgnoreCase(group.getPermission().getCode())) {
                redirectAttributes.addFlashAttribute("group", group);
                redirectAttributes.addFlashAttribute("errorMessage", "permission code " + group.getPermission().getCode() + " has already been added so permission has to be unique to be unique");
                return "redirect:/group/add";
            }
        }
        if (permissions.contains(group.getPermission())) {
            permissions.remove(group.getPermission());
        }
        permissions.add(group.getPermission());
        group.setPermission(new Permission());
        LOG.log(Level.INFO, "size of permissions list{0}", permissions.size());
        redirectAttributes.addFlashAttribute("group", group);
        return "redirect:/group/add";
    }

    @RequestMapping(value = "/group/save", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("group") GroupPermission group, @ModelAttribute("permission") Permission permission, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        try {
            LOG.info("Inside the save form of permission");
            if (bindingResult.hasErrors()) {
                redirectAttributes.addAttribute("addGroupPermission", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "unable to add group permission " + bindingResult.getFieldError());
                return "redirect:/group/add";
            }
            LOG.info("-------------inside save group permission----------------");
            group.setPermissions(new HashSet<>(permissions));
            auditInfo.setCreatedBy("bibek shakya");
            group.setAuditInfo(auditInfo);
            LOG.log(Level.INFO, "size of setPermission{0}", group.getPermissions().size());
            this.groupPermissionEhealthService.add(group);
            LOG.info("successfully added group permission");
            redirectAttributes.addFlashAttribute("message", "Group Permission" + group.getCode() + " has beed stored on database");
            permissions = new ArrayList<>();
        } catch (Exception e) {
            LOG.log(Level.INFO, "errorMessage on save form of Group Permission{0}", e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/group/add";
        }
        return "redirect:/group/list";
    }

    @RequestMapping(value = "/group/list", method = RequestMethod.GET)
    public String getList(Model model) {
        LOG.info("inside the get list of the group");
        List<GroupPermission> groupPermissions = this.groupPermissionEhealthService.getList();
        LOG.log(Level.INFO, "size of the list{0}", groupPermissions.size());
        model.addAttribute("groups", groupPermissions);
        return "/group/list";
    }

    @RequestMapping(value = "/group/edit/{code}", method = RequestMethod.GET)
    public ModelAndView editForm(@PathVariable String code, @Valid @ModelAttribute("Group") GroupPermission group,
            BindingResult bindingResult, Model model,
            RedirectAttributes redirectAttributes) {
        LOG.info("Inside the edit form for group permission ----------------------");
        model.addAttribute("org.springframework.validation.BindingResult.group", model.asMap().get("editGroupForm"));
        try {
            LOG.info("going inside of edit user form - ---- -- - -");
            group = groupPermissionEhealthService.findOne(code);
            if (group == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "group, you want to edit is not in database");
                return new ModelAndView("redirect:/group/list");
            }
            Permission permission = new Permission();
            permission.setCode("");
            permission.setDescriptions("");
            permission.setName("");
            group.setPermission(permission);
            permissions.addAll(group.getPermissions());
            model.addAttribute("usertype", UserType.values());
            model.addAttribute("permissions", permissions);
            LOG.info("succefully found object");
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit data");
            LOG.log(Level.INFO, "error in edit group permission data>>>>>>>>>>>>>{0}", ex);
            return new ModelAndView("redirect:/group/list");
        }
        return new ModelAndView("/group/edit", "group", group);
    }

    @RequestMapping(value = "/group/editGroup/{code}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("group") GroupPermission group,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        try {
            LOG.log(Level.INFO, "inside the edit form initially{0}", group.toString());
            if (bindingResult.hasErrors()) {
                LOG.log(Level.INFO, "error un binding result in edit group permission {0}", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "error in bing data of the group Permission");
                return new ModelAndView("redirect:/group/edit/" + group.getCode());
            }
            group.setAuditInfo(auditInfo);
            group.setPermissions(new HashSet<>(permissions));
            groupPermissionEhealthService.edit(group);
            LOG.info("successfully edited ..... group permission");
            redirectAttributes.addFlashAttribute("message", "Record " + group.getCode() + " has been successfully edited");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit data");
            LOG.log(Level.INFO, "error in edit group permission data>>>>>>>>>>>>>{0}", e);
            return new ModelAndView("redirect:/group/edit/" + group.getCode());
        }
        return new ModelAndView("redirect:/group/list");
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
