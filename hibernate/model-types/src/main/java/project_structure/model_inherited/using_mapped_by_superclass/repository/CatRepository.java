package project_structure.model_inherited.using_mapped_by_superclass.repository;

import project_structure.model_inherited.using_mapped_by_superclass.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
