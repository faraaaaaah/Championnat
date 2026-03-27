package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.services.ChampionnatServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/championnat")
public class ChampionnatController {
    private ChampionnatServiceImpl champService;
    @PostMapping("/addchampionnat")
    public Championnat ajouterChampionnat(@RequestBody Championnat c) {
        return champService.addChampionnatAndAssociatedCourses(c);
    }
}
