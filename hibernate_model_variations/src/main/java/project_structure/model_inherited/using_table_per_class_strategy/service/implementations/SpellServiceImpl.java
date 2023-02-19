package project_structure.model_inherited.using_table_per_class_strategy.service.implementations;

import project_structure.model_inherited.using_table_per_class_strategy.model.Spell;
import project_structure.model_inherited.using_table_per_class_strategy.repository.SpellRepository;
import project_structure.model_inherited.using_table_per_class_strategy.service.SpellService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements SpellService {
    private final SpellRepository<Spell> spellRepository;

    @Override
    public List<Spell> findAll() {
        return spellRepository.findAll();
    }

    @Override
    public Spell findById(Long id) {
        return spellRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    public Spell save(Spell spell) {
        return spellRepository.save(spell);
    }

    @Override
    public Long deleteById(Long id) {
        spellRepository.deleteById(id);
        return id;
    }
}
