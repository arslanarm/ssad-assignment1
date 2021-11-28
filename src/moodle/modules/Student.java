package moodle.modules;

import moodle.datatypes.Course;
import moodle.datatypes.Project;
import moodle.datatypes.SubmittedProject;
import moodle.managers.*;
import moodle.managers.abstractions.AccountManager;
import moodle.managers.abstractions.CourseManager;
import moodle.managers.abstractions.ProjectManager;
import moodle.managers.abstractions.SubmittedProjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Module {
    private final String email;

    public Student(String email) {
        this.email = email;
    }

    /**
     * The method allows the student to log in to the system.
     *
     * @param email    student email
     * @param password student password
     * @return Student module / none
     */
    public static Student login(String email, String password) {
        Module module = Repository.INSTANCE.getAccountManager().login(email, password);
        if (module instanceof Student) {
            return (Student) module;
        }
        return null;
    }

    /**
     * Method checks equality of 2 objects
     *
     * @param o Object to test for equality
     * @return Equality of objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                '}';
    }

    /**
     * @return List of the courses
     */
    public List<Course> getCourses() {
        return Repository.INSTANCE.getCourseManager().getCoursesByStudent(email);
    }

    /**
     * The method find and returns projects of the course
     *
     * @param course Curse of the projects
     * @return list of projects
     */
    public List<Project> getProjects(Course course) {
        return Repository.INSTANCE.getProjectManager().getProjects(course);
    }

    /**
     * The method allow submitting project
     *
     * @param project Project for submitting
     * @param answer  Answer of the project
     * @return Submitted Project
     */
    public SubmittedProject submitProject(Project project, String answer) {
        return Repository.INSTANCE.getSubmittedProjectManager().createSubmittedProject(project, email, answer);
    }

    /**
     * The method returns feedback of the project
     *
     * @param project Project for feedback
     * @return Feedback of the project
     */
    public String getFeedback(SubmittedProject project) {
        return Repository.INSTANCE.getSubmittedProjectManager().getFeedback(project);
    }

    /**
     * The method find all projects of the course for the student
     *
     * @param course course of the projects
     * @return list of the submitted projects
     */
    public List<SubmittedProject> getSubmittedProjects(Course course) {
        List<SubmittedProject> projects = new ArrayList<>();
        for (Project project : Repository.INSTANCE.getProjectManager().getProjects(course)) {
            projects.add(Repository.INSTANCE.getSubmittedProjectManager().getSubmission(project, email));
        }
        return projects;
    }

    /**
     * The method removes project of the course for the student
     *
     * @param submittedProject project to remove
     */
    public void removeSubmittedProject(SubmittedProject submittedProject) {
        Repository.INSTANCE.getSubmittedProjectManager().removeSubmittedProject(submittedProject);
    }


    /**
     * The method changes answer of submitted project for the student
     *
     * @param submittedProject project to alter
     * @param answer new answer
     * @return edited submittedProject object
     */
    public SubmittedProject editSubmittedProject(SubmittedProject submittedProject, String answer) {
        return Repository.INSTANCE.getSubmittedProjectManager().editSubmission(submittedProject, answer);

    }


    /**
     * The method recovers the initial version of submitted project from snapshot
     *
     * @param submittedProject project to undo
     * @return recovered submittedProject object
     */
    public SubmittedProject undo(SubmittedProject submittedProject) {
        return Repository.INSTANCE.getSubmittedProjectManager().undoSubmission(submittedProject);
    }

    /**
     * @return email of the student
     */
    @Override
    public String getEmail() {
        return email;
    }
}
