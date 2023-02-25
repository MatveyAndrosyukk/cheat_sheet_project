package project_structure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project_structure.data_transfer_objects.SensorDto;
import project_structure.models.Sensor;
import project_structure.services.SensorService;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService sensorService;

    @PostMapping()
    public ResponseEntity<Sensor> handleSaveSensor(@Validated @RequestBody SensorDto sensorDto){

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sensorService.save(SensorDto.buildSensor(sensorDto)));
    }
}
