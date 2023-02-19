package project_structure.model_inherited.using_joined_stratagy.service;

import project_structure.model_inherited.using_joined_stratagy.model.Infantry;

import java.util.List;

public interface InfantryService {
    List<Infantry> findAll();

    Infantry findById(Long id);

    Infantry save(Infantry infantry);

    Long deleteById(Long id);
}
