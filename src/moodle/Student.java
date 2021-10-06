package moodle;

import java.util.ArrayList;
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
        return CourseManager.INSTANCE.getCoursesByStudent(email);
    }
    public List<Project> getProjects(Course course){
        return ProjectManager.INSTANCE.getProjects(course);
    }
    public SubmittedProject submitProject(Project project, String answer){
        return SubmittedProjectManager.INSTANCE.createSubmittedProject(project,email,answer);
    }
    public String getFeedback(SubmittedProject project){
        return SubmittedProjectManager.INSTANCE.getFeedback(project);
    }
    public List<SubmittedProject> getSubmittedProjects(Course course){
        List<SubmittedProject> projects = new ArrayList<>();
        for(Project project : ProjectManager.INSTANCE.getProjects(course)){
            projects.add(SubmittedProjectManager.INSTANCE.getSubmission(project, email));
        }
        return projects;
    }
    Student(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
