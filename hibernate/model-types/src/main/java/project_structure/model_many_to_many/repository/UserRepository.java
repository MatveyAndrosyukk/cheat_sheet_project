package project_structure.model_many_to_many.repository;

import project_structure.model_many_to_many.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByRolesName(String roleName);
}
