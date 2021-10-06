package moodle;

import java.util.List;

public class Admin implements Module{
    // -------------Creators---------------
    public Student createStudent(String email, String password){

        return null;
    }
    public Instructor createInstructor(String email, String password){

        return null;
    }
    public Course createCourse(String name, String instructorEmail, List<String> students){

        return null;
    }

    // -------------Getters---------------
    public Student getStudent(String email){

        return null;
    }
    public Instructor getInstructor(String email){

        return null;
    }
    public Course getCourse(String name){

        return null;
    }

    // -------------Removers---------------
    public void removeStudent(String email){

    }
    public void removeInstructor(String email){

    }
    public void removeCourse(String name){

    }

}
