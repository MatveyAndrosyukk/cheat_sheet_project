package project_structure.model_inherited.using_single_table_strategy.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "ART_PIECE_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class ArtPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author")
    private String author;

    public ArtPiece(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArtPiece artPiece = (ArtPiece) o;
        return id != null && Objects.equals(id, artPiece.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
