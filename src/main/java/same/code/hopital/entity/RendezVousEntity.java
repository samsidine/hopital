package same.code.hopital.entity;


import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
@Table(name="RENDEZ_VOUS")
public class RendezVousEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="DATE_RENDEZ_VOUS")
    private LocalDate dateRendezVous;

    @ManyToOne
    private PatientEntity patient;

    @ManyToOne
    private MedecinEntity medecin;

    @Column(name="DESCRIPTION_RV")
    private  String description;

   // @OneToOne
    //private Consultation consultation;

}
