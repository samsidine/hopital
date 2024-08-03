package same.code.hopital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "MEDECIN")
public class MedecinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;


    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    @Column(name="AgeNaissance")
    private LocalDate dateNaissance;

    @Column(name="EMAIL")
    private String email;

    @Column(name="SPECIALITE")
    private String specialite;

    //@OneToMany(mappedBy = "medecin")
   // private List<RendezVous> rendezVous;
}
