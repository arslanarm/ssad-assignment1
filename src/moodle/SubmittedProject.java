package moodle;

import java.util.Objects;

public class SubmittedProject {
    private final Project project;
    private final String student;
    private final String answer;

    SubmittedProject(Project project, String student, String answer) {
        this.project = project;
        this.student = student;
        this.answer = answer;
    }

    public Project getProject() {
        return project;
    }

    public String getStudent() {
        return student;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmittedProject that = (SubmittedProject) o;
        return Objects.equals(project, that.project) && Objects.equals(student, that.student) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, student, answer);
    }

    @Override
    public String toString() {
        return "SubmittedProject{" +
                "project=" + project +
                ", student='" + student + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
