package moodle;

import java.util.List;

public class Instructor implements Module {
    private final String email;
    public static Instructor login(String email, String password){
        Module module = AccountManager.INSTANCE.login(email,password);
        if(module instanceof Instructor){
            return (Instructor) module;
        }
        return null;
    }
    public List<Course> getCourses(){
        return list;
    }
    public void uploadProject(Course course, Project project){

    }
    public List<SubmittedProject> getSubmittedProjects(Project project){
        return submittedProjects;
    }
    public void uploadFeedback(SubmittedProject project, Feedback feedback){

    }
    Instructor(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
