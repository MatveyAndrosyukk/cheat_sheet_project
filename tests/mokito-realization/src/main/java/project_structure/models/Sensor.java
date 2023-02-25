package project_structure.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "sensors")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "range_from")
    private Integer rangeFrom;

    @Column(name = "range_to")
    private Integer rangeTo;

    @Column(name = "type")
    private String type;

    @Column(name = "unit")
    private String unit;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public Sensor(String name, String model, Integer rangeFrom, Integer rangeTo, String type, String unit, String location, String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sensor sensor = (Sensor) o;
        return id != null && Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
