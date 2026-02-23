//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "DetailChampionnat"
)
public class DetailChampionnat {
    @Id
    @Column(
            name = "code",
            length = 50
    )
    String code;
    @Column(
            name = "description",
            length = 1000
    )
    String description;

    @OneToOne(mappedBy = "detailChampionnat")
    public Championnat championnat;

}
