package project_structure.model_inherited.using_joined_stratagy.model;

import project_structure.model_inherited.using_joined_stratagy.model.enums.InfantryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "archers")
@Getter
@Setter
@ToString
@Builder
public class Archer extends Infantry{
    @Column(name = "range")
    private Integer range;

    public Archer() {
    }

    public Archer(InfantryType type, Integer attack, Integer range) {
        super(type, attack);
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Archer archer = (Archer) o;
        return getId() != null && Objects.equals(getId(), archer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
