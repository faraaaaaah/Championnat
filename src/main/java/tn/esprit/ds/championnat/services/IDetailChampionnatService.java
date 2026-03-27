package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.DetailChampionnat;

public interface IDetailChampionnatService {
    DetailChampionnat ajouterEtAffecterDetailChampionnatAChampionnat(DetailChampionnat dt,Long idchampionnat);
}
