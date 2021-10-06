package moodle;

import java.util.List;

public class Course {
    public String getInstructor() {
        return instructor;
    }

    public List<String> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    Course(String instructor, List<String> students, String name){
        this.instructor = instructor;
        this.students = students;
        this.name = name;
    }
    private String instructor;
    private List<String> students;
    private String name;

}
