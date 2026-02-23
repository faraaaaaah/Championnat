//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.ds.championnat.entities.Categorie;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "Pilote"
)
public class Pilote {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_pilote"
    )
    Long idPilote;
    @Column(
            name = "libelle_p",
            nullable = false,
            length = 100
    )
    String libelleP;
    @Column(
            name = "nb_points_total"
    )
    Integer nbPointsTotal;
    @Column(
            name = "classement_general"
    )
    Integer classementGeneral;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "categorie"
    )
    Categorie categorie;
    @OneToMany(mappedBy = "pilote")
    public List<Position> positions;

    @ManyToOne
    public Equipe equipe;

}
