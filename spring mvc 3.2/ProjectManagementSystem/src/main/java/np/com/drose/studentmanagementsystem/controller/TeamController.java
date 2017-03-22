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
import np.com.drose.studentmanagementsystem.model.Team;
import np.com.drose.studentmanagementsystem.services.EmployeeServices;
import np.com.drose.studentmanagementsystem.services.TeamServices;
import org.apache.log4j.Logger;
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
public class TeamController {

    Logger logger = Logger.getLogger("controller");

    @Autowired
    TeamServices teamServices;

    @Autowired
    EmployeeServices employeeServices;

    @InitBinder
    public void init(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/admin/member/addmember", method = RequestMethod.GET)
    public String getForm(@ModelAttribute("team") Team team,
            @ModelAttribute("employee") Employee employee,
            BindingResult binding,
            Model model) {
        List<Employee> employeeList = new ArrayList<Employee>();
        List<String> teamName = new ArrayList<String>();
        try {
            employeeList = employeeServices.getEmployeeList();
            teamName.add("ALPHA-SPRING");
            teamName.add("ALPHA-PHP");
            teamName.add("ALPHA-EJB");
            model.addAttribute("team", new Team());
            model.addAttribute("employee", new Employee());
            model.addAttribute("employeeList", employeeList);
            model.addAttribute("teamNameList", teamName);
        } catch (Exception e) {
        }
        return "/admin/member/addmember";
    }

    @RequestMapping(value = "/admin/member/savemember", method = RequestMethod.POST)
    public String saveMember(
            @Valid @ModelAttribute("team") Team team,
            @ModelAttribute("employee") Employee employee,
            BindingResult binding,
            RedirectAttributes redirectAttr,
            Model model
    ) {
        try {
            logger.info("error on saving member");
            if (binding.hasErrors()) {
                redirectAttr.addFlashAttribute("message", "error on saving message");
                return "redirect:/admin/member/addmember";
            }
            employee = employeeServices.getEmpById(team.getEmployeeId());
            team.setEmployeeName(employee.getEmployeeName());
            team.setEmployeeRole(employee.getRoleEmployee());
            teamServices.addTeam(team);
            redirectAttr.addFlashAttribute("message", "New Member has been saved under" + team.getTeamName());

        } catch (Exception e) {
            logger.info(e);
        }
        return "redirect:/admin/member/addmember";
    }

    @RequestMapping(value = "/admin/member/list", method = RequestMethod.GET)
    public String listMember(
            Model model,
            RedirectAttributes redirectAttr
    ) {
        List<Team> listMember = new ArrayList<Team>();
        List<String> getTeamList =new ArrayList<String>();
        try {
            getTeamList = teamServices.getTeamList();
            listMember = teamServices.getTeamMemeber("ALPHA-SPRING");
            model.addAttribute("teamMember", listMember);
            model.addAttribute("teamData",getTeamList);
            listMember = teamServices.getTeamMemeber("ALPHA-PHP");
            model.addAttribute("teamMember1", listMember);
            model.addAttribute("teamData1",getTeamList);
            listMember = teamServices.getTeamMemeber("ALPHA-EJB");
            model.addAttribute("teamMember2", listMember);
            model.addAttribute("teamData2",getTeamList);
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
        return "/admin/member/list";
    }

}
