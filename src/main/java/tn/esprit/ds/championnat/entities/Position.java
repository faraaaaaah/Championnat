//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "Position"
)
public class Position {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_position"
    )
    Long idPosition;
    @Column(
            name = "classement",
            nullable = false
    )
    Integer classement;
    @Column(
            name = "nb_points"
    )
    Integer nbPoints;

    @ManyToOne
    public Course course;

    @ManyToOne
    public Pilote pilote;
}
