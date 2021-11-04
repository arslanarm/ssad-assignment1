package moodle.managers;

public class Repository {
    private Repository(){

    }
    public static Repository INSTANCE = new Repository();

    private final AccountManager accountManager = new AccountManagerImpl();
    private final CourseManager courseManager = new CourseManagerImpl();
    private final ProjectManager projectManager = new ProjectManagerImpl();
    private final SubmittedProjectManager submittedProjectManager = new SubmittedProjectManagerImpl();

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
