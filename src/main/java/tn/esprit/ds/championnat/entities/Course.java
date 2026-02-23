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

}
