package project_structure.model_inherited.using_single_table_strategy.repository;

import project_structure.model_inherited.using_single_table_strategy.model.Sculpture;
import org.springframework.stereotype.Repository;

@Repository
public interface SculptureRepository extends ArtPieceRepository<Sculpture>{
}
