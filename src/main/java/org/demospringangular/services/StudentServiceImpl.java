package org.demospringangular.services;

import jakarta.transaction.Transactional;
import org.demospringangular.dtos.NewStudentDto;
import org.demospringangular.entities.Student;
import org.demospringangular.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent( NewStudentDto dto) throws IOException {
        Student student = Student.builder()
                .code(dto.getCode())
                .lastName(dto.getLastName())
                .firstName(dto.getFirstName())
                .programId(dto.getProgramId())
                .build();
        return studentRepository.save(student);
    }
}
