/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.enums.UserGender;
import io.github.bibekshakya35.ehealth.enums.UserType;
import io.github.bibekshakya35.ehealth.model.AuditInfo;
import io.github.bibekshakya35.ehealth.model.UserProfile;
import io.github.bibekshakya35.ehealth.model.User;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
public class RegisterController {

    @Autowired
    EhealthService<User> userService;

    AuditInfo auditInfo;

    @PostConstruct
    public void init() {
        auditInfo = new AuditInfo();
    }

    private static final Logger LOG = Logger.getLogger(RegisterController.class.getName());

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm(Model model) {
        User user = new User();
        try {
            LOG.info("inside the register form controller");
            model.addAttribute("user", user);
            model.addAttribute("usertype", UserType.values());
            model.addAttribute("userGenders", UserGender.values());
            model.addAttribute("org.springframework.validation.BindingResult.user", model.asMap().get("addUserForm"));
        } catch (Exception e) {
            LOG.log(Level.INFO, "error inside the register form{0}", e.getMessage());
        }
        return "/register";
    }

    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("user") User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam("files") MultipartFile profilePicture) {
        try {
            LOG.log(Level.INFO, "Inside save method for user  {0} user profile {1}", user.toString());
            if (bindingResult.hasErrors()) {
                redirectAttributes.addAttribute("addUserForm", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "Not able to add new user");
                return "redirect:/register";
            }

            String profilePicPath = ppUload(profilePicture);
            user.getUserProfile().setUserProfilePic(profilePicPath);
            user.setAuditInfo(auditInfo);
            userService.add(user);
            LOG.log(Level.INFO, "successfully saved entity{0}", user.toString());
            redirectAttributes.addFlashAttribute("message", user.toString() + " has been successfully store");
        } catch (IOException e) {
            LOG.log(Level.INFO, "error in saving user {0}", e);
        }
        return "redirect:/user/list";

    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String getList(Model model) {
        try {
            LOG.info("----------------------list of user-------------");
            LOG.log(Level.INFO, "Size of user list{0}", userService.getList().size());
            model.addAttribute("users", userService.getList());
        } catch (Exception e) {
            LOG.log(Level.INFO, "error while listing out the user{0}", e);
        }
        return "/user/list";
    }

    public String ppUload(@RequestParam("files") MultipartFile profilePicture) throws IOException {
        if (!profilePicture.isEmpty()) {
            String extension = profilePicture.getOriginalFilename().split("\\.")[1];
            LOG.log(Level.INFO, "file extension{0}", extension);
            File fileUpload = new File("/home/bibek/ehealth/user/profilepicture");
            File filePathToStore = File.createTempFile("user", "." + extension, fileUpload);
            if (!fileUpload.exists()) {
                fileUpload.mkdir();
            }
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filePathToStore));
            FileCopyUtils.copy(profilePicture.getInputStream(), stream);
            LOG.log(Level.INFO, "successfully image has been store{0}", filePathToStore.toString());
            return filePathToStore.toString();
        } else {
            LOG.info("profilepicture MultipartFile is null");
        }
        return null;
    }

    @RequestMapping(value = "/user/edit/{username}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable String username, @ModelAttribute User user,
            BindingResult bindingResult, RedirectAttributes redirectAttributes,
            Model model
    ) {
        LOG.info("inside the edit form>>>>>>>>>>>>>>>>>>>");
        model.addAttribute("org.springframework.validation.BindingResult.user", model.asMap().get("userEditForm"));
        try {
            LOG.info("going inside of edit user form>>>>>>");
            user = userService.findOne(username);
            if (user == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "User is unable to found");
                return new ModelAndView("redirect:/user/list");
            }
            model.addAttribute("usertype", UserType.values());
            model.addAttribute("userGenders", UserGender.values());
            model.addAttribute("user", user);
            LOG.info("well easily get the edit form of the user");
        } catch (Exception e) {
            LOG.log(Level.INFO, "problem while loading edit form of user >>>>>>>>>{0}", e);
            redirectAttributes.addFlashAttribute("message", e.getCause());
            return new ModelAndView("redirect:/user/list");
        }
        return new ModelAndView("/user/edit");
    }

    @RequestMapping(value = "/user/edit/{username}", method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        try {
            LOG.log(Level.INFO, "going inside to edit user data{0}", user.toString());
            if (bindingResult.hasErrors()) {
                LOG.log(Level.INFO, "error in binding the user data>>>>{0}", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", bindingResult);
                return new ModelAndView("redirect:/user/edit/" + user.getUserName());
            }
            user.setAuditInfo(auditInfo);
            userService.edit(user);
            LOG.info("successfully edit user data");
            redirectAttributes.addFlashAttribute("message", "Record " + user.getUserName() + " has been edited from database");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit data");
            LOG.log(Level.INFO, "error in edit user data>>>>>>>>>>>>>{0}", e);
            return new ModelAndView("redirect:/user/edit/"+user.getUserName());
        }
        return new ModelAndView("redirect:/user/list");
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

}
