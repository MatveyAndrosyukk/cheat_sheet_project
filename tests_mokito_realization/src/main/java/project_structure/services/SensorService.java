package project_structure.services;

import project_structure.models.Sensor;

import java.util.List;

public interface SensorService{
    List<Sensor> findAll();
    Sensor findById(Long id);
    Sensor save(Sensor sensor);
    Long deleteById(Long id);

    void delete(Sensor sensor);
}
