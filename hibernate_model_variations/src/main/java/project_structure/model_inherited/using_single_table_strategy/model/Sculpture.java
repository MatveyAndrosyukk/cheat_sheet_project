package project_structure.model_inherited.using_single_table_strategy.model;

import project_structure.model_inherited.using_single_table_strategy.model.enums.Material;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@DiscriminatorValue(value = "SCULPTURE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sculpture extends ArtPiece{
    @Enumerated(value = EnumType.STRING)
    @Column(name = "material")
    private Material material;

    @Column(name = "weight")
    private Double weight;

    public Sculpture(String author, Material material, Double weight) {
        super(author);
        this.material = material;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sculpture sculpture = (Sculpture) o;
        return getId() != null && Objects.equals(getId(), sculpture.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
