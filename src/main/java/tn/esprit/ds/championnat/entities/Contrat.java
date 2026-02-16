//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
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

    public Long getIdContrat() {
        return this.idContrat;
    }

    public void setIdContrat(Long idContrat) {
        this.idContrat = idContrat;
    }

    public Float getMontant() {
        return this.montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Boolean getArchieved() {
        return this.archieved;
    }

    public void setArchieved(Boolean archieved) {
        this.archieved = archieved;
    }
}
