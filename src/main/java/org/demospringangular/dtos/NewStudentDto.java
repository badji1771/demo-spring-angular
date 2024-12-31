package org.demospringangular.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentDto {

    private String code;
    private String firstName;
    private String lastName;
    private String programId;


}
