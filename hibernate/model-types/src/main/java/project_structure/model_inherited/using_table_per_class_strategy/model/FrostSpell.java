package project_structure.model_inherited.using_table_per_class_strategy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "frost_spells")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrostSpell extends Spell{
    @Column(name = "freeze_duration")
    private Integer freezeDuration;

    public FrostSpell(String name, Integer cost, Integer freezeDuration) {
        super(name, cost);
        this.freezeDuration = freezeDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FrostSpell that = (FrostSpell) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
