package same.code.hopital.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedecinDto {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateNaissance;
    private String specialite;
}
