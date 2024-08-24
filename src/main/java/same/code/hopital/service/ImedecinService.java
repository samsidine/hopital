package same.code.hopital.service;

import same.code.hopital.dto.MedecinDto;
import same.code.hopital.dto.PatientDto;

import java.util.List;

public interface ImedecinService {
    MedecinDto save (MedecinDto medecinDto);

    List<MedecinDto> listMedecin();
    MedecinDto getMedecinById (Long id);

    MedecinDto getMedecinByEmail (String email);
    void deleteById(Long id);
    MedecinDto updateMedecin(MedecinDto medecinDto);
}
