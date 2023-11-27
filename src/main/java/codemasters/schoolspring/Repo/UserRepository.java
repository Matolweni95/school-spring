package codemasters.schoolspring.Repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import codemasters.schoolspring.Models.User;



public interface UserRepository extends CrudRepository<User, Long> {
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    
}
