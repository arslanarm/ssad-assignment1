package moodle.managers;

import moodle.modules.Admin;
import moodle.modules.Instructor;
import moodle.modules.Module;
import moodle.modules.Student;

import java.util.HashMap;
import java.util.Map;


/**
 *  The AccountManager class manages the administrator, instructor, and student entities on the system.
 */
public class AccountManager {

    private final Map<String, Module> modules = new HashMap<>();
    private final HashMap<Module, String> passwords = new HashMap<>();

    AccountManager() {
    }


    /**
     * Method creates a record about the user
     *
     * @param email email of user
     * @param module user object
     * @param password user's password
     */
    private void createModule(String email, Module module, String password) {
        modules.put(email, module);
        passwords.put(module, password);
    }

    /**
     * The method creates a student
     *
     * @param email email of student
     * @param password password of student
     * @return Student
     */
    public Student createStudent(String email, String password) {
        if (emailContain(email)) return null;
        Student student = new Student(email);
        createModule(email, student, password);
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
        if (emailContain(email)) return null;
        Instructor instructor = new Instructor(email);
        createModule(email, instructor, password);
        return instructor;
    }

    /**
     * The method removes student
     *
     * @param student student to remove
     */
    public void removeStudent(Student student) {
        modules.remove(student.getEmail());
    }

    /**
     * The method removes instructor
     *
     * @param instructor instructor to remove
     */
    public void removeInstructor(Instructor instructor) {
        modules.remove(instructor.getEmail());
    }

    /**
     * The method looks for a student in the system
     *
     * @param email email of student
     * @return Student
     */
    public Student getStudent(String email) {
        Module module = modules.get(email);
        if (module instanceof Student) return (Student) module;
        return null;
    }

    /**
     * The method looks for an instructor in the system
     *
     * @param email email of instructor
     * @return Instructor
     */
    public Instructor getInstructor(String email) {
        Module module = modules.get(email);
        if (module instanceof Instructor) return (Instructor) module;
        return null;
    }

    /**
     * The method creates admin
     *
     * @param email email of admin
     * @param password password of admin
     * @return Admin
     */
    public Admin createAdmin(String email, String password) {
        if (emailContain(email)) return null;
        Admin admin = new Admin(email);
        createModule(email, admin, password);
        return admin;
    }

    /**
     * The method removes admin
     *
     * @param admin Admin instance
     */
    public void removeAdmin(Admin admin) {
        modules.remove(admin.getEmail());
    }


    /**
     * The method looks for an admin in the system
     *
     * @param email email of addmin
     * @return Admin
     */
    public Admin getAdmin(String email) {
        Module module = modules.get(email);
        if (module instanceof Admin) return (Admin) module;
        return null;
    }


    /**
     * The method allows the user to log in to the system.
     *
     * @param email email of user
     * @param password password of user
     * @return The module to which the user belongs
     */
    public Module login(String email, String password) {
        Module module = modules.get(email);
        if (module == null) return null;
        if (passwords.get(module).equals(password)) {
            return module;
        } else {
            return null;
        }
    }

    /**
     * The method checks if any user has an email
     *
     * @param email email of user
     * @return True -> one of the users has email / False -> none of the users have an email
     */
    boolean emailContain(String email) {
        return modules.containsKey(email);
    }

}
