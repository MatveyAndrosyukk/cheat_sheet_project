package project_structure.model_inherited.using_table_per_class_strategy.service;

import project_structure.model_inherited.using_table_per_class_strategy.model.FrostSpell;

import java.util.List;

public interface FrostSpellService {
    List<FrostSpell> findAll();

    FrostSpell findById(Long id);

    FrostSpell save(FrostSpell frostSpell);

    Long deleteById(Long id);
}
