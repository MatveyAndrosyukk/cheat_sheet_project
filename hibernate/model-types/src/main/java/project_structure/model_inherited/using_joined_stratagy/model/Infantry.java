package project_structure.model_inherited.using_joined_stratagy.model;

import project_structure.model_inherited.using_joined_stratagy.model.enums.InfantryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "infantries")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class Infantry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private InfantryType type;

    @Column(name = "attack")
    private Integer attack;

    public Infantry(InfantryType type, Integer attack) {
        this.type = type;
        this.attack = attack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Infantry infantry = (Infantry) o;
        return id != null && Objects.equals(id, infantry.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
