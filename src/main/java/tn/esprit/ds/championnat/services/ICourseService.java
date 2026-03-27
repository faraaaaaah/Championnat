package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Course;

public interface ICourseService {
    Course ajouterCourse (Course course);
    String affecterCourseAChampionnat(Long idCourse,Long idChampionnat);
}
