package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.PiloteServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {
    private PiloteServiceImpl piloteService;
    @PostMapping("/addpilote")
    public String addPilote(@RequestBody Pilote p) {
        return piloteService.addPilote(p);
    }
}
