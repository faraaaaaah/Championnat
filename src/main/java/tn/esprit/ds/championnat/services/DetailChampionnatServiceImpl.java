package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.DetailChampionnat;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.DetailChampionnatRepository;

@Service
@AllArgsConstructor
public class DetailChampionnatServiceImpl implements IDetailChampionnatService{
    private DetailChampionnatRepository detailChampionnatRepository;
    private ChampionnatRepository champRepository;
    @Override
    public DetailChampionnat ajouterEtAffecterDetailChampionnatAChampionnat(DetailChampionnat dc,Long idChampionnat)
    {
        Championnat c=champRepository.findById(idChampionnat).get();
        DetailChampionnat dc1= detailChampionnatRepository.save(dc);
        c.setDetailChampionnat(dc1);
        champRepository.save(c);
        return dc1;
    }
}
