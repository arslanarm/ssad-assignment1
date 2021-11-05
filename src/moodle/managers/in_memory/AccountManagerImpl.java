package moodle.managers.in_memory;

import moodle.managers.abstractions.AccountManager;
import moodle.modules.Admin;
import moodle.modules.Instructor;
import moodle.modules.Module;
import moodle.modules.Student;

import java.util.HashMap;
import java.util.Map;


/**
 *  The AccountManager class manages the administrator, instructor, and student entities on the system.
 */
public class AccountManagerImpl implements AccountManager {

    private final Map<String, Module> modules = new HashMap<>();
    private final HashMap<Module, String> passwords = new HashMap<>();

    public AccountManagerImpl() {
    }


    /**
     * Method creates a record about the user
     *
     * @param email email of user
     * @param module user object
     * @param password user's password
     */
    @Override
    public Module createModule(String email, Module module, String password) {
        modules.put(email, module);
        passwords.put(module, password);
        return module;
    }


    /**
     * The method removes module
     *
     * @param module student to remove
     */
    @Override
    public void removeModule(Module module) {
        modules.remove(module.getEmail());
    }


    /**
     * The method looks for a student in the system
     *
     * @param email email of student
     * @return Student
     */
    @Override
    public Module getModule(String email) {
        return modules.get(email);
    }



    /**
     * The method allows the user to log in to the system.
     *
     * @param email email of user
     * @param password password of user
     * @return The module to which the user belongs
     */
    @Override
    public Module login(String email, String password) {
        Module module = modules.get(email);
        if (module == null) return null;
        if (passwords.get(module).equals(password)) {
            return module;
        } else {
            return null;
        }
    }
}
