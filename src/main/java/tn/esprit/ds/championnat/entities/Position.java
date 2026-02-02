//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Position"
)
public class Position {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_position"
    )
    Long idPosition;
    @Column(
            name = "classement",
            nullable = false
    )
    Integer classement;
    @Column(
            name = "nb_points"
    )
    Integer nbPoints;

    @ManyToOne
    public Course course;

    @ManyToOne
    public Pilote pilote;

    public Long getIdPosition() {
        return this.idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }

    public Integer getClassement() {
        return this.classement;
    }

    public void setClassement(Integer classement) {
        this.classement = classement;
    }

    public Integer getNbPoints() {
        return this.nbPoints;
    }

    public void setNbPoints(Integer nbPoints) {
        this.nbPoints = nbPoints;
    }
}
