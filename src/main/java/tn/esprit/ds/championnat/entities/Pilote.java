//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import tn.esprit.ds.championnat.entities.Categorie;
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

    public Integer getClassementGeneral() {
        return this.classementGeneral;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
