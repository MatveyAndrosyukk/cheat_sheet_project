package project_structure.model_inherited.using_joined_stratagy.model;

import project_structure.model_inherited.using_joined_stratagy.model.enums.InfantryType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "knights")
@Getter
@Setter
@ToString
@Builder
public class Knight extends Infantry{
    private Boolean shield;

    public Knight() {
    }

    public Knight(InfantryType type, Integer attack, Boolean shield) {
        super(type, attack);
        this.shield = shield;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Knight knight = (Knight) o;
        return getId() != null && Objects.equals(getId(), knight.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
