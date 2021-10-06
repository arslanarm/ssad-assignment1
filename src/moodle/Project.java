package moodle;

import java.util.Objects;

public class Project {
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", task='" + task + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(course, project.course) && Objects.equals(task, project.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, task);
    }

    String name;
    Course course;
    String task;
    Project(String name, Course course, String task) {
        this.name = name;
        this.course = course;
        this.task = task;
    }
}
