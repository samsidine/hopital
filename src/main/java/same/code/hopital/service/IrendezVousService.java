package same.code.hopital.service;

import same.code.hopital.dto.MedecinDto;
import same.code.hopital.dto.NewRendezVousDto;
import same.code.hopital.dto.PatientDto;
import same.code.hopital.dto.RendezVousDto;
import same.code.hopital.entity.RendezVousEntity;

import java.util.List;

public interface IrendezVousService {

    RendezVousDto save(RendezVousDto rendezVousDto);
    NewRendezVousDto getDataRendezVous(NewRendezVousDto rendezVousDto);

    List<RendezVousDto> listRendezVous();

    void delete(RendezVousDto rendezVousDto);
    RendezVousDto updateRendezVous(RendezVousDto rendezVousDto);

    void deleteById(long id);


    List<RendezVousDto>  findAllByPatient(PatientDto patient);
    List<RendezVousDto>  findAllByMedecin(MedecinDto medecin);
}
