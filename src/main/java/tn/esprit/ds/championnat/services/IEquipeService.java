package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Equipe;

import java.time.LocalDate;
import java.util.HashMap;

public interface IEquipeService {
    Equipe ajouterEquipe(Equipe equipe);
    Equipe findByLibelle(String libelle);
    HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe);
    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe,Long idChampionnat,String annee);
    Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP);
}
