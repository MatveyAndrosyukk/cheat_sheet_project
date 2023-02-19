package project_structure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_structure.dto.SensorRequest;
import project_structure.dto.SensorResponse;
import project_structure.models.Sensor;
import project_structure.services.SensorService;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<SensorResponse>> handleGetAllSensors(){
        List<SensorResponse> sensors = sensorService.findAll();

        if (sensors == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sensors);
    }

    @GetMapping("{id}")
    public ResponseEntity<SensorResponse> handleGetSensorById(@PathVariable Long id){
        SensorResponse sensor = sensorService.findById(id);

        if (sensor == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sensor);
    }

    @PostMapping()
    public ResponseEntity<SensorResponse> handleSaveSensor(@RequestBody Sensor sensor){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sensorService.save(sensor));
    }

    @PutMapping()
    public ResponseEntity<SensorResponse> handleUpdateSensor(@RequestBody Sensor sensor){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sensorService.save(sensor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> handleDeleteSensor(@PathVariable Long id){
        return ResponseEntity.ok()
                .body(sensorService.deleteById(id));
    }
}
