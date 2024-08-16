package org.demospringangular;

import org.demospringangular.entities.*;
import org.demospringangular.repository.*;
import org.demospringangular.services.UserRoleServiceI;
import org.demospringangular.services.security.RsakeysConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(RsakeysConfig.class)
public class DemoSpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngularApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository, UserRoleServiceI userRoleServiceI, RoleRepository roleRepository,  VilleRepository villeRepository){
        return args ->{
            /*studentRepository.save(Student.builder().id(1L)
                            .firstName("Mohamed").lastName("Badji").code("123").programId("PROS")
                    .build());
             studentRepository.save(Student.builder().id(2L)
                            .firstName("Assane").lastName("Badji").code("1234").programId("PROS")
                    .build());
             studentRepository.save(Student.builder().id(3L)
                            .firstName("Baye").lastName("DIOP").code("12345").programId("SDI")
                    .build());
             studentRepository.save(Student.builder().id(4L)
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

            userRoleServiceI.addNewRole(new Role(1,"ADMIN","ADMIN",true));
            userRoleServiceI.addNewRole(new Role(2,"USER","USER",true));
            userRoleServiceI.addNewRole(new Role(3,"MANAGER","MANAGER",true));

            userRoleServiceI.addNeUser(new User(1,"admin","admin@gmail.com","admin","001","123",true,null,null,new ArrayList<>()));
            userRoleServiceI.addNeUser(new User(2,"user1","user1@gmail.com","user1","002","123",true,null,null,new ArrayList<>()));
            userRoleServiceI.addNeUser(new User(3,"user2","user2@gmail.com","user1","003","123",true,null,null,new ArrayList<>()));
*/


           /* userRoleServiceI.addRoleToUser("user1","USER");
            userRoleServiceI.addRoleToUser("user2","USER");
            userRoleServiceI.addRoleToUser("user2","MANAGER");
            userRoleServiceI.addRoleToUser("admin","ADMIN");
            userRoleServiceI.addRoleToUser("admin","USER");*/
            //userRoleRepository.save(UserRole.builder().user(userRepository.findById(1L).get()).role(roleRepository.findById(1L).get()).codeRole("ADMIN").username("admin").build());
           /* villeRepository.save(Ville.builder()
                    .code("Dakar")
                    .libelle("Dakar")
                    .build());
            villeRepository.save(Ville.builder()
                    .code("Zig")
                    .libelle("Ziguinchor")
                    .build());
            villeRepository.save(Ville.builder()
                    .code("Pikine")
                    .libelle("Pikine")
                    .build());
            villeRepository.save(Ville.builder()
                    .code("Thiaroye")
                    .libelle("Thiaroye")
                    .build());*/

        };
    }




}
