package com.springexample.main.app.students.application;

import com.springexample.main.app.shared.domain.ClockService;
import com.springexample.main.app.students.domain.Student;
import com.springexample.main.app.students.domain.StudentRepository;
import com.springexample.main.app.students.domain.errors.AdultStudentsNotAllowed;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateStudent {
    private final StudentRepository repository;
    private final ClockService clock;

    public CreateStudent(StudentRepository repository, ClockService clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public void execute(Student student) throws AdultStudentsNotAllowed {
        LocalDateTime now = clock.now();
        if (student.isAdult(now)) {
            int age = now.compareTo(student.birthDate());
            throw AdultStudentsNotAllowed.withId(student.id(), age);
        }

        repository.save(student);
    }
}
