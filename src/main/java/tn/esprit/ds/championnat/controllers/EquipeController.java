package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.EquipeServiceImpl;

import java.time.LocalDate;
import java.util.HashMap;

@Tag(name="Gestion des equipes")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    private EquipeServiceImpl equipeService;

    @Operation(description="ajouter une équipe dans la base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipe ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/addequipe")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        Equipe e = equipeService.ajouterEquipe(equipe);
        return e;
    }
    @Operation(description = "Calculer l'historique des contrats d'une équipe")
    @GetMapping("/historique/{libelleEquipe}")
    public HashMap<String, Float> historiqueContratsEquipe(@PathVariable String libelleEquipe) {
        return equipeService.historiqueContratsEquipe(libelleEquipe);
    }
    @Operation(description = "Calculer le nombre de points des pilotes d'une équipe pour un championnat et une année")
    @GetMapping("/nbpoints/{idEquipe}/{idChampionnat}/{annee}")
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(@PathVariable Long idEquipe, @PathVariable Long idChampionnat, @PathVariable String annee) {
        return equipeService.nbPointsParPilotesUneEquipeChampionnatPourUneAnne(idEquipe, idChampionnat, annee);
    }
    @Operation(description = "Calculer la moyenne des positions d'un pilote entre deux dates")
    @GetMapping("/moyennepositions/{libelleP}")
    public Float moyennePositionsEntreDeuxDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @PathVariable String libelleP) {
        return equipeService.moyennePositionsEntreDeuxDate(startDate, endDate, libelleP);
    }
}
