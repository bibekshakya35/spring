/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.model.DoctorType;
import io.github.bibekshakya35.ehealth.enums.UserGender;
import io.github.bibekshakya35.ehealth.enums.UserType;
import io.github.bibekshakya35.ehealth.model.AuditInfo;
import io.github.bibekshakya35.ehealth.model.Doctor;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Controller
public class DoctorController {

    @Autowired
    EhealthService<DoctorType> docTypeEhealthService;

    @Autowired
    EhealthService<Doctor> docEhealthService;

    private static final Logger LOG = Logger.getLogger(DoctorController.class.getName());

    AuditInfo auditInfo;

    @PostConstruct
    public void init() {
        auditInfo = new AuditInfo();
    }

    @RequestMapping(value = "/doctor/add", method = RequestMethod.GET)
    public String getAddDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        try {
            model.addAttribute("doctor", doctor);
            model.addAttribute("userGenders", UserGender.values());
            model.addAttribute("org.springframework.validation.BindingResult.doctor", model.asMap().get("addDoc"));
        } catch (Exception e) {
            LOG.log(Level.INFO, "problem loading form of doctor add{0}", e);
        }
        return "/doctor/add";
    }

    @RequestMapping(value = "/doctor/save", method = RequestMethod.POST)
    public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model,
            @RequestParam("files") MultipartFile multipartFile
    ) {
        try {
            LOG.log(Level.INFO, "inside the saving method of doctor{0}", doctor.getUserName());
            if (bindingResult.hasErrors()) {
                LOG.log(Level.INFO, "problem while binding the data of doctor{0}", bindingResult);
                redirectAttributes.addFlashAttribute("errorMessage", "Not able to add new user");
                return "redirect:/doctor/add";
            }
            doctor.getUserProfile().setUserProfilePic(uploadImage(multipartFile));
            doctor.setAuditInfo(auditInfo);
            docEhealthService.add(doctor);
            LOG.info("successfully added");
            redirectAttributes.addFlashAttribute("message", "Record : " + doctor.getUserProfile().getFullname() + "has been successfully added");

        } catch (Exception e) {
            LOG.log(Level.INFO, "error on saving doctor data {0}", e);
            redirectAttributes.addFlashAttribute("errorMessage", e);
            return "redirect:/doctor/add";
        }
        return "redirect:/doctor/list";
    }

    public String uploadImage(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            LOG.info("inside saving profile picture of doctor");
            String extenstion = multipartFile.getOriginalFilename().split("\\.")[1];
            LOG.log(Level.INFO, "extension of image type {0}", extenstion);
            File fileUpload = new File("/home/bibek/ehealth/user/profilepicture");
            File filePathToStore = File.createTempFile("user", "." + extenstion, fileUpload);
            if (!fileUpload.exists()) {
                fileUpload.mkdir();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePathToStore));
            FileCopyUtils.copy(multipartFile.getInputStream(), bufferedOutputStream);
            LOG.log(Level.INFO, "successfully image has been store{0}", filePathToStore.toString());
            return filePathToStore.toString();
        } else {
            LOG.info("profilepicture MultipartFile is null");
        }
        return null;

    }

    @RequestMapping(value = "/doctor/list", method = RequestMethod.GET)
    public String getList(Model model) {
        try {
            LOG.info("----------------------list of user-------------");
            LOG.log(Level.INFO, "Size of user list{0}", docEhealthService.getList().size());
            model.addAttribute("doctors", docEhealthService.getList());
        } catch (Exception e) {
            LOG.log(Level.INFO, "error while listing out the doctor{0}", e);
        }
        return "/doctor/list";
    }

    @RequestMapping(value = "/doctor/edit/{userName}", method = RequestMethod.GET)
    public String editDoctorForm(@PathVariable String userName,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        model.addAttribute("org.springframework.validation.BindingResult.doctor", model.asMap().get("editDoc"));
        try {
            LOG.info("inside of edit form of doctor");
            Doctor doctor = docEhealthService.findOne(userName);
            if (doctor == null) {
                LOG.info("record not found");
                redirectAttributes.addAttribute("message", "record not found");
                return "redirect:/doctor/edit/" + userName;
            }
            model.addAttribute("doctor", doctor);
            model.addAttribute("gender", UserGender.values());
            LOG.info("good to go ");
        } catch (Exception e) {
            LOG.log(Level.INFO, "problem in loading edit form data{0}", e);
            redirectAttributes.addFlashAttribute("errorMessage", "error in loading form");
            return "redirect:/doctor/edit/" + userName;
        }
        return "/doctor/edit/" + userName;
    }

    @RequestMapping(value = "/doctor/editForm/{userName}", method = RequestMethod.POST)
    public String editForm(
            @Valid @ModelAttribute("doctor") Doctor doctor,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        try {
            LOG.log(Level.INFO, "inside of editing record..........{0}", doctor.getUserName());
            doctor.setAuditInfo(auditInfo);
            doctor.setUserType(UserType.DOCTOR);
            docEhealthService.edit(doctor);
            redirectAttributes.addAttribute("message", "Record has been edited");
        } catch (Exception e) {
            LOG.log(Level.INFO, "error inside of editing{0}", e);
            redirectAttributes.addFlashAttribute("errorMessage", e);
            return "/doctor/edit/" + doctor.getUserName();
        }
        return "redirect:/doctor/list";
    }
}
