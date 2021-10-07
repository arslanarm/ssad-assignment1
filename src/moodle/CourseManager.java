package moodle;

import java.util.ArrayList;
import java.util.List;

/**
 * The CourseManager class includes functionality for managing courses.
 */
class CourseManager {
    static CourseManager INSTANCE = new CourseManager();
    private final List<Course> courses = new ArrayList<>();

    private CourseManager() {
    }

    /**
     * The method creates course
     *
     * @param instructor instructor name
     * @param students list of students
     * @param name name of the course
     * @return Course
     */
    Course createCourse(String instructor, List<String> students, String name) {
        Course course = new Course(instructor, students, name);
        courses.add(course);
        return course;
    }

    /**
     * @return all courses
     */
    List<Course> getCourses() {
        return this.courses;
    }

    /**
     * @param instructor instructor name
     * @return all courses with that instructor
     */
    List<Course> getCoursesByInstructor(String instructor) {
        List<Course> temp = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor().equals(instructor)) {
                temp.add(course);
            }
        }
        return temp;
    }

    /**
     * @param student student name
     * @return all courses with that student
     */
    List<Course> getCoursesByStudent(String student) {
        List<Course> temp = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStudents().contains(student)) {
                temp.add(course);
            }
        }
        return temp;
    }

    /**
     * @param name course name
     * @return Course
     */
    Course getCourseByName(String name) {
        for (Course course :
                courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    /**
     * The method removes course
     *
     * @param name course name
     */
    void removeCourse(String name) {
        courses.removeIf(course -> course.getName().equals(name));
    }
}
