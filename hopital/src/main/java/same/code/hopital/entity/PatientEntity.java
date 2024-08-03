package same.code.hopital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")

    private Long id;

    @Column(name="NOM")
    private String nom;
    @Column(name="PRENOM")
    private String prenom;
    @Column(name="AgeNaissance")
    private LocalDate dateNaissance;
    @Column(name="EMAIL")
    private String email;
   // @OneToMany(mappedBy = "patient")
    //private List<RendezVous> rendezVous;

}
