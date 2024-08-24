package same.code.hopital.dto;


import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;
import same.code.hopital.entity.MedecinEntity;
import same.code.hopital.entity.PatientEntity;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RendezVousDto {

    private Long id;
    private LocalDate dateRendezVous;

    private PatientDto patient;

    private MedecinDto medecin;

    private  String description;

}
