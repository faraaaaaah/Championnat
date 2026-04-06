package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.*;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements IPiloteService{
    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;
    private PositionRepository positionRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "pilote added";
    }
    @Override
    public Pilote findByLibelleP(String libelleP) {
        return piloteRepository.findByLibelleP(libelleP);
    }
    @Override
    public Pilote affecterPiloteAEquipe(String libP,String libEq) {
        Pilote p=piloteRepository.findByLibelleP(libP);
        Equipe eq=equipeRepository.findByLibelle(libEq);
        p.setEquipe(eq);
        piloteRepository.save(p);
        return p;
    }

    @Override
    @Scheduled(cron="0 15 11 31 12 *")
    //pour le test @Scheduled(cron = "0/10 * * * * *")
    public void aJourNbPointsPilote()
    {
        int annee = LocalDate.now().getYear();
        System.out.println("Début mise à jour - Année: " + annee);
        List<Pilote> p1 = piloteRepository.findByCategorie(Categorie.FORMULA1);
        System.out.println("Nombre de pilotes FORMULA1: " + p1.size());
        for (Pilote p: p1)
        {
            int points = 0;
            List<Position> positions = positionRepository.findByPilote(p);
            System.out.println("Pilote: " + p.getLibelleP() + " - Nombre positions: " + positions.size());
            for (Position pos : positions) {
                System.out.println("  Course année: " + pos.getCourse().getDateCourse().getYear() + " - Points: " + pos.getNbPoints());
                if (pos.getCourse().getDateCourse().getYear() == annee) {
                    points += pos.getNbPoints();
                }
            }
            p.setNbPointsTotal(points);
            piloteRepository.save(p);
            System.out.println("  Total points: " + points);
        }
    List<Pilote> classement = piloteRepository.findByCategorieOrderByNbPointsTotalDesc(Categorie.FORMULA1);
        int position = 1;
        for (Pilote p : classement) {
            p.setClassementGeneral(position++);
            piloteRepository.save(p);
            System.out.println("Classement " + p.getClassementGeneral() + ": " + p.getLibelleP() + " - " + p.getNbPointsTotal() + " pts");
    }
}
}
