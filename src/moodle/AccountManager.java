package moodle;

import java.util.HashMap;


/**
 *  The AccountManager class manages the administrator, instructor, and student entities on the system.
 */
class AccountManager {
    static AccountManager INSTANCE = new AccountManager();
    private final HashMap<String, Student> students = new HashMap<>();
    private final HashMap<String, Instructor> instructors = new HashMap<>();
    private final HashMap<String, Admin> admins = new HashMap<>();
    private final HashMap<Module, String> passwords = new HashMap<>();

    private AccountManager() {
    }

    /**
     * The method creates a student
     *
     * @param email email of student
     * @param password password of student
     * @return Student
     */
    Student createStudent(String email, String password) {
        if (emailContain(email)) return null;
        Student student = new Student(email);
        students.put(email, student);
        passwords.put(student, password);
        return student;
    }

    /**
     * The method creates instructor
     *
     * @param email email of instructor
     * @param password password of instructor
     * @return Instructor
     */
    Instructor createInstructor(String email, String password) {
        if (emailContain(email)) return null;
        Instructor instructor = new Instructor(email);
        instructors.put(email, instructor);
        passwords.put(instructor, password);
        return instructor;
    }

    /**
     * The method removes student
     *
     * @param student student to remove
     */
    void removeStudent(Student student) {
        students.remove(student.getEmail());
    }

    /**
     * The method removes instructor
     *
     * @param instructor instructor to remove
     */
    void removeInstructor(Instructor instructor) {
        instructors.remove(instructor.getEmail());
    }

    /**
     * The method looks for a student in the system
     *
     * @param email email of student
     * @return Student
     */
    Student getStudent(String email) {
        return students.get(email);
    }

    /**
     * The method looks for an instructor in the system
     *
     * @param email email of instructor
     * @return Instructor
     */
    Instructor getInstructor(String email) {
        return instructors.get(email);
    }

    /**
     * The method creates admin
     *
     * @param email email of admin
     * @param password password of admin
     * @return Admin
     */
    Admin createAdmin(String email, String password) {
        if (emailContain(email)) return null;
        Admin admin = new Admin(email);
        admins.put(email, admin);
        passwords.put(admin, password);
        return admin;
    }

    /**
     * The method removes admin
     *
     * @param admin Admin instance
     */
    void removeAdmin(Admin admin) {
        admins.remove(admin.getEmail());
    }


    /**
     * The method looks for an admin in the system
     *
     * @param email email of addmin
     * @return Admin
     */
    Admin getAdmin(String email) {
        return admins.get(email);
    }


    /**
     * The method allows the user to log in to the system.
     *
     * @param email email of user
     * @param password password of user
     * @return The module to which the user belongs
     */
    Module login(String email, String password) {
        Module module = getStudent(email);
        if (module == null) {
            module = getInstructor(email);
        }
        if (module == null) {
            module = getAdmin(email);
        }
        if (module == null) return null;

        if (passwords.get(module) == password) {
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
        return students.containsKey(email) || instructors.containsKey(email) || admins.containsKey(email);
    }

}
