package project_structure.model_inherited.using_joined_stratagy.service.implementations;

import project_structure.model_inherited.using_joined_stratagy.model.Knight;
import project_structure.model_inherited.using_joined_stratagy.repository.KnightRepository;
import project_structure.model_inherited.using_joined_stratagy.service.KnightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnightServiceImpl implements KnightService {
    private final KnightRepository knightRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Knight> findAll() {
        return knightRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Knight findById(Long id) {
        return knightRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public Knight save(Knight knight) {
        return knightRepository.save(knight);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        knightRepository.deleteById(id);
        return id;
    }
}
