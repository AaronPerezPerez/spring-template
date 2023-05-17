package com.springexample.main.app.students.domain.errors;

import java.util.UUID;

public class StudentNotFound extends Exception {
    StudentNotFound(UUID id) {
        super("Student with id %s not found".formatted(id));
    }

    public static StudentNotFound withId(UUID id) {
        return new StudentNotFound(id);
    }
}
