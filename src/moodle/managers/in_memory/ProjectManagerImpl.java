package moodle.managers.in_memory;

import moodle.datatypes.Course;
import moodle.datatypes.Project;
import moodle.managers.abstractions.ProjectManager;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectManager class provides basic functionality for project management
 */
public class ProjectManagerImpl implements ProjectManager {

    List<Project> projects = new ArrayList<>();

    public ProjectManagerImpl() {
    }

    /**
     * The method creates project
     *
     * @param name project name
     * @param course project course
     * @param task project task
     * @return Project
     */
    @Override
    public Project createProject(String name, Course course, String task) {
        Project project = new Project(name, course, task);
        projects.add(project);
        return project;
    }

    /**
     * The method removes project
     * @param project project to remove
     */
    @Override
    public void removeProject(Project project) {
        projects.remove(project);
    }

    /**
     * The method find and return all projects of the course
     *
     * @param course Course of the projects
     * @return list of projects
     */
    @Override
    public List<Project> getProjects(Course course) {
        List<Project> list = new ArrayList<>();
        for (Project element : projects) {
            if (element.getCourse().equals(course)) {
                list.add(element);
            }
        }
        return list;
    }

    /**
     * The method find and return project
     *
     * @param course project course
     * @param name project name
     * @return Project
     */
    @Override
    public Project getProject(Course course, String name) {
        return projects.stream()
                .filter(element -> element.getCourse().equals(course) && element.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
