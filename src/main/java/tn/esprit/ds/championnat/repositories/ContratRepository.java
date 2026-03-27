package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Contrat;
@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
