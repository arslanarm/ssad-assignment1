package moodle.managers.in_memory;

import moodle.datatypes.Course;
import moodle.managers.abstractions.CourseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * The CourseManager class includes functionality for managing courses.
 */
public class CourseManagerImpl implements CourseManager {

    private final List<Course> courses = new ArrayList<>();

    public CourseManagerImpl() {
    }

    /**
     * The method creates course
     *
     * @param instructor instructor name
     * @param students list of students
     * @param name name of the course
     * @return Course
     */
    @Override
    public Course createCourse(String instructor, List<String> students, String name) {
        Course course = new Course(instructor, students, name);
        courses.add(course);
        return course;
    }

    /**
     * @return all courses
     */
    @Override
    public List<Course> getCourses() {
        return this.courses;
    }

    /**
     * @param instructor instructor name
     * @return all courses with that instructor
     */
    @Override
    public List<Course> getCoursesByInstructor(String instructor) {
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
    @Override
    public List<Course> getCoursesByStudent(String student) {
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
    @Override
    public Course getCourseByName(String name) {
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
    @Override
    public void removeCourse(String name) {
        courses.removeIf(course -> course.getName().equals(name));
    }
}
