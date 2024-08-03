package same.code.hopital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    @Column(name="DATE_DE_CONSULTATION")
    private Date dateDeConsultation;
    @Column(name="RAPPORT_DE_CONSULTATION")
    private String rapportConsultation;
    @Column(name="PRIX_DE_CONSULTATION")
    private  double prixConsultation;
    //@OneToOne(mappedBy = "consultation")
    //private RendezVous rendezVous;
}
