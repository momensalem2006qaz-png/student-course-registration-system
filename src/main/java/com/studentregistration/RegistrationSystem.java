package com.studentregistration;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RegistrationSystem {
    private final Map<String, Student> students = new LinkedHashMap<>();
    private final Map<String, Course> courses = new LinkedHashMap<>();

    public boolean addStudent(String id, String name, String email) {
        String key = normalize(id);
        if (key.isEmpty() || students.containsKey(key)) return false;
        students.put(key, new Student(key, name.trim(), email.trim()));
        return true;
    }

    public boolean addCourse(String code, String name, int capacity) {
        String key = normalize(code);
        if (key.isEmpty() || courses.containsKey(key) || capacity <= 0) return false;
        courses.put(key, new Course(key, name.trim(), capacity));
        return true;
    }

    public Collection<Student> getStudents() { return students.values(); }
    public Collection<Course> getCourses() { return courses.values(); }

    public boolean registerStudent(String studentId, String courseCode) {
        Student student = students.get(normalize(studentId));
        Course course = courses.get(normalize(courseCode));
        if (student == null || course == null || !course.hasAvailableSeats()) return false;
        if (student.getRegisteredCourseCodes().contains(course.getCode())) return false;
        student.getRegisteredCourseCodes().add(course.getCode());
        course.getRegisteredStudentIds().add(student.getId());
        return true;
    }

    public Student findStudent(String studentId) {
        return students.get(normalize(studentId));
    }

    public Course findCourse(String courseCode) {
        return courses.get(normalize(courseCode));
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toUpperCase();
    }
}
