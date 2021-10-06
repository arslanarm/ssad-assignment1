package moodle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class SubmittedProjectManager {

    static SubmittedProjectManager INSTANCE = new SubmittedProjectManager();

    private SubmittedProjectManager() {
    }

   private final List<SubmittedProject> submittedProjects = new ArrayList<>();
    private final HashMap<SubmittedProject, String> feedbackMap = new HashMap<>();
    SubmittedProject createSubmittedProject(Project project, String student, String answer){
        SubmittedProject submittedProject = new SubmittedProject(project, student, answer);
        submittedProjects.add(submittedProject);
        return submittedProject;
    }

    void removeSubmittedProject(SubmittedProject project) {
        submittedProjects.remove(project);
    }

    List<SubmittedProject> getSubmissions(Project project) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project)).collect(Collectors.toList());
    }

    SubmittedProject getSubmission(Project project, String student) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project) && element.getStudent().equals(student)).findFirst().orElseGet(null);
    }
    void updateFeedback(SubmittedProject project,String feedback){
        feedbackMap.put(project,feedback);
    }
    String getFeedback(SubmittedProject project){
        return feedbackMap.get(project);
    }
}
