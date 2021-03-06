package moodle.managers.in_memory;

import moodle.datatypes.Project;
import moodle.datatypes.SubmittedProject;
import moodle.managers.abstractions.SubmittedProjectManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SubmittedProject class provides basic functionality for managing submitted projects
 */
public class SubmittedProjectManagerImpl implements SubmittedProjectManager {

    private final List<SubmittedProject> submittedProjects = new ArrayList<>();
    private final HashMap<SubmittedProject, String> feedbackMap = new HashMap<>();
    private final HashMap<SubmittedProject, SubmittedProject.Snapshot> snapshotMap = new HashMap<>();

    public SubmittedProjectManagerImpl() {
    }

    /**
     * The method creates submitted project
     *
     * @param project project
     * @param student project student
     * @param answer project answer
     * @return Submitted Project
     */
    @Override
    public SubmittedProject createSubmittedProject(Project project, String student, String answer) {
        SubmittedProject submittedProject = new SubmittedProject(project, student, answer);
        submittedProjects.add(submittedProject);
        return submittedProject;
    }

    /**
     * The method removes submitted project
     *
     * @param project project to remove
     */
    @Override
    public void removeSubmittedProject(SubmittedProject project) {
        submittedProjects.remove(project);
    }

    /**
     * The method find submissions for specific project
     *
     * @param project project
     * @return list of submitted projects
     */
    @Override
    public List<SubmittedProject> getSubmissions(Project project) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project)).collect(Collectors.toList());
    }

    /**
     * The mehod find submission of the student for the project
     *
     * @param project project
     * @param student student
     * @return  Submitted Project
     */
    @Override
    public SubmittedProject getSubmission(Project project, String student) {
        return submittedProjects.stream().filter(element -> element.getProject().equals(project) && element.getStudent().equals(student)).findFirst().orElseGet(null);
    }

    /**
     * The method updates feedback
     *
     * @param project project for updating the feedback
     * @param feedback new feedback
     */
    @Override
    public void updateFeedback(SubmittedProject project, String feedback) {
        feedbackMap.put(project, feedback);
    }

    /**
     * @param project project for feedback
     * @return feedback
     */
    @Override
    public String getFeedback(SubmittedProject project) {
        return feedbackMap.get(project);
    }

    /**
     * This method allows to alter the answer of the submitted project
     *
     * @param submittedProject project to be edited
     * @param answer answer that will replace previous answer
     * @return new object with given answer
     */
    @Override
    public SubmittedProject editSubmission(SubmittedProject submittedProject, String answer){
        SubmittedProject.Snapshot snapshot = submittedProject.createSnapshot();
        this.submittedProjects.remove(submittedProject);
        SubmittedProject newProject = new SubmittedProject(submittedProject.getProject(), submittedProject.getStudent(), answer);
        this.submittedProjects.add(newProject);
        snapshotMap.put(newProject, snapshot);
        return newProject;
    }


    /**
     * This method allows to undo the submission of the project,
     * bringing it to the initial from taken from snapshot
     *
     * @param submittedProject project to be edited
     * @return new submittedProject object generated from snapshot
     */
    @Override
    public SubmittedProject undoSubmission(SubmittedProject submittedProject){
        if (!snapshotMap.containsKey(submittedProject)){
            return submittedProject;
        }
        this.submittedProjects.remove(submittedProject);
        SubmittedProject project = snapshotMap.get(submittedProject).getSubmittedProject();
        this.submittedProjects.add(project);
        snapshotMap.remove(submittedProject);
        return project;
    }
}
