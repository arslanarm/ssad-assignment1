package moodle.managers;

import moodle.managers.abstractions.AccountManager;
import moodle.managers.abstractions.CourseManager;
import moodle.managers.abstractions.ProjectManager;
import moodle.managers.abstractions.SubmittedProjectManager;
import moodle.managers.in_memory.AccountManagerImpl;
import moodle.managers.in_memory.CourseManagerImpl;
import moodle.managers.in_memory.ProjectManagerImpl;
import moodle.managers.in_memory.SubmittedProjectManagerImpl;

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
