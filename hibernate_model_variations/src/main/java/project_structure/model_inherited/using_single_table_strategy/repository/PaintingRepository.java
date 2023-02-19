package project_structure.model_inherited.using_single_table_strategy.repository;

import project_structure.model_inherited.using_single_table_strategy.model.Painting;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends ArtPieceRepository<Painting>{
}
