package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements IPiloteService{
    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "pilote added";
    }
    @Override
    public Pilote findByLibelleP(String libelleP) {
        return piloteRepository.findByLibelleP(libelleP);
    }
    @Override
    public Pilote affecterPiloteAEquipe(String libP,String libEq) {
        Pilote p=piloteRepository.findByLibelleP(libP);
        Equipe eq=equipeRepository.findByLibelle(libEq);
        p.setEquipe(eq);
        piloteRepository.save(p);
        return p;
    }
}
