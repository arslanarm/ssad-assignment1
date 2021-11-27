package moodle.datatypes;

import java.util.Objects;

/**
 * SubmittedProject class provides basic functionality for managing submitted project
 */
public class SubmittedProject {
    private final Project project;
    private final String student;
    private final String answer;

    public SubmittedProject(Project project, String student, String answer) {
        this.project = project;
        this.student = student;
        this.answer = answer;
    }

    /**
     * @return project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @return student of the project
     */
    public String getStudent() {
        return student;
    }

    /**
     * @return answer of the project
     */
    public String getAnswer() {
        return answer;
    }



    /**
     * Method checks equality of 2 objects
     *
     * @param o Object to test for equality
     * @return Equality of objects
     */
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

    public Snapshot createSnapshot() {
        return new Snapshot(this);
    }

    public static class Snapshot {
        private final Project project;
        private final String student;
        private final String answer;
        Snapshot(SubmittedProject submittedProject) {
            this.project = submittedProject.project;
            this.student = submittedProject.student;
            this.answer = submittedProject.answer;
        }

        public SubmittedProject getSubmittedProject() {
            return new SubmittedProject(
                    project,
                    student,
                    answer
            );
        }
    }
}
