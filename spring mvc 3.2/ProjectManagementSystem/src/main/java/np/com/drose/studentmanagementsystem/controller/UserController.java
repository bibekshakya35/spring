/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import np.com.drose.studentmanagementsystem.model.Role;
import np.com.drose.studentmanagementsystem.model.User;
import np.com.drose.studentmanagementsystem.services.RoleServices;
import np.com.drose.studentmanagementsystem.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bibekshakya
 */
@Controller
public class UserController {

    @Autowired
    RoleServices roleServices;

    @Autowired
    UserServices userServices;

    List<Role> role = new ArrayList<Role>();

    @InitBinder
    public void init(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String getLoginForm(
            @ModelAttribute("user") User user,
            Model model
    ) {
        List<Role> roleList = new ArrayList<Role>();
        try {
            roleList = roleServices.getRolesList();
            model.addAttribute("user", new User());

            model.addAttribute("roleList", roleList);

            return "/user/add";
        } catch (Exception e) {

            return null;
        }

    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String addUser(
            @ModelAttribute("user") User user,
            @ModelAttribute("role") Role role,
            BindingResult binding,
            RedirectAttributes redirectAttr,
            Model model
    ) {
        Set<User> users = new HashSet<User>();
        try {
            
            if (binding.hasErrors()) {
                redirectAttr.addFlashAttribute("message", "Unable to add user");
                return "redirect:/user/add";
            }
            if (validationPassword(user.getPassword(), user.getConfirmPassword())) {
                users.add(user);
                role = roleServices.getRole(user.getRoleData());
                role.setUserRoles(users);
                user.setRole(role);
                                userServices.insertUser(user);
                redirectAttr.addFlashAttribute("message", "Able to add User");
            } else {
                redirectAttr.addFlashAttribute("errorMessage", "Password didnot match");
            }

        } catch (Exception e) {
            return null;
        }
        return "redirect:/user/add";
    }

    public boolean validationPassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
