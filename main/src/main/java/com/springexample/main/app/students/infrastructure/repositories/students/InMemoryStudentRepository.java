package com.springexample.main.app.students.infrastructure.repositories.students;

import com.springexample.main.app.students.domain.Student;
import com.springexample.main.app.students.domain.StudentRepository;
import com.springexample.main.app.students.domain.errors.StudentNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class InMemoryStudentRepository implements StudentRepository {
    private final ArrayList<Student> memory = new ArrayList<>();

    @Override
    public void save(Student student) {
        this.memory.add(student);
    }

    @Override
    public Student findById(UUID id) throws StudentNotFound {
        return this.memory.stream()
                .filter(student -> id.equals(student.id()))
                .findFirst()
                .orElseThrow(() -> StudentNotFound.withId(id));
    }
}
