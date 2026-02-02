//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public Long getIdSponsor() {
        return this.idSponsor;
    }

    public void setIdSponsor(Long idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Float getBudgetAnnuel() {
        return this.budgetAnnuel;
    }

    public void setBudgetAnnuel(Float budgetAnnuel) {
        this.budgetAnnuel = budgetAnnuel;
    }

    public Boolean getBloquerContrat() {
        return this.bloquerContrat;
    }

    public void setBloquerContrat(Boolean bloquerContrat) {
        this.bloquerContrat = bloquerContrat;
    }
}
