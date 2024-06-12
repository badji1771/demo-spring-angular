package org.demospringangular.services;

import jakarta.transaction.Transactional;
import org.demospringangular.dtos.NewPaymentDto;
import org.demospringangular.dtos.PaymentDto;
import org.demospringangular.entities.Payment;
import org.demospringangular.entities.PaymentStatus;
import org.demospringangular.entities.Student;
import org.demospringangular.repository.PaymentRepository;
import org.demospringangular.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service @Transactional
public class PaymentService {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    public PaymentService(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(MultipartFile file, NewPaymentDto dto) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"demo-data","payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"demo-data","payment",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
         Student student =studentRepository.findByCode(dto.getStudentCode());
        Payment payment = Payment.builder()
                .date(dto.getDate())
                .type(dto.getType())
                .amount(dto.getAmount())
                .student(student)
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED).build();
        return paymentRepository.save(payment);

    }

    public  Payment updatePaymentStatus(PaymentStatus status, Long id){
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public byte[] getPaymentFile( Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
