package moodle.managers.abstractions;

import moodle.datatypes.Project;
import moodle.datatypes.SubmittedProject;

import java.util.List;
import java.util.stream.Collectors;

public interface SubmittedProjectManager {
    /**
     * The method creates submitted project
     *
     * @param project project
     * @param student project student
     * @param answer project answer
     * @return Submitted Project
     */
    public SubmittedProject createSubmittedProject(Project project, String student, String answer);

    /**
     * The method removes submitted project
     *
     * @param project project to remove
     */
    void removeSubmittedProject(SubmittedProject project);

    /**
     * The method find submissions for specific project
     *
     * @param project project
     * @return list of submitted projects
     */
    public List<SubmittedProject> getSubmissions(Project project);

    /**
     * The mehod find submission of the student for the project
     *
     * @param project project
     * @param student student
     * @return  Submitted Project
     */
    public SubmittedProject getSubmission(Project project, String student);

    /**
     * The method updates feedback
     *
     * @param project project for updating the feedback
     * @param feedback new feedback
     */
    public void updateFeedback(SubmittedProject project, String feedback);

    /**
     * @param project project for feedback
     * @return feedback
     */
    public String getFeedback(SubmittedProject project);

    /**
     * This method allows to undo the submission of the project,
     * bringing it to the initial from taken from snapshot
     *
     * @param submittedProject project to be edited
     * @return new submittedProject object generated from snapshot
     */
    public SubmittedProject undoSubmission(SubmittedProject submittedProject);

    /**
     * This method allows to alter the answer of the submitted project
     *
     * @param submittedProject project to be edited
     * @param answer answer that will replace previous answer
     * @return new object with given answer
     */
    public SubmittedProject editSubmission(SubmittedProject submittedProject, String answer);
}
