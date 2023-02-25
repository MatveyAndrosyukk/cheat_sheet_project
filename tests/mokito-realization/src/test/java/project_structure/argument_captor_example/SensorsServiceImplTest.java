package project_structure.argument_captor_example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import project_structure.models.Sensor;
import project_structure.repository.SensorRepository;
import project_structure.services.implementations.SensorsServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SensorsServiceImplTest {
    @Mock
    private SensorRepository sensorRepository;

    @InjectMocks
    private SensorsServiceImpl sensorService;

    @Test
    public void isSavedSensorCorrect(){
        Sensor sensor = Sensor.builder().name("Matvey").build();
        sensorService.save(sensor);

        ArgumentCaptor<Sensor> sensorCaptor = ArgumentCaptor.forClass(Sensor.class);
        verify(sensorRepository).save(sensorCaptor.capture());
        Sensor sensorInRepositorySaveMethod = sensorCaptor.getValue();
        assertThat(sensorInRepositorySaveMethod.getName()).isEqualTo(sensor.getName());
    }
}