package tn.esprit.ds.championnat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratDTO {
    private Long idContrat;
    private Float montant;
    private String annee;
    private String libelleEquipe;
    private String nomSponsor;
}
