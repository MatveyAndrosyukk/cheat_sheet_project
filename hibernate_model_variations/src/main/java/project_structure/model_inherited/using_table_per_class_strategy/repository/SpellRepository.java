package project_structure.model_inherited.using_table_per_class_strategy.repository;

import project_structure.model_inherited.using_table_per_class_strategy.model.Spell;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface SpellRepository<T extends Spell> extends JpaRepository<T, Long> {
}
