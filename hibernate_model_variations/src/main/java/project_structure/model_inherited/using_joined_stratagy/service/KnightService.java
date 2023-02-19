package project_structure.model_inherited.using_joined_stratagy.service;

import project_structure.model_inherited.using_joined_stratagy.model.Knight;

import java.util.List;

public interface KnightService {
    List<Knight> findAll();

    Knight findById(Long id);

    Knight save(Knight knight);

    Long deleteById(Long id);
}
