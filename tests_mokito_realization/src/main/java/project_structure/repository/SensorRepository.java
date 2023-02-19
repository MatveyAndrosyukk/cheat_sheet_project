package project_structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project_structure.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
