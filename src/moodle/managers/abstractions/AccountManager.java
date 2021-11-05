package moodle.managers.abstractions;

import moodle.modules.Admin;
import moodle.modules.Instructor;
import moodle.modules.Module;
import moodle.modules.Student;

public interface AccountManager {
    /**
     * The method creates a Module
     *
     * @param email email of Module
     * @param password password of Module
     * @return Module
     */
    public Module createModule(String email, Module module, String password);

    /**
     * The method looks for a Module in the system
     *
     * @param email email of Module
     * @return Module
     */
    public Module getModule(String email);


    /**
     * The method removes Module
     *
     * @param module Module instance
     */
    public void removeModule(Module module);



    /**
     * The method allows the user to log in to the system.
     *
     * @param email email of user
     * @param password password of user
     * @return The module to which the user belongs
     */
    public Module login(String email, String password);
}
