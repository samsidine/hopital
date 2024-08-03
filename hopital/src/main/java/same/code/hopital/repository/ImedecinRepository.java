package same.code.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import same.code.hopital.entity.MedecinEntity;

public interface ImedecinRepository extends JpaRepository<MedecinEntity, Long> {

    MedecinEntity findByEmail (String email);
}
