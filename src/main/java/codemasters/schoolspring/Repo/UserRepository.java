package codemasters.schoolspring.Repo;

import org.springframework.data.repository.CrudRepository;

import codemasters.schoolspring.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    
}
