package project_structure.model_simple.service;

import project_structure.model_simple.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> findAll();

    Dish findById(Long id);

    Dish save(Dish dish);

    Long deleteById(Long id);
}
