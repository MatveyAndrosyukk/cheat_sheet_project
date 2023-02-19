package project_structure.model_inherited.using_joined_stratagy.repository;

import org.springframework.data.repository.NoRepositoryBean;
import project_structure.model_inherited.using_joined_stratagy.model.Infantry;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface InfantryRepository<T extends Infantry> extends JpaRepository<T, Long> {
}
