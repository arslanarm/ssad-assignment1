package moodle.datatypes;

import java.util.Objects;

/**
 * Project class provides the main functionality for monitoring projects in the system
 */
public class Project {
    private final String name;
    private final Course course;
    private final String task;

    public Project(String name, Course course, String task) {
        this.name = name;
        this.course = course;
        this.task = task;
    }

    /**
     * @return project name
     */
    public String getName() {
        return name;
    }

    /**
     * @return project course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return project task
     */
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
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(course, project.course) && Objects.equals(task, project.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, task);
    }
}
