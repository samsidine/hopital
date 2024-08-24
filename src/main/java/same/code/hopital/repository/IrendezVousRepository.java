package same.code.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;
import same.code.hopital.entity.MedecinEntity;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.entity.RendezVousEntity;

import java.util.List;

public interface IrendezVousRepository extends JpaRepository<RendezVousEntity, Long> {
    RendezVousEntity findById (long id);

    List<RendezVousEntity>  findAllByPatient(PatientEntity patient);
    List<RendezVousEntity>  findAllByMedecin(MedecinEntity medecin);

}
