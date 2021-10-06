package moodle;

import java.util.HashMap;

class AccountManager implements Module {
    static AccountManager INSTANCE = new AccountManager();
    private final HashMap<String, Student> students = new HashMap<>();
    private final HashMap<String, Instructor> instructors = new HashMap<>();
    private final HashMap<String, Admin> admins = new HashMap<>();
    private final HashMap<Module, String> passwords = new HashMap<>();

    private AccountManager() {
    }

    Student createStudent(String email, String password) {
        if (emailContain(email)) return null;
        Student student = new Student(email);
        students.put(email, student);
        passwords.put(student, password);
        return student;
    }

    Instructor createInstructor(String email, String password) {
        if (emailContain(email)) return null;
        Instructor instructor = new Instructor(email);
        instructors.put(email, instructor);
        passwords.put(instructor, password);
        return instructor;
    }

    void removeStudent(Student student) {
        students.remove(student.getEmail());
    }

    void removeInstructor(Instructor instructor) {
        instructors.remove(instructor.getEmail());
    }

    Student getStudent(String email) {
        return students.get(email);
    }

    Instructor getInstructor(String email) {
        return instructors.get(email);
    }

    Admin createAdmin(String email, String password) {
        if (emailContain(email)) return null;
        Admin admin = new Admin(email);
        admins.put(email, admin);
        passwords.put(admin, password);
        return admin;
    }

    void removeAdmin(Admin admin) {
        admins.remove(admin.getEmail());
    }

    Admin getAdmin(String email) {
        return admins.get(email);
    }

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

    boolean emailContain(String email) {
        return students.containsKey(email) || instructors.containsKey(email) || admins.containsKey(email);
    }

}
