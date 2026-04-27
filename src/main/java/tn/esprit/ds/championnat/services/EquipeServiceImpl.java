package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.*;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService{
    private EquipeRepository equipeRepository;
    private ChampionnatRepository championnatRepository;
    private PositionRepository positionRepository;
    private PiloteRepository piloteRepository;
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe findByLibelle(String libelle) {
        return equipeRepository.findByLibelle(libelle);
    }
    @Override
    public HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe) {
        HashMap<String, Float> historique = new HashMap<>();
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe);
        if (equipe == null) return historique;
        for (Contrat contrat : equipe.getContrats()) {
            if (contrat.getSponsor() != null && contrat.getMontant() != null) {
                String nomSponsor = contrat.getSponsor().getNom();
                Float montant = contrat.getMontant();
                historique.merge(nomSponsor, montant, Float::sum);
            }
        }
        return historique;
    }
    @Override
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe,Long idChampionnat,String annee) {
        int totalPoints = 0;
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        if (equipe == null) return 0;
        Championnat championnat = championnatRepository.findById(idChampionnat).orElse(null);
        if (championnat == null) return 0;
        for (Pilote pilote : equipe.getPilots()) {
            List<Position> positions = positionRepository.findByPilote(pilote);
            for (Position position : positions) {
                if (position.getCourse() != null
                        && championnat.getCourses().contains(position.getCourse())
                        && String.valueOf(position.getCourse().getDateCourse().getYear()).equals(annee)
                        && position.getNbPoints() != null) {
                    totalPoints += position.getNbPoints();
                }
            }
        }
        return totalPoints;
    }
    @Override
    public Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP) {
        Pilote pilote = piloteRepository.findByLibelleP(libelleP);
        if (pilote == null) return 0f;
        List<Position> positions = positionRepository.findByPilote(pilote);
        int totalClassement = 0;
        int count = 0;
        for (Position position : positions) {
            if (position.getCourse() != null && position.getClassement() != null) {
                LocalDate dateCourse = position.getCourse().getDateCourse();
                if (!dateCourse.isBefore(startDate) && !dateCourse.isAfter(endDate)) {
                    totalClassement += position.getClassement();
                    count++;
                }
            }
        }
        if (count == 0) return 0f;
        return (float) totalClassement / count;
    }
}
