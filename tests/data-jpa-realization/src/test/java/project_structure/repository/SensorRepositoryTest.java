package project_structure.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project_structure.models.Sensor;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SensorRepositoryTest {
    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void wasSensorAddedToDatabase(){
        Sensor sensor = new Sensor();

        sensorRepository.save(sensor);

        Sensor sensorFromDb = sensorRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User does not exists"));

        assertThat(sensorFromDb).isNotNull();
    }
}
