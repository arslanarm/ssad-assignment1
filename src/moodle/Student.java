package moodle;

import java.util.List;

public class Student implements Module {
    private final String email;
    public static Student login() {
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
    public Feedback getFeedback(SubmittedProject project){
        return null;
    }
    public List<SubmitedProject> getSubmittedProject(){
        return null;
    }
    Student(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
