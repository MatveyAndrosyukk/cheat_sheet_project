package project_structure.model_inherited.using_single_table_strategy.service.implementations;

import project_structure.model_inherited.using_single_table_strategy.model.ArtPiece;
import project_structure.model_inherited.using_single_table_strategy.repository.ArtPieceRepository;
import project_structure.model_inherited.using_single_table_strategy.service.ArtPieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtPieceServiceImpl implements ArtPieceService {
    private final ArtPieceRepository<ArtPiece> artPieceRepository;


    @Override
    @Transactional(readOnly = true)
    public List<ArtPiece> findAll() {
        return artPieceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ArtPiece findById(Long id) {
        return artPieceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public ArtPiece save(ArtPiece artPiece) {
        return artPieceRepository.save(artPiece);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        artPieceRepository.deleteById(id);
        return id;
    }
}
