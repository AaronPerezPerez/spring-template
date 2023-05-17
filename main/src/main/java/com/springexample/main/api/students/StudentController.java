package com.springexample.main.api.students;

import com.springexample.main.api.students.dto.CreateStudentDTO;
import com.springexample.main.app.students.application.CreateStudent;
import com.springexample.main.app.students.domain.errors.AdultStudentsNotAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final CreateStudent createStudent;

    @Autowired
    public StudentController(CreateStudent createStudent) {
        this.createStudent = createStudent;
    }


    @PostMapping("/students")
    public ResponseEntity<Object> create(@RequestBody CreateStudentDTO studentDTO) throws AdultStudentsNotAllowed {

        this.createStudent.execute(studentDTO.toStudent());


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
