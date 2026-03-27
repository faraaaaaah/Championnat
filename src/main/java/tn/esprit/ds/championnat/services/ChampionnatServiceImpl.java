package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;

@Service
@AllArgsConstructor
public class ChampionnatServiceImpl implements IChampionnatService{
    private ChampionnatRepository champRepository;
    @Override
    public Championnat addChampionnatAndAssociatedCourses(Championnat championnat)
    {
        return champRepository.save(championnat);
    }
}
