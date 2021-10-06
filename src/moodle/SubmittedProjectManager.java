package moodle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubmittedProjectManager {

    static SubmittedProjectManager INSTANCE = new SubmittedProjectManager();

    private SubmittedProjectManager() {
    }

    List<SubmittedProject> submittedProjects = new ArrayList<>();

    SubmittedProject createSubmittedProject(Project project, String student, String answer){
        SubmittedProject submittedProject = new SubmittedProject(project, student, answer);
        submittedProjects.add(submittedProject);
        return submittedProject;
    }

    void removeSubmittedProject(SubmittedProject project) {
        submittedProjects.remove(project);
    }

    List<SubmittedProject> getSubmissions(Project project) {
        return submittedProjects.stream().filter(element -> element.project.equals(project)).collect(Collectors.toList());
    }

    SubmittedProject getSubmission(Project project, String student) {
        return submittedProjects.stream().filter(element -> element.project.equals(project) && element.student.equals(student)).findFirst().orElseGet(null);
    }
}
