package project_structure.model_inherited.using_table_per_class_strategy.repository;

import project_structure.model_inherited.using_table_per_class_strategy.model.FrostSpell;
import org.springframework.stereotype.Repository;

@Repository
public interface FrostSpellRepository extends SpellRepository<FrostSpell>{
}
