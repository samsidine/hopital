package same.code.hopital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Utilisateur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"
				+ "")
	})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id; 
	@NotBlank
	@Size(max = 40)
	  private String username;
	  private String password;
	  private boolean isActive;

	@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	  private String fileName;
	  private String resetToken;
	  private LocalDateTime dateToken;
	  @ManyToOne
	  private MedecinEntity medecin;
	@ManyToOne
	  private PatientEntity patient;


		
}

