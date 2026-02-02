//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public Long getIdChampionnat() {
        return this.idChampionnat;
    }

    public void setIdChampionnat(Long idChampionnat) {
        this.idChampionnat = idChampionnat;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getLibelleC() {
        return this.libelleC;
    }

    public void setLibelleC(String libelleC) {
        this.libelleC = libelleC;
    }

    public Integer getAnnee() {
        return this.annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
}
