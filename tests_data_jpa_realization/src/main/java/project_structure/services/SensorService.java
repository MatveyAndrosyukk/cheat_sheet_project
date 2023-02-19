package project_structure.services;

import project_structure.dto.SensorRequest;
import project_structure.dto.SensorResponse;
import project_structure.models.Sensor;

import java.util.List;

public interface SensorService{
    List<SensorResponse> findAll();
    SensorResponse findById(Long id);
    SensorResponse save(Sensor sensor);
    Long deleteById(Long id);
}
