package org.demospringangular.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Role role;
    @ManyToOne
    private User user;

    private String codeRole;
    private String username;
}
