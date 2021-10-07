package moodle;

import java.util.List;
import java.util.Objects;

/**
 * The Admin class includes the main functionality of the Admin module like creating accounts for students and
 * instructors, creating the curriculum.
 */
public class Admin implements Module {
    private final String email;

    Admin(String email) {
        this.email = email;
    }

    /**
     * The method provides a login for the administrator
     *
     * @param email email of admin
     * @param password password of admin
     * @return Admin module/None
     */
    public static Admin login(String email, String password) {
        Module module = AccountManager.INSTANCE.login(email, password);
        if (module instanceof Admin) {
            return (Admin) module;
        }
        return null;
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
        Admin admin = (Admin) o;
        return Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    // -------------Creators---------------
    /**
     * The method creates student
     *
     * @param email email of student
     * @param password password of student
     * @return Student
     */
    public Student createStudent(String email, String password) {
        return AccountManager.INSTANCE.createStudent(email, password);
    }

    /**
     * The method creates instructor
     *
     * @param email email of instructor
     * @param password password of instructor
     * @return Instructor
     */
    public Instructor createInstructor(String email, String password) {
        return AccountManager.INSTANCE.createInstructor(email, password);
    }

    /**
     * The method creates course
     *
     * @param name name of the course
     * @param instructorEmail email of instructor
     * @param students list of students fot that course
     * @return Course
     */
    public Course createCourse(String name, String instructorEmail, List<String> students) {
        return CourseManager.INSTANCE.createCourse(instructorEmail, students, name);
    }

    // -------------Getters---------------
    /**
     * The method find and return student
     *
     * @param email email of student
     * @return Student
     */
    public Student getStudent(String email) {
        return AccountManager.INSTANCE.getStudent(email);
    }

    /**
     * The method find and return instructor
     *
     * @param email eamil of instructor
     * @return Instructor
     */
    public Instructor getInstructor(String email) {
        return AccountManager.INSTANCE.getInstructor(email);
    }

    /**
     * The method find and return course
     *
     * @param name name of course
     * @return Course
     */
    public Course getCourse(String name) {
        return CourseManager.INSTANCE.getCourseByName(name);
    }

    // -------------Removers---------------
    /**
     * The method removes student
     *
     * @param email email of student
     */
    public void removeStudent(String email) {
        AccountManager.INSTANCE.removeStudent(AccountManager.INSTANCE.getStudent(email));
    }

    /**
     * The method removes instructor
     *
     * @param email email of instructor
     */
    public void removeInstructor(String email) {
        AccountManager.INSTANCE.removeInstructor(AccountManager.INSTANCE.getInstructor(email));
    }

    /**
     * The method removes course
     *
     * @param name name of course
     */
    public void removeCourse(String name) {
        CourseManager.INSTANCE.removeCourse(name);
    }

    public String getEmail() {
        return email;
    }
}
