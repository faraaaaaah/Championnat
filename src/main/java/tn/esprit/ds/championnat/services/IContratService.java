package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Contrat;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat ajouterContratEtAffecterASponsorEtEquipe(Contrat c, Long idEq,String nom,String pays);
    void archiverContratsExpireesEtAffichageContratsActifsParEquipe();
}
