package project_structure.services;

import project_structure.data_transfer_objects.SensorDto;
import project_structure.models.Sensor;

import java.util.List;

public interface SensorService{
    Sensor save(Sensor sensor);
}
