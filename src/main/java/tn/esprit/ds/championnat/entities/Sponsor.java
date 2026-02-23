//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "Sponsor"
)
public class Sponsor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_sponsor"
    )
    Long idSponsor;
    @Column(
            name = "nom",
            nullable = false,
            length = 100
    )
    String nom;
    @Column(
            name = "pays",
            length = 50
    )
    String pays;
    @Column(
            name = "budget_annuel"
    )
    Float budgetAnnuel;
    @Column(
            name = "bloquer_contrat"
    )
    Boolean bloquerContrat;

    @OneToMany(mappedBy = "sponsor")
    public List<Contrat> contrats;


    boolean archieved;

    LocalDate dateCreation;
    LocalDate dateDerniereModification;

}
