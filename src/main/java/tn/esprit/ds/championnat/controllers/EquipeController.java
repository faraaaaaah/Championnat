package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.EquipeServiceImpl;

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
}
