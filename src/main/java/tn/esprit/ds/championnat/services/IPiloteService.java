package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.PiloteDTO;

import java.util.List;

public interface IPiloteService {
    String addPilote(Pilote p) ;
    Pilote findByLibelleP(String libelleP);
    Pilote affecterPiloteAEquipe(String libP,String libEq);
    void aJourNbPointsPilote();
    List<PiloteDTO> listeWinners(Integer annee);
}
