package same.code.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import same.code.hopital.entity.PatientEntity;

public interface IpatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByEmail (String email);
}
