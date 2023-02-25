package project_structure.model_inherited.using_table_per_class_strategy.service.implementations;

import project_structure.model_inherited.using_table_per_class_strategy.model.FrostSpell;
import project_structure.model_inherited.using_table_per_class_strategy.repository.FrostSpellRepository;
import project_structure.model_inherited.using_table_per_class_strategy.service.FrostSpellService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FrostSpellServiceImpl implements FrostSpellService {
    private final FrostSpellRepository frostSpellRepository;

    @Override
    public List<FrostSpell> findAll() {
        return frostSpellRepository.findAll();
    }

    @Override
    public FrostSpell findById(Long id) {
        return frostSpellRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    public FrostSpell save(FrostSpell frostSpell) {
        return frostSpellRepository.save(frostSpell);
    }

    @Override
    public Long deleteById(Long id) {
        frostSpellRepository.deleteById(id);
        return id;
    }
}
