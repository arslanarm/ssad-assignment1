import moodle.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Test.createTestAdmin();
        Admin admin = Admin.login("test@test", "test");
        assert admin != null;

        Instructor instructor = admin.createInstructor("testInstructor@test", "test");
        Student student = admin.createStudent("testStudent@test", "test");

        Course course = admin.createCourse("TestCourse", instructor.getEmail(), List.of(student.getEmail()));
        System.out.println(instructor.getCourses());
        System.out.println(student.getCourses());

        Project project = instructor.uploadProject(course, "Test Project", "Yes, this is the task project");
        System.out.println(student.getProjects(course));

        SubmittedProject submittedProject = student.submitProject(project, "That is a good task");
        System.out.println(submittedProject);

        List<SubmittedProject> projects = instructor.getSubmittedProjects(project);
        System.out.println(projects);

        instructor.uploadFeedback(submittedProject, "Agree");
        System.out.println(student.getFeedback(submittedProject));
    }
}
