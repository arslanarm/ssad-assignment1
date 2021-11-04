package moodle.managers.abstractions;

import moodle.modules.Admin;
import moodle.modules.Instructor;
import moodle.modules.Module;
import moodle.modules.Student;

public interface AccountManager {
    /**
     * The method creates a student
     *
     * @param email email of student
     * @param password password of student
     * @return Student
     */
    public Student createStudent(String email, String password);

    /**
     * The method creates instructor
     *
     * @param email email of instructor
     * @param password password of instructor
     * @return Instructor
     */
    public Instructor createInstructor(String email, String password);

    /**
     * The method removes student
     *
     * @param student student to remove
     */
    public void removeStudent(Student student);

    /**
     * The method removes instructor
     *
     * @param instructor instructor to remove
     */
    public void removeInstructor(Instructor instructor);

    /**
     * The method looks for a student in the system
     *
     * @param email email of student
     * @return Student
     */
    public Student getStudent(String email);

    /**
     * The method looks for an instructor in the system
     *
     * @param email email of instructor
     * @return Instructor
     */
    public Instructor getInstructor(String email);

    /**
     * The method creates admin
     *
     * @param email email of admin
     * @param password password of admin
     * @return Admin
     */
    public Admin createAdmin(String email, String password);

    /**
     * The method removes admin
     *
     * @param admin Admin instance
     */
    public void removeAdmin(Admin admin);


    /**
     * The method looks for an admin in the system
     *
     * @param email email of addmin
     * @return Admin
     */
    public Admin getAdmin(String email);


    /**
     * The method allows the user to log in to the system.
     *
     * @param email email of user
     * @param password password of user
     * @return The module to which the user belongs
     */
    public Module login(String email, String password);
}
