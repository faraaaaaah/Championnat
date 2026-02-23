//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "Equipe"
)
public class Equipe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_equipe"
    )
    Long idEquipe;
    @Column(
            name = "libelle",
            nullable = false,
            length = 100
    )
    String libelle;
    @Column(
            name = "nb_points_total"
    )
    Integer nbPointsTotal;
    @Column(
            name = "classement_general"
    )
    Integer classementGeneral;

    @OneToMany(mappedBy = "equipe")
    public List<Pilote> pilots;

    @OneToMany(mappedBy = "equipe")
    public List<Contrat> contrats;

}
