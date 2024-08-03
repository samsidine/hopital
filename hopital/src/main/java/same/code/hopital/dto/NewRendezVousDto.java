package same.code.hopital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NewRendezVousDto {

    private LocalDate dateRendezVous;

    private Long patient;

    private Long medecin;

    private  String description;

}
