package moodle;

import java.util.ArrayList;
import java.util.List;

class CourseManager {
    static CourseManager INSTANCE = new CourseManager();
    private CourseManager() {}

    private List<Course> courses;

    Course createCourse(String instructor, List<String> students, String name){
        return new Course(instructor, students, name);
    }
    List<Course> getCourses(){
        return this.courses;
    }

    List<Course> getCoursesByInstructor(String instructor){
        List<Course> temp = new ArrayList<>();
        for (Course course:
             courses) {
            if (course.getInstructor().equals(instructor)){
                temp.add(course);
            }
        }
        return temp;
    }

    List<Course> getCoursesByStudent(String student){
        List<Course> temp = new ArrayList<>();
        for (Course course:
                courses) {
            if (course.getStudents().contains(student)){
                temp.add(course);
            }
        }
        return temp;
    }

    Course getCourseByName(String name){
        for (Course course:
                courses) {
            if (course.getName().equals(name)){
                return course;
            }
        }
        return null;
    }

    void removeCourse(String name){
        courses.removeIf(course -> course.getName().equals(name));
    }
}
