package com.springexample.main.api.students.dto;

import com.springexample.main.app.students.domain.Student;

import java.time.LocalDate;
import java.util.UUID;

public record CreateStudentDTO(String name, String lastName, LocalDate birthDate) {
    public Student toStudent() {
        return new Student(
                UUID.randomUUID(),
                name, lastName, birthDate.atStartOfDay());
    }
}
