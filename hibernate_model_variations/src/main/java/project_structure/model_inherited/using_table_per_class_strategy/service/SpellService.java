package project_structure.model_inherited.using_table_per_class_strategy.service;

import project_structure.model_inherited.using_table_per_class_strategy.model.Spell;

import java.util.List;

public interface SpellService {
    List<Spell> findAll();

    Spell findById(Long id);

    Spell save(Spell spell);

    Long deleteById(Long id);
}
