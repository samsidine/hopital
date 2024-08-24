package same.code.hopital.dto;


import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;

}
