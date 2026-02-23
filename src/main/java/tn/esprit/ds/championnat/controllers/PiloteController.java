package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.PiloteServiceImpl;

@Tag(name="Gestion des pilotes")
@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {
    private PiloteServiceImpl piloteService;

    @Operation(description="ajouter un pilote dans la base")
    @PostMapping("/addpilote")
    public String addPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }
}
