package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.ContratDTO;
import tn.esprit.ds.championnat.entities.ContratMapper;
import tn.esprit.ds.championnat.services.ChampionnatServiceImpl;
import tn.esprit.ds.championnat.services.ContratServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private ContratServiceImpl contratService;
    private ContratMapper contratMapper;

    @PostMapping("/addcontrat/{idEquipe}/{nom}/{pays}")
    public Contrat ajouterContratEtAffecterASponsorEtEquipe(@RequestBody Contrat c,@PathVariable Long idEquipe ,@PathVariable String nom, @PathVariable String pays) {
        return contratService.ajouterContratEtAffecterASponsorEtEquipe(c,idEquipe,nom,pays);
    }
    @PostMapping("/addc/{libelleEquipe}/{nomSponsor}/{pays}")
    public ContratDTO ajoutContrat(@RequestBody Contrat contrat, @PathVariable String libelleEquipe, @PathVariable String nomSponsor, @PathVariable String pays) {
        Contrat c = contratService.ajoutContratEtAffecterASponsorEtEquipe(contrat, libelleEquipe, nomSponsor, pays);
        // methode manuelle: return new ContratDTO(c.getIdContrat(), c.getMontant(), c.getAnnee(), c.getEquipe().getLibelle(), c.getSponsor().getNom());
        //methode avec mapper
        return contratMapper.contratToContratDTO(c);
    }
}
