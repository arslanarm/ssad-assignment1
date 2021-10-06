package moodle;

import java.util.List;
import java.util.Objects;

public class Admin implements Module {
    private final String email;

    Admin(String email) {
        this.email = email;
    }

    public static Admin login(String email, String password) {
        Module module = AccountManager.INSTANCE.login(email, password);
        if (module instanceof Admin) {
            return (Admin) module;
        }
        return null;
    }

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
    public Student createStudent(String email, String password) {
        return AccountManager.INSTANCE.createStudent(email, password);
    }

    public Instructor createInstructor(String email, String password) {
        return AccountManager.INSTANCE.createInstructor(email, password);
    }

    public Course createCourse(String name, String instructorEmail, List<String> students) {
        return CourseManager.INSTANCE.createCourse(instructorEmail, students, name);
    }

    // -------------Getters---------------
    public Student getStudent(String email) {
        return AccountManager.INSTANCE.getStudent(email);
    }

    public Instructor getInstructor(String email) {
        return AccountManager.INSTANCE.getInstructor(email);
    }

    public Course getCourse(String name) {
        return CourseManager.INSTANCE.getCourseByName(name);
    }

    // -------------Removers---------------
    public void removeStudent(String email) {
        AccountManager.INSTANCE.removeStudent(AccountManager.INSTANCE.getStudent(email));
    }

    public void removeInstructor(String email) {
        AccountManager.INSTANCE.removeInstructor(AccountManager.INSTANCE.getInstructor(email));
    }

    public void removeCourse(String name) {
        CourseManager.INSTANCE.removeCourse(name);
    }

    public String getEmail() {
        return email;
    }
}
