package project_structure.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorRequest {
    private String name;

    private String model;

    private Integer rangeFrom;

    private Integer rangeTo;

    private String type;

    private String unit;

    private String location;

    private String description;
}
