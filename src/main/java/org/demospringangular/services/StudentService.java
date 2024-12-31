package org.demospringangular.services;

import org.demospringangular.dtos.NewStudentDto;
import org.demospringangular.entities.Student;

import java.io.IOException;

public interface StudentService {
    Student saveStudent(NewStudentDto dto) throws IOException;
}
