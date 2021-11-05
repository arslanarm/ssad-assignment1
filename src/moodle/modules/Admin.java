package moodle.modules;

import moodle.datatypes.Course;
import moodle.managers.*;
import moodle.managers.abstractions.AccountManager;
import moodle.managers.abstractions.CourseManager;
import moodle.managers.abstractions.ProjectManager;
import moodle.managers.abstractions.SubmittedProjectManager;

import java.util.List;
import java.util.Objects;

/**
 * The Admin class includes the main functionality of the Admin module like creating accounts for students and
 * instructors, creating the curriculum.
 */
public class Admin implements Module {
    private final String email;

    public Admin(String email) {
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
        Module module = Repository.INSTANCE.getAccountManager().login(email, password);
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
        Student student = new Student(email);
        Repository.INSTANCE.getAccountManager().createModule(email, student, password);
        return student;
    }

    /**
     * The method creates instructor
     *
     * @param email email of instructor
     * @param password password of instructor
     * @return Instructor
     */
    public Instructor createInstructor(String email, String password) {
        Instructor instructor = new Instructor(email);
        Repository.INSTANCE.getAccountManager().createModule(email, instructor, password);
        return instructor;
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
        return Repository.INSTANCE.getCourseManager().createCourse(instructorEmail, students, name);
    }

    // -------------Getters---------------
    /**
     * The method find and return student
     *
     * @param email email of student
     * @return Student
     */
    public Student getStudent(String email) {
        Module module = Repository.INSTANCE.getAccountManager().getModule(email);
        if (module instanceof Student) return (Student) module;
        return null;
    }

    /**
     * The method find and return instructor
     *
     * @param email eamil of instructor
     * @return Instructor
     */
    public Instructor getInstructor(String email) {
        Module module = Repository.INSTANCE.getAccountManager().getModule(email);
        if (module instanceof Instructor) return (Instructor) module;
        return null;
    }

    /**
     * The method find and return course
     *
     * @param name name of course
     * @return Course
     */
    public Course getCourse(String name) {
        return Repository.INSTANCE.getCourseManager().getCourseByName(name);
    }

    // -------------Removers---------------
    /**
     * The method removes student
     *
     * @param email email of student
     */
    public void removeStudent(String email) {
        Module module = Repository.INSTANCE.getAccountManager().getModule(email);
        if (!(module instanceof Student)) return;
        Repository.INSTANCE.getAccountManager().removeModule(module);
    }

    /**
     * The method removes instructor
     *
     * @param email email of instructor
     */
    public void removeInstructor(String email) {
        Module module = Repository.INSTANCE.getAccountManager().getModule(email);
        if (!(module instanceof Instructor)) return;
        Repository.INSTANCE.getAccountManager().removeModule(module);
    }

    /**
     * The method removes course
     *
     * @param name name of course
     */
    public void removeCourse(String name) {
        Repository.INSTANCE.getCourseManager().removeCourse(name);
    }

    @Override
    public String getEmail() {
        return email;
    }
}
