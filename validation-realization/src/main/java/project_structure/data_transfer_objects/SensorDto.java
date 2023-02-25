package project_structure.data_transfer_objects;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import project_structure.models.Sensor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorDto {
    @NotNull
    private Long id;

    @NotEmpty
    @Length(max = 30)
    private String name;

    public static Sensor buildSensor(SensorDto sensorDto) {
        return Sensor.builder()
                .id(sensorDto.getId())
                .name(sensorDto.getName())
                .build();
    }
}
