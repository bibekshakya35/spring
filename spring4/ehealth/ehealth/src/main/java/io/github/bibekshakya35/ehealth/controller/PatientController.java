/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.enums.UserGender;
import io.github.bibekshakya35.ehealth.model.AuditInfo;
import io.github.bibekshakya35.ehealth.model.Patient;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Controller
public class PatientController {

    @Autowired
    EhealthService<Patient> patient;

    AuditInfo auditInfo;

    @PostConstruct
    public void init() {
        auditInfo = new AuditInfo();
    }
    private static final Logger LOG = Logger.getLogger(PatientController.class.getName());

    @RequestMapping(value = "/patient/add", method = RequestMethod.GET)
    public String getAddDoctorForm(Model model) {
        try {
            model.addAttribute("patient", new Patient());
            model.addAttribute("userGenders", UserGender.values());
            model.addAttribute("org.springframework.validation.BindingResult.doctor", model.asMap().get("addPatient"));
        } catch (Exception e) {
            LOG.log(Level.INFO, "problem loading form of doctor add{0}", e);
        }
        return "/patient/add";
    }

}
