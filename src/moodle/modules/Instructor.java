package moodle.modules;

import moodle.datatypes.Course;
import moodle.datatypes.Project;
import moodle.datatypes.SubmittedProject;
import moodle.managers.*;
import moodle.managers.abstractions.AccountManager;
import moodle.managers.abstractions.CourseManager;
import moodle.managers.abstractions.ProjectManager;
import moodle.managers.abstractions.SubmittedProjectManager;

import java.util.List;
import java.util.Objects;

/**
 * The Instructor class provides functionality for controlling the actions of the instructor
 */
public class Instructor implements Module {
    private final String email;

    public Instructor(String email) {
        this.email = email;
    }

    /**
     * The method allows the instructor to log in to the system.
     *
     * @param email instructor email
     * @param password instructor password
     * @return module of instructor or none
     */
    public static Instructor login(String email, String password) {
        Module module = Repository.INSTANCE.getAccountManager().login(email, password);
        if (module instanceof Instructor) {
            return (Instructor) module;
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
        Instructor that = (Instructor) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "email='" + email + '\'' +
                '}';
    }

    /***
     * @return courses list
     */
    public List<Course> getCourses() {
        return Repository.INSTANCE.getCourseManager().getCoursesByInstructor(email);
    }

    /**
     * The method allow user upload project to the course
     *
     * @param course Course of the project
     * @param name project name
     * @param task task
     * @return Project
     */
    public Project uploadProject(Course course, String name, String task) {
        return Repository.INSTANCE.getProjectManager().createProject(name, course, task);
    }

    /**
     * The method find all submissions of specific project
     *
     * @param project original projects
     * @return list of submitted projects
     */
    public List<SubmittedProject> getSubmittedProjects(Project project) {
        return Repository.INSTANCE.getSubmittedProjectManager().getSubmissions(project);
    }


    /**
     * The method uploads feedback for the project
     *
     * @param project project for feedback
     * @param feedback feedback for the project
     */
    public void uploadFeedback(SubmittedProject project, String feedback) {
        Repository.INSTANCE.getSubmittedProjectManager().updateFeedback(project, feedback);
    }

    /**
     * @return instructor email
     */
    @Override
    public String getEmail() {
        return email;
    }
}
