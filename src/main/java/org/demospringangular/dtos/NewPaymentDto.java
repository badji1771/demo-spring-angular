package org.demospringangular.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.demospringangular.entities.PaymentType;
import org.demospringangular.entities.Ville;


import java.time.LocalDate;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NewPaymentDto {
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private String studentCode;
    private Long ville;
}
