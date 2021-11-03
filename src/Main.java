import moodle.datatypes.Course;
import moodle.datatypes.Project;
import moodle.datatypes.SubmittedProject;
import moodle.managers.Repository;
import moodle.modules.Admin;
import moodle.modules.Instructor;
import moodle.modules.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository.INSTANCE.getAccountManager().createAdmin("test@test", "test");
        Admin admin = Admin.login("test@test", "test");
        assert admin != null;

        // Admin creates instructor
        Instructor instructor = admin.createInstructor("testInstructor@test", "test");
        Student student = admin.createStudent("testStudent@test", "test");

        // Admin creates course
        Course course = admin.createCourse("TestCourse", instructor.getEmail(), List.of(student.getEmail()));
        System.out.println(instructor.getCourses());
        System.out.println(student.getCourses());

        // Instructor uploads project
        Project project = instructor.uploadProject(course, "Test Project", "Yes, this is the task project");
        System.out.println(student.getProjects(course));

        // Student submit project
        SubmittedProject submittedProject = student.submitProject(project, "That is a good task");
        System.out.println(submittedProject);

        // Instructor get projects
        List<SubmittedProject> projects = instructor.getSubmittedProjects(project);
        System.out.println(projects);

        // Instructor upload feedback
        instructor.uploadFeedback(submittedProject, "Agree");
        System.out.println(student.getFeedback(submittedProject));
    }
}
