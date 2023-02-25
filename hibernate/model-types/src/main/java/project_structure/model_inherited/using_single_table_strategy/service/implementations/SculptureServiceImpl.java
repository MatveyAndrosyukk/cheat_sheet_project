package project_structure.model_inherited.using_single_table_strategy.service.implementations;

import project_structure.model_inherited.using_single_table_strategy.model.Sculpture;
import project_structure.model_inherited.using_single_table_strategy.repository.SculptureRepository;
import project_structure.model_inherited.using_single_table_strategy.service.SculptureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SculptureServiceImpl implements SculptureService{
    private final SculptureRepository sculptureRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sculpture> findAll() {
        return sculptureRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sculpture findById(Long id) {
        return sculptureRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public Sculpture save(Sculpture sculpture) {
        return sculptureRepository.save(sculpture);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        sculptureRepository.deleteById(id);
        return id;
    }
}
