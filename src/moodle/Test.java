package moodle;

public class Test {
    public static Admin createTestAdmin() {
        return AccountManager.INSTANCE.createAdmin("test@test", "test");
    }
}
