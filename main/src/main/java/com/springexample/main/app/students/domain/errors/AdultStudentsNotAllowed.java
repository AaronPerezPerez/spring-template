package com.springexample.main.app.students.domain.errors;

import java.util.UUID;

public class AdultStudentsNotAllowed extends Exception {
    AdultStudentsNotAllowed(UUID id, int age) {
        super("Student with id %s is %s years old. Adults are not allowed.".formatted(id, age));
    }

    public static AdultStudentsNotAllowed withId(UUID id, int age) {
        return new AdultStudentsNotAllowed(id, age);
    }
}
