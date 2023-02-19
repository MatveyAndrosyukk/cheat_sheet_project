package project_structure.model_inherited.using_single_table_strategy.model;

import project_structure.model_inherited.using_single_table_strategy.model.enums.PaintingTechnique;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@DiscriminatorValue(value = "PAINTING")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Painting extends ArtPiece{
    @Enumerated(value = EnumType.STRING)
    @Column(name = "technique")
    private PaintingTechnique technique;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    public Painting(String author, PaintingTechnique technique, Double width, Double height) {
        super(author);
        this.technique = technique;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Painting painting = (Painting) o;
        return getId() != null && Objects.equals(getId(), painting.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
