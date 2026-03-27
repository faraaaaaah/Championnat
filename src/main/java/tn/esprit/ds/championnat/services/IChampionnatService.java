package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Championnat;

public interface IChampionnatService {
    Championnat addChampionnatAndAssociatedCourses(Championnat championnat);
}
