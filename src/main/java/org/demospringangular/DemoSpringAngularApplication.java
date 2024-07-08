package org.demospringangular;

import org.demospringangular.entities.*;
import org.demospringangular.repository.PaymentRepository;
import org.demospringangular.repository.StudentRepository;
import org.demospringangular.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoSpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngularApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository, UserRepository  userRepository){
        return args ->{
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                            .firstName("Mohamed").lastName("Badji").code("123").programId("PROS")
                    .build());
             studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                            .firstName("Assane").lastName("Badji").code("1234").programId("PROS")
                    .build());
             studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                            .firstName("Baye").lastName("DIOP").code("12345").programId("SDI")
                    .build());
             studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                            .firstName("Bamba").lastName("Badjinka").code("123456").programId("ZSDI")
                    .build());
            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
studentRepository.findAll().forEach(st->{
    for (int i=0;i<10; i++){
        int index = random.nextInt(paymentTypes.length);
       paymentRepository.save(Payment.builder().amount(1000+Math.random()*20000)
                .type(paymentTypes[index])
                .status(PaymentStatus.CREATED)
                .date(LocalDate.now())
                .student(st).build());
    }
});
userRepository.save(User.builder()
                .username("admin")
                .password("123")
                .nom("Moussa")
                .email("moussa@gmail.com")
                .role("ADMIN")
                .matricule("123")
                .isActive(true)
        .build());
            userRepository.save(User.builder()
                    .username("user1")
                    .password("123")
                    .nom("Amadou")
                    .email("amadou@gmail.com")
                    .role("USER")
                    .matricule("1234")
                    .isActive(true)
                    .build());

        };
    }

}
