package bj.rony.testapi.services;


import bj.rony.testapi.ppmtool.Project;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final RestTemplate restTemplate;

    private String uri = "http://localhost:8080/api/projects";

    public ProjectServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Set<Project> getAllProjects(){

        Project[] projects = restTemplate.getForObject(uri+"/all", Project[].class);

        return Arrays.stream(projects).collect(Collectors.toSet());
        //return null;
    }

    @Override
    public Project getOneProject(String identifier) {

        Project project = restTemplate.getForObject(uri+"/"+identifier, Project.class);
        return project;
    }

    @Override
    public Project createOneProject(Project project) {
        Project createdProject = restTemplate.postForObject(uri, project, Project.class);
        return createdProject;
    }

    @Override
    public void deleteOneProject(String identifier){
        restTemplate.delete(uri+"/"+identifier);
    }
}
