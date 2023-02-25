package project_structure.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_structure.models.Sensor;
import project_structure.repository.SensorRepository;
import project_structure.services.SensorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorsServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sensor findById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("findById failed"));
    }

    @Override
    @Transactional
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        sensorRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public void delete(Sensor sensor) {
        sensorRepository.delete(sensor);
    }
}
