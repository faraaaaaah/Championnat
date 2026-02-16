package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.services.EquipeServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    private EquipeServiceImpl equipeService;

    @PostMapping("/addequipe")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        Equipe e = equipeService.ajouterEquipe(equipe);
        return e;
    }
}
