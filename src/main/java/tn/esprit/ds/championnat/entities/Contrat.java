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
        name = "Contrat"
)
public class Contrat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_contrat"
    )
    Long idContrat;
    @Column(
            name = "montant",
            nullable = false
    )
    Float montant;
    @Column(
            name = "annee",
            length = 4
    )
    String annee;
    @Column(
            name = "archived"
    )
    Boolean archieved;

    @ManyToOne
    public Equipe equipe;

    @ManyToOne
    public Sponsor sponsor;

}
