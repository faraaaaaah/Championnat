package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SponsorScheduledServiceImpl {
    private SponsorRepository sponsorRepository;
    private SponsorServiceImpl sponsorService;

    @Scheduled(cron = "0 0 9 * * MON")
    //@Scheduled(cron="0/10 * * * * *")
    public void afficherPourcentageBudgetDepense()
    {
        int annee = LocalDate.now().getYear();
        List<Sponsor> sponsors = sponsorRepository.findAll();
        for(Sponsor sponsor : sponsors)
        {
            double pourcentage = sponsorService.pourcentageBudgetAnnuelConsomme(sponsor.getIdSponsor(), annee);
            if (pourcentage > 100) {
                System.out.println("budget dépassé!! vous ne pouvez plus faire de contrats");
                sponsor.setBloquerContrat(true);
                sponsorRepository.save(sponsor);

            } else if (pourcentage >= 70 && pourcentage < 100) {
                System.out.println("attention budget presque consommé : "
                        + String.format("%.2f", pourcentage) + "% !");

            } else {
                System.out.println(sponsor.getNom() + " : " + String.format("%.2f", pourcentage) + "%");
            }
        }
    }
}
