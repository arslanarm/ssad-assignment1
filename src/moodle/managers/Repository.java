package moodle.managers;

public class Repository {
    private Repository(){

    }
    public static Repository INSTANCE = new Repository();

    private final AccountManager accountManager = new AccountManager();
    private final CourseManager courseManager = new CourseManager();
    private final ProjectManager projectManager = new ProjectManager();
    private final SubmittedProjectManager submittedProjectManager = new SubmittedProjectManager();

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public SubmittedProjectManager getSubmittedProjectManager() {
        return submittedProjectManager;
    }

}
