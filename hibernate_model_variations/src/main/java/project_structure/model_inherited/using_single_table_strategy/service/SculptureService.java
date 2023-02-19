package project_structure.model_inherited.using_single_table_strategy.service;

import project_structure.model_inherited.using_single_table_strategy.model.Sculpture;

import java.util.List;

public interface SculptureService {
    List<Sculpture> findAll();

    Sculpture findById(Long id);

    Sculpture save(Sculpture sculpture);

    Long deleteById(Long id);
}
