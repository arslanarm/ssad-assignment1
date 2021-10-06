package moodle;

import java.util.Objects;

public class Project {
    private final String name;
    private final Course course;
    private final String task;

    Project(String name, Course course, String task) {
        this.name = name;
        this.course = course;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public String getTask() {
        return task;
    }

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
}
