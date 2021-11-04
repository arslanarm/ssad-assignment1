package moodle.managers;

import moodle.datatypes.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseManager {
    /**
     * The method creates course
     *
     * @param instructor instructor name
     * @param students list of students
     * @param name name of the course
     * @return Course
     */
    public Course createCourse(String instructor, List<String> students, String name);

    /**
     * @return all courses
     */
    List<Course> getCourses();

    /**
     * @param instructor instructor name
     * @return all courses with that instructor
     */
    public List<Course> getCoursesByInstructor(String instructor);

    /**
     * @param student student name
     * @return all courses with that student
     */
    public List<Course> getCoursesByStudent(String student);

    /**
     * @param name course name
     * @return Course
     */
    public Course getCourseByName(String name);

    /**
     * The method removes course
     *
     * @param name course name
     */
    public void removeCourse(String name);
}
