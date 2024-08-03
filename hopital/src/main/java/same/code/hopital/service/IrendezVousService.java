package same.code.hopital.service;

import same.code.hopital.dto.NewRendezVousDto;
import same.code.hopital.dto.RendezVousDto;

import java.util.List;

public interface IrendezVousService {

    RendezVousDto save(RendezVousDto rendezVousDto);
    NewRendezVousDto getDataRendezVous(NewRendezVousDto rendezVousDto);

    List<RendezVousDto> listRendezVous();

    void delete(RendezVousDto rendezVousDto);
    RendezVousDto updateRendezVous(RendezVousDto rendezVousDto);

    void deleteById(long id);
}
