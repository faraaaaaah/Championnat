package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.List;

import static java.lang.System.in;

public class SponsorServiceImpl implements ISponsorService{
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchieved(false);
        sponsor.setBloquerContrat(false);
        return sponsorRepository.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        //return List.of();
        for(Sponsor sponsor : sponsors)
        {
            sponsor.setDateCreation(LocalDate.now());
            sponsor.setArchieved(false);
            sponsor.setBloquerContrat(false);
        }
        return sponsorRepository.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        //return null;
        sponsor.setDateDerniereModification(LocalDate.now());
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
        sponsorRepository.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        //return List.of();
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        //return null;
        return sponsorRepository.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        //return null;
        Sponsor sponsor=sponsorRepository.findById(idSponsor).orElse(null);
        sponsor.setArchieved(true);
        sponsorRepository.save(sponsor);
        return true;
    }
}
