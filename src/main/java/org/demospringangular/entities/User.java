package org.demospringangular.entities;

import java.time.LocalDateTime;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Utilisateur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"
				+ ""),
		@UniqueConstraint(columnNames = "email"
				+ ""),
		@UniqueConstraint(columnNames = "matricule") 
	})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id; 
	@NotBlank
	@Size(max = 40)
	  private String username;
	@NotBlank
	  @Size(max = 60)
	  @Email
	  private String email;
	  private String nom;
	  private String matricule;
	  private String password;
	  private boolean isActive;

	@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@ManyToOne
	  private Role role;

	  private String fileName;
	  private String resetToken;
	  private LocalDateTime dateToken;


		
}

