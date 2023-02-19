package project_structure.model_inherited.using_table_per_class_strategy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "fire_spells")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FireSpell extends Spell{
    @Column(name = "damage_over_time")
    private Integer damageOverTime;

    public FireSpell(String name, Integer cost, Integer damageOverTime) {
        super(name, cost);
        this.damageOverTime = damageOverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FireSpell fireSpell = (FireSpell) o;
        return getId() != null && Objects.equals(getId(), fireSpell.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
