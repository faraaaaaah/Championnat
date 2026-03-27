package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.services.ChampionnatServiceImpl;
import tn.esprit.ds.championnat.services.ContratServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private ContratServiceImpl contratService;
    @PostMapping("/addcontrat/{idEquipe}/{nom}/{pays}")
    public Contrat ajouterContratEtAffecterASponsorEtEquipe(@RequestBody Contrat c,@PathVariable Long idEquipe ,@PathVariable String nom, @PathVariable String pays) {
        return contratService.ajouterContratEtAffecterASponsorEtEquipe(c,idEquipe,nom,pays);
    }
}
