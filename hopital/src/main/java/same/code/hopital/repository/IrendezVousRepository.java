package same.code.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import same.code.hopital.entity.PatientEntity;
import same.code.hopital.entity.RendezVousEntity;

public interface IrendezVousRepository extends JpaRepository<RendezVousEntity, Long> {
    RendezVousEntity findById (long id);

}
