package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.services.DetailChampionnatServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/detailchampionnat")
public class DetailChampionnatController {

    private DetailChampionnatServiceImpl detailChampionnatService;
    @PutMapping("/affecterdetailchampionnat/{idChampionnat}")
    public DetailChampionnat ajouterEtAffecterDetailChampionnatAChampionnat(@RequestBody DetailChampionnat dc, @PathVariable Long idChampionnat) {
        return detailChampionnatService.ajouterEtAffecterDetailChampionnatAChampionnat(dc,idChampionnat);
    }
}
