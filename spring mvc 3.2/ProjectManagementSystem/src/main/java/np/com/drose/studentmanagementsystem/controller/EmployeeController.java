/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import np.com.drose.studentmanagementsystem.model.Employee;
import np.com.drose.studentmanagementsystem.services.EmployeeServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bibekshakya
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    static Logger logger = Logger.getLogger("controller");

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/admin/employee/addemployee", method = RequestMethod.GET)
    public String getFormEmployee(@ModelAttribute("employee") Employee employee,
            Model model) {
        try {
            model.addAttribute("gender", employee.getGender().values());
            model.addAttribute("role", employee.getRoleEmployee().values());

        } catch (Exception e) {
            logger.info("Error in getForm " + e);
        }
        return "/admin/employee/addemployee";
    }

    @RequestMapping(value = "/admin/employee/add", method = RequestMethod.POST)
    public String addEmp(@ModelAttribute("employee") Employee employee,
            BindingResult binding,
            RedirectAttributes redirectAttr,
            Model model
    ) {

        try {
            if (binding.hasErrors()) {
                redirectAttr.addFlashAttribute("message", "Error, Unable to add New Employee");
                return "redirect:/employee/addemployee";
            }
            employeeServices.addEmployee(employee);
            redirectAttr.addFlashAttribute("message", "New Employee With Name : " + employee.getEmployeeName() + "has been added");
        } catch (Exception e) {
            logger.info("error on saving " + e);
        }
        return "redirect:/admin/employee/addemployee";

    }

    @RequestMapping(value = "/admin/employee/list", method = RequestMethod.GET)
    public String listEmp(
            Model model,
            RedirectAttributes redirectAttr
    ) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        try {
            listEmployee = employeeServices.getEmployeeList();
            model.addAttribute("listEmployee", listEmployee);

        } catch (Exception e) {
            model.addAttribute("message", "No Employee Record");
            return "/admin/employee/list";
        }
        return "/admin/employee/list";
    }

    @RequestMapping(value = "/admin/employee/edit/{id}", method = RequestMethod.GET)
    public String getEditForm(
            @PathVariable Integer id,
            Model model,
            RedirectAttributes redirectAttr
    ) {
        Employee emp = new Employee();
        try {
            if (id == 0) {
                redirectAttr.addFlashAttribute("errorMessage", "Restriction!!! You cannot edit the record");
                return "redirect:/admin/employee/list";
            }
            model.addAttribute("gender", emp.getGender().values());
            model.addAttribute("role", emp.getRoleEmployee().values());
            emp = employeeServices.getEmpById(id);
            model.addAttribute("employee", emp);
            
        } catch (Exception e) {
            redirectAttr.addFlashAttribute("message", "UNable to edit employee record");
            return "redirect:/admin/employee/list";
        }
        return "/admin/employee/edit";
    }

    @RequestMapping(value = "/admin/employee/editemployee", method = RequestMethod.POST)
    public String edit(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult binding,
            RedirectAttributes redirect,
            Model model
    ) {
        try {
            if (binding.hasErrors()) {
                redirect.addFlashAttribute("errorMessage", "Unable to Edit employee Record");
            }
            employeeServices.addEmployee(employee);
        } catch (Exception e) {
            redirect.addFlashAttribute("errorMessage", "Unable to Edit employee Record");
            logger.info(e);

        }
        return "redirect:/admin/employee/list";
    }

}
