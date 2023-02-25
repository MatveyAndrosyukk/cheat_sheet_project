package project_structure.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import project_structure.models.Sensor;
import project_structure.services.SensorService;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class SensorControllerTest {
    @Mock
    SensorService sensorService;

    @InjectMocks
    SensorController sensorController;

    @Test
    @DisplayName("GET /api/sensors возвращает HTTP-ответ со статусом 200 OK и списком сенсоров")
    public void handleGetAllSensorsReturnsValidResponseEntity(){
        List<Sensor> sensors = List.of(new Sensor());
        doReturn(sensors).when(this.sensorService).findAll();

        ResponseEntity<List<Sensor>> responseEntity = this.sensorController.handleGetAllSensors();

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(responseEntity.getBody()).isEqualTo(sensors);
    }

}