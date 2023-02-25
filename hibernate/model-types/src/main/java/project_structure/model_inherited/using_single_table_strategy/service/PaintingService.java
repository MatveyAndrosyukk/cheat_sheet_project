package project_structure.model_inherited.using_single_table_strategy.service;

import project_structure.model_inherited.using_single_table_strategy.model.Painting;

import java.util.List;

public interface PaintingService {
    List<Painting> findAll();

    Painting findById(Long id);

    Painting save(Painting painting);

    Long deleteById(Long id);
}

