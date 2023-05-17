package com.springexample.main.app.students.application;

import com.springexample.main.app.shared.domain.ClockService;
import com.springexample.main.app.students.domain.Student;
import com.springexample.main.app.students.domain.StudentRepository;
import com.springexample.main.app.students.domain.errors.AdultStudentsNotAllowed;
import com.springexample.main.app.students.domain.errors.StudentNotFound;
import com.springexample.main.app.students.infrastructure.repositories.students.InMemoryStudentRepository;
import com.springexample.main.app.students.infrastructure.services.clock.FakeClockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateStudentTest {
    CreateStudent createStudent;
    StudentRepository repository;
    ClockService clock;

    @BeforeEach
    void setUp() {
        repository = new InMemoryStudentRepository();
        clock = new FakeClockService();
        createStudent = new CreateStudent(repository, clock);
    }

    @Test
    @DisplayName("Should add an student")
    void createStudent() throws AdultStudentsNotAllowed, StudentNotFound {
        Student student = new Student(UUID.randomUUID(), "Paco", "Pérez", LocalDateTime.of(2010, Month.APRIL, 1, 1, 1));

        createStudent.execute(student);
        Student savedStudent = repository.findById(student.id());

        assertEquals(savedStudent, student,
                "Received student and persisted student should be equal");
    }

    @Test
    @DisplayName("Should throw an error if the student is an adult")
    void createAdultStudent() {
        Student adultStudent = new Student(UUID.randomUUID(), "Laura", "Martín", LocalDateTime.of(1994, Month.APRIL, 1, 1, 1, 1, 1));

        Exception error = assertThrows(AdultStudentsNotAllowed.class, () -> {
            createStudent.execute(adultStudent);
        });

        assertTrue(error.getMessage().contains("Adults are not allowed."));
    }
}
