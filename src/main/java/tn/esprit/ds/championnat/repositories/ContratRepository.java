package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Contrat;
import tn.esprit.ds.championnat.entities.ContratDTO;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
    List<Contrat> findBySponsorIdSponsorAndAnnee(Long idSponsor, String annee);

    @Query("SELECT SUM(c.montant) FROM Contrat c WHERE c.sponsor.idSponsor = :idSponsor AND c.annee = :annee")
    Double sumMontantBySponsorAndAnnee(@Param("idSponsor") Long idSponsor, @Param("annee") int annee);

    @Query("SELECT new tn.esprit.ds.championnat.entities.ContratDTO(c.idContrat, c.montant, c.annee, eq.libelle, sp.nom) FROM Contrat c JOIN c.equipe eq JOIN c.sponsor sp")
    ContratDTO findContratDTO(Long idContrat);

}
