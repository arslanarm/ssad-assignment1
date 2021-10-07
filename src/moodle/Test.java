package moodle;

// Class for testing the system
public class Test {
    public static Admin createTestAdmin() {
        return AccountManager.INSTANCE.createAdmin("test@test", "test");
    }
}
