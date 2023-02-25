package project_structure.model_inherited.using_single_table_strategy.service.implementations;

import project_structure.model_inherited.using_single_table_strategy.model.Painting;
import project_structure.model_inherited.using_single_table_strategy.repository.PaintingRepository;
import project_structure.model_inherited.using_single_table_strategy.service.PaintingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaintingServiceImpl implements PaintingService {
    private final PaintingRepository paintingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Painting> findAll() {
        return paintingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Painting findById(Long id) {
        return paintingRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public Painting save(Painting painting) {
        return paintingRepository.save(painting);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        paintingRepository.deleteById(id);
        return id;
    }
}
