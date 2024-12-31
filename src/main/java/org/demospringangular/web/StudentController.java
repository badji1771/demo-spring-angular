package org.demospringangular.web;

import org.demospringangular.dtos.NewPaymentDto;
import org.demospringangular.dtos.NewStudentDto;
import org.demospringangular.entities.Payment;
import org.demospringangular.entities.Student;
import org.demospringangular.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class StudentController {


    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/students",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student savePayment(NewStudentDto dto) throws IOException {
        return this.studentService.saveStudent(dto);
    }
}
