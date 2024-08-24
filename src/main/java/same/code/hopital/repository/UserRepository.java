package same.code.hopital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import same.code.hopital.entity.UserEntity;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String name);


}
