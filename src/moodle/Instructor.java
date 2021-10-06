package moodle;

import java.util.List;
import java.util.Objects;

public class Instructor implements Module {
    private final String email;

    Instructor(String email) {
        this.email = email;
    }

    public static Instructor login(String email, String password) {
        Module module = AccountManager.INSTANCE.login(email, password);
        if (module instanceof Instructor) {
            return (Instructor) module;
        }
        return null;
    }

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

    public List<Course> getCourses() {
        return CourseManager.INSTANCE.getCoursesByInstructor(email);
    }

    public Project uploadProject(Course course, String name, String task) {
        return ProjectManager.INSTANCE.createProject(name, course, task);
    }

    public List<SubmittedProject> getSubmittedProjects(Project project) {
        return SubmittedProjectManager.INSTANCE.getSubmissions(project);
    }

    public void uploadFeedback(SubmittedProject project, String feedback) {
        SubmittedProjectManager.INSTANCE.updateFeedback(project, feedback);
    }

    public String getEmail() {
        return email;
    }
}
