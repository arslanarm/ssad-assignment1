package moodle;

import java.util.HashMap;
import java.util.List;

class AccountManager implements Module{
    private HashMap<String,Student> students = new HashMap<>();
    private HashMap<String,Instructor> instructors = new HashMap<>();
    private HashMap<String,Admin> admins = new HashMap<>();
    private HashMap<Module, String> passwords = new HashMap<>();

    static AccountManager INSTANCE = new AccountManager();
    private AccountManager() {}
    Student createStudent(String email, String password){
        Student student = new Student(email);
        students.put(email, student);
        passwords.put(student, password);
        return student;
    }
    Instructor createInstructor(String email, String password){
        Instructor instructor = new Instructor(email);
        instructors.put(email, instructor);
        passwords.put(instructor, password);
        return instructor;
    }
    void removeStudent(Student student){students.remove(student.getEmail());}
    void removeInstructor(Instructor instructor){instructors.remove(instructor.getEmail());}
    Student getStudent(String email){return students.get(email);}
    Instructor getInstructor(String email){return instructors.get(email);}
    Admin createAdmin(String email, String password){
        Admin admin = new Admin(email);
        admins.put(email, admin);
        passwords.put(admin, password);
        return admin;
    }
    void removeAdmin(Admin admin){admins.remove(admin.getEmail());}
    Admin getAdmin(String email){return admins.get(email);}
    Module login(String email, String password) {
        Module module = getStudent(email);
        if (module == null) {
            module = getInstructor(email);
        }
        if (module == null) {
            module = getAdmin(email);
        }
        if (module == null) return null;

        if(passwords.get(module) == password){
            return module;
        }else{
            return null;
        }
    }
}
