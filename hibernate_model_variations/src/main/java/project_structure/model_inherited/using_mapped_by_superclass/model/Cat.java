package project_structure.model_inherited.using_mapped_by_superclass.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cats")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cat extends Animal {
    @Column(name = "tail_length")
    private Integer tailLength;

    public Cat(Date createdDate, Integer tailLength) {
        super(createdDate);
        this.tailLength = tailLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cat cat = (Cat) o;
        return getId() != null && Objects.equals(getId(), cat.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
