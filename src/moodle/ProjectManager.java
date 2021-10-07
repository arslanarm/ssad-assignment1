package moodle;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectManager class provides basic functionality for project management
 */
class ProjectManager {
    static ProjectManager INSTANCE = new ProjectManager();
    List<Project> projects = new ArrayList<>();

    private ProjectManager() {
    }

    /**
     * The method creates project
     *
     * @param name project name
     * @param course project course
     * @param task project task
     * @return Project
     */
    Project createProject(String name, Course course, String task) {
        Project project = new Project(name, course, task);
        projects.add(project);
        return project;
    }

    /**
     * The method removes project
     * @param project project to remove
     */
    void removeProject(Project project) {
        projects.remove(project);
    }

    /**
     * The method find and return all projects of the course
     *
     * @param course Course of the projects
     * @return list of projects
     */
    List<Project> getProjects(Course course) {
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
    Project getProject(Course course, String name) {
        return projects.stream()
                .filter(element -> element.getCourse().equals(course) && element.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
