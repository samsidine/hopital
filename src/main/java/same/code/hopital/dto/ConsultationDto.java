package same.code.hopital.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultationDto {

    private long id;
    private Date dateDeConsultation;
    private String rapportConsultation;
    private  double prixConsultation;

}
