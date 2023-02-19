package project_structure.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_structure.data_transfer_objects.SensorDto;
import project_structure.models.Sensor;
import project_structure.repository.SensorRepository;
import project_structure.services.SensorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorsServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    @Override
    @Transactional
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
}
