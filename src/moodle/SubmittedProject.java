package moodle;

public class SubmittedProject {
    Project project;
    String student;
    String answer;
    SubmittedProject(Project project, String student, String answer){
        this.project=project;
        this.student=student;
        this.answer=answer;
    }
}
