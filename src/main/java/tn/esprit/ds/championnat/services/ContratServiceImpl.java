package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.Year;

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

    @Override
    @Scheduled(cron="*/30 * * * * *")
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe()
    {
        int anneeCourante = Year.now().getValue();
        System.out.println("debut");
        for (Contrat c : contratRepository.findAll()) {System.out.println("debut2");
            int anneeContrat = Integer.parseInt(c.getAnnee());
            if (anneeContrat < anneeCourante && !c.getArchieved()) {
                c.setArchieved(true);
                contratRepository.save(c);
            }
        }System.out.println("fin1");
        for (Contrat c : contratRepository.findAll()) {System.out.println("debut3");
            int anneeContrat = Integer.parseInt(c.getAnnee());
            if (anneeContrat >= anneeCourante && !c.getArchieved()) {
                System.out.println("L'equipe: " + c.getEquipe().getLibelle() + " a un contrat d'un montant de " + c.getMontant() + "avec le sponsor" + c.getSponsor().getNom());
            }System.out.println("fin2");
        }
    }

}
