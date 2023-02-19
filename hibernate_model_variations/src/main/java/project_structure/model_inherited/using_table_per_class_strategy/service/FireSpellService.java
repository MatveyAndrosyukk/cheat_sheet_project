package project_structure.model_inherited.using_table_per_class_strategy.service;

import project_structure.model_inherited.using_table_per_class_strategy.model.FireSpell;

import java.util.List;

public interface FireSpellService {
    List<FireSpell> findAll();

    FireSpell findById(Long id);

    FireSpell save(FireSpell fireSpell);

    Long deleteById(Long id);
}
