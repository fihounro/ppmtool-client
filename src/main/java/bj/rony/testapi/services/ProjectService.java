package bj.rony.testapi.services;

import bj.rony.testapi.ppmtool.Project;

import java.util.Set;

public interface ProjectService {

    public Set<Project> getAllProjects();
    public Project getOneProject(String identifier);
    public Project createOneProject(Project project);

    public void deleteOneProject(String identifier);
}
