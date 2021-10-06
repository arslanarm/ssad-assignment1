package moodle;

import java.util.List;
import java.util.Objects;

public class Course {
    private final String instructor;
    private final List<String> students;
    private final String name;

    Course(String instructor, List<String> students, String name) {
        this.instructor = instructor;
        this.students = students;
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

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

    public String getName() {
        return name;
    }

}
