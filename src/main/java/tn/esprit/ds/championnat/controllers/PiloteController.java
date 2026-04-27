package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.PiloteDTO;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.PiloteServiceImpl;

import java.util.List;

@Tag(name="Gestion des pilotes")
@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {
    private PiloteServiceImpl piloteService;

    @Operation(description="ajouter un pilote dans la base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pilote ajouté avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/addpilote")
    public String addPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }

    @PutMapping("/affecterpilote-equipe/{libelleP}/{libelle}")
    public Pilote affecterPiloteAEquipe(@PathVariable String libelleP,@PathVariable String libelle) {
        return piloteService.affecterPiloteAEquipe(libelleP,libelle);
    }
    @Operation(description = "Afficher le gagnant de chaque championnat pour les années > annee")
    @GetMapping("/winners/{annee}")
    public List<PiloteDTO> listeWinners(@PathVariable Integer annee) {
        return piloteService.listeWinners(annee);
    }
}
