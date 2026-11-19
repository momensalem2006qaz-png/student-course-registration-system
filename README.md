# Student Course Registration System

A simple Java console application for the Part 3 requirements. It supports adding students and courses, listing courses with seats available, registering students, and viewing a student's course registrations.

## Requirements

- Java Development Kit (JDK) 8 or later
- PowerShell, Command Prompt, or another terminal

## Compile and run

From this project directory, run:

```powershell
javac -d out src/main/java/com/studentregistration/*.java
java -cp out com.studentregistration.Main
```

## Menu

1. Add student (student ID, name, email)
2. Add course (course code, course name, seat capacity)
3. Display courses with available seats
4. Register a student in a course
5. Display a student's registered courses by student ID
6. Display all students
0. Exit

## Notes

- Data is kept in memory while the program is running and is cleared when it exits.
- Student IDs and course codes are unique (case-insensitive).
- The system rejects duplicate registrations and does not allow course capacity to be exceeded.
- Each group member should make their own meaningful Git commits. A possible split is: student/course classes, registration logic, and the console menu/documentation.

