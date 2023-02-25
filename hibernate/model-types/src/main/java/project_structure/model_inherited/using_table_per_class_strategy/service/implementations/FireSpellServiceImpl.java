package project_structure.model_inherited.using_table_per_class_strategy.service.implementations;

import project_structure.model_inherited.using_table_per_class_strategy.model.FireSpell;
import project_structure.model_inherited.using_table_per_class_strategy.repository.FireSpellRepository;
import project_structure.model_inherited.using_table_per_class_strategy.service.FireSpellService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FireSpellServiceImpl implements FireSpellService {
    private final FireSpellRepository fireSpellRepository;

    @Override
    public List<FireSpell> findAll() {
        return fireSpellRepository.findAll();
    }

    @Override
    public FireSpell findById(Long id) {
        return fireSpellRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    public FireSpell save(FireSpell fireSpell) {
        return fireSpellRepository.save(fireSpell);
    }

    @Override
    public Long deleteById(Long id) {
        fireSpellRepository.deleteById(id);
        return id;
    }
}
