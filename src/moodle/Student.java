package moodle;

import java.util.List;

public class Student implements Module {
    private final String email;
    public static Student login(String email, String password) {
        Module module = AccountManager.INSTANCE.login(email,password);
        if(module instanceof Student){
            return (Student) module;
        }
        return null;
    }
    public List<Course> getCourses(){
        return null;
    }
    public List<Project> getProjects(Course course){
        return null;
    }
    public SubmittedProject submitProject(Project project, String answer){
        return null;
    }
    public String getFeedback(SubmittedProject project){
        return null;
    }
    public List<SubmittedProject> getSubmittedProject(){
        return null;
    }
    Student(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
