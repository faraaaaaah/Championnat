package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.SponsorServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {
    private SponsorServiceImpl sponsorService;
    @PostMapping("/addsponsor")
    public Sponsor ajouterSponsor(@RequestBody Sponsor s) {
        Sponsor sponsor = sponsorService.ajouterSponsor(s);
        return sponsor;
    }

    @PostMapping("/addsponsors")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> s) {
        List<Sponsor> sponsors = sponsorService.ajouterSponsors(s);
        return sponsors;
    }

    @PutMapping("/updatesponsor")
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        Sponsor sponsor= sponsorService.modifierSponsor(s);
        return sponsor;
    }

    @DeleteMapping("/removesponsor/{idSponsor}")
    public void supprimerSponsor(@PathVariable("idSponsor") Long idSponsor) {
            sponsorService.supprimerSponsor(idSponsor);
}

    @GetMapping("/retrieveallsponsors")
    public List<Sponsor> listSponsors() {
        List<Sponsor> listeSponsors = sponsorService.listSponsors();
        return listeSponsors;
    }

    @GetMapping("/retrievesponsor/{idSponsor}")
    public Sponsor recupererSponsor(@PathVariable("idSponsor") Long idSponsor) {
            return sponsorService.recupererSponsor(idSponsor);
}

    @PutMapping("/archievedsponsor/{idSponsor}")
    public Boolean archiverSponsor(@PathVariable Long idSponsor) {
        Boolean sponsor= sponsorService.archiverSponsor(idSponsor);
        return sponsor;
    }



}
