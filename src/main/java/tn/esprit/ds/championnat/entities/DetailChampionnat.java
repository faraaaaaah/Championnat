//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
