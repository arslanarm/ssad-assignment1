package moodle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SubmittedProject class provides basic functionality for managing submitted projects
 */
class SubmittedProjectManager {

    static SubmittedProjectManager INSTANCE = new SubmittedProjectManager();
    private final List<SubmittedProject> submittedProjects = new ArrayList<>();
    private final HashMap<SubmittedProject, String> feedbackMap = new HashMap<>();
    private SubmittedProjectManager() {
    }

    /**
     * The method creates submitted project
     *
     * @param project project
     * @param student project student
     * @param answer project answer
     * @return Submitted Project
     */
    SubmittedProject createSubmittedProject(Project project, String student, String answer) {
        SubmittedProject submittedProject = new SubmittedProject(project, student, answer);
        submittedProjects.add(submittedProject);
        return submittedProject;
    }

    /**
     * The method removes submitted project
     *
     * @param project project to remove
     */
    void removeSubmittedProject(SubmittedProject project) {
        submittedProjects.remove(project);
    }

    /**
     * The method find submissions for specific project
     *
     * @param project project
     * @return list of submitted projects
     */
    List<SubmittedProject> getSubmissions(Project project) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project)).collect(Collectors.toList());
    }

    /**
     * The mehod find submission of the student for the project
     *
     * @param project project
     * @param student student
     * @return  Submitted Project
     */
    SubmittedProject getSubmission(Project project, String student) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project) && element.getStudent().equals(student)).findFirst().orElseGet(null);
    }

    /**
     * The method updates feedback
     *
     * @param project project for updating the feedback
     * @param feedback new feedback
     */
    void updateFeedback(SubmittedProject project, String feedback) {
        feedbackMap.put(project, feedback);
    }

    /**
     * @param project project for feedback
     * @return feedback
     */
    String getFeedback(SubmittedProject project) {
        return feedbackMap.get(project);
    }
}
