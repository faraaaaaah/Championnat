package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService{
    private ContratRepository contratRepository;
    private SponsorRepository sponsorRepository;
    private EquipeRepository equipeRepository;
    @Override
    public Contrat ajouterContrat(Contrat contrat)
    {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat ajouterContratEtAffecterASponsorEtEquipe(Contrat c, Long idEquipe,String nom,String pays)
    {
        Sponsor s=sponsorRepository.findByNomAndPays(nom,pays);
        Equipe e=equipeRepository.findById(idEquipe).get();
        Contrat contrat =contratRepository.save(c);
        contrat.setSponsor(s);
        contrat.setEquipe(e);
        return contratRepository.save(contrat);
    }
}
