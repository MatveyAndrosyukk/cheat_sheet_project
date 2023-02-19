package project_structure.model_inherited.using_joined_stratagy.repository;

import project_structure.model_inherited.using_joined_stratagy.model.Archer;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcherRepository extends InfantryRepository<Archer>{
}
