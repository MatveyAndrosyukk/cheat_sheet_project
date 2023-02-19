package project_structure.model_inherited.using_joined_stratagy.service.implementations;

import project_structure.model_inherited.using_joined_stratagy.model.Infantry;
import project_structure.model_inherited.using_joined_stratagy.repository.InfantryRepository;
import project_structure.model_inherited.using_joined_stratagy.service.InfantryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfantryServiceImpl implements InfantryService {
    private final InfantryRepository<Infantry> infantryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Infantry> findAll() {
        return infantryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Infantry findById(Long id) {
        return infantryRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public Infantry save(Infantry infantry) {
        return infantryRepository.save(infantry);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        infantryRepository.deleteById(id);
        return id;
    }
}
