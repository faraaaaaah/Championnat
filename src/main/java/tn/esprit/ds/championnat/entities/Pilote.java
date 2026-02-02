//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
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
    Integer classementGeneal;

    @OneToMany(mappedBy = "pilote")
    public List<Position> positions;

    @ManyToOne
    public Equipe equipe;

    public Long getIdPilote() {
        return this.idPilote;
    }

    public void setIdPilote(Long idPilote) {
        this.idPilote = idPilote;
    }

    public String getLibelleP() {
        return this.libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }

    public Integer getNbPointsTotal() {
        return this.nbPointsTotal;
    }

    public void setNbPointsTotal(Integer nbPointsTotal) {
        this.nbPointsTotal = nbPointsTotal;
    }

    public Integer getClassementGeneal() {
        return this.classementGeneal;
    }

    public void setClassementGeneal(Integer classementGeneal) {
        this.classementGeneal = classementGeneal;
    }
}
