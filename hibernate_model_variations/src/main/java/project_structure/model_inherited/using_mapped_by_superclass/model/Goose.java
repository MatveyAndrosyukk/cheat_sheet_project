package project_structure.model_inherited.using_mapped_by_superclass.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "gooses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goose extends Animal {
    @Column(name = "wings_length")
    private Integer wingsLength;

    public Goose(Date createdDate, Integer wingsLength) {
        super(createdDate);
        this.wingsLength = wingsLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Goose goose = (Goose) o;
        return getId() != null && Objects.equals(getId(), goose.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
