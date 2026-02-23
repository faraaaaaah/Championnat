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
        name = "Championnat"
)
public class Championnat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_championnat"
    )
    Long idChampionnat;
    @Enumerated(EnumType.STRING)
    @Column(
            name = "categorie"
    )
    Categorie categorie;
    @Column(
            name = "libelleC",
            nullable = false,
            length = 100
    )
    String libelleC;
    @Column(
            name = "annee"
    )
    Integer annee;

    @OneToOne
    public DetailChampionnat detailChampionnat;

    @ManyToMany
    public List<Course> courses;

}
