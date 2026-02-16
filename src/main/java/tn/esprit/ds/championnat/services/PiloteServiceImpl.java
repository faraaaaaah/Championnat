package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.repositories.PiloteRepository;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements IPiloteService{
    private PiloteRepository piloteRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "pilote added";
    }
}
