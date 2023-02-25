package project_structure.model_inherited.using_single_table_strategy.repository;

import project_structure.model_inherited.using_single_table_strategy.model.ArtPiece;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ArtPieceRepository<T extends ArtPiece> extends JpaRepository<T, Long> {
}
