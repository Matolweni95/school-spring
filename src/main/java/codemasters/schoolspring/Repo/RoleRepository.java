package codemasters.schoolspring.Repo;

import codemasters.schoolspring.Models.ERole;
import codemasters.schoolspring.Models.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long>{
    Optional<Role> findByName(ERole name);
}
