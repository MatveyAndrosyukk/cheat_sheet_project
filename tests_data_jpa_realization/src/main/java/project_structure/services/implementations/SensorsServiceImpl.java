package project_structure.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_structure.dto.SensorRequest;
import project_structure.dto.SensorResponse;
import project_structure.models.Sensor;
import project_structure.repository.SensorRepository;
import project_structure.services.SensorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorsServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SensorResponse> findAll() {
        List<Sensor> sensors = sensorRepository.findAll();

        return sensors.stream().map(this::mapToSensorResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SensorResponse findById(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("findById failed"));

        return mapToSensorResponse(sensor);
    }

    @Override
    @Transactional
    public SensorResponse save(Sensor sensor) {
        return mapToSensorResponse(sensorRepository.save(sensor));
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        sensorRepository.deleteById(id);
        return id;
    }

    private SensorResponse mapToSensorResponse(Sensor sensor) {
        return SensorResponse.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .model(sensor.getModel())
                .description(sensor.getDescription())
                .type(sensor.getType())
                .unit(sensor.getUnit())
                .rangeFrom(sensor.getRangeFrom())
                .rangeTo(sensor.getRangeTo())
                .location(sensor.getLocation())
                .build();
    }
}
