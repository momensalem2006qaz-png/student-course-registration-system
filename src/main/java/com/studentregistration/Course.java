package com.studentregistration;

import java.util.LinkedHashSet;
import java.util.Set;

public class Course {
    private final String code;
    private final String name;
    private final int capacity;
    private final Set<String> registeredStudentIds = new LinkedHashSet<>();

    public Course(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public Set<String> getRegisteredStudentIds() { return registeredStudentIds; }
    public int getAvailableSeats() { return capacity - registeredStudentIds.size(); }
    public boolean hasAvailableSeats() { return getAvailableSeats() > 0; }

    @Override
    public String toString() {
        return code + " - " + name + " (" + getAvailableSeats() + "/" + capacity + " seats available)";
    }
}
