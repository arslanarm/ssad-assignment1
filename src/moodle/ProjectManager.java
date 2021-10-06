package moodle;

import java.util.ArrayList;
import java.util.List;

class ProjectManager {
    static ProjectManager INSTANCE = new ProjectManager();
    List<Project> projects = new ArrayList<>();

    private ProjectManager() {
    }

    Project createProject(String name, Course course, String task) {
        Project project = new Project(name, course, task);
        projects.add(project);
        return project;
    }

    void removeProject(Project project) {
        projects.remove(project);
    }

    List<Project> getProjects(Course course) {
        List<Project> list = new ArrayList<>();
        for (Project element : projects) {
            if (element.getCourse().equals(course)) {
                list.add(element);
            }
        }
        return list;
    }

    Project getProject(Course course, String name) {

        return projects.stream()
                .filter(element -> element.getCourse().equals(course) && element.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
