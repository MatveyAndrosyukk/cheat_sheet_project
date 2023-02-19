package project_structure.model_inherited.using_joined_stratagy.service;

import project_structure.model_inherited.using_joined_stratagy.model.Archer;

import java.util.List;

public interface ArcherService {
    List<Archer> findAll();

    Archer findById(Long id);

    Archer save(Archer archer);

    Long deleteById(Long id);
}

