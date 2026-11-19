package com.studentregistration;

import java.util.LinkedHashSet;
import java.util.Set;

public class Student {
    private final String id;
    private final String name;
    private final String email;
    private final Set<String> registeredCourseCodes = new LinkedHashSet<>();

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Set<String> getRegisteredCourseCodes() { return registeredCourseCodes; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + email + ")";
    }
}
