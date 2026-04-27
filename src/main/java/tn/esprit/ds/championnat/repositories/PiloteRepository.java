package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Categorie;
import tn.esprit.ds.championnat.entities.Course;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.entities.PiloteDTO;

import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository <Pilote,Long> {
    Pilote findByLibelleP(String libelleP);
    List<Pilote> findByCategorie(Categorie categorie);
    List<Pilote> findByCategorieOrderByNbPointsTotalDesc(Categorie categorie);
    @Query("SELECT new tn.esprit.ds.championnat.entities.PiloteDTO(p.libelleP,p.nbPointsTotal,ch.libelleC) from Pilote p join p.positions pos join pos.course c join c.championnats ch where ch.annee>?1 and p.classementGeneral=1")
    List<PiloteDTO> listeWinners(Integer annee);
}
