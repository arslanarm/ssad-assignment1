package moodle;

import java.util.ArrayList;
import java.util.List;

class ProjectManager {
    static ProjectManager INSTANCE = new ProjectManager();

    private ProjectManager() {
    }

    List<Project> projects = new ArrayList<>();

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
            if (element.course == course) {
                list.add(element);
            }
        }
        return list;
    }

    Project getProject(Course course, String name) {

        return projects.stream()
                .filter(element -> element.course == course && element.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
