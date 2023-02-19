package project_structure.model_inherited.using_mapped_by_superclass.repository;

import project_structure.model_inherited.using_mapped_by_superclass.model.Goose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GooseRepository extends JpaRepository<Goose, Long> {
}
