package com.studentregistration;

import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final RegistrationSystem SYSTEM = new RegistrationSystem();

    public static void main(String[] args) {
        System.out.println("Student Course Registration System");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = read("Choose an option: ");
            switch (choice) {
                case "1": addStudent(); break;
                case "2": addCourse(); break;
                case "3": showAvailableCourses(); break;
                case "4": registerStudent(); break;
                case "5": showStudentCourses(); break;
                case "6": showStudents(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
        System.out.println("Goodbye.");
    }

    private static void printMenu() {
        System.out.println("\n1. Add student");
        System.out.println("2. Add course");
        System.out.println("3. Display available courses");
        System.out.println("4. Register a student in a course");
        System.out.println("5. Display a student's registered courses");
        System.out.println("6. Display students");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        String id = read("Student ID: ");
        String name = read("Student name: ");
        String email = read("Student email: ");
        if (id.trim().isEmpty() || name.trim().isEmpty() || email.trim().isEmpty()) {
            System.out.println("All student fields are required.");
        } else if (SYSTEM.addStudent(id, name, email)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Could not add student. The ID may already exist.");
        }
    }

    private static void addCourse() {
        String code = read("Course code: ");
        String name = read("Course name: ");
        int capacity = readPositiveInteger("Course capacity: ");
        if (code.trim().isEmpty() || name.trim().isEmpty()) {
            System.out.println("Course code and name are required.");
        } else if (SYSTEM.addCourse(code, name, capacity)) {
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Could not add course. Check that its code is unique and capacity is positive.");
        }
    }

    private static void showAvailableCourses() {
        boolean found = false;
        for (Course course : SYSTEM.getCourses()) {
            if (course.hasAvailableSeats()) {
                System.out.println(course);
                found = true;
            }
        }
        if (!found) System.out.println("No courses are currently available.");
    }

    private static void registerStudent() {
        String studentId = read("Student ID: ");
        String courseCode = read("Course code: ");
        if (SYSTEM.registerStudent(studentId, courseCode)) {
            System.out.println("Registration completed successfully.");
        } else {
            System.out.println("Registration failed. Check the student ID, course code, available seats, and duplicate registrations.");
        }
    }

    private static void showStudentCourses() {
        String studentId = read("Student ID: ");
        Student student = SYSTEM.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Courses registered by " + student.getName() + ":");
        if (student.getRegisteredCourseCodes().isEmpty()) {
            System.out.println("No course registrations found.");
            return;
        }
        for (String code : student.getRegisteredCourseCodes()) {
            Course course = SYSTEM.findCourse(code);
            if (course != null) System.out.println(course.getCode() + " - " + course.getName());
        }
    }

    private static void showStudents() {
        if (SYSTEM.getStudents().isEmpty()) {
            System.out.println("No students have been added.");
            return;
        }
        for (Student student : SYSTEM.getStudents()) System.out.println(student);
    }

    private static int readPositiveInteger(String prompt) {
        while (true) {
            String value = read(prompt);
            try {
                int number = Integer.parseInt(value);
                if (number > 0) return number;
            } catch (NumberFormatException ignored) {
                // Show the same helpful message for text and non-positive values.
            }
            System.out.println("Enter a whole number greater than zero.");
        }
    }

    private static String read(String prompt) {
        System.out.print(prompt);
        return INPUT.nextLine().trim();
    }
}


