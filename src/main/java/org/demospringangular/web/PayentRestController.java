package org.demospringangular.web;


import org.demospringangular.dtos.PaymentDto;
import org.demospringangular.entities.Payment;
import org.demospringangular.entities.PaymentStatus;
import org.demospringangular.entities.PaymentType;
import org.demospringangular.entities.Student;
import org.demospringangular.repository.PaymentRepository;
import org.demospringangular.repository.StudentRepository;
import org.demospringangular.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;


@RestController
@CrossOrigin("*")
public class PayentRestController {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    private PaymentService paymentService;

    public PayentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository,PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }
    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }

    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }

    @GetMapping(path = "/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }

    @GetMapping(path = "/studentsByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }

    @PutMapping(path = "/payments/{id}")
    public  Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id){
        return paymentService.updatePaymentStatus(status,id);
    }

    @PostMapping(path = "/payments",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(MultipartFile file,@RequestParam PaymentDto dto) throws IOException {
         return this.paymentService.savePayment(file,dto);
    }
    @GetMapping(path = "/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPaymentFile(paymentId);
    }
}
