package org.demospringangular.entities;

import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

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
public class User {
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
	  private String role;
	  private String fileName;
	  private String resetToken;
	  private LocalDateTime dateToken;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	public LocalDateTime getDateToken() {
		return dateToken;
	}
	public void setDateToken(LocalDateTime dateToken) {
		this.dateToken = dateToken;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", nom=" + nom + ", matricule="
				+ matricule + ", password=" + password + ", isActive=" + isActive + ", role=" + role + ", fileName="
				+ fileName + ", resetToken=" + resetToken + ", dateToken=" + dateToken + "]";
	}
	public User(long id, @NotBlank @Size(max = 40) String username, @NotBlank @Size(max = 60) @Email String email,
			String nom, String matricule, String password, boolean isActive, String role, String fileName,
			String resetToken, LocalDateTime dateToken) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.matricule = matricule;
		this.password = password;
		this.isActive = isActive;
		this.role = role;
		this.fileName = fileName;
		this.resetToken = resetToken;
		this.dateToken = dateToken;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

		
}

