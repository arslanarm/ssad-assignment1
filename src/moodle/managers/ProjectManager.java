package moodle.managers;

import moodle.datatypes.Course;
import moodle.datatypes.Project;

import java.util.ArrayList;
import java.util.List;

public interface ProjectManager {
    /**
     * The method creates project
     *
     * @param name project name
     * @param course project course
     * @param task project task
     * @return Project
     */
    public Project createProject(String name, Course course, String task);

    /**
     * The method removes project
     * @param project project to remove
     */
    public void removeProject(Project project);

    /**
     * The method find and return all projects of the course
     *
     * @param course Course of the projects
     * @return list of projects
     */
    public List<Project> getProjects(Course course);

    /**
     * The method find and return project
     *
     * @param course project course
     * @param name project name
     * @return Project
     */
    public Project getProject(Course course, String name);
}
