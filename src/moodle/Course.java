package moodle;

import java.util.List;
import java.util.Objects;

/**
 * Course class provides functionality for managing course content.
 */
public class Course {
    private final String instructor;
    private final List<String> students;
    private final String name;

    Course(String instructor, List<String> students, String name) {
        this.instructor = instructor;
        this.students = students;
        this.name = name;
    }

    /**
     * @return Instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @return list of names
     */
    public List<String> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "instructor='" + instructor + '\'' +
                ", students=" + students +
                ", name='" + name + '\'' +
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
        Course course = (Course) o;
        return Objects.equals(instructor, course.instructor) && Objects.equals(students, course.students) && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructor, students, name);
    }

    /**
     * @return Course name
     */
    public String getName() {
        return name;
    }

}
