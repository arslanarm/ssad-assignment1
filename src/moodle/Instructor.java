package moodle;

import java.util.List;

public class Instructor implements Module {
    private final String email;

    public static Instructor login(String email, String password) {
        Module module = AccountManager.INSTANCE.login(email, password);
        if (module instanceof Instructor) {
            return (Instructor) module;
        }
        return null;
    }

    public List<Course> getCourses() {
        return CourseManager.INSTANCE.getCoursesByInstructor(email);
    }

    public void uploadProject(Course course, String name, String task) {
        ProjectManager.INSTANCE.createProject(name, course, task);
    }

    public List<SubmittedProject> getSubmittedProjects(Project project) {
        return SubmittedProjectManager.INSTANCE.getSubmissions(project);
    }

    public void uploadFeedback(SubmittedProject project, String feedback) {
        SubmittedProjectManager.INSTANCE.updateFeedback(project,feedback);
    }

    Instructor(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
