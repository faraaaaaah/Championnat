package tn.esprit.ds.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.SponsorServiceImpl;

import java.util.List;

@Tag(name="Gestion des sponsors")
@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {
    private SponsorServiceImpl sponsorService;

    @Operation(description="ajouter un sponsor dans la base")
    @PostMapping("/addsponsor")
    public Sponsor ajouterSponsor(@RequestBody Sponsor s) {
        Sponsor sponsor = sponsorService.ajouterSponsor(s);
        return sponsor;
    }

    @Operation(description="ajouter une liste de sponsors dans la base")
    @PostMapping("/addsponsors")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> s) {
        List<Sponsor> sponsors = sponsorService.ajouterSponsors(s);
        return sponsors;
    }

    @Operation(description="modifier un sponsor de la base")
    @PutMapping("/updatesponsor")
    public Sponsor modifierSponsor(@RequestBody Sponsor s) {
        Sponsor sponsor= sponsorService.modifierSponsor(s);
        return sponsor;
    }

    @Operation(description="supprimer un sponsor de la base")
    @DeleteMapping("/removesponsor/{idSponsor}")
    public void supprimerSponsor(@PathVariable("idSponsor") Long idSponsor) {
            sponsorService.supprimerSponsor(idSponsor);
}

    @Operation(description="récupérer tous les sponsors de la base")
    @GetMapping("/retrieveallsponsors")
    public List<Sponsor> listSponsors() {
        List<Sponsor> listeSponsors = sponsorService.listSponsors();
        return listeSponsors;
    }

    @Operation(description="récupérer un sponsor de la base")
    @GetMapping("/retrievesponsor/{idSponsor}")
    public Sponsor recupererSponsor(@PathVariable("idSponsor") Long idSponsor) {
            return sponsorService.recupererSponsor(idSponsor);
}

    @Operation(description="archiver un sponsor de la base")
    @PutMapping("/archievedsponsor/{idSponsor}")
    public Boolean archiverSponsor(@PathVariable Long idSponsor) {
        Boolean sponsor= sponsorService.archiverSponsor(idSponsor);
        return sponsor;
    }



}
