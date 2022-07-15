package bj.rony.testapi.controllers;

import bj.rony.testapi.ppmtool.Project;
import bj.rony.testapi.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"", "/", "/all"})
    public String getProjects(Model model){

        Set<Project> allProjects =  projectService.getAllProjects();
        model.addAttribute("projects", allProjects);

        System.out.println("All Projects -> {}"+projectService.getAllProjects());

        return "project/index";
    }

    @GetMapping({"/{identifier}", "/{identifier}/"})
    public String getOneProject(@PathVariable("identifier") String identifier, Model model){

        Project project =  projectService.getOneProject(identifier);
        model.addAttribute("project", project);

        System.out.println("All Projects -> {}"+projectService.getOneProject(identifier));

        return "project/show";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);

//        List<String> listCategory = Arrays.asList("Development", "Comics", "Entrepreneurship");
//
//        model.addAttribute("categories", listCategory);

//        model.addAttribute("authors", projectService.getAllAuthors());

        return "project/add";
    }


    @PostMapping("/add")
    public String createNewProject(@ModelAttribute("project") Project project) {

        System.out.println(project);

        projectService.createOneProject(project);

        return "redirect:" + "/projects";
    }

    @GetMapping({"/delete/{identifier}", "/delete/{identifier}/"})
    public String deleteOneProject(@PathVariable("identifier") String identifier, Model model){

        projectService.deleteOneProject(identifier);

        return "redirect:" + "/projects";
    }
}
