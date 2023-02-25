package project_structure.model_inherited.using_single_table_strategy.service;

import project_structure.model_inherited.using_single_table_strategy.model.ArtPiece;

import java.util.List;

public interface ArtPieceService {
    List<ArtPiece> findAll();

    ArtPiece findById(Long id);

    ArtPiece save(ArtPiece artPiece);

    Long deleteById(Long id);
}
