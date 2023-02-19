package project_structure.model_simple.service.implementations;

import project_structure.model_simple.model.Dish;
import project_structure.model_simple.repository.DishRepository;
import project_structure.model_simple.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    @Override
    @Transactional
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        dishRepository.deleteById(id);
        return id;
    }
}
