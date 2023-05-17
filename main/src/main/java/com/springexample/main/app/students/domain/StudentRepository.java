package com.springexample.main.app.students.domain;

import com.springexample.main.app.students.domain.errors.StudentNotFound;

import java.util.UUID;

public interface StudentRepository {
    void save(Student student);

    Student findById(UUID id) throws StudentNotFound;
}
