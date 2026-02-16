//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
        name = "Course"
)
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_course"
    )
    Long idCourse;
    @Column(
            name = "emplacement",
            nullable = false,
            length = 100
    )
    String emplacement;
    @Column(
            name = "date_course",
            nullable = false
    )
    LocalDate dateCourse;

    @ManyToMany(mappedBy = "courses")
    public List<Championnat> championnats;

    @OneToMany(mappedBy = "course")
    public List<Position> positions;

    public Long getIdCourse() {
        return this.idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getEmplacement() {
        return this.emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public LocalDate getDateCourse() {
        return this.dateCourse;
    }

    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }
}
