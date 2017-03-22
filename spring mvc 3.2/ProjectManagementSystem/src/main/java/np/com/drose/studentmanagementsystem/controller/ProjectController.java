/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Part;
import javax.validation.Valid;
import np.com.drose.studentmanagementsystem.model.Project;
import np.com.drose.studentmanagementsystem.model.Team;
import np.com.drose.studentmanagementsystem.services.ProjectServices;
import np.com.drose.studentmanagementsystem.services.TeamServices;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import np.com.drose.studentmanagementsystem.model.Progress;
import np.com.drose.studentmanagementsystem.services.ProgressServices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author bibekshakya
 */
@Controller
public class ProjectController {

    //logging checked
    static org.apache.commons.logging.Log log = LogFactory.getLog(Project.class.getName());
    protected static Logger logger = Logger.getLogger("controller");

//    private Project project;
    @Autowired
    ProjectServices projectService;

//    @Autowired
//    EmployeeServices employeeService;
    @Autowired
    TeamServices teamServices;
    
    @Autowired
    ProgressServices progressService;

    private Part filePart;

    private List<String> listSkill;
  
//       public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

  public String fileUpload(@RequestParam("files") MultipartFile projectfile,
            RedirectAttributes redirectAttr) throws FileNotFoundException, IOException{
        
        if (!projectfile.isEmpty()) {
            File fileUploadPath = new File("/opt/files");
            File filePathToStore = File.createTempFile("project", ".pdf",fileUploadPath);
            if (!fileUploadPath.exists()) {
                fileUploadPath.mkdir();
            }
            BufferedOutputStream stream =new BufferedOutputStream(
                    new FileOutputStream(filePathToStore));
            FileCopyUtils.copy(projectfile.getInputStream(), stream);
            redirectAttr.addFlashAttribute("message","FIle with name" +filePathToStore.toString()+" is upload");
            return filePathToStore.toString();
        }
        else{
            redirectAttr.addFlashAttribute("message","failed to upload file");
        }
        return null;
    }


    @RequestMapping(value = "/admin/project/addProject", method = RequestMethod.GET)
    public String getForm(@ModelAttribute("project") Project project, @ModelAttribute("team") Team team, Model model) {
        try {

            log.info("Opening Add employee Page");

            List<String> skill = teamServices.getTeamList();

            model.addAttribute("project", new Project());
            model.addAttribute("team", new Team());
            model.addAttribute("projectRes", project.getProjectResource().values());
            model.addAttribute("projectStatus", project.getProjectStatus().values());
            model.addAttribute("skill", skill);

        } catch (Exception e) {
            log.error("Error in opening addProject Page" + e);
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        return "/admin/project/addProject";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProject(@Valid @ModelAttribute("project") Project project,
            @Valid @ModelAttribute("team") Team team,
            BindingResult binding,
            RedirectAttributes redirectAttr,
            Model model,
            @RequestParam("files") MultipartFile projectfile
            ) {
            Progress progress =new Progress();
        try {
            log.info("Going to save project" + project.getProjectName() + "  " );
            if (binding.hasErrors()) {
                redirectAttr.addFlashAttribute("addProjectForm", binding);
                redirectAttr.addFlashAttribute("errorMessage", "Not able to add project Detail");
                log.info("Redirect to /project/addProject");
                return "redirect:/admin/project/addProject";
            }
            //file upload on process
            String fileNameToStore=fileUpload(projectfile, redirectAttr);
            project.setProjectRequirementFile(fileNameToStore);
            project.setTeamName(team.getTeamName());
            
            progress.setWorkProgress(Progress.WorkProgress.Designer);
            project.setProgress(progress);
            progressService.insertProgress(progress);
            
            
            projectService.addProject(project);
            
            //teamServices.addTeam(team);
            redirectAttr.addFlashAttribute("message", "Project " + project.getProjectName() + " has been successfully added");
        } catch (Exception ex) {
            log.error("error in save project : " + ex);
        }
        return "redirect:/both/project/list";
    }

    @RequestMapping(value = "/both/project/list", method = RequestMethod.GET)
    public ModelAndView listProject(Model model) {
        List<Project> projectList = new ArrayList<Project>();
        List<Progress> progressList = new ArrayList<Progress>();
        List<Integer> progressList1;
        try {

            log.info("Inside list of project");
            projectList = projectService.getProjectList();
            progressList=progressService.getProgressList();
            progressList1=getProgressPercentage(progressList);
            model.addAttribute("progressList", progressList1);
            
            
            

        } catch (Exception e) {
            log.info("error of getting list of project : " + e);
        }
        return new ModelAndView("/both/project/list", "listProject", projectList);
    }
    
    public List<Integer> getProgressPercentage(List<Progress> progress){
        List<Integer> listData= new ArrayList<Integer>();
            int i=0;
            for (Progress progressData : progress) {
                int dataWork =progressData.getWorkProgress().ordinal();
                switch(dataWork){
                    case 0:
                        i=10;
                        break;
                    case 1:
                        i=20;
                        break;
                    case 2:
                        i=40;
                        break;
                    case 3:
                        i=60;
                        break;
                    case 4:
                        i=80;
                        break;
                    case 5:
                        i=90;
                        break;
                    default:
                        i=0;
                    
                }
                listData.add(i);
            }
            return listData;
           
    }


    @RequestMapping(value = "/admin/project/edit/{id}", method = RequestMethod.GET)
    public String editProject(@PathVariable Integer id,
            Model model
    ) {
        model.addAttribute("org.springframework.validation.BindingResult.project", model.asMap().get("editProject"));
        try {

            model.addAttribute("project", new Project());
            model.addAttribute("projectObject", this.projectService.getProjectById(id));
            model.addAttribute("skill", this.teamServices.getTeamList());
            model.addAttribute("projectRes", new Project().getProjectResource().values());
            model.addAttribute("projectStat", new Project().getProjectStatus().values());

        } catch (Exception E) {
            log.info("error " + E);
        }
        return "/admin/project/project/edit";
    }

    @RequestMapping(value = "/admin/project/edit/{id}", method = RequestMethod.POST)
    public RedirectView updateProject(
            @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            RedirectAttributes redirectAttr, 
            Model model
    ) {
        RedirectView redirectView = new RedirectView();
        try {
            if (result.hasErrors()) {
                redirectAttr.addAttribute("editProject", result);
                redirectAttr.addFlashAttribute("errorMessage", "unable to update due to null value " + project.getProjectName());
                redirectView.setContextRelative(true);
                redirectView.setUrl("/admin/project/edit/{id}");
                return redirectView;

            }
            projectService.updateRow(project);
            redirectAttr.addFlashAttribute("message", "Successful update");

        } catch (Exception e) {
            log.info("error in updating" + e);
        }
        redirectView.setContextRelative(true);
        redirectView.setUrl("/both/project/project/list");
        return redirectView;
    }
    
    @RequestMapping(value="/admin/project/delete/{id}",method = RequestMethod.GET)
    public String getProjectDisable(@PathVariable int id,Model model,RedirectAttributes redirectAttr){
        try {
            if (id==0) {
                redirectAttr.addFlashAttribute("errorMessage","Project cannot be disabled, Wrong Input");
                return "/project/list";
            }
            Project project = projectService.getProjectById(id);
            project.setProjectStatus(Project.ProjectStatus.FINISHED);
            projectService.updateRow(project);
            redirectAttr.addFlashAttribute("message",project.getProjectName() +" had been finished");
        } catch (Exception e) {
           
        }
        return "redirect:/both/project/list";
    }

}
