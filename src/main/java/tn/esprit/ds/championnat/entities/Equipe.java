//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public Long getIdEquipe() {
        return this.idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNbPointsTotal() {
        return this.nbPointsTotal;
    }

    public void setNbPointsTotal(Integer nbPointsTotal) {
        this.nbPointsTotal = nbPointsTotal;
    }

    public Integer getClassementGeneral() {
        return this.classementGeneral;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }
}
