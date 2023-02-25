package project_structure.model_inherited.using_joined_stratagy.service.implementations;

import project_structure.model_inherited.using_joined_stratagy.model.Archer;
import project_structure.model_inherited.using_joined_stratagy.repository.ArcherRepository;
import project_structure.model_inherited.using_joined_stratagy.service.ArcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArcherServiceImpl implements ArcherService {
    private final ArcherRepository archerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Archer> findAll() {
        return archerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Archer findById(Long id) {
        return archerRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
    }

    @Override
    @Transactional
    public Archer save(Archer archer) {
        return archerRepository.save(archer);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        archerRepository.deleteById(id);
        return id;
    }
}
